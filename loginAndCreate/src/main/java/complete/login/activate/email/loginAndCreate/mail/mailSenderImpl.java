package complete.login.activate.email.loginAndCreate.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class mailSenderImpl implements mailSenderService {


    @Autowired
    private JavaMailSender javaMailSender;


    @Override
    public void mailSender(String email,
                         String password,
                         String fName){

        String msg = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:th=\"http://www.thymeleaf.org\">\n" +
                "<head>\n" +
                "\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n" +
                "\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "\t<title>w3newbie HTML Email</title>\n" +
                "\n" +
                "\t<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css/\">\n" +
                "\t<style type=\"text/css\">\n" +
                "\t\tbody {\n" +
                "\t\t\tMargin: 0;\n" +
                "      background-color: #f6f9fc;\n" +
                "\t\t}\n" +
                "\t\ttable {\n" +
                "\t\t\tborder-spacing: 0;\n" +
                "\t\t}\n" +
                "\t\ttd {\n" +
                "\t\t\tpadding: 0;\n" +
                "\t\t}\n" +
                "\t\timg {\n" +
                "\t\t\tborder: 0;\n" +
                "\t\t}\n" +
                "    .wrapper{\n" +
                "      width: 100%;\n" +
                "      background-color: #f6f9fc;\n" +
                "      padding-bottom: 40px;\n" +
                "    }\n" +
                "\n" +
                "    .webkit {\n" +
                "      max-width: 600px;\n" +
                "      background-color: white\n" +
                "    }\n" +
                "\n" +
                ".outer{\n" +
                "  Margin: 0 auto;\n" +
                "  width: 100%;\n" +
                "  max-width: 600px;\n" +
                "  border-spacing: 0;\n" +
                "  font-family: sans-serif;\n" +
                "  color: #4A4A4A;\n" +
                "}\n" +
                ".three-columns{\n" +
                "\ttext-align: center;\n" +
                "\tfont-size: 0;\n" +
                "\tpadding-top: 40px;\n" +
                "\tpadding-bottom: 30px;\n" +
                "}\n" +
                ".three-columns .columns{\n" +
                "\twidth: 100%\n" +
                "\tmax-width: 200px;\n" +
                "\tdisplay: inline-block;\n" +
                "\tvertical-align: top;\n" +
                "}\n" +
                ".padding {\n" +
                "\tpadding: 15px;\n" +
                "}\n" +
                ".three-columns .content{\n" +
                "\tfont-size: 15px;\n" +
                "\tline-height: 20px;\n" +
                "}\n" +
                "a {\n" +
                "\ttext-decoration: none;\n" +
                "\tcolor: #388CDA;\n" +
                "\tfont-size: 16px;\n" +
                "}\n" +
                "\n" +
                "body footer{\n" +
                "  margin-top: 100px;\n" +
                "  margin-bottom: 0px;\n" +
                "padding-bottom: 0px;\n" +
                "}\n" +
                "\n" +
                ".social-text {\n" +
                "  padding: 0.7rem 0;\n" +
                "  font-size: 1rem;\n" +
                "}\n" +
                "\n" +
                ".social-media {\n" +
                "  display: flex;\n" +
                "  justify-content: center;\n" +
                "  margin-bottom: 20px;\n" +
                "}\n" +
                "\n" +
                ".social-icon {\n" +
                "  height: 46px;\n" +
                "  width: 46px;\n" +
                "  display: flex;\n" +
                "  justify-content: center;\n" +
                "  align-items: center;\n" +
                "  margin: 0 0.45rem;\n" +
                "  color:  #F5F5F5;\n" +
                "  border-radius: 50%;\n" +
                "  border: 1px solid #333;\n" +
                "  text-decoration: none;\n" +
                "  font-size: 1.1rem;\n" +
                "  transition: 0.3s;\n" +
                "}\n" +
                "\n" +
                ".social-icon:hover {\n" +
                "  color: black;\n" +
                "  border-color: black;\n" +
                "\n" +
                "  height: 56px;\n" +
                "  width: 56px;\n" +
                "\n" +
                "}\n" +
                "\n" +
                "#p43{\n" +
                "font-size: 40px;\n" +
                "color:black;\n" +
                "}\n" +
                "\n" +
                "#follow{\n" +
                "  font-family: \"serif\", cursive;\n" +
                "  text-align: center;\n" +
                "  font-size: 20px;\n" +
                "  color: black;\n" +
                "  margin-bottom: 10px;\n" +
                "}\n" +
                "#footr{\n" +
                "  font-family: \"serif\", sans-serif;\n" +
                "  text-align: center;\n" +
                "  font-size: 15px;\n" +
                "  color: DarkBlue;\n" +
                "}\n" +
                "\n" +
                "@media screen and (max-width: 600px) {\n" +
                "\t\t\timg.third {\n" +
                "\t\t\t\twidth: 200px!important;\n" +
                "\t\t\t\tmax-width: 200px!important;\n" +
                "\t\t\t}\n" +
                "\t\t\t.padding {\n" +
                "\t\t\t\tpadding-right: 0!important;\n" +
                "\t\t\t\tpadding-left: 0!important;\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t\t@media screen and (max-width: 400px) {\n" +
                "\t\t\timg.third-img{\n" +
                "\t\t\t\twidth: 200px!important;\n" +
                "\t\t\t\tmax-width: 200px!important;\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t</style>\n" +
                "</head>\n" +
                "<body class=\"wrapper\">\n" +
                "  <div class=\"webkit\">\n" +
                "    <table class=\"outer\" style=\"position:absolute; left:30%\" >\n" +
                "     <tr>\n" +
                "       <td>\n" +
                "         <table width=\"100%\" style=\"border-spacing:0\">\n" +
                "           <tr>\n" +
                "             <td style=\"background-color: #388CDA; padding: 10px; text-align:center;\">\n" +
                "               <a href=\"#\" style=\"text-decoration:none; \"><h1 style=\"color: #fff; text-size:60px;\">Git-Nerds</h1></a>\n" +
                "             </td>\n" +
                "           </tr>\n" +
                "         </table>\n" +
                "\t\t\t\t <p style=\"padding-top:30px; padding-left:40px; text-size:35px;\">Hello, "+fName+"</p>\n" +
                "       </td>\n" +
                "     </tr>\n" +
                "\t\t <tr>\n" +
                "\t\t \t<td>\n" +
                "\t\t\t<a href=\"#\"> <img style=\"padding-top:20px;\" src=\"https://www.freestudy.com/wp-content/uploads/2019/11/Education-800x512.jpg?ezimgfmt=rs%3Adevice%2Frscb1-1\" alt=\"Banner\" width=\"600\"> </a>\n" +
                "\t\t</td>\n" +
                "\t\t </tr>\n" +
                "\t\t <tr>\n" +
                "\t\t \t<td>\n" +
                "\t\t\t\t<table width=\"100%\" style=\"border-spacing: 0;\">\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"three-columns\">\n" +
                "\n" +
                "\t\t\t\t\t\t\t<table class=\"columns\">\n" +
                "\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t<td class=\"padding\">\n" +
                "\n" +
                "\t\t\t\t\t\t\t\t\t\t<table class=\"content\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t<table class=\"columns\">\n" +
                "\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t<td class=\"padding\">\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t<table class=\"columns\">\n" +
                "\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t<td class=\"padding\">\n" +
                "\n" +
                "\t\t\t\t\t\t\t\t\t\t<table  class=\"content\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<p id=\"p43\">Activate Your Account</p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<p id=\"p43\">By login using this password sends you by generating " +
                "random password </p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"padding: 10px;\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<p id=\"p43\">Hello, Mr/Mrs "+fName+"</p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<p id=\"p43\">Please use those available information to login</p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<p id=\"p43\">     </p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<p id=\"p43\">Email : "+email+"</p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<p id=\"p43\">Password : "+password+"</p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<p id=\"p43\">Welcome again on our portal</p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t</table>\n" +
                "\n" +
                "\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t</table>\n" +
                "\t\t\t</td>\n" +
                "\t\t </tr>\n" +
                "\t\t \t<tr>\n" +
                "\t\t \t\t<td>\n" +
                "\t\t\t\t\t<table width=\"100%\" style=\"border-spacing: 0;\">\n" +
                "\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t<td style=\"background-color: #388CDA; padding: 15px; text-align: center;\">\n" +
                "\t\t\t\t\t\t\t\t<footer>\n" +
                "\t\t\t       <p id=\"follow\" style=\"font-size:30px; color:black;\">Follow Us <i class=\"fas fa-exclamation\"></i></p>\n" +
                "\t\t\t     <div class=\"social-media\">\n" +
                "\t\t\t                     <a href=\"https://www.facebook.com/gutu.daniel.980/\" class=\"social-icon\" target=\"_blank\">\n" +
                "\t\t\t                 <i class=\"fa fa-facebook-f\" aria-hidden=\"true\"></i>\n" +
                "\t\t\t               </a>\n" +
                "\t\t\t               <a href=\"https://twitter.com/GeletaGutu?s=09\" class=\"social-icon\" target=\"_blank\">\n" +
                "\t\t\t                 <i class=\"fa fa-twitter\" aria-hidden=\"true\"></i>\n" +
                "\t\t\t               </a>\n" +
                "\t\t\t               <a href=\"https://t.me/gutudanii\" class=\"social-icon\" target=\"_blank\">\n" +
                "\t\t\t                 <i class=\"fa fa-telegram\" aria-hidden=\"true\"></i>\n" +
                "\t\t\t               </a>\n" +
                "\t\t\t               <a href=\"https://www.instagram.com/gutuyeshi/\" class=\"social-icon\" target=\"_blank\">\n" +
                "\t\t\t                 <i class=\"fa fa-instagram\" aria-hidden=\"true\"></i>\n" +
                "\t\t\t               </a>\n" +
                "\t\t\t               <a href=\"https://www.linkedin.com/in/gutu-daniel\" class=\"social-icon\" target=\"_blank\">\n" +
                "\t\t\t                 <i class=\"fa fa-linkedin\" aria-hidden=\"true\"></i>\n" +
                "\t\t\t               </a>\n" +
                "\t\t\t             </div>\n" +
                "\t\t\t     </footer>\n" +
                "\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t</table>\n" +
                "\t\t\t\t</td>\n" +
                "\t\t \t</tr>\n" +
                "\t\t\t <tr>\n" +
                "\t\t\t \t<td style=\"background-color: #EFEFEF;\">\n" +
                "\t\t\t\t\t<table width=\"100%\" style=\"border-spacing: 0;\">\n" +
                "\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t<td style=\"padding: 20px; text-align: center; padding-bottom: 10px\">\n" +
                "\n" +
                "\t\t\t\t\t\t\t\t<a href=\"#\"> <img src=\"https://www.freestudy.com/wp-content/uploads/2019/11/Education-800x512.jpg?ezimgfmt=rs%3Adevice%2Frscb1-1\" alt=\"\" width=\"160\"> </a>\n" +
                "\t\t\t\t\t\t\t\t<p style=\"font-size: 16px; margin-top: 18px;\n" +
                "\t\t\t\t\t\t\t\t\t\tmargin-bottom: 10px\">w3newbie HTML Email</p>\n" +
                "\t\t\t\t\t\t\t\t<p style=\"font-size: 16px; margin-bottom: 10px;\">123 Street\n" +
                "\t\t\t\t\t\t\t\t\t\tRoad, City, State 55555</p>\n" +
                "\t\t\t\t\t\t\t\t<p><a href=\"#\"></a>email@sfdf.com</p>\n" +
                "\t\t\t\t\t\t\t\t<p><a href=\"#\"></a>093456787 </p>\n" +
                "\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t</tr>\n" +
                "\n" +
                "\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t<td style=\"padding-bottom: 25px; text-align: center;\">\n" +
                "\n" +
                "\t\t\t\t\t\t\t\t<p><a href=\"#\" style=\"font-size: 13px\"></a>UNSUBSCRIBE</p>\n" +
                "\t\t\t\t\t\t\t\t <p id=\"footr\">&copy; <em id=\"date\"></em> 2022 Copyright reserved by @Git-Nerds</p>\n" +
                "\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t<td height=\"20\" style=\"background-color: #388CDA\">\n" +
                "\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t</tr>\n" +
                "\n" +
                "\t\t\t\t\t</table>\n" +
                "\t\t\t\t</td>\n" +
                "\t\t\t </tr>\n" +
                "    </table>\n" +
                "  </div>\n" +
                "</body>\n" +
                "</html>\n";

        MimeMessagePreparator mailMessage = mimeMessage -> {

            MimeMessageHelper message = new MimeMessageHelper(
                    mimeMessage, "utf-8");
                    message.setFrom("git.nerds.operator.team@gmail.com","Git-Nerds Team");
                    message.setText(msg,true);
                    message.setSubject("Auto Password Generator and Activator");
                    message.addTo(email);

        };
        this.javaMailSender.send(mailMessage);
    }


    @Override
    public void mailSenderEdit(String email,
                           String password){

        String msg = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:th=\"http://www.thymeleaf.org\">\n" +
                "<head>\n" +
                "\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n" +
                "\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "\t<title>w3newbie HTML Email</title>\n" +
                "\n" +
                "\t<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css/\">\n" +
                "\t<style type=\"text/css\">\n" +
                "\t\tbody {\n" +
                "\t\t\tMargin: 0;\n" +
                "      background-color: #f6f9fc;\n" +
                "\t\t}\n" +
                "\t\ttable {\n" +
                "\t\t\tborder-spacing: 0;\n" +
                "\t\t}\n" +
                "\t\ttd {\n" +
                "\t\t\tpadding: 0;\n" +
                "\t\t}\n" +
                "\t\timg {\n" +
                "\t\t\tborder: 0;\n" +
                "\t\t}\n" +
                "    .wrapper{\n" +
                "      width: 100%;\n" +
                "      background-color: #f6f9fc;\n" +
                "      padding-bottom: 40px;\n" +
                "    }\n" +
                "\n" +
                "    .webkit {\n" +
                "      max-width: 600px;\n" +
                "      background-color: white\n" +
                "    }\n" +
                "\n" +
                ".outer{\n" +
                "  Margin: 0 auto;\n" +
                "  width: 100%;\n" +
                "  max-width: 600px;\n" +
                "  border-spacing: 0;\n" +
                "  font-family: sans-serif;\n" +
                "  color: #4A4A4A;\n" +
                "}\n" +
                ".three-columns{\n" +
                "\ttext-align: center;\n" +
                "\tfont-size: 0;\n" +
                "\tpadding-top: 40px;\n" +
                "\tpadding-bottom: 30px;\n" +
                "}\n" +
                ".three-columns .columns{\n" +
                "\twidth: 100%\n" +
                "\tmax-width: 200px;\n" +
                "\tdisplay: inline-block;\n" +
                "\tvertical-align: top;\n" +
                "}\n" +
                ".padding {\n" +
                "\tpadding: 15px;\n" +
                "}\n" +
                ".three-columns .content{\n" +
                "\tfont-size: 15px;\n" +
                "\tline-height: 20px;\n" +
                "}\n" +
                "a {\n" +
                "\ttext-decoration: none;\n" +
                "\tcolor: #388CDA;\n" +
                "\tfont-size: 16px;\n" +
                "}\n" +
                "\n" +
                "body footer{\n" +
                "  margin-top: 100px;\n" +
                "  margin-bottom: 0px;\n" +
                "padding-bottom: 0px;\n" +
                "}\n" +
                "\n" +
                ".social-text {\n" +
                "  padding: 0.7rem 0;\n" +
                "  font-size: 1rem;\n" +
                "}\n" +
                "\n" +
                ".social-media {\n" +
                "  display: flex;\n" +
                "  justify-content: center;\n" +
                "  margin-bottom: 20px;\n" +
                "}\n" +
                "\n" +
                ".social-icon {\n" +
                "  height: 46px;\n" +
                "  width: 46px;\n" +
                "  display: flex;\n" +
                "  justify-content: center;\n" +
                "  align-items: center;\n" +
                "  margin: 0 0.45rem;\n" +
                "  color:  #F5F5F5;\n" +
                "  border-radius: 50%;\n" +
                "  border: 1px solid #333;\n" +
                "  text-decoration: none;\n" +
                "  font-size: 1.1rem;\n" +
                "  transition: 0.3s;\n" +
                "}\n" +
                "\n" +
                ".social-icon:hover {\n" +
                "  color: black;\n" +
                "  border-color: black;\n" +
                "\n" +
                "  height: 56px;\n" +
                "  width: 56px;\n" +
                "\n" +
                "}\n" +
                "\n" +
                "#p43{\n" +
                "font-size: 40px;\n" +
                "color:black;\n" +
                "}\n" +
                "\n" +
                "#follow{\n" +
                "  font-family: \"serif\", cursive;\n" +
                "  text-align: center;\n" +
                "  font-size: 20px;\n" +
                "  color: black;\n" +
                "  margin-bottom: 10px;\n" +
                "}\n" +
                "#footr{\n" +
                "  font-family: \"serif\", sans-serif;\n" +
                "  text-align: center;\n" +
                "  font-size: 15px;\n" +
                "  color: DarkBlue;\n" +
                "}\n" +
                "\n" +
                "@media screen and (max-width: 600px) {\n" +
                "\t\t\timg.third {\n" +
                "\t\t\t\twidth: 200px!important;\n" +
                "\t\t\t\tmax-width: 200px!important;\n" +
                "\t\t\t}\n" +
                "\t\t\t.padding {\n" +
                "\t\t\t\tpadding-right: 0!important;\n" +
                "\t\t\t\tpadding-left: 0!important;\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t\t@media screen and (max-width: 400px) {\n" +
                "\t\t\timg.third-img{\n" +
                "\t\t\t\twidth: 200px!important;\n" +
                "\t\t\t\tmax-width: 200px!important;\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t</style>\n" +
                "</head>\n" +
                "<body class=\"wrapper\">\n" +
                "  <div class=\"webkit\">\n" +
                "    <table class=\"outer\" style=\"position:absolute; left:30%\" >\n" +
                "     <tr>\n" +
                "       <td>\n" +
                "         <table width=\"100%\" style=\"border-spacing:0\">\n" +
                "           <tr>\n" +
                "             <td style=\"background-color: #388CDA; padding: 10px; text-align:center;\">\n" +
                "               <a href=\"#\" style=\"text-decoration:none; \"><h1 style=\"color: #fff; text-size:60px;\">Git-Nerds</h1></a>\n" +
                "             </td>\n" +
                "           </tr>\n" +
                "         </table>\n" +
                "\t\t\t\t <p style=\"padding-top:30px; padding-left:40px; text-size:35px;\">Hello, </p>\n" +
                "       </td>\n" +
                "     </tr>\n" +
                "\t\t <tr>\n" +
                "\t\t \t<td>\n" +
                "\t\t\t<a href=\"#\"> <img style=\"padding-top:20px;\" src=\"https://www.freestudy.com/wp-content/uploads/2019/11/Education-800x512.jpg?ezimgfmt=rs%3Adevice%2Frscb1-1\" alt=\"Banner\" width=\"600\"> </a>\n" +
                "\t\t</td>\n" +
                "\t\t </tr>\n" +
                "\t\t <tr>\n" +
                "\t\t \t<td>\n" +
                "\t\t\t\t<table width=\"100%\" style=\"border-spacing: 0;\">\n" +
                "\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t<td class=\"three-columns\">\n" +
                "\n" +
                "\t\t\t\t\t\t\t<table class=\"columns\">\n" +
                "\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t<td class=\"padding\">\n" +
                "\n" +
                "\t\t\t\t\t\t\t\t\t\t<table class=\"content\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t<table class=\"columns\">\n" +
                "\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t<td class=\"padding\">\n" +
                "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t<table class=\"columns\">\n" +
                "\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t<td class=\"padding\">\n" +
                "\n" +
                "\t\t\t\t\t\t\t\t\t\t<table  class=\"content\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<p id=\"p43\">Activate Your Account</p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<p id=\"p43\">By login using this password sends you by generating " +
                "random password </p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<td style=\"padding: 10px;\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<p id=\"p43\">Hello, </p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<p id=\"p43\">Please use those available information to login</p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<p id=\"p43\">     </p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<p id=\"p43\">Email : "+email+"</p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<p id=\"p43\">Password : "+password+"</p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<p id=\"p43\">Forget Password request</p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t\t</table>\n" +
                "\n" +
                "\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t</tr>\n" +
                "\t\t\t\t</table>\n" +
                "\t\t\t</td>\n" +
                "\t\t </tr>\n" +
                "\t\t \t<tr>\n" +
                "\t\t \t\t<td>\n" +
                "\t\t\t\t\t<table width=\"100%\" style=\"border-spacing: 0;\">\n" +
                "\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t<td style=\"background-color: #388CDA; padding: 15px; text-align: center;\">\n" +
                "\t\t\t\t\t\t\t\t<footer>\n" +
                "\t\t\t       <p id=\"follow\" style=\"font-size:30px; color:black;\">Follow Us <i class=\"fas fa-exclamation\"></i></p>\n" +
                "\t\t\t     <div class=\"social-media\">\n" +
                "\t\t\t                     <a href=\"https://www.facebook.com/gutu.daniel.980/\" class=\"social-icon\" target=\"_blank\">\n" +
                "\t\t\t                 <i class=\"fa fa-facebook-f\" aria-hidden=\"true\"></i>\n" +
                "\t\t\t               </a>\n" +
                "\t\t\t               <a href=\"https://twitter.com/GeletaGutu?s=09\" class=\"social-icon\" target=\"_blank\">\n" +
                "\t\t\t                 <i class=\"fa fa-twitter\" aria-hidden=\"true\"></i>\n" +
                "\t\t\t               </a>\n" +
                "\t\t\t               <a href=\"https://t.me/gutudanii\" class=\"social-icon\" target=\"_blank\">\n" +
                "\t\t\t                 <i class=\"fa fa-telegram\" aria-hidden=\"true\"></i>\n" +
                "\t\t\t               </a>\n" +
                "\t\t\t               <a href=\"https://www.instagram.com/gutuyeshi/\" class=\"social-icon\" target=\"_blank\">\n" +
                "\t\t\t                 <i class=\"fa fa-instagram\" aria-hidden=\"true\"></i>\n" +
                "\t\t\t               </a>\n" +
                "\t\t\t               <a href=\"https://www.linkedin.com/in/gutu-daniel\" class=\"social-icon\" target=\"_blank\">\n" +
                "\t\t\t                 <i class=\"fa fa-linkedin\" aria-hidden=\"true\"></i>\n" +
                "\t\t\t               </a>\n" +
                "\t\t\t             </div>\n" +
                "\t\t\t     </footer>\n" +
                "\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t</table>\n" +
                "\t\t\t\t</td>\n" +
                "\t\t \t</tr>\n" +
                "\t\t\t <tr>\n" +
                "\t\t\t \t<td style=\"background-color: #EFEFEF;\">\n" +
                "\t\t\t\t\t<table width=\"100%\" style=\"border-spacing: 0;\">\n" +
                "\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t<td style=\"padding: 20px; text-align: center; padding-bottom: 10px\">\n" +
                "\n" +
                "\t\t\t\t\t\t\t\t<a href=\"#\"> <img src=\"https://www.freestudy.com/wp-content/uploads/2019/11/Education-800x512.jpg?ezimgfmt=rs%3Adevice%2Frscb1-1\" alt=\"\" width=\"160\"> </a>\n" +
                "\t\t\t\t\t\t\t\t<p style=\"font-size: 16px; margin-top: 18px;\n" +
                "\t\t\t\t\t\t\t\t\t\tmargin-bottom: 10px\">w3newbie HTML Email</p>\n" +
                "\t\t\t\t\t\t\t\t<p style=\"font-size: 16px; margin-bottom: 10px;\">123 Street\n" +
                "\t\t\t\t\t\t\t\t\t\tRoad, City, State 55555</p>\n" +
                "\t\t\t\t\t\t\t\t<p><a href=\"#\"></a>email@sfdf.com</p>\n" +
                "\t\t\t\t\t\t\t\t<p><a href=\"#\"></a>093456787 </p>\n" +
                "\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t</tr>\n" +
                "\n" +
                "\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t<td style=\"padding-bottom: 25px; text-align: center;\">\n" +
                "\n" +
                "\t\t\t\t\t\t\t\t<p><a href=\"#\" style=\"font-size: 13px\"></a>UNSUBSCRIBE</p>\n" +
                "\t\t\t\t\t\t\t\t <p id=\"footr\">&copy; <em id=\"date\"></em> 2022 Copyright reserved by @Git-Nerds</p>\n" +
                "\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t<td height=\"20\" style=\"background-color: #388CDA\">\n" +
                "\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t</tr>\n" +
                "\n" +
                "\t\t\t\t\t</table>\n" +
                "\t\t\t\t</td>\n" +
                "\t\t\t </tr>\n" +
                "    </table>\n" +
                "  </div>\n" +
                "</body>\n" +
                "</html>\n";

        MimeMessagePreparator mailMessage = mimeMessage -> {

            MimeMessageHelper message = new MimeMessageHelper(
                    mimeMessage, "utf-8");
            message.setFrom("git.nerds.operator.team@gmail.com","Git-Nerds Team");
            message.setText(msg,true);
            message.setSubject("Forget Password");
            message.addTo(email);

        };
        this.javaMailSender.send(mailMessage);
    }

}
