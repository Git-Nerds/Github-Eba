//package complete.login.activate.email.loginAndCreate.role;
//
//import complete.login.activate.email.loginAndCreate.user.UserRepository;
//import complete.login.activate.email.loginAndCreate.user.Users;
//import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Set;
//
//@Service
//@AllArgsConstructor
//public class RoleService {
//
//    @Autowired
//    private final RoleRepository roleRepository;
//
//    @Autowired
//    private final UserRepository userRepository;
//    public void saveRole(Role role){
//        roleRepository.save(role);
//    }
//
//    public void assignUserRole(Long userId, Long roleId){
//        Users users = userRepository.findById(userId).orElse(null);
//        Role role = roleRepository.findById(roleId).orElse(null);
//
//        Set<Role> userRoles = users.getRoles();
//        userRoles.add(role);
//        users.setRoles(userRoles);
//
//        userRepository.save(users);
//    }
//    public void unassignUserRole(Long userId, Long roleId){
//        Users users = userRepository.findById(userId).orElse(null);
//        Set<Role> userRoles = users.getRoles();
//
//        userRoles.removeIf(x -> x.getId() == roleId);
//        userRepository.save(users);
//    }
//
//    public Set<Role> getUserRoles(Users users){
//        return users.getRoles();
//    }
//
//}
