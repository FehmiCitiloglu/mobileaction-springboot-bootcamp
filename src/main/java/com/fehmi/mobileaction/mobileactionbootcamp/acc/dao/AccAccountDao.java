package com.fehmi.mobileaction.mobileactionbootcamp.acc.dao;

import com.fehmi.mobileaction.mobileactionbootcamp.acc.entity.AccAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccAccountDao  extends JpaRepository<AccAccount, Long> {
}
