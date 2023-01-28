package com.example.TipService.controllers;

import com.example.TipService.model.AnswerDto;
import com.example.TipService.model.QuestionDto;
import com.example.TipService.services.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
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

    @GetMapping("/questions/{id}")
    public String getQuestion(@PathVariable("id") Long id, Model model) {
        QuestionDto question = questionService.getQuestion(id);
        model.addAttribute("question", question);
        AnswerDto answer = new AnswerDto();
        model.addAttribute("answer", answer);
        return "singleQuestion";

    }

    @GetMapping("/question")
    public String getQuestionsForCategory() {
        return "category_list";

    }

    @PostMapping("/add_answer")
    public String addAnswer(AnswerDto answerDto) {
        questionService.addAnswer(answerDto);
        return "singleQuestion";
    }
}
