package com.sec1.Controllers;

import com.sec1.Product.Product;
import com.sec1.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/home")
    public String getHome() {
        return "Hello dashboard";
    }

    @GetMapping(value = "/products")
    @PreAuthorize("hasAuthority('ROLE_admin')")
    public List<Product> getProducts() {
        return service.getProducts();
    }
    @GetMapping("/products/{id}")
    @PreAuthorize("hasAuthority('ROLE_user')")
    public Product getProductById(@PathVariable int id) {
        return service.getProductById(id);
    }
}
