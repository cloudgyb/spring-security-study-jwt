package com.github.cloudgyb.ss.modules.app;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A controller for the hello resource.
 *
 * @author Josh Cummings
 */
@RestController
public class HelloController {

    @GetMapping("/")
    @PreAuthorize("hasAuthority('gfgfdg')")
    public String hello(Authentication authentication) {
        return "Hello, " + authentication.getName() + "!";
    }

}
