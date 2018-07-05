Spring Resource Server Demo
===

This is a minimal demo, with a Spring Boot 2.0 application to act as an OAuth 2.0 resource server behind an authentication proxy. 

It is demonstrated, how to convert the Bearer JWT's `sub` claim to a `Principal` with a custom `UserAuthenticationConverter`. 

Note: Alternativly, the Identity Provider could be configured to add the claim `user_name`, which is the default in spring-security-oauth.