package com.example.todo.controller;

import com.example.todo.dao.MyBatisUtil;
import com.example.todo.dto.TodoDTO;
import lombok.Cleanup;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TodoReadControllerServlet", value = "/todo/read")
public class TodoReadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String tno = request.getParameter("tno");

        @Cleanup SqlSession session
                = MyBatisUtil.INSTANCE.getSqlSessionFactory().openSession(true);

        try {
            TodoDTO todoDTO = session.selectOne("com.example.todo.dao.TodoMapper.selectOne", tno);

            request.setAttribute("todo", todoDTO);

            request.getRequestDispatcher("/WEB-INF/views/todo/read.jsp").forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
