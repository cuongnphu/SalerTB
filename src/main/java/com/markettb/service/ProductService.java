package com.markettb.service;

import com.markettb.model.Product;

import java.util.List;

public interface ProductService {
    public void saveProduct(Product product);
    public void updateProduct(Product product);
    public void deleteProduct(Product product);
    public Product getProductById(int id);
    public List<Product> getAllProducts();
    public List<Product> getLast5Products();
}
