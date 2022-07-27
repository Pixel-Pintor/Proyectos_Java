package account.controller;

import account.component.CurrentUser;
import account.dto.request.ChangePassRequest;
import account.dto.request.SignupRequest;
import account.dto.response.ChangePassResponse;
import account.dto.response.UserDto;
import account.mapper.ChangePassResponseMapper;
import account.mapper.UserDtoMapper;
import account.model.EventEnum;
import account.model.User;
import account.service.AuthService;
import account.service.LogService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final CurrentUser currentUser;

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signup(@Valid @RequestBody SignupRequest request) {
        if (authService.checkExistsEmail(request.getEmail())) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User exist!");
        return ResponseEntity.ok().body(UserDtoMapper.mapping(authService.signup(request)));
    }

    @PostMapping("/changepass")
    public ResponseEntity<ChangePassResponse> changePass(@Valid @RequestBody ChangePassRequest request) {
        if (currentUser.getCurrentUser().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        User user = currentUser.getCurrentUser().get().getUser();

        if (authService.isSameOldPass(request.getNew_password(), user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The passwords must be different!");
        }
        return ResponseEntity.ok().body(ChangePassResponseMapper.mapping(authService.changePass(request.getNew_password(), user.getEmail())));
    }
}