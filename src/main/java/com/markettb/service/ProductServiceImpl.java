package com.markettb.service;

import com.markettb.dao.ProductDAO;
import com.markettb.model.Product;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO;

    @Autowired
    public void setProductDAO(ProductDAO productDAO){
        this.productDAO = productDAO;
    }

    @Override
    public void saveProduct(Product product) {
        if(product.getName()!= "" && product.getPrice()!= 0 && product.getQuantity()!=0 ){
            int total = product.getQuantity() * product.getPrice();
            product.setTotal(total);
            product.setDate(new Date());
            this.productDAO.saveProduct(product);
        }
    }

    @Override
    public void updateProduct(Product product) {
        if(product.getName()!= "" && product.getPrice()!= 0 && product.getQuantity()!=0 ){
            int total = product.getQuantity() * product.getPrice();
            product.setTotal(total);
            this.productDAO.updateProduct(product);
        }
    }

    @Override
    public void deleteProduct(int id) {
        if(id > 0)
            this.productDAO.deleteProduct(id);
    }

    @Override
    public Product getProductById(int id) {
        return this.productDAO.getProductById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return this.productDAO.getAllProducts();
    }

    @Override
    public List<Product> getLast5Products() {
        return this.productDAO.getLast5Products();
    }

    @Override
    public List<Product> getAllProductsByName(String name) {
        return this.productDAO.getAllProductsByName(name);
    }
}
