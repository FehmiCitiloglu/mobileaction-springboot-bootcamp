package com.fehmi.mobileaction.mobileactionbootcamp.acc.dto;

import com.fehmi.mobileaction.mobileactionbootcamp.acc.enums.EnumAccMoneyTransferType;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AccMoneyTransferDto {

    private Long accAccountIdFrom;
    private String accAccountNameFrom;
    private String accAccountNameTo;
    private Long cusCustomerIdFrom;
    private Long cusCustomerIdTo;
    private Long accAccountIdTo;
    private String cuCustomerNameTo;
    private String cuCustomerNameFrom;
    private BigDecimal amount;
    private String description;
    private EnumAccMoneyTransferType moneyTransferType;
    private Date transferDate;

}
