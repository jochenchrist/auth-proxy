package de.jochenchrist.springresourceserver;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;

import java.util.Collections;
import java.util.Map;

/**
 * Use "sub" claim from JWT as principal to conform OpenID Connect conventions.
 * The default behaviour from DefaultUserAuthenticationConverter is to use the claim "user_name".
 *
 * For simplicity, this converter does not include any authorities (i. e. roles) from the JWT.
 */
public class OidcSubjectUserAuthenticationConverter implements UserAuthenticationConverter {

    private static final String SUBJECT_CLAIM = "sub";

    @Override
    public Authentication extractAuthentication(Map<String, ?> map) {
        if (map.containsKey(SUBJECT_CLAIM)) {
            Object principal = map.get(SUBJECT_CLAIM);
            return new UsernamePasswordAuthenticationToken(principal, "N/A", Collections.emptyList());
        }
        return null;
    }

    @Override
    public Map<String, ?> convertUserAuthentication(Authentication authentication) {
        throw new UnsupportedOperationException("convertUserAuthentication is not supported");
    }

}
