package org.example.fb_api.controllers;

import org.example.fb_api.services.FacebookApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/intern/fb_api")
public class FacebookApiController {

    private final FacebookApiService facebookApiService;

    @Autowired
    public FacebookApiController(FacebookApiService facebookApiService) {
        this.facebookApiService = facebookApiService;
    }


    @PostMapping("/postData")
    public String postData(@RequestBody Map<String, Object> requestBody) {
        return facebookApiService.postData(requestBody);
    }

}
