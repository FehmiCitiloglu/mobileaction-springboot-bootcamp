package com.fehmi.mobileaction.mobileactionbootcamp.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class WebService {

    @Autowired
    private ResponseConverter responseConverterXml;



    public void converterResponse(){
        responseConverterXml.convert();
    }

}
