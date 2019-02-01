package com.epam.rd.onlineStore.dao;

import com.epam.rd.onlineStore.model.Category;
import com.epam.rd.onlineStore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CategoryDAO extends JpaRepository<Category, Long> {

    public List<Category> findAll();

//    public List<Category> findAll() {
//
//        List<Category> categories = new ArrayList<>();
//
//        categories.add(new Category(1, "Планетарные станции и корабли поколений"));
//        categories.add(new Category(2, "Звездолеты среднего размера"));
//        categories.add(new Category(3, "Малые звездолеты"));
//
//        return categories;
//    }

}