package com.sboot.study.mapper;

import com.sboot.study.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @outhor wcl
 * @create 2019-10-08 12:43
 */
@Mapper
public interface UserMapper {
    @Select("select * from sys_user")
    List<SysUser> selectAll();
}
