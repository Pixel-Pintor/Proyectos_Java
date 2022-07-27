package account.controller;

import account.dto.request.UpdateActivatedUserRequest;
import account.dto.request.UpdateRoleRequest;
import account.dto.response.UserDto;
import account.mapper.UserDtoMapper;
import account.model.RoleOperationStatus;
import account.model.User;
import account.model.UserOperationStatus;
import account.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admin")
@AllArgsConstructor
public class AdminController {
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity<List<UserDto>> getUserList() {
        return ResponseEntity.ok().body(userService.getAll().stream().map(UserDtoMapper::mapping).collect(Collectors.toList()));
    }

    @DeleteMapping(value = {"/user/{email}", "/user/", "/user"})
    public ResponseEntity<Map<String, String>> deleteUser(@PathVariable String email) {
        userService.deleteUser(email);
        return ResponseEntity.ok().body(Map.of("user", email, "status", "Deleted successfully!"));
    }

    @PutMapping("/user/role")
    public ResponseEntity<UserDto> updateUserRole(@RequestBody @Valid UpdateRoleRequest request) {
        return ResponseEntity.ok().body(UserDtoMapper.mapping(userService.updateRole(RoleOperationStatus.valueOf(request.getOperation()), request.getRole(), request.getUser())));
    }

    @PutMapping("/user/access")
    public ResponseEntity<Map<String, String>> updateActivatedUser(@RequestBody @Valid UpdateActivatedUserRequest request) {
        User user = userService.updateActivatedUser(UserOperationStatus.valueOf(request.getOperation()), request.getUser());
        String message = String.format("User %s %s", user.getEmail(), request.getOperation().toLowerCase() + "ed!");
        return ResponseEntity.ok().body(Map.of("status", message));
    }
}