package com.example.TipService.services;

import com.example.TipService.dao.CategoryRepository;
import com.example.TipService.dao.CommentRepository;
import com.example.TipService.dao.QuestionRepository;
import com.example.TipService.entities.*;
import com.example.TipService.model.AnswerDto;
import com.example.TipService.model.CommentDto;
import com.example.TipService.model.QuestionDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class QuestionService {

    UserService userService;
    QuestionRepository questionRepository;

    CategoryRepository categoryRepository;

    CommentRepository commentRepository;

    public QuestionService(QuestionRepository questionRepository, CategoryRepository categoryRepository, CommentRepository commentRepository, UserService userService) {
        this.questionRepository = questionRepository;
        this.categoryRepository = categoryRepository;
        this.commentRepository = commentRepository;
        this.userService = userService;
    }

    public void addQuestion(QuestionDto questionDto) {
        QuestionEntity questionEntity = new QuestionEntity();
        questionEntity.setQuestionDetails(questionDto.getQuestionDetails());
        questionEntity.setQuestionDate(LocalDate.now());
        //questionEntity.setAnswer(null); // nowe pytanie nie ma jeszcze odpowiedzi wiec tej linijki nie musi byc
        Optional<CategoryEntity> byId = categoryRepository.findById(questionDto.getCategoryId());
        byId.ifPresent(questionEntity::setCategory);
        //questionEntity.setUser(null);
        questionRepository.save(questionEntity);
    }

    public QuestionDto getQuestion(long id) {
        Optional<QuestionEntity> questionOp = questionRepository.findById(id);
        if (questionOp.isPresent()) {
            QuestionDto questionDto = new QuestionDto();
            QuestionEntity question = questionOp.get();
            questionDto.setId(question.getId());
            questionDto.setQuestionDetails(question.getQuestionDetails());
            questionDto.setQuestionDate(question.getQuestionDate());
            questionDto.setCategoryName(question.getCategory().getName());
            questionDto.setAnswer(convertAnswerEntityToAnswerDto(question.getAnswer()));
            return questionDto;
        }
        return null;

    }

    private AnswerDto convertAnswerEntityToAnswerDto(AnswerEntity answerEntity) {
        AnswerDto answerDto = new AnswerDto();
        answerDto.setDescription(answerEntity.getDescription());
        answerDto.setAnswerDate(answerEntity.getAnswerDate());
        answerDto.setRating(answerEntity.getRating());
        return answerDto;

    }

    public void addAnswer(Long questionId, AnswerDto answerDto) {
        AnswerEntity answer = new AnswerEntity();
        answer.setDescription(answerDto.getDescription());
        answer.setAnswerDate(LocalDate.now());
        answer.setRating(answerDto.getRating());
        UserEntity loggedUserEntity = userService.getLoggedUserEntity();
        answer.setUser(loggedUserEntity);
        Optional<QuestionEntity> questionEntityOp = questionRepository.findById(questionId);
        QuestionEntity questionEntity = questionEntityOp.get();
        answer.setQuestion(questionEntity);
        questionEntity.setAnswer(answer);
        questionRepository.save(questionEntity);

    }

    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }

    public void addComment(Long questionId, CommentDto commentDto) {
        CommentEntity comment = new CommentEntity();
        comment.setCommentContent(commentDto.getCommentContent());
        comment.setCommentDate(commentDto.getCommentDate());
        UserEntity loggedUserEntity = userService.getLoggedUserEntity();
        comment.setUser(loggedUserEntity);
        Optional<QuestionEntity> entityOp = questionRepository.findById(questionId);
        QuestionEntity questionEntity = entityOp.get();
        comment.setQuestion(questionEntity);
        questionEntity.setComment;
        questionRepository.save(questionEntity);

    }
}
