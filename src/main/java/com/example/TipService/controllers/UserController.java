package com.example.TipService.controllers;

import com.example.TipService.model.UserDto;
import com.example.TipService.model.UserProfileDto;
import com.example.TipService.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

    private UserService userService;

    public UserController() {
    }

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public RedirectView editUserProfile(@ModelAttribute UserProfileDto userProfileDto) {
        userService.editUser(userProfileDto);
        return new RedirectView("/");
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
//    @PostMapping("/delete")
//    public String deleteProfile() {
//        Long id = userService.getLoggedUser().getId();
//        userService.deleteUser(id);
//
//        return "index";
//    }
}




