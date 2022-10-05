package com.example.todo.filter;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginCheckFilter", urlPatterns = {"/todo/*"})
@Log4j2
public class LoginCheckFilter implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {
        log.info("init...........");
    }

    public void destroy() {
        log.info("destroy......");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        log.info("doFilter..................");
        log.info("doFilter..................");
        log.info("doFilter..................");
        log.info("doFilter..................");

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        //한글 패치
        req.setCharacterEncoding("utf-8");
        res.setContentType("text/html;charset=utf-8");

        HttpSession session = req.getSession();

        String requestURL = req.getRequestURI();
        String requestQueryString = req.getQueryString();



//        if(session == null){
//            res.sendRedirect("/login");
//            return;
//        }
        if(requestURL.equals("/todo/list")){
            log.info("fdsfsdafdasfsdfdasfdasf");
            chain.doFilter(request,response);
            return;

        }


        if (session.getAttribute("loginResult") == null) {
            session.setAttribute("wanted", requestURL + "?" + requestQueryString);
            res.sendRedirect("/login");
            return;
        }

        chain.doFilter(request, response);
    }
}