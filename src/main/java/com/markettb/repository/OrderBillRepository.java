package com.markettb.repository;

import com.markettb.model.OrderBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderBillRepository extends JpaRepository<OrderBill,Integer> {
    OrderBill findById(int id);
    List<OrderBill> findFirst5ByOrderByIdDesc();
    List<OrderBill> findAllByDateBetween(Date fromDate,Date toDate);
}
