package engine.business.presentation.controller;

import engine.business.entity.Quiz;
import engine.business.presentation.SolveQuizResponseDto;
import engine.business.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class QuizController {
    @Autowired
    QuizService quizService;

    @GetMapping("quiz")
    public Quiz getQuiz() {
        return quizService.getQuiz();
    }

    @PostMapping("quiz")
    public SolveQuizResponseDto solveQuiz(@RequestParam int answer) {
        return quizService.solveQuiz(answer);
    }
}