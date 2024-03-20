package org.example.fb_api.interfaces;

import lombok.*;

@RequiredArgsConstructor
@Data
public class FacebookApiRequestBody {
    private String tid;
    private String msisdn;

    private EventTypeEnum event;

    private ResultCodeEnum result_code;
    private String result_message;
    private InventoryTypeEnum inventory_type;

    private Payment payment;

    private Product product;
}