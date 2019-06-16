package com.xiaoquan.compus.util;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncodingRequest extends HttpServletRequestWrapper {
    private HttpServletRequest hsr;

    public EncodingRequest (HttpServletRequest request) {
        super(request);
        this.hsr = request;
    }
    @Override
    public String getParameter (String name) {
        String value = hsr.getParameter(name);
        try {
            value = new String(value.getBytes("ISO-8859-1 "),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return value;
    }
}
