package com.fehmi.mobileaction.mobileactionbootcamp.springcore;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct() {

        List<Product> productList = getProductList();

        return ResponseEntity.ok(productList);
    }

    private List<Product> getProductList() {
        Product product = new Product(
                1L,
                "Product 1",
                new BigDecimal("100.00"),
                true,
                new Date()
        );

        Product product2 = new Product(
                2L,
                "Product 2",
                new BigDecimal("100.00"),
                true,
                new Date()
        );
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        productList.add(product2);
        return productList;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        List<Product> productList = getProductList();

        Product myProduct = productList.stream().filter((product) -> product.getId().equals(id)).findFirst().orElseThrow();

        return ResponseEntity.ok(myProduct);
    }

//    @GetMapping("/test/{id}")
//    public ResponseEntity<Product> getById2(@PathVariable Long id) {
//        List<Product> productList = getProductList();
//
//        Product myProduct = productList.stream().filter((product) -> product.getId().equals(id)).findFirst().orElseThrow();
//
//        return ResponseEntity.ok(myProduct);
//    }


    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        System.out.println(product);
        return ResponseEntity.ok(product);
    }
}
