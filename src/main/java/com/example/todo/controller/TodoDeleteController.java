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

//@WebServlet(name = "TodoDeleteController", value = "/todo/delete")
//public class TodoDeleteController extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        String tno = request.getParameter("tno");
//
//        TodoDTO todoDTO = TodoDTO.builder().tno(Integer.parseInt(tno)).build();
//
//        @Cleanup SqlSession session
//                = MyBatisUtil.INSTANCE.getSqlSessionFactory().openSession(true);
//
//        session.delete("com.example.todo.dao.TodoMapper.delete", tno);
//
//        response.sendRedirect("/todo/list");
//
//    }
//
//}
@WebServlet(name = "TodoDeleteController", value = "/todo/delete")
public class TodoDeleteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/todo/delete.jsp")
                .forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String tno = request.getParameter("tno");
        TodoDTO todoDTO = TodoDTO.builder()
                .tno(Integer.valueOf(tno))
                .build();
        TodoDAO.INSTANCE.delete(todoDTO);
        response.sendRedirect("/todo/list");
    }
}

