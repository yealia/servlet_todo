package com.example.todo.controller;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "LoginController", value = "/login")
@Log4j2
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("login get.........");

        request.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("login post...");

        String mid = request.getParameter("mid");
        String mpw = request.getParameter("mpw");

        String rememberMe = request.getParameter("remember-me") == null?"": request.getParameter("remember-me");

        log.info(mid);
        log.info(mpw);

        //로그인 처리
        if(mid.equals("aaa")&&mpw.equals("111")){

            HttpSession session = request.getSession();
            session.setAttribute("loginResult", "success");

            if(rememberMe.equals("on")){
                Cookie loginCookie = new Cookie("loginResult", URLEncoder.encode("Hong Gil Dong","UTF-8"));
                loginCookie.setPath("/");
                loginCookie.setMaxAge(60*60*24*7);//7days
                response.addCookie(loginCookie);
            }

            if(session.getAttribute("wanted") != null){
                response.sendRedirect((String)session.getAttribute("wanted"));
                session.removeAttribute("wanted");
            }else {
                response.sendRedirect("/todo/list");
            }
            return;
        }

        log.info("login failed...");
        response.sendRedirect("/login?error=fail");



    }
}