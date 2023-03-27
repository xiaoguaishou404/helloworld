package com.example.helloworld.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.helloworld.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

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
