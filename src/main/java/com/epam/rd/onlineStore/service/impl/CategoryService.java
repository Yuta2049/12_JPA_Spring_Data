package com.epam.rd.onlineStore.service.impl;

import com.epam.rd.onlineStore.dao.CategoryDAO;
import com.epam.rd.onlineStore.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryDAO productDAO = new CategoryDAO();

    public CategoryService() {}

    public List<Category> findAll() {
        return productDAO.findAll();
    }

}
