package com.markettb.repository;

import com.markettb.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findById(int id);
    List<Product> findFirst5ByOrderByIdDesc();
}
