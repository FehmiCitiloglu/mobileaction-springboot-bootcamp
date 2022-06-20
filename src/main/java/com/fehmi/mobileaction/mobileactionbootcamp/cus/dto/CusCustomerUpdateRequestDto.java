package com.fehmi.mobileaction.mobileactionbootcamp.cus.dto;


import lombok.Data;

@Data
public class CusCustomerUpdateRequestDto {
    private Long id;
    private String name;
    private String surname;
    private Long identityNo;
    private String password;
}
