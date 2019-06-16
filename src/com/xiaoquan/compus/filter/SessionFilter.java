package com.xiaoquan.compus.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/*")
public class SessionFilter implements Filter {

    public SessionFilter() {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
/*        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse hsResp = (HttpServletResponse)response;
        String reqURL = req.getRequestURI();
        String cotPath = req.getContextPath();
        String reqedURL = reqURL.substring(cotPath.length()+1);
        HttpSession session = req.getSession();
        User curUser = (User)session.getAttribute("USER");
        boolean isAllow = false;
        if ("".equals(reqedURL) || "userLogin.do".equals(reqedURL) || "userRegister.do".equals(reqedURL)) {
            isAllow = true;
        }
        if (curUser == null && !isAllow) {
            hsResp.sendRedirect("userLogin.do");
        } else {
            chain.doFilter(request, response);
        }
*/
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
    }

}
