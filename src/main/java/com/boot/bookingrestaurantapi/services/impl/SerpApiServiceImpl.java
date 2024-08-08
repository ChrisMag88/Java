package com.boot.bookingrestaurantapi.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.bookingrestaurantapi.entities.SerpApi;
import com.boot.bookingrestaurantapi.exceptions.BookingException;
import com.boot.bookingrestaurantapi.exceptions.InternalServerErrorException;
import com.boot.bookingrestaurantapi.exceptions.NotFountException;
import com.boot.bookingrestaurantapi.jsons.CreateSerpApiRest;
import com.boot.bookingrestaurantapi.jsons.SerpApiRest;
import com.boot.bookingrestaurantapi.repositories.SerpApiRepository;
import com.boot.bookingrestaurantapi.services.SerpApiService;

@Service
public class SerpApiServiceImpl implements SerpApiService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SerpApiServiceImpl.class);
	
	@Autowired
	SerpApiRepository serpApiRepository;

	public static final ModelMapper modelMapper = new ModelMapper();
	
	public String saveResult(final CreateSerpApiRest createSerpApiRest) throws BookingException {


		final SerpApi serpApi = new SerpApi();
		serpApi.setTopic(createSerpApiRest.getTopic());
		serpApi.setTotalResults(createSerpApiRest.getTotalResults());
		serpApi.setSearchEngine(createSerpApiRest.getSearchEngine());
		serpApi.setResults(createSerpApiRest.getResults());

		try {
			serpApiRepository.save(serpApi);
		} catch (final Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR", e);
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		return null;
	}

	public SerpApiRest getResultById(Long id) throws BookingException {
		return modelMapper.map(getSerpApiEntity(id), SerpApiRest.class);
	}

	public List<SerpApiRest> getResults() throws BookingException {
		final List<SerpApi> serpApiEntity = serpApiRepository.findAll();
		return serpApiEntity.stream().map(service -> modelMapper.map(service, SerpApiRest.class))
				.collect(Collectors.toList());
	}

	private SerpApi getSerpApiEntity(Long id) throws BookingException {
		return serpApiRepository.findById(id)
				.orElseThrow(() -> new NotFountException("SNOT-404-1", "RESULT_NOT_FOUND"));
	}

}
