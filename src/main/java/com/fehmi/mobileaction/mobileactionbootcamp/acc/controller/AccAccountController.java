package com.fehmi.mobileaction.mobileactionbootcamp.acc.controller;

import com.fehmi.mobileaction.mobileactionbootcamp.acc.dto.AccAccountDto;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.dto.AccAccountSaveRequestDto;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.service.AccAccountService;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.service.entityservice.AccAccountEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v2/accounts")
@RequiredArgsConstructor
public class AccAccountController {

    private final AccAccountService accAccountService;

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

}
