package org.example.fb_api.services;

import org.example.fb_api.interfaces.FacebookApiRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;


@Service
public class FacebookApiService {

    private final RestTemplate restTemplate;


    @Value("${fb_api.endpoint}")
    private String apiEndpoint;


    @Autowired
    public FacebookApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    private String generateHmacSHA256(String timestamp, String carrier_id, String secret) {
        try {
            String data = timestamp + carrier_id;
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            byte[] hash = sha256_HMAC.doFinal(data.getBytes());
            StringBuilder result = new StringBuilder();
            for (byte b : hash) {
                result.append(String.format("%02x", b));
            }
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


    public String postData(String carrierId, String timestamp, String secret, String accessToken, FacebookApiRequestBody requestBody) {
        try {
            String hmac = generateHmacSHA256(timestamp, carrierId, secret);
            String url = UriComponentsBuilder.fromHttpUrl(apiEndpoint)
                    .queryParam("timestamp", timestamp)
                    .queryParam("carrier_id", carrierId)
                    .queryParam("hmac", hmac)
                    .queryParam("access_token", accessToken)
                    .toUriString();
            System.out.println(url);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<FacebookApiRequestBody> request = new HttpEntity<>(requestBody);
            ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
            return response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
