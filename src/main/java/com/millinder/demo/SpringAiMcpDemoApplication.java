package com.millinder.demo;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAiMcpDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAiMcpDemoApplication.class, args);
    }

    @Bean
    public ToolCallbackProvider weatherTools(WordEncoderService encoderService) {
        return MethodToolCallbackProvider.builder().toolObjects(encoderService).build();
    }

}
