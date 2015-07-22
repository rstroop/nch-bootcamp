Feature: Book Artists at Venues
		Requests should have a valid opening time and closing time
		Venues should not allow two bookings in the same time slot
		Venues should not allow a booking with a performance it cannot accomodate
		
	# XXX-Instructions
	Scenario: Deny a Band to play with no opening time or closing time specified
		Given a venue "The Cellar" with an occupancy of "200"
		And the venue accomodates performances by a "Comic", "Band"
		And a request for a "Comic" performance by "Aziz Ansari"
		When validating the booking
		Then the booking should be "REVOKED"
		
	Scenario: Deny a Band to play an overlapping timeslot
		Given a venue "The Cellar" with an occupancy of "200"
		And the venue accomodates performances by a "Band", "Orchestra"
		And an existing "Band" performance by "The Clash" from "01-01-2016 01:00:00" to "01-01-2016 02:00:00"
		And a dated request for a "Orchestra" performance by "The Brooklyn Symphony Orchestra" from "01-01-2016 01:30:00" to "01-01-2016 02:30:00"
		When validating the booking
		Then the booking should be "REVOKED"
	
	Scenario: Allow a Band to play an open timeslot
		Given a venue "The Cellar" with an occupancy of "200"
		And the venue accomodates performances by a "Band", "Orchestra"
		And an existing "Band" performance by "The Clash" from "01-01-2016 01:00:00" to "01-01-2016 02:00:00"
		And a dated request for a "Orchestra" performance by "The Brooklyn Symphony Orchestra" from "01-01-2016 02:00:00" to "01-01-2016 03:00:00"
		When validating the booking
		Then the booking should be "CONFIRMED"
	
	Scenario: Allow a Band to play a small venue
		Given a venue "The Cellar" with an occupancy of "200"
		And the venue accomodates performances by a "Band", "Comic"
		And a dated request for a "Band" performance by "The Clash" from "01-01-2016 02:00:00" to "01-01-2016 03:00:00"
		When validating the booking
		Then the booking should be "CONFIRMED"
		
	Scenario: Deny an Orchestra to play a small venue
		Given a venue "The Cellar" with an occupancy of "200"
		And the venue accomodates performances by a "Band", "Comic"
		And a dated request for a "Orchestra" performance by "The Brooklyn Symphony Orchestra" from "01-01-2016 02:00:00" to "01-01-2016 03:00:00"
		When validating the booking
		Then the booking should be "REVOKED"
