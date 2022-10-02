package org.zerock.todoteam.controller;

import org.apache.ibatis.session.SqlSession;
import org.zerock.todoteam.dao.MyBatisUtil;
import org.zerock.todoteam.dao.TodoDAO;
import org.zerock.todoteam.dto.TodoDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "TodoUpdateControllerServlet", value = "/todo/update")
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
        SqlSession session = MyBatisUtil.INSTANCE.getSqlSessionFactory().openSession(true);
        session.update("org.zerock.todoteam.dao.TodoMapper.update",dto);

        response.sendRedirect("/todo/list");
//
//        TodoDTO dto = TodoDTO.builder().title("yealia").memo("yayaya").dueDate(LocalDate.parse("2022-12-25")).tno(17).build();
//        SqlSession session
//                = MyBatisUtil.INSTANCE.getSqlSessionFactory().openSession(true);
//        session.update("org.zerock.todoteam.dao.TodoMapper.update",dto);

    }
}
