package complete.login.activate.email.loginAndCreate.user;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Repository
//@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByEmail(String email);
    public List<Users> getAllByType(String type);

//    public Users findByEmails(String email);

//    public Users findByResetPasswordToken(String token);

}
