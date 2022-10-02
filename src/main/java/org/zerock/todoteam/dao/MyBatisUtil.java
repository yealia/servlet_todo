package org.zerock.todoteam.dao;

import jdk.internal.loader.Resource;
import lombok.Getter;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.zerock.todoteam.dto.TodoDTO;

import java.io.InputStream;
import java.util.List;

@Getter
public enum MyBatisUtil {
    INSTANCE;

    private SqlSessionFactory sqlSessionFactory;

    MyBatisUtil(){
        try{
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //Resource.getResourceAsStream Resource파일 읽기
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //sqlSessionFactory Mybatis사용하면 생기는 sql 생성 공장

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


}
