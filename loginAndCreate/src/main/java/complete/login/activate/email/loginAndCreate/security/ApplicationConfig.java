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
public class
ApplicationConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomLoginSuccessHandler sucessHandler;
    @Autowired
    private final UserService userService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http
               .csrf().disable()
               .authorizeRequests()
               .antMatchers("/logins").permitAll()
               .antMatchers("/save","/savet","/forgets","/registers","/edit/{email}").permitAll()
               .antMatchers("/newt").hasAuthority("TEACHER")
               .antMatchers("/news").hasAnyAuthority("STUDENT","TEACHER")
               .anyRequest()
               .authenticated()
               .and()
               .formLogin().permitAll()
               .loginPage("/logins")
               .failureUrl("/login?error=true")
               .successHandler(sucessHandler)
               .usernameParameter("username")
               .passwordParameter("password")
//               .successForwardUrl("/news")
//               .defaultSuccessUrl("/news", true)
               .and()
               .rememberMe()
               .rememberMeParameter("remember-me")
               .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21))
               .key("somethingverysecured")
               .and()
               .logout()
               .logoutUrl("/logout")
               .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
               .clearAuthentication(true)
               .invalidateHttpSession(true)
               .deleteCookies("JSESSIONID","remember-me")
               .logoutSuccessUrl("/logins").and()
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

//    @Bean
//    @Override
//    protected UserDetailsService userDetailsService() {
//        UserDetails gutu = User.builder()
//                .password(passwordEncoder.encode("gutu"))
//                .username("gutu")
//                .authorities(TECHNICIAN.grantedAuthorities())
//                .build();
//
//        return new InMemoryUserDetailsManager(
//                gutu
//        );
//
//    }

}
