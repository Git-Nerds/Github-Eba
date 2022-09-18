package complete.login.activate.email.loginAndCreate.security;

import complete.login.activate.email.loginAndCreate.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.concurrent.TimeUnit;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class ApplicationConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomLoginSuccessHandler successHandler;
    @Autowired
    private final UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http
               // CSRF DISABLE, ANT MATCHERS, SETTING SECURITY FOR HTTPS
               .csrf().disable()
               .authorizeRequests()
               .antMatchers("/logins","/index","/").permitAll()
               .antMatchers("static/**",
                                        "css/**").permitAll()
               .antMatchers("/edit","/send","/save","/save/teacher","/forgets","/registration","/edit/{email}","/forgetConfirmation",
                       // Password And Reset Process
                       "/forget_password","/reset_password","message"
                       ).permitAll()
               .antMatchers("/teacherPage").hasAuthority("TEACHER")
               .antMatchers("/studentPage").hasAnyAuthority("STUDENT","TEACHER","ADMIN","SUPER")
               .antMatchers("/adminPage").hasAnyAuthority("ADMIN","SUPER")
               .antMatchers("/superAdminPage",
               "/addAdminsSuper","/addAdmin","/save/super","/save/admin",
               "/save/super/admin","/save","/registration","/logins","/display_user","/update","/update/{id}","/view","/view/{type}").permitAll()
//               .antMatchers("/save/admin","/view").hasAnyAuthority("SUPER","ADMIN")
//               .antMatchers("/display_user").hasAnyAuthority("USER","TEACHER","SUPER","ADMIN")
//               .antMatchers("/addAdminsSuper").hasAuthority("SUPER")
//               .antMatchers("/superAdminPage").hasAuthority("SUPER")
//               .antMatchers("/save/super").hasAuthority("SUPER")
//               .antMatchers("/addAdmin","/add-shop","/add").hasAnyAuthority("SUPER","ADMIN")

             // HTTPS CODE
               //  .and()
//              .requiresChannel()
//              .anyRequest()
//              .requiresSecure()
               .anyRequest()
               .authenticated()
               .and()

               // LOGIN PAGE
               .formLogin().permitAll()
               .successForwardUrl("/logins")
               .loginPage("/logins")
               .failureUrl("/login?error=true")
               .successHandler(successHandler)
               .usernameParameter("email")
               .passwordParameter("password")
               .and()
              // REMEMBER-ME
//               .rememberMe()
//               .rememberMeParameter("remember-me")
//               .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(30))
//               .key("somethingverysecured")
//               .and()
               .logout()
               .logoutUrl("/logout")
               .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
               .clearAuthentication(true)
               .invalidateHttpSession(true)
               .deleteCookies("JSESSIONID")
               .logoutSuccessUrl("/logins")
               .and()
               .exceptionHandling()
               .accessDeniedPage("/access-denied");


    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userService);

        return provider;
    }

}
