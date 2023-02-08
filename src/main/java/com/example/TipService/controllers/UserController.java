package com.example.TipService.controllers;

import com.example.TipService.model.PasswordDto;
import com.example.TipService.model.UserDto;
import com.example.TipService.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private UserService userService;

    public UserController() {
    }

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "new_user";
    }

    @PostMapping("/add_user")
    public String addNewUser(@ModelAttribute("user") UserDto user) {
        userService.addNewUser(user);
        return "redirect:/";
    }

    @PutMapping("/user")
    public String editUserProfile(UserDto userDto) {
        userService.editUser(userDto);
        return "redirect:/";
    }

    @DeleteMapping("/delete")
    public String deleteProfile() {
        Long id = userService.getLoggedUserEntity().getId();
        userService.deleteUser(id);

        return "index";
    }

    @GetMapping("/user/password")
    public String getViewForChangingPassword(Model model) {
        model.addAttribute("password", new PasswordDto());
        return "change_password";
    }

    @PostMapping("/user/password")
    public String changePassword(PasswordDto passwordDto) {
        userService.changePassword(passwordDto);
        return "redirect:/";
    }

}





