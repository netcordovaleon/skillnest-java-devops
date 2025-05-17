package com.skillnest.docker.com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/example")
public class ExampleController {

    @GetMapping("")
    public String getString() throws InterruptedException {
        return "Hola mundo desde docker";
    }
}
