package com.example.TipService.services;

import com.example.TipService.dao.CategoryRepository;
import com.example.TipService.entities.CategoryEntity;
import com.example.TipService.model.CategoryDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    public CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;


    }

    public List<CategoryDto> getAllCategories() {
        List<CategoryEntity> categories = categoryRepository.findAll();


        return null;
    }

    private List<CategoryDto> convertEntityToDto(List<CategoryEntity> entities) {
        List<CategoryDto> result = new ArrayList<>();
        for (CategoryEntity entity : entities) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setCategoryId(entity.getId());
            categoryDto.setCategoryName(entity.getName());
            result.add(categoryDto);
        }
        return result;
    }
}
