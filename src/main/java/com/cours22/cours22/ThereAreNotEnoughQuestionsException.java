package com.cours22.cours22;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ThereAreNotEnoughQuestionsException extends RuntimeException{
}
