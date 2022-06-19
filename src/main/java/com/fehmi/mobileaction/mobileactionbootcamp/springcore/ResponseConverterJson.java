package com.fehmi.mobileaction.mobileactionbootcamp.springcore;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("json")
public class ResponseConverterJson implements ResponseConverter {
    @Override
    public void convert() {
        System.out.println("JSON");
    }
}
