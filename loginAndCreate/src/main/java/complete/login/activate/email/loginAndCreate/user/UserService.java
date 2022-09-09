package complete.login.activate.email.loginAndCreate.user;

import complete.login.activate.email.loginAndCreate.role.Role;
import complete.login.activate.email.loginAndCreate.role.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException(String.format("this email %s not found", email)));
    }

    public Users signUp(Users users){
        boolean userExist = userRepository
                .findByEmail(users.getEmail())
                .isPresent();
        if (userExist) {
            throw new IllegalStateException(String.format("Email is already registered" + users.getEmail()));

        }

       String encodedPass = passwordEncoder.encode(users.getPassword());

        users.setPassword(encodedPass);
       return userRepository.save(users);

    }
//    public Users signUpEdit(Users users){
//
//        boolean userExist = userRepository
//                .findByEmail(users.getEmail())
//                .isPresent();
//        if (!userExist) {
//            throw new IllegalStateException(String.format("Email is not registered" + users.getEmail()));
//        }
//        String encodedPass = passwordEncoder.encode(users.getPassword());
//
//        users.setPassword(encodedPass);
//        return userRepository.save(users);
//    }

}
