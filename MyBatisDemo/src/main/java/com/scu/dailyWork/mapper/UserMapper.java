package com.scu.dailyWork.mapper;

import com.scu.dailyWork.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    User selectUserById(int id);
    //通过Map的方式
    List<User> selectUserByAddrAndSexA(Map<String, Object> map);

    List<User> selectUserByAddrAndSexB(User user);
    List<User> selectUserByAddrAndSexC(@Param("user")User user);
    List<User> selectUserByAddrAndSexD(@Param("s")String sex,@Param("a")String address);


    List<User> selectUserByAddrA(@Param("addresses") String... addr );


    User selectUserByName(String nam);//演示 $ 和# 区别


    List<User> selectUserLikeNameA(String name);
    List<User> selectUserLikeNameB(String name);
    List<User> selectUserLikeNameC(@Param("name") String name);

}
