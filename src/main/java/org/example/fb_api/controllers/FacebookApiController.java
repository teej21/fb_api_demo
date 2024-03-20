package org.example.fb_api.controllers;

import org.example.fb_api.interfaces.*;
import org.example.fb_api.services.FacebookApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/intern/fb_api")
public class FacebookApiController {

    private final FacebookApiService facebookApiService;

    @Autowired
    public FacebookApiController(FacebookApiService facebookApiService) {
        this.facebookApiService = facebookApiService;
    }


    @PostMapping("/postData")
    public String postData(
            @RequestParam String carrierId,
            @RequestParam String timestamp,
            @RequestParam String secret,
            @RequestParam String access_token,
            @RequestBody FacebookApiRequestBody requestBody
    ) {
        return facebookApiService.postData(carrierId, timestamp, secret, access_token, requestBody);
    }


}

