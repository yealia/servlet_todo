package com.example.todo.controller;

import com.example.todo.util.CookieUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogoutController", value = "/logout")
public class LogoutController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        HttpSession session = request.getSession(false);
//
//        if(session == null){
//            response.sendRedirect("/todo/list");
//            return;
//        }
//
//        session.invalidate();
//        session.setMaxInactiveInterval(0);

        Cookie loginCookie = CookieUtil.findCookie(request,"login");
        loginCookie.setMaxAge(0);
        response.addCookie(loginCookie);



    }

}