package com.example.todo.controller;

import com.example.todo.dao.TodoDAO;
import com.example.todo.dto.PageRequestDTO;
import com.example.todo.dto.PageResponseDTO;
import com.example.todo.dto.TodoDTO;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Predicate;



@Log4j2
@Getter
@WebServlet(name = "TodoListController", value = "/todo/list")
public class TodoListController extends HttpServlet {

    protected int getInt(String value, int defaultValue, Predicate<Integer> predicate){
        try {
            int intValue = Integer.parseInt(value);

            if(predicate != null) {
                boolean result = predicate.test(intValue);

                if (!result) {
                    return defaultValue;
                }
            }

            return intValue;
        }catch(Exception e){
            return defaultValue;
        }
    }

    protected LocalDate getLocalDate(String value, boolean end){

        try{
            DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(value, DATEFORMATTER);

            return localDate;
        }catch(Exception e){
            if(end){
                return LocalDate.of(2100,12,31);
            }else{
                return LocalDate.of(1970,01,01);
            }

        }
    }

    protected void dispatch(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/views/" +page+".jsp").forward(request,response);

    }
    protected void redirect(HttpServletResponse response, String queryString) throws ServletException, IOException {

        response.sendRedirect(queryString);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int page = getInt(request.getParameter("page"), 1, (value) -> {
            if(value < 0){
                return false;
            }else {
                if(value > 100){
                    return false;
                }
            }
            return true;
        });

        int size = getInt(request.getParameter("size"), 10, null);

        LocalDate from = getLocalDate(request.getParameter("from"),false);
        LocalDate to = getLocalDate(request.getParameter("to"),true);


        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(page)
                .size(size)
                .from(from)
                .to(to)
                .build();

        log.info(pageRequestDTO);

        List<TodoDTO> dtoList = TodoDAO.INSTANCE.getList(pageRequestDTO);

        request.setAttribute("dtoList", dtoList);

        PageResponseDTO responseDTO
                = new PageResponseDTO(pageRequestDTO, TodoDAO.INSTANCE.getTotal(pageRequestDTO));

        request.setAttribute("pageDTO", responseDTO);

        dispatch(request,response, "todo/list");

    }


    /*@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        @Cleanup SqlSession session
                = MyBatisUtil.INSTANCE.getSqlSessionFactory().openSession(true); // true는 autoCommit을 의미

        List<TodoDTO> dtoList = session.selectList("com.example.todo.dao.TodoMapper.selectAll");

        request.setAttribute("todo", dtoList);

        request.getRequestDispatcher("/WEB-INF/views/todo/list.jsp").forward(request, response);

    }*/ // 페이징하기 전 무한 스크롤 기능
}

