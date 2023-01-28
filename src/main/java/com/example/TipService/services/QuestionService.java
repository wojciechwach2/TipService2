package com.example.TipService.services;

import com.example.TipService.dao.CategoryRepository;
import com.example.TipService.dao.CommentRepository;
import com.example.TipService.dao.QuestionRepository;
import com.example.TipService.entities.CategoryEntity;
import com.example.TipService.entities.QuestionEntity;
import com.example.TipService.model.QuestionDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class QuestionService {


    QuestionRepository questionRepository;

    CategoryRepository categoryRepository;

    CommentRepository commentRepository;

    public QuestionService(QuestionRepository questionRepository, CategoryRepository categoryRepository, CommentRepository commentRepository) {
        this.questionRepository = questionRepository;
        this.categoryRepository = categoryRepository;
        this.commentRepository = commentRepository;
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

    public QuestionDto getQuestion(long id) {
        Optional<QuestionEntity> question = questionRepository.findById(id);
        if (!question.isEmpty()) {
            return null;
        }

        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestionDetails(question.get().getQuestionDetails());
        questionDto.setQuestionDate(question.get().getQuestionDate());
        questionDto.setCategoryName(question.get().getCategory().getName());

//        List<CommentEntity> comments = commentRepository.findById();
//        if (!comments.isEmpty()) {
//         questionDto.setComments(comments.stream().map(comment -> new CommentDto(comment.getCommentContent().collect(Collectors.toList()));
//         }
        return questionDto;
    }

}
