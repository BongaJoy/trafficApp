package com.traffic.trafficApp;

import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository repo;

    @GetMapping("")
    public String  viewHomePage()
    {
        return "ticket";
    }


    @GetMapping("/register")
    public String showSignUpForm(Model model)
    {
        model.addAttribute("user", new User());
        return "signup_form";
    }

    @GetMapping("/ticketPage")
    public String showTicketWelcomePage(Model model)
    {
        return "ticketPage";
    }

    @GetMapping("/login")
    public String loginPage(Model model)
    {
        return "login";
    }

    @GetMapping("/password")
    public String showPasswordResetPage(Model model)
    {
        return "password";
    }
    @PostMapping("/process_register")
    public String processRegistration(User user)
    {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePassword = encoder.encode(user.getPassword());
        user.setPassword(encodePassword);

        repo.save(user);
        return "register_success";
    }

    @GetMapping("/users")
    public String viewUsersList(Model model){
        List<User> listUsers = repo.findAll();
        model.addAttribute("listUsers", listUsers);
        return "users";
    }


}
