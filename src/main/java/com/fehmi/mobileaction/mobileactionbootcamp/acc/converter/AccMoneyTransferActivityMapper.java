package com.fehmi.mobileaction.mobileactionbootcamp.acc.converter;

import com.fehmi.mobileaction.mobileactionbootcamp.acc.dao.AccMoneyActivityDto;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.entity.AccAccountActivity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccMoneyTransferActivityMapper {
    AccMoneyTransferActivityMapper INSTANCE =
            Mappers.getMapper(AccMoneyTransferActivityMapper.class);

    @Mapping(target = "accAccountId", source = "accAccount.id")
    AccMoneyActivityDto convertToAccMoneyActivityDto(AccAccountActivity accAccountActivity);

}
