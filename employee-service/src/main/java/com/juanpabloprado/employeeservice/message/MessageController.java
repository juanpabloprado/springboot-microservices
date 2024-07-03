package com.juanpabloprado.employeeservice.message;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("api/message")
public class MessageController {

    @Value("${message:Hello default}")
    private String message;

    @GetMapping
    public String message(){
        return message;
    }
}