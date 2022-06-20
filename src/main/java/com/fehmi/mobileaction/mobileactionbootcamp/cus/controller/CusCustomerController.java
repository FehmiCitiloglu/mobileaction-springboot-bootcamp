package com.fehmi.mobileaction.mobileactionbootcamp.cus.controller;

import com.fehmi.mobileaction.mobileactionbootcamp.cus.dto.CusCustomerDto;
import com.fehmi.mobileaction.mobileactionbootcamp.cus.dto.CusCustomerSaveRequestDto;
import com.fehmi.mobileaction.mobileactionbootcamp.cus.dto.CusCustomerUpdateRequestDto;
import com.fehmi.mobileaction.mobileactionbootcamp.cus.service.CusCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CusCustomerController {

    private CusCustomerService cusCustomerService;

    @GetMapping
    public ResponseEntity<List<CusCustomerDto>> findAll(){
        List<CusCustomerDto> cusCustomerDtoList = cusCustomerService.findAll();

        return ResponseEntity.ok(cusCustomerDtoList);
    }

    @PostMapping
    public ResponseEntity save(
            @RequestBody CusCustomerSaveRequestDto cusCustomerSaveRequestDto
    ){
            CusCustomerDto cusCustomerDto =  cusCustomerService.save(cusCustomerSaveRequestDto);

            return new ResponseEntity(cusCustomerDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id){

       CusCustomerDto cusCustomerDto= cusCustomerService.findById();
       return ResponseEntity.ok(cusCustomerDto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        CusCustomerDto cusCustomerDto = cusCustomerService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping
    public ResponseEntity update(@RequestBody CusCustomerUpdateRequestDto cusCustomerUpdateRequestDto){
        CusCustomerDto cusCustomerDto= cusCustomerService.update(cusCustomerUpdateRequestDto);
        return ResponseEntity.ok(cusCustomerDto);
    }

}
