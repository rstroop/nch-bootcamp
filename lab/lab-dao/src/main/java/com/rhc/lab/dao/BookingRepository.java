package com.rhc.lab.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.rhc.lab.domain.BookingRequest;

@Repository
public interface BookingRepository
		extends
			PagingAndSortingRepository<BookingRequest, String> {

}
