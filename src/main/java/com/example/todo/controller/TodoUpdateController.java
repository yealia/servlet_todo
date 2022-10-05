package com.example.todo.controller;

import com.example.todo.dao.MyBatisUtil;
import com.example.todo.dao.TodoDAO;
import com.example.todo.dto.TodoDTO;
import com.sun.tools.javac.comp.Todo;
import lombok.Cleanup;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@WebServlet(name = "TodoUpdateController", value = "/todo/update")
public class TodoUpdateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/todo/update.jsp")
                .forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TodoDTO dto = TodoDTO.builder()
                .title(request.getParameter("title"))
                .memo(request.getParameter("memo"))
                .dueDate(LocalDate.parse(request.getParameter("dueDate")))
                .tno(Integer.valueOf(request.getParameter("tno")))
                .build();
        TodoDAO.INSTANCE.update(dto);

        response.sendRedirect("/todo/list");


    }


}
