package com.fehmi.mobileaction.mobileactionbootcamp.springcore;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "PRODUCT")
public class Product {

    @Id
    @SequenceGenerator(name = "Product", sequenceName = "PRODUCT_ID_SEQ")
    @GeneratedValue(generator = "Product")
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name="PRICE", precision = 19, scale = 2)
    private BigDecimal price;


    private Boolean isActive;

    @Temporal(TemporalType.TIMESTAMP)
    private Date expireDate;

}
