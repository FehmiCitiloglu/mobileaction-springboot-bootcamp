package com.fehmi.mobileaction.mobileactionbootcamp.cus.converter;

import com.fehmi.mobileaction.mobileactionbootcamp.cus.dto.CusCustomerDto;
import com.fehmi.mobileaction.mobileactionbootcamp.cus.dto.CusCustomerSaveRequestDto;
import com.fehmi.mobileaction.mobileactionbootcamp.cus.dto.CusCustomerUpdateRequestDto;
import com.fehmi.mobileaction.mobileactionbootcamp.cus.entity.CusCustomer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CusCustomerMapper {
    CusCustomerMapper INSTANCE = Mappers.getMapper(CusCustomerMapper.class);

    CusCustomer convertToCusCustomer(CusCustomerUpdateRequestDto cusCustomerUpdateRequestDto);

    CusCustomerDto covertToCustomerDto(CusCustomer cusCustomer);

    List<CusCustomerDto> convertToCusCustomerDtoList(List<CusCustomer> cusCustomerList);

    CusCustomer convertToCusCustomer(CusCustomerSaveRequestDto cusCustomerSaveRequestDto);
}
