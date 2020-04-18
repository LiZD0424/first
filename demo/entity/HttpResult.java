package com.example.demo.entity;

import java.util.Map;

/**
 * 描述:
 * http返回结果
 *
 * @author mengxs@lenovocloud.com
 */
public class  HttpResult {
    private int httpCode;
    private String result;
    private Map<String,String> headers;

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
}
