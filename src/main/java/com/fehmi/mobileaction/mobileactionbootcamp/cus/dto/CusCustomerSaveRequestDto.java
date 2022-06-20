package com.fehmi.mobileaction.mobileactionbootcamp.cus.dto;


import lombok.Data;

import javax.persistence.Column;

@Data
public class CusCustomerSaveRequestDto {

    private String name;
    private String surname;
    private Long identityNo;
    private String password;

}
