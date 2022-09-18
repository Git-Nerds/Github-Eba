package complete.login.activate.email.loginAndCreate.user;

import complete.login.activate.email.loginAndCreate.mail.mailSenderService;
import complete.login.activate.email.loginAndCreate.role.Role;
import complete.login.activate.email.loginAndCreate.role.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class UserRegister {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    mailSenderService mailSender;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleRepository roleRepository;


    public List<Users> getAllUsers(){
        List<Users> list= userRepository.findAll();
        return list;
    }

    public Users getAllUsersById(Long id) {
        Optional<Users> users = userRepository.findById(id);
        return users.get();
    }

    public Users saveOrUpdateUser(Users users) {
        if(users.getId() == null) {
            Role role = new Role();
            role.setRole("STUDENT");
          Role userRole = roleRepository.save(role);
        users.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        users.setType("USER");

//               // GENERATING PASSWORD
        Random random = new Random();
        String name = users.getFirstName().substring(1,3);
        String lName = users.getLastName().substring(0,3);
        int num = random.nextInt(234,533);
        int num2 = random.nextInt(2344,5433);
        users.setPassword(name+num+lName+num2);
            return userService.signUp(new Users(
                    users.getFirstName(),
                    users.getLastName(),
                    users.getEmail(),
                    users.getPassword(),
                    users.getLevel(),
                    users.getRoles(),
                    users.getType()
            ));}
        else {
            Optional<Users> sOptional = userRepository.findById(users.getId());
            if(sOptional!=null) {
                Users users1 = sOptional.get();
                users1.setFirstName(users.getFirstName());
                users1.setLastName(users.getLastName());
                users1.setEmail(users.getEmail());
                users1.setPassword(users.getPassword());
                users1.setLevel(users.getLevel());
                users1.setType(users.getType());
                if (!Objects.nonNull(users.getRoles())){
                users1.setRoles(users.getRoles());
                }
                users1 = userRepository.save(users1);
                return users1;
            }
            else {
                Role role = new Role();
                role.setRole("STUDENT");
                Role userRole = roleRepository.save(role);
                users.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
                users.setType("USER");

//               // GENERATING PASSWORD
        Random random = new Random();
        String name = users.getFirstName().substring(1,3);
        String lName = users.getLastName().substring(0,3);
        int num = random.nextInt(234,533);
        int num2 = random.nextInt(2344,5433);
        users.setPassword(name+num+lName+num2);
                users = userService.signUp(new Users(
                        users.getFirstName(),
                        users.getLastName(),
                        users.getEmail(),
                        users.getPassword(),
                        users.getLevel(),
                        users.getRoles(),
                        users.getType()
                ));
                return users;
            }
        }
    }

    public Users saveOrUpdateTeacher(Users users) {
        if(users.getId() == null) {
            Role role = new Role();
            role.setRole("TEACHER");
            Role userRole = roleRepository.save(role);
            users.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
            users.setType("PROVIDER");

//               // GENERATING PASSWORD
        Random random = new Random();
        String name = users.getFirstName().substring(1,3);
        String lName = users.getLastName().substring(0,3);
        int num = random.nextInt(234,533);
        int num2 = random.nextInt(2344,5433);
        users.setPassword(name+num+lName+num2);
            return userService.signUp(new Users(
                    users.getFirstName(),
                    users.getLastName(),
                    users.getEmail(),
                    users.getPassword(),
                    users.getLevel(),
                    users.getRoles(),
                    users.getType()
            ));}
        else {
            Optional<Users> sOptional = userRepository.findById(users.getId());
            if(sOptional!=null) {
                Users users1 = sOptional.get();
                users1.setFirstName(users.getFirstName());
                users1.setLastName(users.getLastName());
                users1.setEmail(users.getEmail());
                users1.setPassword(users.getPassword());
                users1.setLevel(users.getLevel());
                users1.setType(users.getType());
                if (!Objects.nonNull(users.getRoles())){
                    users1.setRoles(users.getRoles());
                }
                users1 = userRepository.save(users1);
                return users1;
            }
            else {
                Role role = new Role();
                role.setRole("TEACHER");
                Role userRole = roleRepository.save(role);
                users.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
                users.setType("PROVIDER");

//               // GENERATING PASSWORD
        Random random = new Random();
        String name = users.getFirstName().substring(1,3);
        String lName = users.getLastName().substring(0,3);
        int num = random.nextInt(234,533);
        int num2 = random.nextInt(2344,5433);
        users.setPassword(name+num+lName+num2);
                users = userService.signUp(new Users(
                        users.getFirstName(),
                        users.getLastName(),
                        users.getEmail(),
                        users.getPassword(),
                        users.getLevel(),
                        users.getRoles(),
                        users.getType()
                ));
                return users;
            }
        }
    }
    public Users saveOrUpdateAdmin(Users users) {
        if(users.getId() == null) {
            Role role = new Role();
            role.setRole("ADMIN");
            Role userRole = roleRepository.save(role);
            users.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
            users.setType("CONTROL");

//               // GENERATING PASSWORD
            Random random = new Random();
            String name = users.getFirstName().substring(1,3);
            String lName = users.getLastName().substring(0,3);
            int num = random.nextInt(234,533);
            int num2 = random.nextInt(2344,5433);
            users.setPassword(name+num+lName+num2);
            return userService.signUp(new Users(
                    users.getFirstName(),
                    users.getLastName(),
                    users.getEmail(),
                    users.getPassword(),
                    users.getLevel(),
                    users.getRoles(),
                    users.getType()
            ));}
        else {
            Optional<Users> sOptional = userRepository.findById(users.getId());
            if(sOptional!=null) {
                Users users1 = sOptional.get();
                users1.setFirstName(users.getFirstName());
                users1.setLastName(users.getLastName());
                users1.setEmail(users.getEmail());
                users1.setPassword(users.getPassword());
                users1.setLevel(users.getLevel());
                users1.setType(users.getType());
                if (!Objects.nonNull(users.getRoles())){
                    users1.setRoles(users.getRoles());
                }
                users1 = userRepository.save(users1);
                return users1;
            }
            else {
                Role role = new Role();
                role.setRole("ADMIN");
                Role userRole = roleRepository.save(role);
                users.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
                users.setType("CONTROL");

//               // GENERATING PASSWORD
                Random random = new Random();
                String name = users.getFirstName().substring(1,3);
                String lName = users.getLastName().substring(0,3);
                int num = random.nextInt(234,533);
                int num2 = random.nextInt(2344,5433);
                users.setPassword(name+num+lName+num2);
                users = userService.signUp(new Users(
                        users.getFirstName(),
                        users.getLastName(),
                        users.getEmail(),
                        users.getPassword(),
                        users.getLevel(),
                        users.getRoles(),
                        users.getType()
                ));
                return users;
            }
        }
    }

    public Users saveOrUpdateSuper(Users users) {
        if(users.getId() == null) {
            Role role = new Role();
            role.setRole("SUPER");
            Role userRole = roleRepository.save(role);
            users.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
            users.setType("CONTROLLER");

//               // GENERATING PASSWORD
            Random random = new Random();
            String name = users.getFirstName().substring(1,3);
            String lName = users.getLastName().substring(0,3);
            int num = random.nextInt(234,533);
            int num2 = random.nextInt(2344,5433);
            users.setPassword(name+num+lName+num2);
            return userService.signUp(new Users(
                    users.getFirstName(),
                    users.getLastName(),
                    users.getEmail(),
                    users.getPassword(),
                    users.getLevel(),
                    users.getRoles(),
                    users.getType()
            ));}
        else {
            Optional<Users> sOptional = userRepository.findById(users.getId());
            if(sOptional!=null) {
                Users users1 = sOptional.get();
                users1.setFirstName(users.getFirstName());
                users1.setLastName(users.getLastName());
                users1.setEmail(users.getEmail());
                users1.setPassword(users.getPassword());
                users1.setLevel(users.getLevel());
                users1.setType(users.getType());
                if (!Objects.nonNull(users.getRoles())){
                    users1.setRoles(users.getRoles());
                }
                users1 = userRepository.save(users1);
                return users1;
            }
            else {
                Role role = new Role();
                role.setRole("SUPER");
                Role userRole = roleRepository.save(role);
                users.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
                users.setType("CONTROLLER");

//               // GENERATING PASSWORD
                Random random = new Random();
                String name = users.getFirstName().substring(1,3);
                String lName = users.getLastName().substring(0,3);
                int num = random.nextInt(234,533);
                int num2 = random.nextInt(2344,5433);
                users.setPassword(name+num+lName+num2);
                users = userService.signUp(new Users(
                        users.getFirstName(),
                        users.getLastName(),
                        users.getEmail(),
                        users.getPassword(),
                        users.getLevel(),
                        users.getRoles(),
                        users.getType()
                ));
                return users;
            }
        }
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public List<Users> getAllByRole(String type) {
        List<Users> list = userRepository.getAllByType(type);
        return list;
    }



















//    public Users saveTeacher(Users users){
//
//               // GENERATING PASSWORD
//        Random random = new Random();
//        String name = users.getFirstName().substring(1,3);
//        String lName = users.getLastName().substring(0,3);
//        int num = random.nextInt(234,533);
//        int num2 = random.nextInt(2344,5433);
//        users.setPassword(name+num+lName+num2);
//
//              // SAVING ROLE FOR THE USERS
//        Role role = new Role();
//             role.setRole("TEACHER");
//             Role userRole = roleRepository.save(role);
//        users.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
//
//                // SAVING INFORMATION OF TEACHER
//        Teacher teacher = new Teacher();
//            teacher.setFirstName(users.getFirstName());
//            teacher.setLastName(users.getLastName());
//            teacher.setEmail(users.getEmail());
//            teacher.setDepartment(users.getDepartment());
//            teacher.setPassword(users.getPassword());
//            teacher.setPassword(passwordEncoder.encode(teacher.getPassword()));
//            teacherRepository.save(teacher);
//
//         users.setTeacher(teacher);
//        //Sending Mail
//        mailSender.mailSender(users.getEmail(),users.getPassword(),users.getFirstName());
//        return userService.signUp(new Users(
//                users.getFirstName(),
//                users.getLastName(),
//                users.getEmail(),
//                users.getPassword(),
//                users.getDepartment(),
//                users.getRoles(),
//                users.getStudents(),
//                users.getTeacher(),
//                users.getAdmin(),
//                users.getSupers()
//        ));
//    }
//
//    public Users SaveStudents(Users users){
//
//       // GENERATING PASSWORD FOR USERS
//        Random random = new Random();
//        String name = users.getFirstName().substring(1,3);
//        String lName = users.getLastName().substring(0,3);
//        int num = random.nextInt(234,533);
//        int num2 = random.nextInt(2344,5433);
//        users.setPassword(name+num+lName+num2);
//
//        // SETTING ROLES FOR USERS
//        Role role = new Role();
//            role.setRole("STUDENT");
//            Role userRole = roleRepository.save(role);
//        users.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
//
//        //SAVING STUDENTS INTO STUDENT TABLE AND JOINING TABLE WITH THE USERS TABLE
//        Student student = new Student();
//            student.setFirstName(users.getFirstName());
//            student.setLastName(users.getLastName());
//            student.setEmail(users.getEmail());
//            student.setLevel(users.getDepartment());
//            student.setPassword(users.getPassword());
//            student.setPassword(passwordEncoder.encode(student.getPassword()));
//          studentRepository.save(student);
//
//        users.setStudents(student);
//        //Sending Mail
//        mailSender.mailSender(users.getEmail(),users.getPassword(),users.getFirstName());
//        return userService.signUp(new Users(
//                users.getFirstName(),
//                users.getLastName(),
//                users.getEmail(),
//                users.getPassword(),
//                users.getDepartment(),
//                users.getRoles(),
//                users.getStudents(),
//                users.getTeacher(),
//                users.getAdmin(),
//                users.getSupers()
//        ));
//    }
//    public Users saveAdmin(Users users){
//
//        // GENERATING PASSWORD FOR ADMINS
//        Random random = new Random();
//        String name = users.getFirstName().substring(1,3);
//        String lName = users.getLastName().substring(0,3);
//        int num = random.nextInt(234,533);
//        int num2 = random.nextInt(2344,5433);
//        users.setPassword(name+num+lName+num2);
//
//        // ADDING ROLE AND SAVING THEM TO DATABASE AND JOINING TABLE WITH
//        Role role = new Role();
//             role.setRole("ADMIN");
//             Role userRole = roleRepository.save(role);
//             users.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
//
//             // SAVING ADMINS INFO TO TABLE OF ADMINS
//        Admin admin = new Admin();
//            admin.setFirstName(users.getFirstName());
//            admin.setLastName(users.getLastName());
//            admin.setEmail(users.getEmail());
//         adminRepository.save(admin);
//
//         users.setAdmin(admin);
//         //Sending Mail
//        mailSender.mailSender(users.getEmail(),users.getPassword(),users.getFirstName());
//        return userService.signUp(new Users(
//                users.getFirstName(),
//                users.getLastName(),
//                users.getEmail(),
//                users.getPassword(),
//                users.getDepartment(),
//                users.getRoles(),
//                users.getStudents(),
//                users.getTeacher(),
//                users.getAdmin(),
//                users.getSupers()
//        ));
//    }
//    public Users saveSuper(Users users){
//
//        // GENERATING PASSWORD FOR SUPER ADMINS
//        Random random = new Random();
//        String name = users.getFirstName().substring(1,3);
//        String lName = users.getLastName().substring(0,3);
//        int num = random.nextInt(234,533);
//        int num2 = random.nextInt(2344,5433);
//        users.setPassword(name+num+lName+num2);
//
//        // ADDING ROLES TO THE DATABASES
//        Role role = new Role();
//            role.setRole("SUPER");
//            Role userRole = roleRepository.save(role);
//        users.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
//
//        // SAVING SUPERS TO TABLE OF THEM AND USERS
//        Supers supers = new Supers();
//            supers.setFirstName(users.getFirstName());
//            supers.setLastName(users.getLastName());
//            supers.setEmail(users.getEmail());
//         superRepository.save(supers);
//
//         users.setSupers(supers);
//         // Sending Mail
//        mailSender.mailSender(users.getEmail(),users.getPassword(),users.getFirstName());
//        return userService.signUp(new Users(
//                users.getFirstName(),
//                users.getLastName(),
//                users.getEmail(),
//                users.getPassword(),
//                users.getDepartment(),
//                users.getRoles(),
//                users.getStudents(),
//                users.getTeacher(),
//                users.getAdmin(),
//                users.getSupers()
//        ));
//    }

}