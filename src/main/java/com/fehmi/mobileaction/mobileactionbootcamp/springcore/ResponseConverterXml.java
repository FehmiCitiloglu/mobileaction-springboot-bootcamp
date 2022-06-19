package com.fehmi.mobileaction.mobileactionbootcamp.springcore;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("xml")
public class ResponseConverterXml implements ResponseConverter {
    @Override
    public void convert() {
        System.out.println("XML");
    }
}
