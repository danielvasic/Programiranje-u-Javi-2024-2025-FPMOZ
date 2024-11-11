package ba.sum.fpmoz.mymath.controller;

import ba.sum.fpmoz.mymath.model.User;
import ba.sum.fpmoz.mymath.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MyFirstController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/")
    public String index () {
        return "index";
    }

    @GetMapping("/users")
    public String users (Model model)  {
        List<User> users = this.usersRepository.findAll();
        model.addAttribute("users", users);
        return "users";
    }
}