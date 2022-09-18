package complete.login.activate.email.loginAndCreate.user;

import complete.login.activate.email.loginAndCreate.role.RoleRepository;
import complete.login.activate.email.loginAndCreate.session.Session;
import complete.login.activate.email.loginAndCreate.session.SessionHandler;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
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
            Users users = userRepository.findByEmail(email).get();
                    SessionHandler.setSession(new Session(users.getEmail()));
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

    // PASSWORD RESET

//    public void updateResetPasswordToken(String token, String email) throws Exception{
//        Users users = userRepository.findByEmail(email);
//        if (users != null) {
//            users.setResetPasswordToken(token);
//            userRepository.save(users);
//        } else {
//            throw new UsernameNotFoundException("Could not find any users with the email " + email);
//        }
//    }
//
//    public Users getByResetPasswordToken(String token) {
//        return userRepository.findByResetPasswordToken(token);
//    }
//
//    public void updatePassword(Users users, String newPassword) {
//        String encodedPassword = passwordEncoder.encode(newPassword);
//        users.setPassword(encodedPassword);
//
//        users.setResetPasswordToken(null);
//        userRepository.save(users);
//    }
}
