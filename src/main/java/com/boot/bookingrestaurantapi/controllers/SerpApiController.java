package com.boot.bookingrestaurantapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/serpapi/v1")
public class SerpApiController {

    private static final String SERPAPI_URL = "https://serpapi.com/search.json";

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getSerpData(
    		@RequestParam(value = "q", required = true) String query,
    		@RequestParam(value = "api_key", required = true) String api_key) {
    	
        String googleDomain = "google_scholar";
        String apiKey = api_key; 
        
        String url = SERPAPI_URL + "?engine=" + googleDomain + "&q=" + query + "&api_key=" + apiKey;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        return response.getBody();
    }
}