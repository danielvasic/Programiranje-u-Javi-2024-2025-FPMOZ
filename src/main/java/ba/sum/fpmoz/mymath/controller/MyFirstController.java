package ba.sum.fpmoz.mymath.controller;

import ba.sum.fpmoz.mymath.model.User;
import ba.sum.fpmoz.mymath.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MyFirstController {

    @Autowired
    private UsersRepository usersRepository;

    private PasswordEncoder encoder;

    public MyFirstController(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

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

    @GetMapping("/register")
    public String register () {
        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(User user) {
        user.setPassword(this.encoder.encode(user.getPassword()));
        this.usersRepository.save(user);
        return "redirect:/users";
    }

    @GetMapping("/login")
    public String login () {
        return "login";
    }


}
