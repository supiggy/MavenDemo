package com.scu.dailyWork.main;

import com.scu.dailyWork.mapper.UserMapper;
import com.scu.dailyWork.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {

        //读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
        //创建ssf
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
        //打开sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUserById(1);
        System.out.println(user);

        sqlSession.close();
    }
}
