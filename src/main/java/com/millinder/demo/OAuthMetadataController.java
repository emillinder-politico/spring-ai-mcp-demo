package com.millinder.demo;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/.well-known")
public class OAuthMetadataController {

    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri:#{null}}")
    private String issuerUri;

    @GetMapping(path = {"/oauth-protected-resource", "/oauth-protected-resource/**"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> getOAuthProtectedResourceMetadata(HttpServletRequest request) {
        Map<String, Object> metadata = new HashMap<>();

        String baseUrl = ServletUriComponentsBuilder.fromRequestUri(request)
                .replacePath(null)
                .build()
                .toUriString();

        // Required fields according to the spec
        metadata.put("resource", baseUrl);

        // Authorization servers that can issue tokens for this resource
        if (issuerUri != null) {
            metadata.put("authorization_servers", List.of(issuerUri));
        }

        return metadata;
    }
}
