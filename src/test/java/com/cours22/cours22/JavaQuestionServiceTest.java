package com.cours22.cours22;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import static com.cours22.cours22.Constants.*;

public class JavaQuestionServiceTest {

    private QuestionService questionService;
    private Question question1;
    private Question question2;

    @BeforeEach
    public void setUp() {
        questionService = new JavaQuestionService();
        question1 = new Question(QUESTION1, ANSWER1);
        question2 = new Question(QUESTION2, ANSWER2);
    }

    @Test
    public void addQuestionOnTextQuestionAndAnswerTest() {
        Assertions.assertEquals(question1, questionService.add(QUESTION1, ANSWER1));
    }

    @Test
    public void questionAlreadyAddedExceptionTest() {
        questionService.add(question1);
        Assertions.assertThrows(QuestionAlreadyAddedException.class,
                () -> questionService.add(QUESTION1, ANSWER1));
    }

    @Test
    public void addQuestionTest(){
        Assertions.assertEquals(question1, questionService.add(question1));
    }

    @Test
    public void questionAlreadyAddedException() {
        questionService.add(question1);
        Assertions.assertThrows(QuestionAlreadyAddedException.class,
                () -> questionService.add(question1));
    }

    @Test
    public void removeTest(){
        questionService.add(question1);
        Assertions.assertEquals(question1, questionService.remove(question1));
    }

    @Test
    public void questionNotFoundExceptionTest(){
        Assertions.assertThrows(QuestionNotFoundException.class,
                ()-> questionService.remove(question1));
    }

    @Test
    public void getAllTest(){
        Collection<Question> actual = questionService.getAll();
        Collection<Question> expected = new ArrayList<>();
        expected.add(question1);
        expected.add(question2);
        questionService.add(question1);
        questionService.add(question2);
        Assertions.assertEquals(expected, questionService.getAll());
    }
}
