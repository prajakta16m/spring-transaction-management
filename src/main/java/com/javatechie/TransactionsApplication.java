package com.javatechie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.dto.BookingAcknowledgment;
import com.javatechie.dto.FlightBookingRequest;
import com.javatechie.service.FlightBookingService;

@SpringBootApplication
@RestController
@EnableTransactionManagement
public class TransactionsApplication {

	@Autowired
	private FlightBookingService flightBookingService;

	@PostMapping("/bookFlightTicket")
	public BookingAcknowledgment bookFlight(@RequestBody FlightBookingRequest request) {
		return flightBookingService.bookFlightTicket(request);
	}

	public static void main(String[] args) {
		SpringApplication.run(TransactionsApplication.class, args);
	}

}
