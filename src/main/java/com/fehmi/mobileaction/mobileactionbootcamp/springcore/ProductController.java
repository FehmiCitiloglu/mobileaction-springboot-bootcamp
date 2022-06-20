package com.fehmi.mobileaction.mobileactionbootcamp.springcore;



import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductDao productDao;


    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct() {
        List<Product> productList = productDao.findAll();
        return ResponseEntity.ok(productList);
    }



    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        Product product = productDao.findById(id).orElseThrow();

        return ResponseEntity.ok(product);
    }


    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        product = productDao.save(product);

        return new ResponseEntity(product, HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        product = productDao.save(product);
        if(product.getId() == null){
            throw new RuntimeException("Product id can not be empty!");
        }
        boolean isExist = productDao.existsById(product.getId());
        if(!isExist){
            throw new RuntimeException("Product does not exists!");
        }
        product = productDao.save(product);
        return ResponseEntity.ok(product);

    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        productDao.deleteById(id);
    }


    @PatchMapping("/passive/{id}")
    public ResponseEntity makePassive(@PathVariable Long id){
        Product product = productDao.findById(id).orElseThrow();
        product.setIsActive(Boolean.FALSE);
        productDao.save(product);
        return ResponseEntity.ok(product);
    }
}
