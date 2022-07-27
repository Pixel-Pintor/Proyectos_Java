package account.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.YearMonth;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UploadPayrollRequest {
    @NotNull
    private String employee;
    @NotNull
    @JsonFormat(pattern = "MM-yyyy")
    private YearMonth period;
    @NotNull
    @Min(0)
    private long salary;
}