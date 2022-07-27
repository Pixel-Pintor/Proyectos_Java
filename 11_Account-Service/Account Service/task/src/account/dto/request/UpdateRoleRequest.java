package account.dto.request;

import account.annotation.EnumCheck;
import account.model.RoleOperationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRoleRequest {
    @NotNull
    private String user;
    @NotNull
    private String role;
    @EnumCheck(enumClazz = RoleOperationStatus.class)
    private String operation;
}