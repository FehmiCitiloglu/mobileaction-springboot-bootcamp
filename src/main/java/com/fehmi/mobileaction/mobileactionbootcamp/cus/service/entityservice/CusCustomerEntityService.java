package com.fehmi.mobileaction.mobileactionbootcamp.cus.service.entityservice;

import com.fehmi.mobileaction.mobileactionbootcamp.cus.dao.CusCustomerDao;
import com.fehmi.mobileaction.mobileactionbootcamp.cus.entity.CusCustomer;
import com.fehmi.mobileaction.mobileactionbootcamp.gen.service.BaseEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class CusCustomerEntityService extends BaseEntityService<CusCustomer, CusCustomerDao> {


    public CusCustomerEntityService(CusCustomerDao dao) {
        super(dao);
    }
}
