package account.mapper;

import account.dto.response.UserDto;
import account.model.User;

import java.util.Set;
import java.util.TreeSet;

public class UserDtoMapper {
    public static UserDto mapping(User user) {
        Set<String> roles = new TreeSet<>();
        user.getRoles().forEach(role -> roles.add(role.getName()));
        return new UserDto(user.getId(), user.getName(), user.getLastname(), user.getEmail(), roles);
    }
}