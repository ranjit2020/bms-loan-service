package com.bms.loanservice.service.impl;

import com.bms.loanservice.entity.CustomerAuthResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Component
public class RestTemplateService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public CustomerAuthResponse checkUserAuthorization(String authKey,String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        HttpEntity<String> request = new HttpEntity<String>(headers);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("key",authKey);

        ResponseEntity<Object> ob = restTemplate.exchange(builder.buildAndExpand(url).toUri(),
                HttpMethod.GET,
                request,
                new ParameterizedTypeReference<Object>() {
                });

        Map<String,String>  map = objectMapper.convertValue(ob,Map.class);

        if(map.isEmpty()){
            throw new IllegalStateException("Un-authorized Access");
        }
        CustomerAuthResponse customerAuthResponse = new CustomerAuthResponse();

        customerAuthResponse.setCustomerId(Long.parseLong(map.get("customerId").toString()));

        return customerAuthResponse;
    }


}
