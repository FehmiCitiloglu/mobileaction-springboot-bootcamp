package com.fehmi.mobileaction.mobileactionbootcamp.acc.dao;

import com.fehmi.mobileaction.mobileactionbootcamp.acc.enums.EnumAccAccountActivityType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class AccMoneyActivityDto {

    private Long accAccountId;
    private BigDecimal amount;
    private EnumAccAccountActivityType accountActivityType;
}
