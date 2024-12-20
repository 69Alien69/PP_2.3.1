package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    UserService userService;

    private UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "list";
    }

    @GetMapping("/add")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "add";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:list";
    }

    @PostMapping("/delete")
    public String removeUser(@RequestParam("userId") Long id) {
        userService.removeUserById(id);
        return "redirect:list";
    }

    @GetMapping("/edit")
    public String editUserForm(Model model, @RequestParam("userId") Long id) {
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:list";
    }

}
