package complete.login.activate.email.loginAndCreate.mail;

import org.springframework.stereotype.Service;

@Service
public interface mailSenderService {

    public void mailSender(String email,
                           String password,
                           String fName);

    public void mailSenderEdit(String email,
                           String password);
}
