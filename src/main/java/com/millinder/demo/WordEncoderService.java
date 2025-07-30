package com.millinder.demo;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

@Service
public class WordEncoderService {
    @Tool(name = "eric_encoder",
            description = "Encode input in eric format")
    public String doEricEncoding(@ToolParam(description = "The text to encode in eric format")
    String input) {
        return "eric" + input + "cire";
    }
}
