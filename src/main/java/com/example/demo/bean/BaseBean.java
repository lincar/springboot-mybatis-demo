package com.example.demo.bean;

import java.io.Serializable;

/**
 * 实体一律采用序列化，方便缓冲，网络以及分布式的传输和储存。
 *
 * Created by rico on 2016/2/19.
 */
public class BaseBean implements Serializable{

    public static final Short OWNER = 100;
    public static final Short ADMIN = 90;
    public static final Short MEMBER = 80;
    public static final Short VISITOR = 70;
    public static final Short GUEST = 60;

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    protected Short getUserRole(User user) {
        return GUEST;
    }

    /**
     * 只要当前用户的权限比目标权限大的权限都会返回 true
     *
     * @param user 当前用户
     * @param role 当前用户的权限
     * @return boolean
     */
    public boolean checkRole(User user, Short role) {
        Short realRole = getUserRole(user);
        return realRole >= role;
    }

    /**
     * 当前用户的权限比如等于目标权限大的权限才会返回 true
     *
     * @param user 当前用户
     * @param role 当前用户的权限
     * @return boolean
     */
    public boolean checkRoleStrict(User user, Short role) {
        int realRole = getUserRole(user);
        return realRole == role;
    }
}
