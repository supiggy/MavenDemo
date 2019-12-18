package com.scu.dailyWork.mapper;

import com.scu.dailyWork.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class UserMapperTest {
    SqlSession sqlSession;
    UserMapper mapper;
    @Before
    public void before(){
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
            //创建ssf
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //打开sqlSession
            sqlSession = sqlSessionFactory.openSession();
            mapper = sqlSession.getMapper(UserMapper.class);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void testSelectUserById(){
        User user = mapper.selectUserById(3);
        System.out.println(user);
    }
    @Test
    public void testSelectUserByAddrAndSexA(){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("sex","0");
        map.put("address","上海");

        List<User> users = mapper.selectUserByAddrAndSexA(map);
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void testSelectUserByAddrAndSexB(){
        User user = new User();
        user.setSex("0");
        user.setAddress("上海");

        List<User> users = mapper.selectUserByAddrAndSexB(user);
        for (User u : users) {
            System.out.println(u);
        }
    }

    @Test
    public void testSelectUserByAddrAndSexC(){
        User user = new User();
        user.setSex("0");
        user.setAddress("上海");

        List<User> users = mapper.selectUserByAddrAndSexC(user);
        for (User u : users) {
            System.out.println(u);
        }
    }

    @Test
    public void testSelectUserByAddrAndSexD(){
        List<User> users = mapper.selectUserByAddrAndSexD("0","上海");
        for (User u : users) {
            System.out.println(u);
        }
    }


    @Test
    public void testSelectUserByAddrA(){
        List<String> list = new ArrayList();
        list.add("北京");
        list.add("成都");
        list.add("广州");

        String[] strs = list.toArray(new String[]{});
        List<User> users = mapper.selectUserByAddrA(strs);
//        List<User> users2 = mapper.selectUserByAddrAndSexD(new String[]{"广州","上海"});
        for (User u : users) {
            System.out.println(u);
        }
    }

    @Test
    public void testArrayt2List(){
        String[] str = new String[]{"中国","美国","印度","泰国","韩国"};
       /* boolean is = false;
        for (int i = 0; i < str.length; i++) {
            String each = str[i];
            if(each.equals("泰国")){
                is=true;
                break;
            }
        }*/

        List<String> list = Arrays.asList(str);// 数组  ---> List
        String[] arr = list.toArray(new String[]{});//List  ---> 数组
        if(Arrays.asList(str).contains("泰国")){
            System.out.println("我活腻了");
        }else{
            System.out.println("我活得很潇洒!");
        }
    }

    @Test
    public void testSelectUserByName(){
        User user = mapper.selectUserByName("王八");

        System.out.println(user);
    }

    @Test
    public void testSelectUserLikeNameA(){
        List<User> userList = mapper.selectUserLikeNameA("王");// 危险
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testSelectUserLikeNameB(){
        List<User> userList = mapper.selectUserLikeNameB("王");// 危险
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testSelectUserLikeNameC(){
        List<User> userList = mapper.selectUserLikeNameC("王");// 危险
        for (User user : userList) {
            System.out.println(user);
        }
    }

}