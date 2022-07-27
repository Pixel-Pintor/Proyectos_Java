package account.service;

import account.component.CurrentUser;
import account.model.User;
import account.model.*;
import account.repository.RoleRepository;
import account.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private LogService logService;
    private CurrentUser currentUser;
    private HttpServletRequest request;

    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }

    public void deleteUser(String email) {
        User user = getUser(email);
        if (isAdministrator(user)) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Can't remove ADMINISTRATOR role!");
        userRepository.delete(user);
        logService.log(EventEnum.DELETE_USER, getCurrentUser().getEmail(), user.getEmail(), "/api/admin/user");
    }

    public User updateRole(RoleOperationStatus operation, String strRole, String email) {
        User user = getUser(email);
        User currentUser = getCurrentUser();
        Role role = roleRepository.findByName("ROLE_" + strRole);
        if (role == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Role not found!");
        if (operation.equals(RoleOperationStatus.GRANT)) {
            grantRole(role, user);
            logService.log(
                    EventEnum.GRANT_ROLE, currentUser.getEmail(),
                    String.format("Grant role %s to %s", strRole, user.getEmail()),
                    "/api/admin/user/role"
            );
        }
        if (operation.equals(RoleOperationStatus.REMOVE)) {
            removeRole(role, user);
            logService.log(
                    EventEnum.REMOVE_ROLE, currentUser.getEmail(),
                    String.format("Remove role %s from %s", strRole, user.getEmail()),
                    "/api/admin/user/role"
            );
        }
        return user;
    }

    private void grantRole(Role role, User user) {
        if (isAdministrator(user) || role.getName().equals("ROLE_ADMINISTRATOR")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The user cannot combine administrative and business roles!");
        }
        Set<Role> roles = new HashSet<>(user.getRoles());
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);
    }

    private void removeRole(Role role, User user) {
        if (!user.getRoles().contains(role)) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The user does not have a role!");
        if (role.getName().equals("ROLE_ADMINISTRATOR")) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Can't remove ADMINISTRATOR role!");
        if (user.getRoles().size() == 1) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The user must have at least one role!");
        Set<Role> roles = new HashSet<>(user.getRoles());
        roles.remove(role);
        user.setRoles(roles);
        userRepository.save(user);
    }

    private User getUser(String email) {
        User user = userRepository.findByEmailIgnoreCase(email);
        if (user == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found!");
        return user;
    }

    private boolean isAdministrator(User user) {
        for (Role role :
                user.getRoles()) {
            if (role.getName().equals("ROLE_ADMINISTRATOR")) return true;
        }
        return false;
    }

    public User updateActivatedUser(UserOperationStatus operation, String email) {
        User user = getUser(email);
        User currentUser = getCurrentUser();
        if (isAdministrator(user)) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Can't lock the ADMINISTRATOR!");
        boolean active = UserOperationStatus.UNLOCK.equals(operation);
        user.setActive(active);
        userRepository.save(user);

        final String uri = request.getRequestURI();
        if (active) logService.log(EventEnum.UNLOCK_USER, currentUser.getEmail(), String.format("Unlock user %s", user.getEmail()), uri);
        else logService.log(EventEnum.LOCK_USER, currentUser.getEmail(), String.format("Lock user %s", user.getEmail()), uri);

        return user;
    }

    private User getCurrentUser() {
        Optional<UserDetailsImpl> userDetails = currentUser.getCurrentUser();
        return userDetails.map(UserDetailsImpl::getUser).orElse(null);
    }
}