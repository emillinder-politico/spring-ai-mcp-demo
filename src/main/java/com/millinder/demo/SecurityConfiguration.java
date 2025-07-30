package com.millinder.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // or @EnableWebFluxSecurity for reactive applications
public class SecurityConfiguration {
    private final Logger logger = LoggerFactory.getLogger(SecurityConfiguration.class);

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().authenticated() // Protect all requests by default
                )
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(Customizer.withDefaults()) // Configure JWT processing
                );
        return http.build();
    }

    // For JWTs, you'll need a JwtDecoder bean to validate and decode tokens.
    // This could involve configuring a JWK Set URI or providing a public key.
     @Bean
     public JwtDecoder jwtDecoder() {
        return (token ) -> {
            logger.info("JWT Token: {}", token);
            return null;
        };
      }
}
