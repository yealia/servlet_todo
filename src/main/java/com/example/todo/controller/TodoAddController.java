package com.example.todo.controller;

import com.example.todo.dao.MyBatisUtil;
import com.example.todo.dao.TodoDAO;
import com.example.todo.dto.TodoDTO;
import lombok.Cleanup;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "TodoAddController", value = "/todo/add")
public class TodoAddController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/views/todo/add.jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TodoDTO dto = TodoDTO.builder()
                .title(request.getParameter("title"))
                .memo(request.getParameter("memo"))
                .dueDate(LocalDate.parse(request.getParameter("dueDate")))
                .build();

        TodoDAO.INSTANCE.insert(dto);

        response.sendRedirect("/todo/list");

    }
}
