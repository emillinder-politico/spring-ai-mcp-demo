package com.millinder.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.modelcontextprotocol.server.transport.HttpServletStreamableServerTransportProvider;
import io.modelcontextprotocol.spec.McpStreamableServerTransportProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@EnableWebMvc
public class McpServerConfig {
//    @Bean
//    public McpStreamableServerTransportProvider transportProvider(ObjectMapper objectMapper) {
//        return new HttpServletStreamableServerTransportProvider.Builder().objectMapper(objectMapper).mcpEndpoint("/mcp").build();
//    }
//    @Bean
//    public ServletRegistrationBean customServletBean(McpStreamableServerTransportProvider transportProvider) {
//        return new ServletRegistrationBean(transportProvider, "/mcp");
//    }
}
//public class McpServerConfig implements WebMvcConfigurer {
//
//    @Bean
//    public HttpServletSseServerTransportProvider servletSseServerTransportProvider() {
//        return new HttpServletSseServerTransportProvider(new ObjectMapper(), "/mcp/message");
//    }
//
//    @Bean
//    public ServletRegistrationBean customServletBean(HttpServletSseServerTransportProvider transportProvider) {
//        return new ServletRegistrationBean(transportProvider);
//    }
//}
