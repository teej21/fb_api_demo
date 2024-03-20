package org.example.fb_api.interfaces;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Payment {
    private PaymentTypeEnum payment_type;
    private String payment_provider_name;


}
