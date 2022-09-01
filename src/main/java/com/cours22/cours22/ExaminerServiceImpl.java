package com.cours22.cours22;

import org.springframework.stereotype.Service;
import java.util.*;
import java.util.Collection;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private Random random;
    private QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    public Collection<Question> qetQuestions(int amount){
        Set<Question> listQuestions = new HashSet<>();
        if(questionService.getAll().size() < amount){
            throw new ThereAreNotEnoughQuestionsException();
        }
        while (listQuestions.size() < amount){
            listQuestions.add(questionService.getRandomQuestion());
        }
        return listQuestions;
    }
}
