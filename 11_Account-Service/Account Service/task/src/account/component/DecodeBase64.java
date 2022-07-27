package account.component;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class DecodeBase64 {
    public String decode(String encodeStr) {
        byte[] credDecoded = Base64.getDecoder().decode(encodeStr);
        return new String(credDecoded, StandardCharsets.UTF_8);
    }
}