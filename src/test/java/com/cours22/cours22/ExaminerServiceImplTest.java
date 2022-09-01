package com.cours22.cours22;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.cours22.cours22.Constants.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    private Question question1 = new Question(QUESTION1, ANSWER1);
    private Question question2 = new Question(QUESTION2, ANSWER2);
    private Question question3 = new Question(QUESTION3, ANSWER3);
    private final Set<Question> questionList = new HashSet<>(Arrays.asList(
            question1,
            question2,
            question3
    ));

    @Mock
    private QuestionService questionService = new JavaQuestionService();

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    public void qetQuestionTest() {
        Mockito.when(questionService.getAll()).thenReturn(questionList);
        Mockito.when(questionService.getRandomQuestion()).thenReturn(question1, question2);
        Set<Question> expected = new HashSet<>(Arrays.asList(
                question1,
                question2
        ));
        Assertions.assertEquals(expected, examinerService.qetQuestions(2));
    }

    @Test
    public void ThereAreNotEnoughQuestionsExceptionTest() {
        Mockito.when(questionService.getAll()).thenReturn(questionList);
        Assertions.assertThrows(ThereAreNotEnoughQuestionsException.class,
                ()-> examinerService.qetQuestions(4));
    }

}
