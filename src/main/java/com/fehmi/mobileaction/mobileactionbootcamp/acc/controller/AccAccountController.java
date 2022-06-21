package com.fehmi.mobileaction.mobileactionbootcamp.acc.controller;

import com.fehmi.mobileaction.mobileactionbootcamp.acc.dto.AccAccountDto;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.service.AccAccountService;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.service.entityservice.AccAccountEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v2/accounts")
@RequiredArgsConstructor
public class AccAccountController {

    private final AccAccountService accAccountService;

    public ResponseEntity findAll(Optional<Integer> pageOptional, Optional<Integer> sizeOptional){
        List<AccAccountDto> accAccountDtoList = accAccountService.findAll(pageOptional, sizeOptional);

        return  ResponseEntity.ok(accAccountDtoList);
    }

}
