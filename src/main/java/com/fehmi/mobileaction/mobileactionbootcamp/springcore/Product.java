package com.fehmi.mobileaction.mobileactionbootcamp.springcore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Product {
    @Id
    private Long id;

    private String name;

    private BigDecimal price;

    private Boolean isActive;

    private Date expireDate;

}
