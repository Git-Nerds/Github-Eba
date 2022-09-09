package complete.login.activate.email.loginAndCreate.role;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
//    public List<String> getRoleList(){
//        if(this.role.length() > 0){
//            return Arrays.asList(this.role.split(","));
//        }
//        return new ArrayList<>();
//    }

}
