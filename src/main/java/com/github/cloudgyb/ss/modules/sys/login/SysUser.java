package com.github.cloudgyb.ss.modules.sys.login;

import java.util.Date;

/**
 * 用户实体类
 *
 * @author cloudgyb
 * @since 2022/7/31 20:00
 */
public class SysUser {
    private Integer userId;
    private String username;
    private String password;
    private Date createTime;
    private Date passwordUpdateTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPasswordUpdateTime() {
        return passwordUpdateTime;
    }

    public void setPasswordUpdateTime(Date passwordUpdateTime) {
        this.passwordUpdateTime = passwordUpdateTime;
    }
}
