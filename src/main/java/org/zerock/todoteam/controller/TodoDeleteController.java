package org.zerock.todoteam.controller;

import org.apache.ibatis.session.SqlSession;
import org.zerock.todoteam.dao.MyBatisUtil;
import org.zerock.todoteam.dto.TodoDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

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
        System.out.println("tno :: " + tno);
        TodoDTO dto = TodoDTO.builder()
                .tno(Integer.parseInt(tno))
                .build();
        SqlSession session
                = MyBatisUtil.INSTANCE.getSqlSessionFactory().openSession(true);
        session.delete("org.zerock.todoteam.dao.TodoMapper.delete",dto);

        response.sendRedirect("/todo/list");
    }
}
