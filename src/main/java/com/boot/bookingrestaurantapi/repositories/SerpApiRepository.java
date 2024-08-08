package com.boot.bookingrestaurantapi.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.boot.bookingrestaurantapi.entities.SerpApi;

public interface SerpApiRepository extends JpaRepository<SerpApi, Long> {
	
	Optional<SerpApi> findById(Long id);
	
	@Query("SELECT REST FROM SerpApi REST")
	public List<SerpApi> findResults();
}
