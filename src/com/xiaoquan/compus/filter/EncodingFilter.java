package com.xiaoquan.compus.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.xiaoquan.compus.util.EncodingRequest;

@WebFilter("/*")
public class EncodingFilter implements Filter {

    public EncodingFilter() {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        response.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        if (req.getMethod().equals("get")) {
            EncodingRequest ereq = new EncodingRequest(req);
            chain.doFilter(ereq,response);
        } else {
            chain.doFilter(req, response);
        }
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
    }

}
