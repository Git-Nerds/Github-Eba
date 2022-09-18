package complete.login.activate.email.loginAndCreate.controller;

import complete.login.activate.email.loginAndCreate.mail.mailSenderImpl;
import complete.login.activate.email.loginAndCreate.role.Role;
import complete.login.activate.email.loginAndCreate.role.RoleRepository;
import complete.login.activate.email.loginAndCreate.session.SessionHandler;
import complete.login.activate.email.loginAndCreate.user.UserRegister;
import complete.login.activate.email.loginAndCreate.user.UserRepository;
import complete.login.activate.email.loginAndCreate.user.UserService;
import complete.login.activate.email.loginAndCreate.user.Users;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
@ControllerAdvice
@Slf4j
@RequestMapping("/")
@AllArgsConstructor
public class TemplateController {

    @Autowired
    private UserService userService;
    @Autowired
    final UserRegister userRegister;
    @Autowired
    final mailSenderImpl mailSender;
    @Autowired
    final UserRepository userRepository;
    @Autowired
    final RoleRepository roleRepository;


    @GetMapping("/")
    public String viewUSer(){
        return "index";
    }
    @GetMapping("logins")
    public String getLogins(){
        return "logins";
    }
    @GetMapping("display_user")
    public String gsetLogins(){
        return "display_user";
    }
    @GetMapping("teacherPage")
    public String getTeacher(Model model){
        Users currentUser = userRepository.findByEmail(SessionHandler.getSession().getEmail()).get();
            model.addAttribute("teacherView",currentUser);
        return  "teacherPage";
    }
    @GetMapping("studentPage")
    public String getStudent(Model model){
        Users currentUser = userRepository.findByEmail(SessionHandler.getSession().getEmail()).get();
        model.addAttribute("users",currentUser);
        return "studentPage";
    }
    @GetMapping("adminPage")
    public String getAdmin(Model model){
        Users currentUser = userRepository.findByEmail(SessionHandler.getSession().getEmail()).get();
        model.addAttribute("adminView",currentUser);
        return "adminPage";
    }
    @GetMapping("superAdminPage")
    public String getAdminSuperAdmin(Model model){
        Users currentUser = userRepository.findByEmail(SessionHandler.getSession().getEmail()).get();
            model.addAttribute("superView", currentUser);
        return "superAdminPage";
    }

    //CREATING

    //REGISTER

    @PostMapping("/save")
    public String add(@ModelAttribute @RequestBody Users users, RedirectAttributes ra, Model model)throws IOException {
        model.addAttribute("users",users);
      try {
          userRegister.saveOrUpdateUser(users);
          ra.addFlashAttribute("message","Registered successfully please check your mail and login through this page");
//          return "confirm";
          return "display_user";
      }
      catch (Exception e){
          throw new IllegalStateException();
      }
    }
    @GetMapping("registration")
    public String showRegistrationForms(Model model) {
        Users users = new Users();
        model.addAttribute("users", users);
        return "registration";
    }
    @PostMapping("/save/teacher")
    public String addTeacher(@ModelAttribute @RequestBody Users users,RedirectAttributes ra, Model model){
        model.addAttribute("teacher",users);
        try {
            ra.addFlashAttribute("success","Registered successfully please check your mail and login through this page");
            userRegister.saveOrUpdateTeacher(users);
//            return "confirm";
            return "display_user";
        }
        catch (Exception e){
            throw new IllegalStateException();
        }
    }

    // ADMINS

    @PostMapping("/save/admin")
    public String addAdmin(@ModelAttribute @RequestBody Users admins, Model model){
        model.addAttribute("admins",admins);
     try {
         userRegister.saveOrUpdateAdmin(admins);
         return "display_user";
     }
     catch (Exception e){
         throw new IllegalStateException();
     }
    }
    @GetMapping("/addAdmin")
    public String showRegistrationFos(Model model) {
        Users admins = new Users();
        model.addAttribute("admins", admins);
        return "/addAdmin";
    }

    // SUPER ADMIN

    @PostMapping("/save/super/admin")
    public String addAdminSuperAdded(@ModelAttribute @RequestBody Users suAdmins, Model model){
        model.addAttribute("suAdmins",suAdmins);
     try {
         userRegister.saveOrUpdateAdmin(suAdmins);
//         return "confirm";
         return "display_user";
     }
     catch (Exception e){
         throw new IllegalStateException();
     }
    }
    @GetMapping("addAdminsSuper")
    public String showRegistrationFs(Model model) {
        Users suAdmins = new Users();
        model.addAttribute("suAdmins", suAdmins);
        Users supers = new Users();
        model.addAttribute("suAdmins", supers);
        return "addAdminsSuper";
    }
    @PostMapping("/save/super")
    public String addAdminSupers(@ModelAttribute @RequestBody Users supers, Model model){
        model.addAttribute("suAdmins",supers);
       try {
            userRegister.saveOrUpdateSuper(supers);
           return "display_user";
       }
       catch (Exception e){
           throw new IllegalStateException();
       }
    }


    // NEW CODE ARRIVING SEP 14

    @Autowired
    private UserService service;
    @GetMapping("view")
    public String home(Users users, Model model) {
        List<Users> list = userRepository.findAll();
        model.addAttribute("list", list);
        return "view";
    }

    @GetMapping("/add")
    public String showAddForm(Users shop, Model model) {
        return "add-shop";
    }

    @PostMapping("/saveShop")
    public String create(Users users, Model model) {
        userRegister.saveOrUpdateUser(users);
        return "redirect:/view";
    }
    @RequestMapping(path = { "/update","/update/{id}"})
    public String update(Model model,@PathVariable("id") Long id) {
        if(id!=null) {
            Users users = userRegister.getAllUsersById(id);
            model.addAttribute("users", users);
        }else {
            model.addAttribute("users", new Users());
        }
        return "add-shop";
    }

    @RequestMapping(path = { "/delete/{id}"})
    public String delete(Model model, @PathVariable("id") Long id) {
        userRegister.deleteUser(id);
        return "redirect:/view";
    }

        // SEPT 18

    @RequestMapping(path = { "/view","/view/{type}"})
    public String viewAll(Model model, @PathVariable("type") String type){
        List<Users> list = userRegister.getAllByRole(type);
        model.addAttribute("list", list);
        return "viewUser";
    }











            // PASSWORD

//    @GetMapping("/forget_password")
//    public String showForgotPasswordForm() {
//        return "forget_password";
//    }
////    @SneakyThrows
//    @PostMapping("/forgot_password")
//    public String processForgotPassword(HttpServletRequest request, Model model) throws Exception {
//        String email = request.getParameter("email");
//        String token = RandomString.make(30);
//
//        try {
//            userService.updateResetPasswordToken(token, email);
//            String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token=" + token;
//            mailSender.mailSenderEdit(email, resetPasswordLink);
//            model.addAttribute("message", "We have sent a reset password link to your email. Please check.");
//
//        } catch (UsernameNotFoundException ex) {
//            model.addAttribute("error", ex.getMessage());
//        } catch (UnsupportedEncodingException | MessagingException e) {
//            model.addAttribute("error", "Error while sending email");
//        }
//        return "forget_password";
//    }
//
//    @GetMapping("/reset_password")
//    public String showResetPasswordForm(@Param(value = "token") String token, Model model) {
//        Users customer = userService.getByResetPasswordToken(token);
//        model.addAttribute("token", token);
//
//        if (customer == null) {
//            model.addAttribute("message", "Invalid Token");
//            return "message";
//        }
//
//        return "reset_password";
//    }
//
//    @PostMapping("/reset_password")
//    public String processResetPassword(HttpServletRequest request, Model model) {
//        String token = request.getParameter("token");
//        String password = request.getParameter("password");
//
//        Users customer = userService.getByResetPasswordToken(token);
//        model.addAttribute("title", "Reset your password");
//
//        if (customer == null) {
//            model.addAttribute("message", "Invalid Token");
//            return "message";
//        } else {
//            userService.updatePassword(customer, password);
//
//            model.addAttribute("message", "You have successfully changed your password.");
//        }
//
//        return "message";
//    }

}
