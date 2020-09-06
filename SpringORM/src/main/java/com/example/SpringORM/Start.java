package com.example.SpringORM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Start {
	
	private ClientRepo clientRepo;
	private CourtReservationRepo courtReservationRepo;
	private CourtRepo courtRepo;
	
	@Autowired
	public Start(ClientRepo clientRepo, CourtReservationRepo courtReservationRepo, CourtRepo courtRepo){
		this.clientRepo = clientRepo;
		this.courtReservationRepo = courtReservationRepo;
		this.courtRepo = courtRepo;
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void runExample(){
		Client client = new Client("Piotr", "Piter", "P123", 500600700);
		clientRepo.save(client);	
		CourtReservation courtReservation = new CourtReservation("20.09.2020", 1);
		courtReservationRepo.save(courtReservation);	
		Court court = new Court(1, "twarda");
		courtRepo.save(court);
	}	

}












