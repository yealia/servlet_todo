package com.example.todo.controller;

import com.example.todo.util.CookieUtil;
import lombok.extern.log4j.Log4j2;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello")
@Log4j2
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        log.trace("t-----------------------");
        log.debug("d-----------------------");
        log.info("i-----------------------");
        log.warn("w-----------------------");
        log.error("e-----------------------");
        log.fatal("f-----------------------");

        StringBuffer buffer = (StringBuffer) request.getServletContext().getAttribute("sample");

        buffer.append("A");

        try {
            Cookie loginCookie = CookieUtil.findCookie(request,"login");

            if(loginCookie != null ){

                log.info("--------------------");
                String value = loginCookie.getValue();

                value += '%'+value;

                loginCookie.setValue(value);
                response.addCookie(loginCookie);

            }

            request.getRequestDispatcher("/WEB-INF/views/hello.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }


    }

    public void destroy() {
    }
}