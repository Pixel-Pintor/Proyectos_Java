package platform.repository;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CodeBase implements Comparable<CodeBase>{

    static int noOfObjects = 0;
    final String datePattern = "yyyy/MM/dd HH:mm:ss";

    @JsonIgnore
    int id;
    @JsonProperty("date")
    String dateTime;
    String code;

    public CodeBase(String code) {
        this.code = code;
        this.dateTime = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern(datePattern));
        noOfObjects += 1;
        this.id = noOfObjects;
    }

    public String getCode() {
        return code;
    }

    public String getDateTime() {
        return this.dateTime;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public int compareTo(CodeBase codeBase) {
        return Integer.compare(codeBase.getId(), this.getId());
    }
}