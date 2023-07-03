package com.example.helloworld.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.helloworld.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT * FROM t_user WHERE id=#{id}")
    User selectById(int id);

    @Select("SELECT * FROM  t_user")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "birthday", property = "birthday"),
            @Result(column = "id", property = "orders", javaType = List.class,
                    many = @Many(select = "com.example.helloworld.mapper.OrderMapper.selectByUid"))
    }
    )
    List<User> selectAllUserAndOrders();

}

//import com.example.helloworld.entity.User;
//import org.apache.ibatis.annotations.*;
//import java.util.List;
//
//@Mapper
//public interface UserMapper {
//
//    @Select("SELECT * FROM ${user}")
//    public List<User> selectList(String user);
//
//    @Select("SELECT * FROM user WHERE id=#{id}")
//    public User selectById(int id);
//
//    @Insert("INSERT INTO user VALUES (#{id},#{username},#{password},#{birthday})")
//    public int insert(User user);
//
//    @Update("UPDATE user SET username=#{username},password=#{password},birthday=#{birthday} WHERE id=#{id}")
//    public int update(User user);
//
//    @Delete("DELETE FROM user WHERE id=#{id}")
//    public int delete(int id);
//
//
//}
