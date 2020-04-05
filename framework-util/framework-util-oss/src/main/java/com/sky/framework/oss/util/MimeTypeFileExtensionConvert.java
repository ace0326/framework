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
package com.sky.framework.oss.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author
 */
public class MimeTypeFileExtensionConvert {

    private static Map<String, String> maps = new HashMap<>();

    static {
        maps.put("image/jpeg", ".jpg");
        maps.put("image/gif", ".gif");
        maps.put("image/png", ".png");
        maps.put("image/bmp", ".bmp");
        maps.put("text/plain", ".txt");
        maps.put("application/zip", ".zip");
        maps.put("application/x-zip-compressed", ".zip");
        maps.put("multipart/x-zip", ".zip");
        maps.put("application/x-compressed", ".zip");
        maps.put("audio/mpeg3", ".mp3");
        maps.put("video/avi", ".avi");
        maps.put("audio/wav", ".wav");
        maps.put("application/x-gzip", ".gzip");
        maps.put("application/x-gzip", ".gz");
        maps.put("text/html", ".html");
        maps.put("application/x-shockwave-flash", ".svg");
        maps.put("application/pdf", ".pdf");
        maps.put("application/msword", ".doc");
        maps.put("application/vnd.openxmlformats-officedocument.wordprocessingml.document", ".docx");
        maps.put("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", ".xlsx");
        maps.put("application/vnd.ms-excel", ".xls");
        maps.put("application/vnd.ms-powerpoint", ".ppt");
        maps.put("application/vnd.openxmlformats-officedocument.presentationml.presentation", ".pptx");
    }

    public static String getFileExtension(String mimeType) {
        return maps.get(mimeType);
    }
}
