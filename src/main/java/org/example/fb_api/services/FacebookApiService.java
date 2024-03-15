package org.example.fb_api.services;

import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.http.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Service
public class FacebookApiService {

    private final RestTemplate restTemplate;
    @Value("${fb_api.endpoint}")
    private String apiEndpoint;

    @Value("${fb_api.access_token}")
    private String accessToken;

    @Value("${fb_api.secrect}")
    private String apiSecret;

    @Value("${fb_api.carrier_id}")
    private String carrierId;

    @Autowired
    public FacebookApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String postData(Map<String, Object> requestBody) {
        String timestamp = getTimestamp();
        String hmac = generateHmacSHA256(timestamp, carrierId);
        String url = UriComponentsBuilder.fromHttpUrl(apiEndpoint)
                .queryParam("carrier_id", carrierId)
                .queryParam("timestamp", timestamp)
                .queryParam("hmac", hmac)
                .queryParam("access_token", accessToken)
                .toUriString();
        return restTemplate.postForObject(url, requestBody, String.class);
    }

    private String generateHmacSHA256(String timestamp, String carrier_id) {

        try {
            String data = timestamp + carrier_id;
            byte[] key = apiSecret.getBytes(StandardCharsets.UTF_8);
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(secretKeySpec);
            byte[] hmacData = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
            return Hex.encodeHexString(hmacData);
        } catch (Exception e) {
            throw new RuntimeException("Failed when generate HMAC", e);
        }
    }

    private String getTimestamp() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

}
