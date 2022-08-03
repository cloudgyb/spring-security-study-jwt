package com.github.cloudgyb.ss.modules.sys.login;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Spring Security UserDetails对象
 *
 * @author cloudgyb
 * @since 2022/7/31 20:23
 */

public class SpringSecurityUserDetails extends User {
    private final Integer userId;

    public SpringSecurityUserDetails(Integer userId, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.userId = userId;
    }

    public SpringSecurityUserDetails(Integer userId, String username, String password, boolean enabled, boolean accountNonExpired,
                                     boolean credentialsNonExpired, boolean accountNonLocked,
                                     Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }
}
