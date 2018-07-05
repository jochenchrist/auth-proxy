package de.jochenchrist.springresourceserver;

import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.jwk.JwkTokenStore;

@EnableResourceServer
@Configuration
public class ResourceServerConfiguration {

    /**
     * Register a token store with custom UserAuthenticationConverter.
     */
    @Bean
    public TokenStore jwkTokenStore(ResourceServerProperties resource) {
        DefaultAccessTokenConverter tokenConverter = new DefaultAccessTokenConverter();
        tokenConverter.setUserTokenConverter(new OidcSubjectUserAuthenticationConverter());
        return new JwkTokenStore(resource.getJwk().getKeySetUri(), tokenConverter);
    }

}
