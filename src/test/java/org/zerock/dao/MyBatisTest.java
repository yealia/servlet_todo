package org.zerock.dao;

import com.sun.tools.javac.comp.Todo;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.zerock.todoteam.dao.MyBatisUtil;
import org.zerock.todoteam.dto.TodoDTO;

import java.time.LocalDate;
import java.util.List;

@Log4j2
public class MyBatisTest {

    @Test
    public void tesstSelectAll(){
        SqlSession session
                = MyBatisUtil.INSTANCE.getSqlSessionFactory().openSession(true);
        List<TodoDTO> dToList = session.selectList("org.zerock.todoteam.dao.TodoMapper.selectAll");
        dToList.forEach(todoDTO -> log.info(todoDTO));
    }
    @Test
    public void testInsert(){
        TodoDTO dto = TodoDTO.builder().title("yealim").memo("today is yealim day").dueDate(LocalDate.now()).build();
        SqlSession session
                = MyBatisUtil.INSTANCE.getSqlSessionFactory().openSession(true);
        session.insert("org.zerock.todoteam.dao.TodoMapper.insert",dto);
    }
    @Test
    public void testDelete(){
        TodoDTO dto = TodoDTO.builder().tno(16).build();
        SqlSession session
                = MyBatisUtil.INSTANCE.getSqlSessionFactory().openSession(true);
        session.delete("org.zerock.todoteam.dao.TodoMapper.delete",dto);
    }
    @Test
    public void testUpdate(){
        TodoDTO dto = TodoDTO.builder().title("yealia").memo("yayaya").dueDate(LocalDate.parse("2022-12-25")).tno(17).build();
        SqlSession session
                = MyBatisUtil.INSTANCE.getSqlSessionFactory().openSession(true);
        session.update("org.zerock.todoteam.dao.TodoMapper.update",dto);
    }
    @Test
    public void testSelect(){
        TodoDTO dto = TodoDTO.builder()
                .tno(22)
                .build();
        SqlSession session
                = MyBatisUtil.INSTANCE.getSqlSessionFactory().openSession(true);
        TodoDTO dtoOne = session.selectOne("org.zerock.todoteam.dao.TodoMapper.select",dto);
        System.out.println(dtoOne);
    }

}
