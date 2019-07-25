package com.markettb.dao;

import com.markettb.model.Product;
import com.markettb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ProductDAOImpl implements ProductDAO {

    private ProductRepository productRepository;

    /*Inject productRepository to class*/
    @Autowired
    public void setProductRepository(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    /*SAVE a new Product*/
    @Override
    public void saveProduct(Product product) {
        this.productRepository.save(product);
    }

    /*UPDATE a particular Product*/
    @Override
    public void updateProduct(Product product) {
        Product updateProduct = this.productRepository.getOne(product.getId());
        updateProduct.setName(product.getName());
        updateProduct.setQuantity(product.getQuantity());
        updateProduct.setPrice(product.getPrice());
        updateProduct.setTotal(product.getTotal());
        this.productRepository.save(updateProduct);
    }

    /*DELETE a particular Product*/
    @Override
    public void deleteProduct(Product product) {
        this.productRepository.delete(product);
    }

    /* GET a particular Product By Id*/
    @Override
    public Product getProductById(int id) {
        return this.productRepository.findById(id);
    }

    /* GET All products */
    @Override
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    /* GET last 5 product in list*/
    @Override
    public List<Product> getLast5Products() {
        return this.productRepository.findFirst5ByOrderByIdDesc();
    }
}
