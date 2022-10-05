package com.example.todo.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDate;

@Data   // getter setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
public class PageRequestDTO {

    @Builder.Default
    private int page = 1;
    @Builder.Default
    private int size = 10;

    private String keyword;

    private LocalDate from, to ;

    private boolean complete;

    public int getSkip() {
        page = page <= 1 ? 1 : page;
        size = size <= 10 ? 10 : (size >= 100 ? 100 : size);   // 삼항연산자 두 개

        log.info("-------------------------------");
        log.info(page);
        log.info(size);

        return (page - 1) * size;
    }


}
