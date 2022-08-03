package com.github.cloudgyb.ss.modules.sys.login;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cloudgyb
 * @since 2022/7/31 20:00
 */
@Service
public class SpringSecurityUserDetailsService implements UserDetailsService {
    private static final Map<String, SpringSecurityUserDetails> users = new HashMap<>(1);

    static {
        final SimpleGrantedAuthority app = new SimpleGrantedAuthority("app");
        users.put("admin", new SpringSecurityUserDetails(1,
                "admin", "123456",
                true, true, true, true,
                Collections.singletonList(app)));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final SpringSecurityUserDetails userDetails = users.get(username);
        if(userDetails == null)
            throw new UsernameNotFoundException(String.format("'%s' not existed!", username));
        return userDetails;
    }
}
