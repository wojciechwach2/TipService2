package com.example.TipService.Validators;

import com.example.TipService.model.CategoryDto;
import com.example.TipService.model.QuestionDto;
import com.example.TipService.services.CategoryService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

@Component
public class QuestionValidator implements Validator {

    private final CategoryService categoryService;

    public QuestionValidator(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return QuestionDto.class.equals(clazz);

    }


    @Override
    public void validate(Object target, Errors errors) {
        QuestionDto questionDto = (QuestionDto) target;
        List<CategoryDto> allCategories = categoryService.getAllCategories();
        if (questionDto.getCategoryId() == null) {
            if (questionDto.getCategoryName().isBlank()) {
                errors.rejectValue("categoryName", "categoryName.error.format.notBlank");
            }
        }
        for (CategoryDto allCategory : allCategories) {
            if (allCategory.getCategoryName().equals(questionDto.getCategoryName())) {
                errors.rejectValue("categoryName", "categoryName.error.format.notUnique");
            }
        }
    }
}


