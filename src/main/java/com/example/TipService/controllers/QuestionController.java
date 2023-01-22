package com.example.TipService.controllers;

import com.example.TipService.model.QuestionDto;
import com.example.TipService.services.QuestionService;
import org.springframework.web.bind.annotation.PostMapping;

public class QuestionController {


    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/question")
    public String addQuestion(QuestionDto questionDto) {
        questionService.addQuestion(questionDto);
        return "redirect:/index";
    }

}