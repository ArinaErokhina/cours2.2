package com.cours22.cours22;

import com.sun.source.doctree.SeeTree;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    public List<Question> examQuestion = new ArrayList<>();

    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        for (int i = 0; i < examQuestion.size(); i++) {
            if (newQuestion.equals(examQuestion.get(i))) {
                throw new QuestionAlreadyAddedException();
            }
        }
        examQuestion.add(newQuestion);
        return newQuestion;
    }

    public Question add(Question question) {
        for (int i = 0; i < examQuestion.size(); i++) {
            if (question.equals(examQuestion.get(i))) {
                throw new QuestionAlreadyAddedException();
            }
        }
        examQuestion.add(question);
        return question;
    }

    public Question remove(Question question) {
        for (int i = 0; i < examQuestion.size(); i++) {
            if (question.equals(examQuestion.get(i))) {
                examQuestion.remove(question);
                return question;
            }
        }
        throw new QuestionNotFoundException();
    }

    public Collection<Question> getAll() {
        return examQuestion;
    }

    public Question getRandomQuestion() {
        Random random = new Random();
        int numberQuestion = random.nextInt(examQuestion.size());
        return examQuestion.get(numberQuestion);
    }
}
