package org.zerock.todoteam.dao;

import org.apache.ibatis.session.SqlSession;
import org.zerock.todoteam.dto.TodoDTO;

import java.util.List;

public enum TodoDAO {
    INSTANCE;

    public List<TodoDTO> selectAll(){
        SqlSession session
                = MyBatisUtil.INSTANCE.getSqlSessionFactory().openSession(true);
        List<TodoDTO> dToList = session.selectList("org.zerock.todoteam.dao.TodoMapper.selectAll");
        return dToList;
    }

    public TodoDTO selectOne(int i){
        SqlSession session
                =MyBatisUtil.INSTANCE.getSqlSessionFactory().openSession(true);
        TodoDTO todoDTO = session.selectOne("org.zerock.todoteam.dao.TodoMapper.selectOne");
        return todoDTO;
    }

    public void insert(){
        SqlSession session
                =MyBatisUtil.INSTANCE.getSqlSessionFactory().openSession(true);
        session.insert("org.zerock.todoteam.dao.TodoMapper.insert");

    }
    public void delete(){
        SqlSession session
                =MyBatisUtil.INSTANCE.getSqlSessionFactory().openSession(true);
        session.delete("org.zerock.todoteam.dao.TodoMapper.delete");
    }
    public void update(){
        SqlSession session
                =MyBatisUtil.INSTANCE.getSqlSessionFactory().openSession(true);
        session.delete("org.zerock.todoteam.dao.TodoMapper.update");
    }

}
