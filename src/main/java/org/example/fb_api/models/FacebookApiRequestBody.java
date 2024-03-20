package org.example.fb_api.models;

import lombok.*;


@RequiredArgsConstructor
@Data
public class FacebookApiRequestBody {
    private String tid;
    private String msisdn;

    private Enum.EventType event;

    private Enum.ResultCode result_code;
    private String result_message;
    private Enum.InventoryType inventory_type;

    private Payment payment;

    private Product product;
}