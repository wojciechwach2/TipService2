package com.example.TipService.services;

import com.example.TipService.DAO.CategoryRepository;
import com.example.TipService.model.CategoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    public CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;


    }
    public List<CategoryDTO> getAllCategories(){
        return null;
    }
}
