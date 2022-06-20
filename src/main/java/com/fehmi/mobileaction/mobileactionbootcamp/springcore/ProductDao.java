package com.fehmi.mobileaction.mobileactionbootcamp.springcore;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Long> {


}
