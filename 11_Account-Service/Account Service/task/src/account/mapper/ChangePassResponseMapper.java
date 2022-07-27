package account.mapper;

import account.dto.response.ChangePassResponse;
import account.model.User;

public class ChangePassResponseMapper {
    public static ChangePassResponse mapping(User user) {
        return new ChangePassResponse(user.getEmail(), "The password has been updated successfully");
    }
}