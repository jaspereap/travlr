package com.nus.iss.travlr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nus.iss.travlr.models.Costing;
import com.nus.iss.travlr.models.Day;
import com.nus.iss.travlr.models.Flight;
import com.nus.iss.travlr.models.Itinerary;
import com.nus.iss.travlr.models.Lodging;
import com.nus.iss.travlr.models.Place;
import com.nus.iss.travlr.models.Trip;
import com.nus.iss.travlr.repository.TripRepository;
import com.nus.iss.travlr.repository.UserRepository;
import com.nus.iss.travlr.service.TripService;
import com.nus.iss.travlr.service.UserService;

@SpringBootApplication
public class TravlrApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TravlrApplication.class, args);
	}
	@Autowired UserRepository userRepo;
	@Autowired UserService userService;
	@Autowired TripRepository tripRepo;
	@Autowired TripService tripSvc;

	@Override
	public void run(String... args) throws Exception {
		// UserEntity user = new UserEntity();
		// user.setUsername("lmfao");
		// user.setPassword("fugggg");
		// userService.registerUser(user, Role.USER);
		// UserEntity retrievedUser = userRepo.findUserByUsername("lmfao").get();
		// System.out.println(retrievedUser.getRoles());
		// UserEntity retrievedUser = userRepo.findUserById(1).get();
		// System.out.println(retrievedUser);

		Trip trip = createTrip();
		tripRepo.save(trip);
		// tripSvc.addTripMate("1", 33L);
		// Optional<Trip> optTrip = tripRepo.findById("1");
		// System.out.println("\tTrip: \n" + optTrip.get());
	}
	public List<Lodging> createLodgings() {
		// Creating lodging
		List<Costing> costings = new ArrayList<>();
		costings.add(new Costing(200.0f, "SGD"));
		Lodging lodging = new Lodging("Hotel Paris", 
			"Nice view of the Eiffel Tower", 
			new Date(), 
			new Date(),
			costings,
			"lodging address 1",
			new Float[]{1.3f, 103.2f}
			);

		return Arrays.asList(lodging);
	}

	public Itinerary createItinerary() {
		// Creating a place
		List<Costing> costings = new ArrayList<>();
		costings.add(new Costing(100f, "SGD"));
		Place place = new Place(1, 
			"Eiffel Tower", 
			"image_url", 
			"A must-see landmark in Paris", 
			new Date(), 
			new Date(),
			costings,
			"Champ de Mars, 5 Avenue Anatole France, 75007 Paris, France",
			new Float[]{1.3f, 103.5f});
		
		// Creating a day
		Day day = new Day(new Date(), Arrays.asList(place));
		
		// Creating an itinerary
		Set<Long> tripMatesId = new HashSet<>();
		tripMatesId.add(5L);
		Itinerary itinerary = new Itinerary("1", Arrays.asList(day));
		
		return itinerary;
	}

	public List<Flight> createFlightData() {
		List<Flight> flights = new ArrayList<>();
		List<Costing> costings1 = new ArrayList<>();
		costings1.add(new Costing(1200.50f, "SGD"));
		Flight flight1 = new Flight(
			"Airline One",
			"FL123",
			"USA",
			"France",
			new Date(), // Assume this is the departure date
			new Date(), // Assume this is the arrival date
			"Notes about flight 1",
			"image-url-1",
			costings1
		);
		List<Costing> costings2 = new ArrayList<>();
		costings2.add(new Costing(800.75f, "SGD"));
		Flight flight2 = new Flight(
			"Airline Two",
			"FL456",
			"France",
			"Italy",
			new Date(), // Adjust these dates as necessary
			new Date(),
			"Notes about flight 2",
			"image-url-2",
			costings2
		);
		flights.add(flight1);
		flights.add(flight2);
		return flights;
	}
	public Trip createTrip() {
		Trip trip = new Trip(
			"1",
			"Italy",
			new Date(), // Start date of the trip
			new Date(), // End date of the trip
			4L,
			new HashSet<>(Arrays.asList(1L, 2L)), // Example user IDs of trip mates
			createFlightData(),
			createLodgings(),
			createItinerary(),
			"image url here"
		);
		return trip;
	}
}
