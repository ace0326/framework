/*
 * The MIT License (MIT)
 * Copyright © 2019-2020 <sky>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the “Software”), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.sky.framework.redis.util;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RedissonClient;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 分布式锁,redis官方推荐分布式锁
 *
 * @author
 */
@Slf4j
public class DistributedLockUtils {

    @Setter
    private static RedissonClient redissonClient;

    /**
     * 此方法默认锁没有超时时间
     *
     * @param key
     * @param timeout 尝试多长时间获取锁对象
     * @return
     */
    public static boolean lock(String key, long timeout) {
        RLock lock = redissonClient.getLock(key);
        try {
            return lock.tryLock(timeout, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("distributed lock interrupted:{}", e.getMessage(), e);
            return false;
        }
    }

    /**
     * @param key
     * @param timeout
     * @param leaseTime 锁租约时间,即锁过期时间
     * @return
     */
    public static boolean lock(String key, long timeout, long leaseTime) {
        RLock lock = redissonClient.getLock(key);
        try {
            return lock.tryLock(timeout, leaseTime, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("distributed lock interrupted:{}", e.getMessage(), e);
            return false;
        }
    }

    /**
     * 获取读锁
     *
     * @param key
     * @param timeout
     * @param leaseTime 锁租约时间,即锁过期时间
     * @return
     */
    public static boolean readLock(String key, long timeout, long leaseTime) {
        RReadWriteLock readWriteLock = redissonClient.getReadWriteLock(key);
        try {
            RLock lock = readWriteLock.readLock();
            return lock.tryLock(timeout, leaseTime, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("distributed lock interrupted:{}", e.getMessage(), e);
            return false;
        }
    }

    /**
     * 获取写锁
     *
     * @param key
     * @param timeout
     * @param leaseTime 锁租约时间,即锁过期时间
     * @return
     */
    public static boolean writeLock(String key, long timeout, long leaseTime) {
        RReadWriteLock readWriteLock = redissonClient.getReadWriteLock(key);
        try {
            RLock lock = readWriteLock.writeLock();
            return lock.tryLock(timeout, leaseTime, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("distributed lock interrupted:{}", e.getMessage(), e);
            return false;
        }
    }


    /**
     * 获取公平锁
     *
     * @param key
     * @param timeout
     * @param leaseTime 锁租约时间,即锁过期时间
     * @return
     */
    public static boolean fairLock(String key, long timeout, long leaseTime) {
        RLock lock = redissonClient.getFairLock(key);
        try {
            return lock.tryLock(timeout, leaseTime, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("distributed lock interrupted:{}", e.getMessage(), e);
            return false;
        }
    }

    /**
     * @param key
     * @return
     */
    public static boolean unlock(String key) {
        RLock lock = redissonClient.getLock(key);
        if (lock != null) {
            lock.unlock();
        }
        return true;
    }

    /**
     * 强制解锁
     *
     * @param key
     * @return
     */
    public static boolean forceUnlock(String key) {
        RLock lock = redissonClient.getLock(key);
        if (lock != null) {
            try {
                return lock.forceUnlockAsync().get();
            } catch (InterruptedException e) {
                return false;
            } catch (ExecutionException e) {
                return false;
            }
        }
        return true;
    }

}
