package account.component;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.YearMonth;

public class StringToLocalDateConverter {
    public static YearMonth convert(String source) {
        if (!source.matches("^(1[0-2]|0[1-9])-\\d{4}$")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid format MM-yyyy");
        }
        String[] parts = source.split("-");
        return YearMonth.of(Integer.parseInt(parts[1]), Integer.parseInt(parts[0]));
    }
}