package com.fehmi.mobileaction.mobileactionbootcamp.springcore;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/{id}")
    public TestResponse test(@PathVariable(required = false) Long id) {
        System.out.println("Test");
        TestResponse testResponse = TestResponse.builder()
                .id(1L)
                .data("Get data from db")
                .isSuccess(true)
                .build();

        return testResponse;
    }

    @GetMapping("/test2")
    public TestResponse test2(@RequestParam(defaultValue = "999") Long id) {
        System.out.println("Test");


//        Long idL = null;
//        if(id.isPresent()){
//            idL = id.get();
//        }

        TestResponse testResponse = TestResponse.builder()
                .id(id)
                .data("Get data from db")
                .isSuccess(true)
                .build();

        return testResponse;
    }

    @PostMapping
    public String save(){
        System.out.println("Test");
        return "poost";
    }

}
