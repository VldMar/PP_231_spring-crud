package crud.controller;

import crud.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {


    @GetMapping
    public String showAllUsers(ModelMap model) {
        List<User> users = Arrays.asList(
                new User("user1", "lastname1", LocalDate.of(1990, 3, 4)),
                new User("user2", "lastname2", LocalDate.of(1996, 3, 5)),
                new User("user3", "lastname3", LocalDate.of(2000, 3, 6))
        );

        model.addAttribute("users", users);

        return "users/all-users";
    }

//    @GetMapping
//    public String editUser(int id) {
//        return "";
//    }

}
