package com.example.TipService.controllers;

import com.example.TipService.model.UserDto;
import com.example.TipService.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private UserService userService;

    public UserController() {
    }

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/new_user")
    public String getUserForm(Model model) {
        model.addAttribute("user", new UserDto());
        UserDto user = new UserDto();
        return "new_user";
    }

    @PostMapping("/add_user")
    public String addNewUser( UserDto user) {
        userService.addNewUser(user);
        return "redirect:/profile";
    }
}




