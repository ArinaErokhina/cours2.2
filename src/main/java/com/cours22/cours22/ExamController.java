package com.cours22.cours22;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "/exam")
public class ExamController {

    private ExaminerService examinerService;

    public ExamController(ExaminerService examinerService){
        this.examinerService = examinerService;
    }

    @GetMapping(path ="/get")
    public Collection<Question> qetQuestions(@RequestParam(name = "amount") int amount){
        return examinerService.qetQuestions(amount);
    }
}
