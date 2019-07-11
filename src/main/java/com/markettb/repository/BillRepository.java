package com.markettb.repository;

import com.markettb.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BillRepository extends JpaRepository<Bill,Integer> {
    Bill findById(int id);
    List<Bill> findByOrderId(int orderId);
}
