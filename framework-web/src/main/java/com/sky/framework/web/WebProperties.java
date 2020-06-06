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
package com.sky.framework.web;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * The class Swagger properties.
 *
 * @author
 */

@Component
@ConfigurationProperties(prefix = WebAutoConfiguration.PREFIX + "web")
@Data
public class WebProperties {

    /**
     * 是否启用全局异常处理器,默认true
     */
    private Boolean globalExceptionEnabled = true;

    /**
     * 是否启用全局异常处理器,默认true
     */
    private Boolean globalHttpConverterEnabled;

    /**
     * 是否使用钉钉发送错误信息,默认true
     */
    private Boolean globalExceptionDingTalkEnabled = true;
    /**
     * 是否启用用户信息上下文转换器,默认true
     */
    private Boolean globalContextInterceptorEnabled = true;

    /**
     * 是否启用用户token拦截器,默认true
     */
    private Boolean globalTokenInterceptorEnabled = true;

}
