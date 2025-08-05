package com.example.dbgittry;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloWorldController {

    private final MessageService messageService;

    public HelloWorldController(MessageService messageService) {
        this.messageService = messageService;
    }


    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello, World!";
    }

    @PostMapping("/messages")
    public String saveMessage(@RequestBody String messageContent) {
        messageService.saveMessage(messageContent);
        return "Message saved successfully";
    }

    @GetMapping("/messages")
    public List<String> getAllMessages() {
        return messageService.getAllMessageContents();
    }
}
