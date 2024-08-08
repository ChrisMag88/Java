package com.boot.bookingrestaurantapi.services;

import java.util.List;

import com.boot.bookingrestaurantapi.exceptions.BookingException;
import com.boot.bookingrestaurantapi.jsons.CreateSerpApiRest;
import com.boot.bookingrestaurantapi.jsons.SerpApiRest;

public interface SerpApiService {
	
	SerpApiRest getResultById(Long id) throws BookingException;
	
	public List<SerpApiRest> getResults() throws BookingException;
	
	String saveResult(CreateSerpApiRest CreateSerpApiRest) throws BookingException;

}
