package complete.login.activate.email.loginAndCreate.user;

import complete.login.activate.email.loginAndCreate.role.Role;
import complete.login.activate.email.loginAndCreate.role.RoleRepository;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserRegister {

    @Autowired
    private UserService userService;

    @Autowired
    RoleRepository roleRepository;

    public Users saveTeacher(Users users){
        Random random = new Random();
        String name = users.getFirstName().substring(1,3);
        String lName = users.getLastName().substring(0,3);
        int num = random.nextInt(234,533);
        int num2 = random.nextInt(2344,5433);
        Role role = new Role();
        role.setRole("TEACHER");
        Role userRole = roleRepository.save(role);
        users.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        users.setPassword(name+num+lName+num2);
        return userService.signUp(new Users(
                users.getFirstName(),
                users.getLastName(),
                users.getEmail(),
                users.getPassword(),
                users.getRoles(),
                users.getDepartment()
            ));
    }

    public Users saveUser(Users users){
        Random random = new Random();
        String name = users.getFirstName().substring(1,3);
        String lName = users.getLastName().substring(0,3);
        int num = random.nextInt(234,533);
        int num2 = random.nextInt(2344,5433);
        users.setPassword(name+num+lName+num2);
        Role role = new Role();
        role.setRole("STUDENT");
        Role userRole = roleRepository.save(role);
        users.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userService.signUp(new Users(
                users.getFirstName(),
                users.getLastName(),
                users.getEmail(),
                users.getPassword(),
                users.getRoles()
        ));
    }
}