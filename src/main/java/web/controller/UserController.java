package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired()
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String users(Model model) {
        model.addAttribute("users", userService.printUser());
        return "users";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping("/add")
    public String createUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "create_user";

    }

    @PostMapping("/")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public String editUser(Model model, @PathVariable int id) {
        model.addAttribute(userService.getById(id));
        return "edit_user";

    }

    @PostMapping("/edit/{id}")
    public String updateStudent(User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit_user";
        } else {
            userService.edit(user);
            return "redirect:/";
        }
    }


}