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
package com.sky.framework.rule.engine.component.operator;

import com.alibaba.fastjson.JSONArray;
import com.google.common.collect.Lists;
import com.sky.framework.rule.engine.constant.OperatorConstants;
import org.apache.commons.lang.ObjectUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author
 */
public class GreaterEqualOperator extends AbstractOperator {

    @Override
    public boolean doExecute(Object data, List baseline) {
        if (data == null) return false;

        List<Object> list = data instanceof JSONArray ? ((JSONArray) data).toJavaList(Object.class) : Lists.newArrayList(data);
        BigDecimal bdSubject, object;
        String subject, baselineStr = ObjectUtils.toString(baseline.get(0));

        boolean bRet = false;
        for (Object value : list) {
            subject = ObjectUtils.toString(value);
            try {
                bdSubject = new BigDecimal(subject);
                object = new BigDecimal(baselineStr);
                bRet = (bdSubject.compareTo(object) >= 0);
            } catch (Exception e1) {
                bRet = (subject.compareTo(baselineStr) >= 0);
            }
            if (bRet) {
                break;
            }
        }
        return bRet;
    }

    @Override
    public String code() {
        return OperatorConstants.OPR_CODE.GREATER_EQUAL;
    }
}
