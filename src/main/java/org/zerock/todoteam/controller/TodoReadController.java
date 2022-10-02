package org.zerock.todoteam.controller;

import org.zerock.todoteam.dao.TodoDAO;
import org.zerock.todoteam.dto.TodoDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TodoReadController", value = "/todo/read")
public class TodoReadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tno = request.getParameter("tno");

        TodoDTO todoDTO = TodoDAO.INSTANCE.selectOne(Integer.parseInt(tno));
        request.setAttribute("list", todoDTO);

        request.getRequestDispatcher("/WEB-INF/views/todo/read.jsp")
                .forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
