package com.rhc.lab.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.rhc.lab.domain.Venue;

@Repository
public interface VenueRepository
		extends
			PagingAndSortingRepository<Venue, String> {

}
