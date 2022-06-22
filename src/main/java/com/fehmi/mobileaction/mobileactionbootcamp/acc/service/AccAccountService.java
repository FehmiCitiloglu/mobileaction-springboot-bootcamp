package com.fehmi.mobileaction.mobileactionbootcamp.acc.service;

import com.fehmi.mobileaction.mobileactionbootcamp.acc.converter.AccAccountMapper;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.dto.AccAccountDto;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.dto.AccAccountSaveRequestDto;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.entity.AccAccount;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.service.entityservice.AccAccountEntityService;
import com.fehmi.mobileaction.mobileactionbootcamp.cus.entity.CusCustomer;
import com.fehmi.mobileaction.mobileactionbootcamp.cus.service.entityservice.CusCustomerEntityService;
import com.fehmi.mobileaction.mobileactionbootcamp.gen.enums.EnumGenStatus;
import com.fehmi.mobileaction.mobileactionbootcamp.gen.util.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccAccountService {

    private final AccAccountEntityService accAccountEntityService;
    private final CusCustomerEntityService cusCustomerEntityService; // TODO: remove

    public List<AccAccountDto> findAll(){
        List<AccAccount> accAccountList = accAccountEntityService.findAll();
        List<AccAccountDto> accAccountDtoList = AccAccountMapper.INSTANCE.convertToAccAccountDtoList(accAccountList);
        return accAccountDtoList;
    }

    public List<AccAccountDto> findAll(Optional<Integer> pageOptional, Optional<Integer> sizeOptional) {

        List<AccAccount> accAccountList = accAccountEntityService.findAll(pageOptional, sizeOptional);
        List<AccAccountDto> accAccountDtoList = AccAccountMapper.INSTANCE.convertToAccAccountDtoList(accAccountList);
        return accAccountDtoList;
    }

    public AccAccountDto findById(Long id) {
        AccAccount accAccount = accAccountEntityService.findByIdWithControl(id);

        AccAccountDto accAccountDto = AccAccountMapper.INSTANCE.convertToAccAccountDto(accAccount);

        return accAccountDto;
    }

    public AccAccountDto save(AccAccountSaveRequestDto accAccountSaveRequestDto) {
        CusCustomer cusCustomer = cusCustomerEntityService.findByIdWithControl(accAccountSaveRequestDto.getCusCustomerId());

        String ibanNo = getIbanNo();

        AccAccount accAccount = AccAccountMapper.INSTANCE.convertToAccAccount(accAccountSaveRequestDto);

        accAccount.setCusCustomer(cusCustomer);
        accAccount.setIbanNo(ibanNo);
        accAccount.setStatus(EnumGenStatus.ACTIVE);
        accAccount = accAccountEntityService.save(accAccount);
        AccAccountDto accAccountDto = AccAccountMapper.INSTANCE.convertToAccAccountDto(accAccount);

        return accAccountDto;
    }

    public void cancel(Long id) {

        AccAccount accAccount = accAccountEntityService.findByIdWithControl(id);

        accAccount.setStatus(EnumGenStatus.PASSIVE);
        accAccount.setCancelDate(new Date());

        accAccountEntityService.save(accAccount);
    }

    private String getIbanNo(){
        String ibanNo = StringUtil.getRandomNumberAsString(26);
        return ibanNo;
    }
}
