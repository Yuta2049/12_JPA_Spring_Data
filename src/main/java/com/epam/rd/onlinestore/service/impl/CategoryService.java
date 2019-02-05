package com.epam.rd.onlinestore.service.impl;

import com.epam.rd.onlinestore.dao.CategoryDAO;
import com.epam.rd.onlinestore.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

}
