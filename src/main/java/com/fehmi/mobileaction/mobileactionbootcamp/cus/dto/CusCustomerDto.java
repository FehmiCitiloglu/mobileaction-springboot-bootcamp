package com.fehmi.mobileaction.mobileactionbootcamp.cus.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class CusCustomerDto {

    private Long id;
    private String name;
    private String surname;
    private Long identityNo;
}
