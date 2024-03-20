package org.example.fb_api.controllers;

import org.example.fb_api.models.*;
import org.example.fb_api.services.FacebookApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class FacebookApiController {

    private final FacebookApiService facebookApiService;

    @Autowired
    public FacebookApiController(FacebookApiService facebookApiService) {
        this.facebookApiService = facebookApiService;
    }

//url  localhost:8080/postData
    @PostMapping("/postData")
    public ResponseEntity<String> postData(
            @RequestParam String carrierId,
            @RequestParam String timestamp,
            @RequestParam String secret,
            @RequestParam String access_token,
            @RequestBody FacebookApiRequestBody requestBody
    ) {
        return facebookApiService.postData(carrierId, timestamp, secret, access_token, requestBody);
    }


}

