package com.example.TipService.services;

import com.example.TipService.dao.CategoryRepository;
import com.example.TipService.dao.CommentRepository;
import com.example.TipService.dao.QuestionRepository;
import com.example.TipService.entities.AnswerEntity;
import com.example.TipService.entities.CategoryEntity;
import com.example.TipService.entities.QuestionEntity;
import com.example.TipService.entities.UserEntity;
import com.example.TipService.model.AnswerDto;
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
        //questionEntity.setAnswers(null); // nowe pytanie nie ma jeszcze odpowiedzi wiec tej linijki nie musi byc
        Optional<CategoryEntity> byId = categoryRepository.findById(questionDto.getCategoryId());
        byId.ifPresent(questionEntity::setCategory);
        //questionEntity.setUser(null);
        questionRepository.save(questionEntity);
    }

    public QuestionDto getQuestion(long id) {
        Optional<QuestionEntity> question = questionRepository.findById(id);
        if (question.isEmpty()) {
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

    public void  addAnswer(AnswerDto answerDto) {
        AnswerEntity answer = new AnswerEntity();
        answer.setDescription(answerDto.getDescription());
        answer.setAnswerDate(LocalDate.now());
        answer.setRating(answerDto.getRating());
        UserEntity loggedUserEntity = userService.getLoggedUserEntity();
        answer.setUser(loggedUserEntity);
        Optional<QuestionEntity> questionEntity = questionRepository.findById(null);
        answer.setQuestion(questionEntity.get());
        questionRepository.save(questionEntity.get());

    }
//    public void changePassword(PasswordDto passwordDto) {
//        UserEntity user = getLoggedUserEntity();
//        String currentPassword = passwordEncoder.encode(passwordDto.getCurrentPassword());
//        if (currentPassword.equals(user.getPassword())) {
//            if (passwordDto.getNewPassword().equals(passwordDto.getReenteredNewPassword())) {
//                user.setPassword(passwordEncoder.encode(passwordDto.getNewPassword()));
//            }
//        }
//        userRepository.save(user);
    }

