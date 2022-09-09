package complete.login.activate.email.loginAndCreate.controller;

import complete.login.activate.email.loginAndCreate.mail.mailSenderImpl;
import complete.login.activate.email.loginAndCreate.user.UserRegisterService;
import complete.login.activate.email.loginAndCreate.user.UserRepository;
import complete.login.activate.email.loginAndCreate.user.Users;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@ControllerAdvice
@Slf4j
@CrossOrigin("*")
@RequestMapping("/")
@AllArgsConstructor
public class TemplateController {

    @Autowired
    final UserRegisterService userRegisterService;
    @Autowired
    final mailSenderImpl mailSender;
    @Autowired
    final UserRepository userService;


    @GetMapping("logins")
    public String getTemp(){
        return "logins";
    }
    @GetMapping("news")
    public String getNew(){
        return  "news";
    }
    @GetMapping("newt")
    public String getNewt(){
        return "newt";
    }

    @PostMapping("/save")
    public String add(@ModelAttribute @RequestBody Users users, Model model){
           model.addAttribute("users",users);
           userRegisterService.saveUsers(users);
           mailSender.mailSender(users.getEmail(),users.getPassword(),users.getFirstName());
           return "display_user";
    }
    @GetMapping("registers")
    public String showRegistrationForms(Model model) {
        Users users = new Users();
        model.addAttribute("users", users);
        return "registers";
    }
    @GetMapping("forgets")
    public String getForgets(Model model){
        Users users = new Users();
        model.addAttribute("users", users);
        return "forgets";
    }
    @PutMapping("/edit/{email}")
    public String editUser(@RequestBody Users users,@PathVariable("email") String email){
        userRegisterService.editUser(users,email);
        mailSender.mailSenderEdit(email,users.getPassword());
        return "login";
    }

    @PostMapping("/savet")
    public String addT(@ModelAttribute @RequestBody Users users, Model model){
        model.addAttribute("users",users);
        userRegisterService.saveTeacher(users);
        mailSender.mailSender(users.getEmail(),users.getPassword(),users.getFirstName());
        return "display_user";
    }
}
