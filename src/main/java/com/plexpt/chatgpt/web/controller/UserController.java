package com.plexpt.chatgpt.web.controller;

import com.plexpt.chatgpt.web.domain.AjaxResult;
import com.plexpt.chatgpt.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    @ResponseBody
    public Object func(){
        return AjaxResult.success(userService.findAll());
    }

    @GetMapping
    public String home() {
        return "Hello, World!";
    }

}
