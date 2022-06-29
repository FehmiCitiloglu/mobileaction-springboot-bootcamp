package com.fehmi.mobileaction.mobileactionbootcamp.cus.converter;

import com.fehmi.mobileaction.mobileactionbootcamp.cus.dto.CusCustomerDto;
import com.fehmi.mobileaction.mobileactionbootcamp.cus.dto.CusCustomerSaveRequestDto;
import com.fehmi.mobileaction.mobileactionbootcamp.cus.entity.CusCustomer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CusCustomerConverter {

    public CusCustomer convertToCustomer(CusCustomerSaveRequestDto cusCustomerSaveRequestDto){

        CusCustomer cusCustomer = new CusCustomer();

        cusCustomer.setName(cusCustomerSaveRequestDto.getName());
        cusCustomer.setSurname(cusCustomerSaveRequestDto.getSurname());
        cusCustomer.setIdentityNo(cusCustomerSaveRequestDto.getIdentityNo());
        cusCustomer.setPassword(cusCustomerSaveRequestDto.getPassword());

        return cusCustomer;
    }

    public List<CusCustomerDto> convertToCusCustomerDtoList(List<CusCustomer> cusCustomerList){
        List<CusCustomerDto> cusCustomerDtoList = new ArrayList<>();
        for (CusCustomer cusCustomer : cusCustomerList) {
            CusCustomerDto cusCustomerDto = covertToCustomerDto(cusCustomer);
            cusCustomerDtoList.add(cusCustomerDto);

        }
        return cusCustomerDtoList;
    }
    
    public CusCustomerDto covertToCustomerDto(CusCustomer cusCustomer){
        CusCustomerDto cusCustomerDto = new CusCustomerDto();
        cusCustomerDto.setId(cusCustomer.getId());
        cusCustomerDto.setName(cusCustomer.getName());
        cusCustomerDto.setSurname(cusCustomer.getSurname());
        cusCustomerDto.setIdentityNo(cusCustomer.getIdentityNo());

        return cusCustomerDto;
    }


}
