package com.fehmi.mobileaction.mobileactionbootcamp.acc.converter;

import com.fehmi.mobileaction.mobileactionbootcamp.acc.dto.AccMoneyTransferDto;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.dto.AccMoneyTransferSaveRequestDto;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.entity.AccMoneyTransfer;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccMoneyTransferMapper {

    AccMoneyTransferMapper INSTANCE = Mappers.getMapper(AccMoneyTransferMapper.class);

    AccMoneyTransfer convertToAccMoneyTransferDto(AccMoneyTransferSaveRequestDto accMoneyTransferSaveRequestDto);

    AccMoneyTransferDto convertToAccMoneyTransferDto(AccMoneyTransfer accMoneyTransfer);

//    @AfterMapping
//    default void setAccounts(
//            @MappingTarget AccMoneyTransfer accMoneyTransfer,
//            AccMoneyTransferSaveRequestDto accMoneyTransferSaveRequestDto
//    ){
//
//    }
}
