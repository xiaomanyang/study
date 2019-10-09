package com.sboot.study.dao;

import com.sboot.study.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Delete({
        "delete from wsjc_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into wsjc_user (acc, pwd, ",
        "utype, pid, des, ",
        "dataright)",
        "values (#{acc,jdbcType=VARCHAR}, #{pwd,jdbcType=VARCHAR}, ",
        "#{utype,jdbcType=TINYINT}, #{pid,jdbcType=INTEGER}, #{des,jdbcType=VARCHAR}, ",
        "#{dataright,jdbcType=BIT})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(User record);

    int insertSelective(User record);

    @Select({
        "select",
        "id, acc, pwd, utype, pid, des, dataright",
        "from wsjc_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.sboot.study.dao.UserMapper.BaseResultMap")
    User selectByPrimaryKey(Integer id);

//    @Select("select * from wsjc_user")
    List<User> selectAll();

    int updateByPrimaryKeySelective(User record);

    @Update({
        "update wsjc_user",
        "set acc = #{acc,jdbcType=VARCHAR},",
          "pwd = #{pwd,jdbcType=VARCHAR},",
          "utype = #{utype,jdbcType=TINYINT},",
          "pid = #{pid,jdbcType=INTEGER},",
          "des = #{des,jdbcType=VARCHAR},",
          "dataright = #{dataright,jdbcType=BIT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
}