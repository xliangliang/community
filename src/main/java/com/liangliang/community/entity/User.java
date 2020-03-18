package com.liangliang.community.entity;

import java.io.Serializable;

public class User implements Serializable {
    private Long id;
    private String name;
    private String phone;
    private String mail;
    private Long createTime;

    public User() {
    }

    public User(Long id, String name, String phone, String mail, Long createTime) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
