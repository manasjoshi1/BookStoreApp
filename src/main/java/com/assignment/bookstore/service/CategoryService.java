package com.assignment.bookstore.service;

import com.assignment.bookstore.model.Category;
import com.assignment.bookstore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;
    public  void addCategory(Category category){
        categoryRepository.save(category);

    }
    public List<Category> getAllCategories(){
        List<Category> categories= categoryRepository.findAll();
        return categories;
    }
    public void deleteCategoryById(int id){
        categoryRepository.deleteById(id);
    }
    public Optional<Category> findCategoryByID(int id){
        return categoryRepository.findById(id);
    }
}
