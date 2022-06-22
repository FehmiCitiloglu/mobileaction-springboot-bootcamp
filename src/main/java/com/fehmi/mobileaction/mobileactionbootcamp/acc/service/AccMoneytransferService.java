package com.fehmi.mobileaction.mobileactionbootcamp.acc.service;

import com.fehmi.mobileaction.mobileactionbootcamp.acc.converter.AccMoneyTransferMapper;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.dao.AccMoneyActivityDto;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.dto.AccMoneyTransferDto;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.dto.AccMoneyTransferSaveRequestDto;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.entity.AccAccount;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.entity.AccMoneyTransfer;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.enums.EnumAccAccountActivityType;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.enums.EnumAccMoneyTransferType;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.service.entityservice.AccAccountEntityService;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.service.entityservice.AccMoneyTransferEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccMoneytransferService {

    private final AccAccountEntityService accAccountEntityService;
    private final AccMoneyTransferEntityService accMoneyTransferEntityService;
    private final AccAccountActivityService accAccountActivityService;

    public AccMoneyTransferDto transferMoney(AccMoneyTransferSaveRequestDto accMoneyTransferSaveRequestDto) {
        AccMoneyTransfer accMoneyTransfer = AccMoneyTransferMapper.INSTANCE.convertToAccMoneyTransferDto(accMoneyTransferSaveRequestDto);

        BigDecimal amount = accMoneyTransferSaveRequestDto.getAmount();
        Long accAccountIdFrom = accMoneyTransferSaveRequestDto.getAccAccountIdFrom();
        Long accAccountIdTo = accMoneyTransferSaveRequestDto.getAccAccountIdTo();

        AccAccount accAccountFrom = accAccountEntityService.findByIdWithControl(accAccountIdFrom);
        AccAccount accAccountTo = accAccountEntityService.findByIdWithControl(accAccountIdTo);

        validateCurrencyType(accAccountFrom, accAccountTo);

        accMoneyTransfer.setAccAccountFrom(accAccountFrom);
        accMoneyTransfer.setAccAccountTo(accAccountTo);
        accMoneyTransfer.setTransferDate(new Date());

        AccMoneyActivityDto moneyActivityDtoOut = AccMoneyActivityDto.builder()
                .accAccountId(accAccountIdFrom)
                .amount(amount)
                .accountActivityType(EnumAccAccountActivityType.SEND)
                .build();

        AccMoneyActivityDto moneyActivityDtoIn = AccMoneyActivityDto.builder()
                .accAccountId(accAccountIdTo)
                .amount(amount)
                .accountActivityType(EnumAccAccountActivityType.GET)
                .build();

        accAccountActivityService.moneyOut(moneyActivityDtoOut);
        accAccountActivityService.moneyIn(moneyActivityDtoIn);

        accMoneyTransfer = accMoneyTransferEntityService.save(accMoneyTransfer);
        AccMoneyTransferDto accMoneyTransferDto = AccMoneyTransferMapper.INSTANCE.convertToAccMoneyTransferDto(accMoneyTransfer);

        return accMoneyTransferDto;
    }

    private void validateCurrencyType(AccAccount accAccountFrom, AccAccount accAccountTo) {
        if(accAccountFrom.getCurrencyType().equals(accAccountTo.getCurrencyType())){
            throw new RuntimeException("Currency types can not be different!");
        }
    }
}
