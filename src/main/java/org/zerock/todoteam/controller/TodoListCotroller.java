package org.zerock.todoteam.controller;

import org.zerock.todoteam.dao.MyBatisUtil;
import org.zerock.todoteam.dao.TodoDAO;
import org.zerock.todoteam.dto.TodoDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TodoListCotroller", value = "/todo/list")
public class TodoListCotroller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<TodoDTO> todoList = TodoDAO.INSTANCE.selectAll();

        request.setAttribute("list", todoList);
        //setAttribute 기여하다

        request.getRequestDispatcher("/WEB-INF/views/todo/list.jsp")
                .forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
