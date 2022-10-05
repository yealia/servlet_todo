package com.example.todo.dao;

import com.example.todo.dto.PageRequestDTO;
import com.example.todo.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

@Log4j2
public class TodoDAOTests {

    @Test
    public void testList() {

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .keyword("memo")
                .from(LocalDate.of(2022,10,01))
                .to(LocalDate.of(2022,10,10))
                .complete(true)
                .build();

        List<TodoDTO> list = TodoDAO.INSTANCE.getList(pageRequestDTO);

        list.forEach(todoDTO -> log.info(todoDTO ));

    }
}
