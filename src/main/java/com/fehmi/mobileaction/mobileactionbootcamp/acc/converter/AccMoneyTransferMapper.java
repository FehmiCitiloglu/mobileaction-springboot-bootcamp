package com.fehmi.mobileaction.mobileactionbootcamp.acc.converter;

import com.fehmi.mobileaction.mobileactionbootcamp.acc.dto.AccMoneyTransferDto;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.dto.AccMoneyTransferSaveRequestDto;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.entity.AccMoneyTransfer;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccMoneyTransferMapper {

    AccMoneyTransferMapper INSTANCE = Mappers.getMapper(AccMoneyTransferMapper.class);

    AccMoneyTransfer convertToAccMoneyTransferDto(AccMoneyTransferSaveRequestDto accMoneyTransferSaveRequestDto);

    @Mapping(target="accAccountIdFrom", source = "accAccountFrom.id")
    @Mapping(target="accAccountIdTo", source = "accAccountTo.id")
    @Mapping(target="cusCustomerIdTo", source = "accAccountTo.cusCustomer.id")
    @Mapping(target="cuCustomerNameTo", source = "accAccountTo.cusCustomer.name")
    @Mapping(target="cusCustomerIdFrom", source = "accAccountFrom.cusCustomer.id")
    @Mapping(target="cuCustomerNameFrom", source = "accAccountFrom.cusCustomer.name")
    AccMoneyTransferDto convertToAccMoneyTransferDto(AccMoneyTransfer accMoneyTransfer);

//    @AfterMapping
//    default void setAccounts(
//            @MappingTarget AccMoneyTransfer accMoneyTransfer,
//            AccMoneyTransferSaveRequestDto accMoneyTransferSaveRequestDto
//    ){
//
//    }
}
