package com.fehmi.mobileaction.mobileactionbootcamp.acc.controller;

import com.fehmi.mobileaction.mobileactionbootcamp.acc.dao.AccMoneyActivityDto;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.dto.*;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.service.AccAccountActivityService;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.service.AccAccountService;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.service.AccMoneytransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccAccountController {

    private final AccAccountService accAccountService;
    private final AccMoneytransferService accMoneytransferService;

    private  final AccAccountActivityService accAccountActivityService;

    @GetMapping
    public ResponseEntity findAll(Optional<Integer> pageOptional, Optional<Integer> sizeOptional){
        List<AccAccountDto> accAccountDtoList = accAccountService.findAll(pageOptional, sizeOptional);

        return  ResponseEntity.ok(accAccountDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        AccAccountDto accAccountDto = accAccountService.findById(id);
        return ResponseEntity.ok(accAccountDto);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody AccAccountSaveRequestDto accAccountSaveRequestDto){
        AccAccountDto accAccountDto = accAccountService.save(accAccountSaveRequestDto);

        return new ResponseEntity(accAccountDto, HttpStatus.CREATED);
    }

    @PatchMapping("/cancel/{id}")
    public ResponseEntity cancel(@PathVariable Long id){
        accAccountService.cancel(id);
        return ResponseEntity.ok().build();
    }


    @PostMapping("/money-transfer")
    public ResponseEntity transferMoney(@RequestBody AccMoneyTransferSaveRequestDto accMoneyTransferSaveRequestDto){
        AccMoneyTransferDto accMoneyTransferDto = accMoneytransferService.transferMoney(accMoneyTransferSaveRequestDto);

        return  ResponseEntity.ok(accMoneyTransferDto);
    }

    @PostMapping("/withdraw")
    public ResponseEntity withdraw(@RequestBody AccMoneyActivityRequestDto accMoneyActivityRequestDto){

        AccMoneyActivityDto accMoneyActivityDto = accAccountActivityService.withdraw(accMoneyActivityRequestDto);
        return ResponseEntity.ok(accMoneyActivityDto);
    }

}
