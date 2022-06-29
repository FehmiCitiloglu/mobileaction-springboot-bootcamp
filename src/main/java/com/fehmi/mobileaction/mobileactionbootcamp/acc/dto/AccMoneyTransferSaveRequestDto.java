package com.fehmi.mobileaction.mobileactionbootcamp.acc.dto;

import com.fehmi.mobileaction.mobileactionbootcamp.acc.entity.AccAccount;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.enums.EnumAccMoneyTransferType;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class AccMoneyTransferSaveRequestDto {

    private Long accAccountIdFrom;
    private Long accAccountIdTo;
    private BigDecimal amount;
    private String description;
    private EnumAccMoneyTransferType moneyTransferType;
}
