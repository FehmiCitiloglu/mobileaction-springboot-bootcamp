package com.fehmi.mobileaction.mobileactionbootcamp.cus.dao;

import com.fehmi.mobileaction.mobileactionbootcamp.cus.entity.CusCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CusCustomerDao extends JpaRepository<CusCustomer, Long> {
}
