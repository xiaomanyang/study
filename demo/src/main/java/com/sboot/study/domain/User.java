package com.sboot.study.domain;

import java.io.Serializable;

public class User implements Serializable {
    private Integer id;

    private String acc;

    private String pwd;

    private Byte utype;

    private Integer pid;

    private String des;

    private Boolean dataright;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc == null ? null : acc.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public Byte getUtype() {
        return utype;
    }

    public void setUtype(Byte utype) {
        this.utype = utype;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des == null ? null : des.trim();
    }

    public Boolean getDataright() {
        return dataright;
    }

    public void setDataright(Boolean dataright) {
        this.dataright = dataright;
    }
}