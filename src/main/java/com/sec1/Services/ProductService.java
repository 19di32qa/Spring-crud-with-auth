package com.sec1.Services;

import com.sec1.Product.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductService {
    List<Product> products = null;

    @PostConstruct
    public void loadProductFromDb() {
        products = IntStream.rangeClosed(1,100).mapToObj(i ->Product.builder().id(i).name("product" + i)
                .gty(new Random().nextInt(10)).price(new Random().nextInt(500)).build())
                .collect(Collectors.toList());
    }
    public List<Product> getProducts() {
        return products;
    }
    public Product getProductById(int id) {
        return products.stream().filter(product -> product.getId()==id).findAny()
                .orElseThrow(()->new RuntimeException("product "+id+" not found"));
    }
}
