package com.markettb.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orderbill")
public class OrderBill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date date;

    @Column(name = "name")
    private String name;

    @Column(name = "total")
    private int total;

    // Implement constructor
    public OrderBill() {this.id = 0; }

    public OrderBill(Date date, String name, int total) {
        this.date = date;
        this.name = name;
        this.total = total;
    }

    // Implement Getter & Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "OrderBill{" +
                "id=" + id +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", total=" + total +
                '}';
    }
}
