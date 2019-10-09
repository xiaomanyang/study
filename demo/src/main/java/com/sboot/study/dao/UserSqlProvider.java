package com.sboot.study.dao;

import com.sboot.study.domain.User;
import org.apache.ibatis.jdbc.SQL;

public class UserSqlProvider {

    public String insertSelective(User record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("wsjc_user");
        
        if (record.getAcc() != null) {
            sql.VALUES("acc", "#{acc,jdbcType=VARCHAR}");
        }
        
        if (record.getPwd() != null) {
            sql.VALUES("pwd", "#{pwd,jdbcType=VARCHAR}");
        }
        
        if (record.getUtype() != null) {
            sql.VALUES("utype", "#{utype,jdbcType=TINYINT}");
        }
        
        if (record.getPid() != null) {
            sql.VALUES("pid", "#{pid,jdbcType=INTEGER}");
        }
        
        if (record.getDes() != null) {
            sql.VALUES("des", "#{des,jdbcType=VARCHAR}");
        }
        
        if (record.getDataright() != null) {
            sql.VALUES("dataright", "#{dataright,jdbcType=BIT}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(User record) {
        SQL sql = new SQL();
        sql.UPDATE("wsjc_user");
        
        if (record.getAcc() != null) {
            sql.SET("acc = #{acc,jdbcType=VARCHAR}");
        }
        
        if (record.getPwd() != null) {
            sql.SET("pwd = #{pwd,jdbcType=VARCHAR}");
        }
        
        if (record.getUtype() != null) {
            sql.SET("utype = #{utype,jdbcType=TINYINT}");
        }
        
        if (record.getPid() != null) {
            sql.SET("pid = #{pid,jdbcType=INTEGER}");
        }
        
        if (record.getDes() != null) {
            sql.SET("des = #{des,jdbcType=VARCHAR}");
        }
        
        if (record.getDataright() != null) {
            sql.SET("dataright = #{dataright,jdbcType=BIT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}