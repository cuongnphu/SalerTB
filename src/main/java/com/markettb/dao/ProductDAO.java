package com.markettb.dao;

import com.markettb.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProductDAO {
    public void saveProduct(Product product);
    public void updateProduct(Product product);
    public void deleteProduct(int id);
    public Product getProductById(int id);
    public List<Product> getAllProducts();
    public List<Product> getLast5Products();
}
