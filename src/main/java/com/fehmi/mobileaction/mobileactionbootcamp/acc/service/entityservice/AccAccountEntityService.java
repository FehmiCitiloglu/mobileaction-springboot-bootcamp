package com.fehmi.mobileaction.mobileactionbootcamp.acc.service.entityservice;

import com.fehmi.mobileaction.mobileactionbootcamp.acc.dao.AccAccountActivityDao;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.dao.AccAccountDao;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.entity.AccAccount;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.entity.AccAccountActivity;
import com.fehmi.mobileaction.mobileactionbootcamp.gen.service.BaseEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
public class AccAccountEntityService extends BaseEntityService<AccAccount, AccAccountDao> {


    public AccAccountEntityService(AccAccountDao dao) {
        super(dao);
    }
}
