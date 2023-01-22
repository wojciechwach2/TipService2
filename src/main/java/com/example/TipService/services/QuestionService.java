package com.example.TipService.services;

import com.example.TipService.dao.CategoryRepository;
import com.example.TipService.dao.QuestionRepository;
import com.example.TipService.entities.CategoryEntity;
import com.example.TipService.entities.QuestionEntity;
import com.example.TipService.model.QuestionDto;

import java.time.LocalDate;
import java.util.Optional;

public class QuestionService {


    QuestionRepository questionRepository;

    CategoryRepository categoryRepository;

    public QuestionService(QuestionRepository questionRepository, CategoryRepository categoryRepository) {
        this.questionRepository = questionRepository;
        this.categoryRepository = categoryRepository;
    }

    public void addQuestion(QuestionDto questionDto) {
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setQuestionDetails(questionDto.getQuestionDetails());
        questionEntity.setQuestionDate(LocalDate.now());
        //questionEntity.setAnswers(null); // nowe pytanie nie ma jeszcze odpowiedzi wiec tej linijki nie musi byc
        Optional<CategoryEntity> byId = categoryRepository.findById(questionDto.getCategoryId());
        byId.ifPresent(questionEntity::setCategory);
        //questionEntity.setUser(null);
        questionRepository.save(questionEntity);
    }
}