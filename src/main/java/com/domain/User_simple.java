package com.domain;

/**
 * @program: mybatis
 * @description:
 * @author:
 * @create: 2019-07-24 17:49
 **/
public class User_simple {
    private  Integer user_id;
    private String  user_name;

    public User_simple(Integer user_id, String user_name) {
        this.user_id = user_id;
        this.user_name = user_name;
    }

    public User_simple() {
    }

    public Integer getUser_id() {
        return user_id;
    }


    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Override
    public String toString() {
        return "User_simple{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                '}';
    }
}
