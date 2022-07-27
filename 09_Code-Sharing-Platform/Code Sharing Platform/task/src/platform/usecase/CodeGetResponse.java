package platform.usecase;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CodeGetResponse {
    String code;
    String date;
}