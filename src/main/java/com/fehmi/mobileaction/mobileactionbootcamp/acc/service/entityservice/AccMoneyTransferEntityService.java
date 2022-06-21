package com.fehmi.mobileaction.mobileactionbootcamp.acc.service.entityservice;

import com.fehmi.mobileaction.mobileactionbootcamp.acc.dao.AccMoneyTransferDao;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.entity.AccMoneyTransfer;
import com.fehmi.mobileaction.mobileactionbootcamp.gen.service.BaseEntityService;


public class AccMoneyTransferEntityService extends BaseEntityService<AccMoneyTransfer, AccMoneyTransferDao> {

    public AccMoneyTransferEntityService(AccMoneyTransferDao dao) {
        super(dao);
    }
}
