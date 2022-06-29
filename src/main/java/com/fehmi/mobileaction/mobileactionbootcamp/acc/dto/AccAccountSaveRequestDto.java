package com.fehmi.mobileaction.mobileactionbootcamp.acc.dto;

import com.fehmi.mobileaction.mobileactionbootcamp.acc.enums.EnumAccAccountType;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.enums.EnumAccCurrencyType;
import com.fehmi.mobileaction.mobileactionbootcamp.cus.entity.CusCustomer;
import com.fehmi.mobileaction.mobileactionbootcamp.gen.enums.EnumGenStatus;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class AccAccountSaveRequestDto {

    private Long cusCustomerId;
    private BigDecimal currentBalance;
    private EnumAccCurrencyType currencyType;
    private EnumAccAccountType accountType;
}
