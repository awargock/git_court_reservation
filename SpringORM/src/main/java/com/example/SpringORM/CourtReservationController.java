package com.example.SpringORM;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CourtReservationController {
	
	@Autowired
	private CourtReservationRepo courtReservationRepo;
	
	List<CourtReservation> res = new ArrayList<CourtReservation>();
		
	public CourtReservationController(CourtReservationRepo courtReservationRepo) {
		this.courtReservationRepo = courtReservationRepo;
	}

	
	@GetMapping(value="/getallreservations")
	public List<CourtReservation> getReservations() {
		return (List<CourtReservation>) courtReservationRepo.findAll();
	}

	@PostMapping(value="/postreservation")
	String postReservation(@RequestBody CourtReservation cr) {
		courtReservationRepo.save(cr);
		return "Rezerwacja dodana! ";
	}
	/*
	
	List<CourtReservation> rest = new ArrayList<CourtReservation>();
	  
	  @RequestMapping(value = "/getallreservations", method = RequestMethod.GET)
	  public List<CourtReservation> getResource(){
	      return rest;
	  }
	  
	  @RequestMapping(value="/postreservation", method=RequestMethod.POST)
	  public String postCustomer(@RequestBody CourtReservation cr){
	    cust.add(cr);
	    
	    return "Sucessful!";
	  }
	*/
}
