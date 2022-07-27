package platform.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import platform.repository.CodeBase;
import platform.repository.CodeBaseRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class WebController {

    CodeBaseRepository codeBase = CodeBaseRepository.getInstance();
    List<CodeBase> codeBaseList = codeBase.getCodeBaseList();

    @GetMapping("/code/{N}")
    public String getCodeById(Model model, @PathVariable int N) {
        for (CodeBase codeBase: codeBaseList) {
            if (codeBase.getId() == N) {
                model.addAttribute("code", codeBase);
                return "usercode";
            }
        }
        return "404";
    }

    @GetMapping("/code/new")
    public String createNew() {
        return "new";
    }

    @GetMapping("/code/latest")
    public String latest(Model model) {
        if (codeBaseList.size() <= 10) {
            List<CodeBase> sortedList = codeBaseList.stream()
                    .sorted(CodeBase::compareTo)
                    .collect(Collectors.toList());
            model.addAttribute("codes", sortedList);
            return "code";
        }
        List<CodeBase> latestCodes = codeBaseList.subList(codeBaseList.size() - 10, codeBaseList.size());
        List<CodeBase> sortedList = latestCodes
                .stream()
                .sorted(CodeBase::compareTo)
                .collect(Collectors.toList());
        model.addAttribute("codes", sortedList);
        return "code";
    }
}