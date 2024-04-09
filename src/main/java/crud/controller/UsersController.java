package crud.controller;

import crud.model.User;
import crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showAllUsers(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users/all-users";
    }

    @GetMapping("/add")
    public String showFormForCreateUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "users/add-user";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String showFormForUpdateUser(@RequestParam("id") Long userId, Model model) {
        User user = userService.findUserById(userId);
        model.addAttribute("user", user);
        return "users/update-user";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/remove")
    public String removeUser(@RequestParam("id") Long userId) {
        userService.removeUserById(userId);
        return "redirect:/";
    }
}
