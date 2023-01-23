package com.example.TipService.controllers;

import com.example.TipService.model.CategoryDto;
import com.example.TipService.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/new_category")
    public String getCategoryForm(Model model) {
        model.addAttribute("category", new CategoryDto());
        return "new_category";

    }

    @GetMapping("/categories")
    public String getAllCategories(Model model) {
        List<CategoryDto> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "category_list";

    }


    @PostMapping("/add_category")
    public String addNewCategory(CategoryDto category) {
        categoryService.getAllCategories();
        return "redirect:/categories";
    }
}

