package com.github.cloudgyb.ss.modules.sys.login;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.stream.Collectors;

/**
 * @author cloudgyb
 * @since 2022/7/31 12:07
 */
@Service
public class SysLoginService {
    private final JwtEncoder jwtEncoder;
    private final SpringSecurityUserDetailsService springSecurityUserDetailsService;

    public SysLoginService(JwtEncoder jwtEncoder, SpringSecurityUserDetailsService springSecurityUserDetailsService) {
        this.jwtEncoder = jwtEncoder;
        this.springSecurityUserDetailsService = springSecurityUserDetailsService;
    }

    public String login(LoginInfo loginInfo) {
        final UserDetails userDetails = springSecurityUserDetailsService.loadUserByUsername(loginInfo.getUsername());
        final String password = userDetails.getPassword();
        if (password.equals(loginInfo.getPassword())) {
            return generateToken(userDetails);
        }
        throw new BadCredentialsException("密码错误！");
    }

    private String generateToken(UserDetails userDetails) {
        Instant now = Instant.now();
        long expiry = 36000L;
        // @formatter:off
        String scope = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiry))
                .subject(userDetails.getUsername())
                .claim("scope", scope)
                .build();
        // @formatter:on
        return this.jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
}
