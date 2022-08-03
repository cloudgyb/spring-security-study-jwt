package com.github.cloudgyb.ss.modules.sys.login;

import javax.validation.constraints.NotBlank;

/**
 * 用户登录凭证信息
 *
 * @author cloudgyb
 * @since 2022/7/31 12:09
 */
public class LoginInfo {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    private String captchaCode;

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

    public String getCaptchaCode() {
        return captchaCode;
    }

    public void setCaptchaCode(String captchaCode) {
        this.captchaCode = captchaCode;
    }
}
