package com.github.cloudgyb.ss.modules.sys.login;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * A controller for the token resource.
 *
 * @author Josh Cummings
 */
@RestController
public class SysLoginController {
    private final SysLoginService sysLoginService;

    public SysLoginController(SysLoginService sysLoginService) {
        this.sysLoginService = sysLoginService;
    }


    @PostMapping("/login")
    public String login(@RequestBody LoginInfo loginInfo) {
        return sysLoginService.login(loginInfo);
    }

}
