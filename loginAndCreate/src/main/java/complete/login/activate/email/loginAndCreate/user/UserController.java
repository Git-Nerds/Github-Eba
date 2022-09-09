//package complete.login.activate.email.loginAndCreate.user;
//
//import complete.login.activate.email.loginAndCreate.mail.mailSenderImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.parameters.P;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping(path = "api/v1")
//public class UserController {
//
//    @Autowired
//    final UserRegisterService userRegisterService;
//    @Autowired
//    final mailSenderImpl mailSender;
//
//
//    public UserController(UserRegisterService userRegisterService, mailSenderImpl mailSender) {
//        this.userRegisterService = userRegisterService;
//        this.mailSender = mailSender;
//    }
//
//    @PostMapping("/save")
//    public String add(@RequestBody Users users){
//           userRegisterService.saveUsers(users);
//           mailSender.mailSender(users.getEmail(),users.getPassword(),users.getFirstName());
//           return "register";
//    }
//    @GetMapping("/register")
//    public String showRegistrationForm(Model model) {
//        model.addAttribute("user", new Users());
//
//        return "register";
//    }
//    @PutMapping("/edit/{email}")
//    public String editUser(@RequestBody Users users, @PathVariable("email") String email){
//        return userRegisterService.editUser(users,email);
//    }
//}
