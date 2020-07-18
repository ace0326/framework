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
package com.sky.framework.model.dto;


import com.sky.framework.model.enums.SystemErrorCodeEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * 通用返回实体
 *
 * @author
 */
@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -1L;
    /**
     * 返回code
     */
    private String code;
    /**
     * 返回消息
     */
    private String msg;
    /**
     * 返回结果
     */
    private T data;

    /**
     * 获取成功返回结果
     *
     * @param data
     * @return
     */
    public static <T> Result success(T data) {
        Result result = new Result();
        result.setCode(SystemErrorCodeEnum.SUCCESS.getCode());
        result.setMsg(SystemErrorCodeEnum.SUCCESS.getMsg());
        result.setData(data);
        return result;
    }

    /**
     * 不用new result的方法
     *
     * @param data
     * @param result
     * @return
     */
    public static <T> Result success(T data, Result result) {
        result.setCode(SystemErrorCodeEnum.SUCCESS.getCode());
        result.setMsg(SystemErrorCodeEnum.SUCCESS.getMsg());
        result.setData(data);
        return result;
    }

    /**
     * 获取成功返回结果
     *
     * @return
     */
    public static Result success() {
        Result result = new Result();
        result.setCode(SystemErrorCodeEnum.SUCCESS.getCode());
        result.setMsg(SystemErrorCodeEnum.SUCCESS.getMsg());
        return result;
    }

    /**
     * 获取失败返回结果
     *
     * @return
     */
    public static Result fail() {
        Result result = new Result();
        result.setCode(SystemErrorCodeEnum.FAILURE.getCode());
        result.setMsg(SystemErrorCodeEnum.FAILURE.getMsg());
        return result;
    }

    /**
     * 获取失败返回结果
     *
     * @param code
     * @return
     */
    public static Result fail(String code) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(SystemErrorCodeEnum.FAILURE.getMsg());
        return result;
    }

    /**
     * 获取失败返回结果
     *
     * @param code
     * @param msg
     * @return
     */
    public static Result fail(String code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
