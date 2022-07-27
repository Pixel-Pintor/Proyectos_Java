package engine.business.service;

import engine.business.entity.Quiz;
import engine.business.presentation.SolveQuizResponseDto;
import org.springframework.stereotype.Service;

@Service
public class QuizService {
    private static final Quiz QUIZ = new Quiz(
            "The Java Logo",
            "What is depicted on the Java logo?",
            new String[]{"Robot", "Tea leaf", "Cup of coffee", "Bug"}
    );

    public Quiz getQuiz() {
        return QUIZ;
    }

    public SolveQuizResponseDto solveQuiz(int answer) {
        if (answer == 2) {
            return new SolveQuizResponseDto(true, "Congratulations, you're right!");
        } else {
            return new SolveQuizResponseDto(false, "Wrong answer! Please, try again.");
        }
    }
}
