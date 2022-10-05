package com.example.todo.dao;

import com.example.todo.dto.PageRequestDTO;
import com.example.todo.dto.TodoDTO;
import lombok.Cleanup;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public enum TodoDAO {
    INSTANCE;

    public List<TodoDTO> getList(PageRequestDTO pageRequestDTO){
        @Cleanup SqlSession session
                = MyBatisUtil.INSTANCE.getSqlSessionFactory().openSession(true);

        List<TodoDTO> dtoList = session.selectList("com.example.todo.dao.TodoMapper.getList",pageRequestDTO);

        return dtoList;
    }

    public int getTotal(PageRequestDTO pageRequestDTO){
        @Cleanup SqlSession session
                = MyBatisUtil.INSTANCE.getSqlSessionFactory().openSession(true);

        int total = session.selectOne("com.example.todo.dao.TodoMapper.getTotal",pageRequestDTO);

        return total;
    }
    public void update(TodoDTO dto){
        SqlSession session
                =MyBatisUtil.INSTANCE.getSqlSessionFactory().openSession(true);
        session.update("com.example.todo.dao.TodoMapper.update",dto);
    }
    public void insert(TodoDTO dto){
        SqlSession session
                =MyBatisUtil.INSTANCE.getSqlSessionFactory().openSession(true);
        session.insert("com.example.todo.dao.TodoMapper.insert",dto);
    }
    public void delete(TodoDTO dto){
        SqlSession session
                =MyBatisUtil.INSTANCE.getSqlSessionFactory().openSession(true);
        session.delete("com.example.todo.dao.TodoMapper.delete",dto);
    }
}