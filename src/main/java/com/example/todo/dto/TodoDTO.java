package com.example.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder // 컬럼을 짓는다. MyBatis에서 쓰는지는 미지수 (0930 13:55)
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO {

    private Integer tno;
    private String title;
    private String memo;
    private LocalDate dueDate;
    private boolean complete;

    private LocalDateTime regDate, modDate;

}
