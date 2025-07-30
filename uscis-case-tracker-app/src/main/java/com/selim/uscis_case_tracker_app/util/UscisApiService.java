package com.selim.uscis_case_tracker_app.util;

import com.selim.uscis_case_tracker_app.dto.CaseStatusResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import java.util.Collections;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UscisApiService {

    private final RestTemplate restTemplate;

    @Value("${uscis.client-id}")
    private String clientId;

    @Value("${uscis.client-secret}")
    private String clientSecret;

    public String getAccessToken() {
        String tokenUrl = "https://api-int.uscis.gov/oauth/accesstoken";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "client_credentials");
        body.add("client_id", clientId);
        body.add("client_secret", clientSecret);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(tokenUrl, request, Map.class);

        return (String) response.getBody().get("access_token");
    }

    public CaseStatusResponse getCaseStatusFromUscis(String receiptNumber) {
        String url = "https://api-int.uscis.gov/case-status/" + receiptNumber;

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(getAccessToken());
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<Void> request = new HttpEntity<>(headers);

        ResponseEntity<CaseStatusResponse> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                CaseStatusResponse.class
        );

        return response.getBody();
    }
}