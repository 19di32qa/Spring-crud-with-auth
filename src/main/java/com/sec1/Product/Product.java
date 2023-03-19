package com.sec1.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    private Integer id;
    private String name;
    private Integer gty;
    private Integer price;
}
