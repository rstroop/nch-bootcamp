package com.rhc.lab.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.rhc.lab.domain.BookingRequest;

/**
 * 
 * This interface extends the Spring-Data-MongoDB interface, exposing base
 * MongoDB operations and additional field level queries for the bookings
 * collection
 * 
 */
@Repository
public interface BookingRepository
		extends
			PagingAndSortingRepository<BookingRequest, String> {

}
