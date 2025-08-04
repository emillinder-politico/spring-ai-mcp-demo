package com.millinder.demo;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringAiMcpDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAiMcpDemoApplication.class, args);
    }

    @Bean
    public ToolCallbackProvider weatherTools(List<ExposedTool> tools) {
        return MethodToolCallbackProvider.builder().toolObjects(tools.toArray()).build();
    }

}
