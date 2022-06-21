package com.fehmi.mobileaction.mobileactionbootcamp.acc.service;

import com.fehmi.mobileaction.mobileactionbootcamp.acc.dto.AccAccountDto;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.entity.AccAccount;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.service.entityservice.AccAccountEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccAccountService {

    private final AccAccountEntityService accAccountEntityService;

    public List<AccAccountDto> findAll(){
        List<AccAccount> accAccountList = accAccountEntityService.findAll();
        return null;
    }

    public List<AccAccountDto> findAll(Optional<Integer> pageOptional, Optional<Integer> sizeOptional) {

        List<AccAccount> accAccountList = accAccountEntityService.findAll(pageOptional, sizeOptional);
        return null;
    }
}
