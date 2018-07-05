package de.jochenchrist.springresourceserver.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RootController {

    private static final Logger logger = LoggerFactory.getLogger(RootController.class);

    /**
     * Simple endpoint to demonstrates how to inject OAuth2Authentication.
     */
    @GetMapping
    public String getRoot(OAuth2Authentication auth) {
        logger.info("Authenticated as principal {}", auth.getPrincipal());
        return String.format("It Works! Principal: '%s'", auth.getPrincipal());
    }

}
