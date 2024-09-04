package com.example.demo.Controller;

import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class DemoController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new User());
        return "user/form";
    }

    @PostMapping("/new")
    public String createUser(@RequestParam String name,
                            @RequestParam String email,
                            @RequestParam(required = false) String phone) {
        User user = new User(null, name, email, phone);
        userService.saveUser(user);
        return "user/form";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        User user = userService.getUserById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user", user);
        return "user/form";
    }

    @PostMapping("/edit/{id}")
    public String updateUser(@PathVariable Long id,
                            @RequestParam String name,
                            @RequestParam String email,
                            @RequestParam(required = false) String phone) {
        User user = new User(id, name, email, phone);
        userService.saveUser(user);
        return "user/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id, Model model) {
        userService.deleteUserById(id);
        model.addAttribute( "message", "User deleted succesfully!" );
        return "user/list";
    }
}