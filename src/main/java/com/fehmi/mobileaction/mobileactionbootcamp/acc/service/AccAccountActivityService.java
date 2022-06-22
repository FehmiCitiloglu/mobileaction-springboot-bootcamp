package com.fehmi.mobileaction.mobileactionbootcamp.acc.service;


import com.fehmi.mobileaction.mobileactionbootcamp.acc.dao.AccMoneyActivityDto;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.entity.AccAccount;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.entity.AccAccountActivity;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.enums.EnumAccAccountActivityType;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.service.entityservice.AccAccountActivityEntityService;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.service.entityservice.AccAccountEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class AccAccountActivityService {

    private final AccAccountEntityService accAccountEntityService;
    private final AccAccountActivityEntityService accAccountActivityEntityService;

    public AccAccountActivity moneyOut(AccMoneyActivityDto moneyActivityDtoOut) {
        validateMoneyActivityParameters(moneyActivityDtoOut);

        Long accAccountId = moneyActivityDtoOut.getAccAccountId();

        BigDecimal amount = moneyActivityDtoOut.getAmount();
        EnumAccAccountActivityType accountActivityType = moneyActivityDtoOut.getAccountActivityType();

        AccAccount accAccount = accAccountEntityService.findByIdWithControl(accAccountId);

        BigDecimal newBalance = calculateAndValidateNewBalanceForMoneyOut(amount, accAccount);

        validateBalance(newBalance);
        AccAccountActivity accAccountActivity = createAccAccountActivity(moneyActivityDtoOut, accAccount, newBalance);


        updateCurrentBalance(accAccount, newBalance);
        return accAccountActivity;
    }


    public AccAccountActivity moneyIn(AccMoneyActivityDto moneyActivityDtoIn) {

        validateMoneyActivityParameters(moneyActivityDtoIn);

        AccAccount accAccount = accAccountEntityService.findByIdWithControl(moneyActivityDtoIn.getAccAccountId());

        BigDecimal newBalance = accAccount.getCurrentBalance().add(moneyActivityDtoIn.getAmount());

        AccAccountActivity accAccountActivity = createAccAccountActivity(moneyActivityDtoIn, accAccount, newBalance);

        return accAccountActivity;
    }

    private BigDecimal calculateAndValidateNewBalanceForMoneyOut(BigDecimal amount, AccAccount accAccount) {
        BigDecimal newBalance = accAccount.getCurrentBalance().subtract(amount);
        return newBalance;
    }

    private void updateCurrentBalance(AccAccount accAccount, BigDecimal newBalance) {
        accAccount.setCurrentBalance(newBalance);
        accAccountEntityService.save(accAccount);
    }

    private AccAccountActivity createAccAccountActivity(
            AccMoneyActivityDto accAccountActivityDto,
            AccAccount accAccount,
            BigDecimal newBalance
    ) {
        AccAccountActivity accAccountActivity = new AccAccountActivity();
        accAccountActivity.setAccountActivityType(accAccountActivityDto.getAccountActivityType());
        accAccountActivity.setAccAccount(accAccount);
        accAccountActivity.setAmount(accAccountActivityDto.getAmount());
        accAccountActivity.setTransactionDate(new Date());
        accAccountActivity.setCurrentBalance(newBalance);
        accAccountActivity = accAccountActivityEntityService.save(accAccountActivity);
        return accAccountActivity;
    }

    private void validateBalance(BigDecimal newBalance) {
        if(newBalance.compareTo(BigDecimal.ZERO) < 0 ){
            throw new RuntimeException("Insufficient balance!");
        }
    }


    private void validateMoneyActivityParameters(AccMoneyActivityDto moneyActivityDtoOut) {
        if(moneyActivityDtoOut == null){
            throw new RuntimeException("Parameter can not be null");
        }
    }

}
