package com.example.TipService.services;

import com.example.TipService.dao.CategoryRepository;
import com.example.TipService.model.CategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    public CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;


    }
    public List<CategoryDto> getAllCategories(){
        return null;
    }
}
