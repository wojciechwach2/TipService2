package com.example.TipService.controllers;

import com.example.TipService.controllers.Validators.QuestionValidator;
import com.example.TipService.model.AnswerDto;
import com.example.TipService.model.CommentDto;
import com.example.TipService.model.QuestionDto;
import com.example.TipService.services.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
public class QuestionController {


    private final QuestionService questionService;
    private final QuestionValidator questionValidator;



    public QuestionController(QuestionService questionService, QuestionValidator questionValidator) {
        this.questionService = questionService;
        this.questionValidator = questionValidator;

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
    public String deleteQuestion(Long id) {
        questionService.deleteQuestion(id);
        return "redirect:/questions/";
    }
    @PostMapping("/add_comment/{questionId}")
    public String addComment(@PathVariable("questionId") Long questionId, CommentDto commentDto){
        questionService.addComment(questionId, commentDto);
        return "redirect:/questions" + questionId;
    }
    @InitBinder("question")
    private void initBinder(WebDataBinder binder) {
        binder.addValidators(questionValidator);
    }
}
