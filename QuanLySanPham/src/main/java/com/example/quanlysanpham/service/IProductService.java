package com.example.quanlysanpham.service;

import com.example.quanlysanpham.model.Product;
import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);
    Product findById(int id);
    void update(int id, Product product);
    void delete(int id);
    List<Product> searchByName(String name);
}
