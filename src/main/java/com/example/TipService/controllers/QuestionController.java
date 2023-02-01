package com.example.TipService.controllers;

import com.example.TipService.model.AnswerDto;
import com.example.TipService.model.QuestionDto;
import com.example.TipService.services.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class QuestionController {


    private final QuestionService questionService;

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
        return "single_question";
    }

    @GetMapping("/questions")
    public String getQuestionsForCategory() {
        return "category_list";

    }
    @PostMapping("/add_answer/{questionId}")
    public String addAnswer(@PathVariable("questionId") Long questionId, AnswerDto answerDto) {
        questionService.addAnswer(questionId, answerDto);
        return "redirect:/questions/" + questionId;
    }
    @DeleteMapping
    public String deleteQuestion(Long id){
        questionService.deleteQuestion(id);
        return "redirect:/questions/";
    }
}
