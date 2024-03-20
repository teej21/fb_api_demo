package org.example.fb_api.interfaces;

public class Product {
    private String product_code;
    private float product_price;

    private String product_currency;

    public Product(float product_price, String product_currency) {
        this.product_price = product_price;
        this.product_currency = product_currency;
    }

    public Product(String product_code, float product_price, String product_currency) {
        this.product_code = product_code;
        this.product_price = product_price;
        this.product_currency = product_currency;
    }
}
