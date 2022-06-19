package com.fehmi.mobileaction.mobileactionbootcamp.springcore;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestResponse {

    private Long id;
    private String data;
    private boolean isSuccess;
}
