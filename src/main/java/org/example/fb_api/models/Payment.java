package org.example.fb_api.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Payment {
    private Enum.PaymentType payment_type;
    private String payment_provider_name;


}
