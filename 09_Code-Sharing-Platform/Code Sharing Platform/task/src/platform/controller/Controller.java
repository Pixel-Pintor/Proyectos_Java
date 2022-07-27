package platform.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import platform.repository.CodeBase;
import platform.repository.CodeBaseRepository;
import platform.usecase.CodeDto;
import platform.usecase.CodeGetResponse;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api")
public class Controller {

    CodeBaseRepository codeBase = CodeBaseRepository.getInstance();
    List<CodeBase> codeBaseList = codeBase.getCodeBaseList();

    @PostMapping("/code/new")
    public ResponseEntity<HashMap<String, Object>> createFeed(@RequestBody CodeDto codeDto) {
        CodeBase base = new CodeBase(codeDto.getCode());
        codeBaseList.add(base);
        HashMap<String, Object> response = new HashMap<>();
        response.put("id", String.valueOf(codeBaseList.size()));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/code/{id}")
    public ResponseEntity<CodeGetResponse> getFeedById(@PathVariable int id) {
        for (CodeBase code : codeBaseList) {
            if (code.getId() == id) {
                CodeGetResponse getResponse = new CodeGetResponse();
                getResponse.setDate(code.getDateTime());
                getResponse.setCode(code.getCode());
                return new ResponseEntity<>(getResponse, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/code/latest")
    public ResponseEntity<List<CodeBase>> getLatest() {
        if (codeBaseList.size() <= 10) {
            List<CodeBase> sortedList = codeBaseList.stream()
                    .sorted(CodeBase::compareTo)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(sortedList, HttpStatus.OK);
        }
        List<CodeBase> latestCodes = codeBaseList.subList(codeBaseList.size() - 10, codeBaseList.size());
        List<CodeBase> sortedList = latestCodes
                .stream()
                .sorted(CodeBase::compareTo)
                .collect(Collectors.toList());
        return new ResponseEntity<>(sortedList, HttpStatus.OK);
    }
}