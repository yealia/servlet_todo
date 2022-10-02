package org.zerock.todoteam.controller;

import org.apache.ibatis.session.SqlSession;
import org.zerock.todoteam.dao.MyBatisUtil;
import org.zerock.todoteam.dto.TodoDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "TodoAddController", value = "/todo/add")
public class TodoAddController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/views/todo/add.jsp")
                .forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TodoDTO dto = TodoDTO.builder()
                .title(request.getParameter("title"))
                .memo(request.getParameter("memo"))
                .dueDate(LocalDate.parse(request.getParameter("dueDate")))
                .build();
        SqlSession session
                = MyBatisUtil.INSTANCE.getSqlSessionFactory().openSession(true);
        session.insert("org.zerock.todoteam.dao.TodoMapper.insert",dto);

        response.sendRedirect("/todo/list");
    }
}
