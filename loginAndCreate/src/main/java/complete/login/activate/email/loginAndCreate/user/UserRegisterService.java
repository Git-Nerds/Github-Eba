//package complete.login.activate.email.loginAndCreate.user;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserRegisterService {
//
//    @Autowired
//    PasswordEncoder passwordEncoder;
//    @Autowired
//    UserRegister userRegister;
//    @Autowired
//    UserRepository userRepository;
//
//
//
//
//
//
//
//
//
//
////
////    // UPDATING STUDENT
////
////    public Users saveOrUpdateStudent(Users users) {
////        if(users.getId() == null) {
////            return userRegister.SaveStudents(users);}
////        else {
////            Optional<Users> sOptional = userRepository.findById(users.getId());
////            if(sOptional!=null) {
////                Users users1 = sOptional.get();
////                users1.setFirstName(users.getFirstName());
////                users1.setLastName(users.getLastName());
////                users1.setEmail(users.getEmail());
////                users1.setPassword(users.getPassword());
////                users1.setDepartment(users.getDepartment());
////                users1.setPassword(passwordEncoder.encode(users1.getPassword()));
////                users1 = userRepository.save(users1);
////                Student student = new Student();
////                        student.setFirstName(users1.getFirstName());
////                        student.setLastName(users1.getLastName());
////                        student.setEmail(users1.getEmail());
////                        student.setLevel(users1.getDepartment());
////                        studentRepository.save(student);
////                return users1;
////            }
////            else {
////                users = userRegister.SaveStudents(users);
////                return users;
////            }
////        }
////    }
////
////    // UPDatIG TEACHER
////
////    public Users saveOrUpdateTeacher(Users users) {
////        if(users.getId() == null) {
////            return userRegister.saveTeacher(users);}
////        else {
////            Optional<Users> sOptional = userRepository.findById(users.getId());
////            if(sOptional!=null) {
////                Users users1 = sOptional.get();
////                users1.setFirstName(users.getFirstName());
////                users1.setLastName(users.getLastName());
////                users1.setEmail(users.getEmail());
////                users1.setPassword(users.getPassword());
////                users1.setDepartment(users.getDepartment());
////                users1 = userRepository.save(users1);
////                return users1;
////            }
////            else {
////                users = userRegister.saveTeacher(users);
////                return users;
////            }
////        }
////    }
////
////    // UPDATING ADMINS
////
////    public Users saveOrUpdateAdmin(Users users) {
////        if(users.getId() == null) {
////            return userRegister.saveAdmin(users);}
////        else {
////            Optional<Users> sOptional = userRepository.findById(users.getId());
////            if(sOptional!=null) {
////                Users users1 = sOptional.get();
////                users1.setFirstName(users.getFirstName());
////                users1.setLastName(users.getLastName());
////                users1.setEmail(users.getEmail());
////                users1.setPassword(users.getPassword());
////                users1.setDepartment(users.getDepartment());
////                users1 = userRegister.saveAdmin(users1);
////                return users1;
////            }
////            else {
////                users = userRepository.save(users);
////                return users;
////            }
////        }
////    }
////    public Users saveOrUpdateSuper(Users users) {
////        if(users.getId() == null) {
////            return userRegister.saveSuper(users);}
////        else {
////            Optional<Users> sOptional = userRepository.findById(users.getId());
////            if(sOptional!=null) {
////                Users users1 = sOptional.get();
////                users1.setFirstName(users.getFirstName());
////                users1.setLastName(users.getLastName());
////                users1.setEmail(users.getEmail());
////                users1.setPassword(users.getPassword());
////                users1.setDepartment(users.getDepartment());
////                users1 = userRegister.saveAdmin(users1);
////                return users1;
////            }
////            else {
////                users = userRepository.save(users);
////                return users;
////            }
////        }
////    }
//
//
//
//                // OLD CODE
//
////    public Users editUser(Users users, String email){
////        Users users1 = userRepository.findByEmail(email).get();
////        Random random = new Random();
////        String name = "someone";
////        String lName ="%";
////        int num = random.nextInt(234,533);
////        int num2 = random.nextInt(2344,5433);
////        users.setPassword(name+num+lName+num2);
////        if (Objects.nonNull(users.getFirstName()) && !"".equalsIgnoreCase(users.getFirstName())){
////            users1.setFirstName(users.getFirstName());
////        }
////        if (Objects.nonNull(users.getEmail()) && !"".equalsIgnoreCase(users.getEmail())){
////            users1.setEmail(users.getEmail());
////        }
////        if (Objects.nonNull(users.getPassword()) && !"".equalsIgnoreCase(users.getPassword())){
////            users1.setPassword(users.getPassword());
////        }
////        if (Objects.nonNull(users.getLastName()) && !"".equalsIgnoreCase(users.getLastName())){
////            users1.setLastName(users.getLastName());
////        }
////        String encodedPass = passwordEncoder.encode(users1.getPassword());
////        users1.setPassword(encodedPass);
////        return userRepository.save(users1);
////    }
////
////    @Modifying
////    public void updatePassword(Users users){
////        users.setPassword("gtuu");
////        users.setPassword(passwordEncoder.encode(users.getPassword()));
////        userRepository.save(users);
////    }
//
//}
