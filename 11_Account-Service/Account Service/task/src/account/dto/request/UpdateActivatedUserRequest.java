package account.dto.request;

import account.annotation.EnumCheck;
import account.model.UserOperationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateActivatedUserRequest {
    @NotNull
    private String user;
    @EnumCheck(enumClazz = UserOperationStatus.class)
    private String operation;
}