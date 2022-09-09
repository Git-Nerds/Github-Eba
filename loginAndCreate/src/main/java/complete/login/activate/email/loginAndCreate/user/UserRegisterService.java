package complete.login.activate.email.loginAndCreate.user;


import complete.login.activate.email.loginAndCreate.role.Role;
import complete.login.activate.email.loginAndCreate.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserRegisterService {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRegister userRegister;
    @Autowired
    UserRepository userRepository;
    public void saveUsers(Users users){
        userRegister.saveUser(users);
    }

    public void saveTeacher(Users users){
        userRegister.saveTeacher(users);
    }
    public Users editUser(Users users, String email){
        Users users1 = userRepository.findByEmail(email).get();
        Random random = new Random();
        String name = "someone";
        String lName ="%";
        int num = random.nextInt(234,533);
        int num2 = random.nextInt(2344,5433);
        users.setPassword(name+num+lName+num2);
        if (Objects.nonNull(users.getFirstName()) && !"".equalsIgnoreCase(users.getFirstName())){
            users1.setFirstName(users.getFirstName());
        }
        if (Objects.nonNull(users.getEmail()) && !"".equalsIgnoreCase(users.getEmail())){
            users1.setEmail(users.getEmail());
        }
        if (Objects.nonNull(users.getPassword()) && !"".equalsIgnoreCase(users.getPassword())){
            users1.setPassword(users.getPassword());
        }
        if (Objects.nonNull(users.getLastName()) && !"".equalsIgnoreCase(users.getLastName())){
            users1.setLastName(users.getLastName());
        }
        String encodedPass = passwordEncoder.encode(users1.getPassword());
        users1.setPassword(encodedPass);
        return userRepository.save(users1);
    }

}
