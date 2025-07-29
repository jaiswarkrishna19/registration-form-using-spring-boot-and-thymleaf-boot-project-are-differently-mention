package com.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.data.model.User;
import com.data.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("user", new User());
        return "adduser";
    }

    @PostMapping("/add")
    public String saveOrUpdateUser(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
        boolean isNew = (user.getU_id() == null);
        service.add_user(user);

        if (isNew) {
            redirectAttributes.addFlashAttribute("message", "User added successfully!");
        } else {
            redirectAttributes.addFlashAttribute("message", "User updated successfully!");
        }

        return "redirect:/get";
    }

    @GetMapping("/get")
    public String getAllUser(Model model) {
        List<User> list = service.get_all_user();
        model.addAttribute("list", list);
        return "getdata";
    }

    @GetMapping("/delete/{u_id}")
    public String deleteUser(@PathVariable int u_id, RedirectAttributes redirectAttributes) {
        service.delete_user_by_id(u_id);
        redirectAttributes.addFlashAttribute("message", "User deleted successfully!");
        return "redirect:/get";
    }

    @GetMapping("/get/{u_id}")
    public String getUserById(@PathVariable int u_id, Model model) {
        User user = service.get_user_by_id(u_id);
        model.addAttribute("user", user);
        return "adduser";
    }
}