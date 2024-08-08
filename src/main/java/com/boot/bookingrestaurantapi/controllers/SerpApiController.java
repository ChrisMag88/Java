package com.boot.bookingrestaurantapi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.boot.bookingrestaurantapi.exceptions.BookingException;
import com.boot.bookingrestaurantapi.jsons.CreateSerpApiRest;
import com.boot.bookingrestaurantapi.jsons.SerpApiRest;
import com.boot.bookingrestaurantapi.responses.BookingResponse;
import com.boot.bookingrestaurantapi.services.SerpApiService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/serpapi/v1")
public class SerpApiController {
	
	@Autowired
	SerpApiService serpApiService;

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
    
    @ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/results", produces = MediaType.APPLICATION_JSON_VALUE)
	public BookingResponse<List<SerpApiRest>> getResults() throws BookingException {
		return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK", serpApiService.getResults());
	}

	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public BookingResponse<String> saveResult(@RequestBody @Valid CreateSerpApiRest createSerpApiRest)
			throws BookingException {
		return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				serpApiService.saveResult(createSerpApiRest));
	}
    
    
}