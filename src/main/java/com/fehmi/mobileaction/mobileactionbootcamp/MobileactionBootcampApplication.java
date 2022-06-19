package com.fehmi.mobileaction.mobileactionbootcamp;

import com.fehmi.mobileaction.mobileactionbootcamp.springcore.ResponseConverterJson;
import com.fehmi.mobileaction.mobileactionbootcamp.springcore.WebService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MobileactionBootcampApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(MobileactionBootcampApplication.class, args);

        WebService webService = applicationContext.getBean(WebService.class);



        webService.converterResponse();
    }

}
