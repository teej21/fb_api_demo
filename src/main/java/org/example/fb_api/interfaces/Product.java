package org.example.fb_api.interfaces;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class Product {
    private String product_code;
    private float product_price;

    private String product_currency;

}
