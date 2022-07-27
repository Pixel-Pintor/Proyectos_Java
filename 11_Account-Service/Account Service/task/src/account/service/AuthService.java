package account.service;

import account.dto.request.SignupRequest;
import account.model.EventEnum;
import account.model.Role;
import account.model.User;
import account.repository.RoleRepository;
import account.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class AuthService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder encoder;
    private LogService logService;
    public User signup(SignupRequest request) {
        User user = new User(request.getName(), request.getLastname(),
                request.getEmail().toLowerCase(), encoder.encode(request.getPassword()), true);
        user = updateRole(user);
        userRepository.save(user);
        logService.log(EventEnum.CREATE_USER, "Anonymous", user.getEmail(), "/api/auth/signup");
        return user;
    }

    public User updateRole(User user) {
        Set<Role> roles = new HashSet<>();
        if (userRepository.countAll() == 0) roles.add(roleRepository.findByName("ROLE_ADMINISTRATOR"));
        else roles.add(roleRepository.findByName("ROLE_USER"));
        user.setRoles(roles);
        return user;
    }

    public boolean checkExistsEmail(String email) {
        return userRepository.existsByEmailIgnoreCase(email);
    }

    public boolean isSameOldPass(String newPass, String oldPass) {
        return encoder.matches(newPass, oldPass);
    }

    public User changePass(String newPass, String email) {
        User user = userRepository.findByEmailIgnoreCase(email);
        user.setPassword(encoder.encode(newPass));
        userRepository.save(user);
        logService.log(EventEnum.CHANGE_PASSWORD, user.getEmail(), user.getEmail(), "/api/auth/changepass");
        return user;
    }
}