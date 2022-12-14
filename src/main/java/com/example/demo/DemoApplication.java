package com.example.demo;

import com.example.demo.model.Customer;
import com.example.demo.model.Reservation;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//-----Customer list-----
		List<Customer> customers = new ArrayList<>();
		for( int n = 0; n < 200; n++){
			customers.add( new Customer(0, Util.getFakeFullName(), Util.getFakeAddress(), Util.getFakeAge()));
		}
		customerRepository.saveAll( customers);

		//-----Reservation list-----
		List<Reservation> reservations = new ArrayList<>();
		for( int n = 0; n < 200; n++){
			reservations.add( new Reservation(0, Util.getFakeFullName(), Util.getFakeNum(), Util.getFakeNum()));
		}
		reservationRepository.saveAll( reservations);

	}
}
