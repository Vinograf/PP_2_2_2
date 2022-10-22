package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImp;

@Controller
public class UserController {

    private final UserService userService = new UserServiceImp();

    @RequestMapping(method = RequestMethod.GET)
    public String printUser(Model model) {
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
        User user = new User();
        model.addAttribute("user", user);
        return "edit_user";

    }

    @PostMapping("/edit/{id}")
    public String updateStudent(@PathVariable int id,
                                @ModelAttribute("user") User user,
                                Model model) {
        User existingUser = userService.getById(id);
        existingUser.setId(user.getId());
        existingUser.setAge(user.getAge());
        existingUser.setName(user.getName());
        userService.edit(existingUser);
        return "redirect:/";
    }


}