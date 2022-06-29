package com.fehmi.mobileaction.mobileactionbootcamp.cus.service;

import com.fehmi.mobileaction.mobileactionbootcamp.cus.converter.CusCustomerConverter;
import com.fehmi.mobileaction.mobileactionbootcamp.cus.converter.CusCustomerMapper;
import com.fehmi.mobileaction.mobileactionbootcamp.cus.dto.CusCustomerDto;
import com.fehmi.mobileaction.mobileactionbootcamp.cus.dto.CusCustomerSaveRequestDto;
import com.fehmi.mobileaction.mobileactionbootcamp.cus.dto.CusCustomerUpdateRequestDto;
import com.fehmi.mobileaction.mobileactionbootcamp.cus.entity.CusCustomer;
import com.fehmi.mobileaction.mobileactionbootcamp.cus.service.entityservice.CusCustomerEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CusCustomerService {

    private final CusCustomerEntityService cusCustomerEntityService;


    public List<CusCustomerDto> findAll() {
        List<CusCustomer> cusCustomerList = cusCustomerEntityService.findAll();

        List<CusCustomerDto> cusCustomerDtoList = CusCustomerMapper.INSTANCE.convertToCusCustomerDtoList(cusCustomerList);

        return cusCustomerDtoList;
    }

    public CusCustomerDto save(CusCustomerSaveRequestDto cusCustomerSaveRequestDto) {


        CusCustomer cusCustomer = CusCustomerMapper.INSTANCE.convertToCusCustomer(cusCustomerSaveRequestDto);

        cusCustomer = cusCustomerEntityService.save(cusCustomer);
        CusCustomerDto cusCustomerDto = CusCustomerMapper.INSTANCE.covertToCustomerDto(cusCustomer);

        return cusCustomerDto;
    }

    public CusCustomerDto findById(Long id) {
        CusCustomer cusCustomer = cusCustomerEntityService.findById(id).orElseThrow();
        CusCustomerDto cusCustomerDto = CusCustomerMapper.INSTANCE.covertToCustomerDto(cusCustomer);

        return cusCustomerDto;
    }

    public void delete(Long id) {
        CusCustomer cusCustomer = cusCustomerEntityService.findById(id).orElseThrow();
        cusCustomerEntityService.delete(cusCustomer);
    }

    public CusCustomerDto update(CusCustomerUpdateRequestDto cusCustomerUpdateRequestDto) {
        Long id = cusCustomerUpdateRequestDto.getId();

        boolean isExists = cusCustomerEntityService.existsById(id);

        if(!isExists){
            throw new RuntimeException("Customer does not exists with given id: " + id);
        }
        CusCustomer cusCustomer = CusCustomerMapper.INSTANCE.convertToCusCustomer(cusCustomerUpdateRequestDto);

        cusCustomer = cusCustomerEntityService.save(cusCustomer);

        CusCustomerDto cusCustomerDto = CusCustomerMapper.INSTANCE.covertToCustomerDto(cusCustomer);

        return cusCustomerDto;
    }
}
