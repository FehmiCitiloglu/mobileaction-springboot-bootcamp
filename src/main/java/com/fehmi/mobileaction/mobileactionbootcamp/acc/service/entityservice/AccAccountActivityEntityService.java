package com.fehmi.mobileaction.mobileactionbootcamp.acc.service.entityservice;


import com.fehmi.mobileaction.mobileactionbootcamp.acc.dao.AccAccountActivityDao;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.entity.AccAccountActivity;
import com.fehmi.mobileaction.mobileactionbootcamp.gen.service.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class AccAccountActivityEntityService extends BaseEntityService<AccAccountActivity, AccAccountActivityDao> {

    public AccAccountActivityEntityService(AccAccountActivityDao dao) {
        super(dao);
    }
}
