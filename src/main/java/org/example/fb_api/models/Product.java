package org.example.fb_api.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Product {
    private String product_code;
    private float product_price;

    private String product_currency;

}
