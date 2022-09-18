//package complete.login.activate.email.loginAndCreate.controller;
//
//import complete.login.activate.email.loginAndCreate.mail.mailSenderImpl;
//import complete.login.activate.email.loginAndCreate.passwords.Utility;
//import complete.login.activate.email.loginAndCreate.user.UserService;
//import complete.login.activate.email.loginAndCreate.user.Users;
//import lombok.SneakyThrows;
//import net.bytebuddy.utility.RandomString;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.repository.query.Param;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.mail.MessagingException;
//import javax.servlet.http.HttpServletRequest;
//import java.io.UnsupportedEncodingException;
//
//@RestController
//public class ForgetPasswordController {
//
//    @Autowired
//    private mailSenderImpl mailSender;
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/forgot_password")
//    public String showForgotPasswordForm() {
//        return "forget_password";
//    }
//    @SneakyThrows
//    @PostMapping("/forgot_password")
//    public String processForgotPassword(HttpServletRequest request, Model model) {
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
//        return "reset-password";
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
//}
//
//
