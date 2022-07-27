package account.controller;

import account.model.LogEvent;
import account.service.LogService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class AuditorController {
    private LogService logService;
    @GetMapping("/security/events")
    public ResponseEntity<List<LogEvent>> getLogs() {
        return ResponseEntity.ok().body(logService.getLogs());
    }
}