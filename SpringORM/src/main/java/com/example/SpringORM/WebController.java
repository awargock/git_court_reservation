package com.example.SpringORM;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class WebController {
    @Autowired
    private CourtReservationRepo courtReservationRepo;

    @GetMapping("/reservations")
    public List<CourtReservation> getAllReservations() {
        return courtReservationRepo.findAll();
    }

    @GetMapping("/reservations/{id}")
    public ResponseEntity<CourtReservation> getReservationeById(@PathVariable(value = "id") Long crId)
      throws ResourceNotFoundException {
    	CourtReservation cr = courtReservationRepo.findById(crId)
           .orElseThrow(() -> new ResourceNotFoundException("Court reservation not found for this id :: " + crId));
        return ResponseEntity.ok().body(cr);
    }

    @PostMapping("/reservations")
    public CourtReservation createEmployee(@Valid @RequestBody CourtReservation cr) {
        return courtReservationRepo.save(cr);
    }

    @PutMapping("/reservations/{id}")
    public ResponseEntity<CourtReservation> updateEmployee(@PathVariable(value = "id") Long crId,
      @Valid @RequestBody CourtReservation crDetails) throws ResourceNotFoundException {
    	CourtReservation cr = courtReservationRepo.findById(crId)
           .orElseThrow(() -> new ResourceNotFoundException("Court reservation not found for this id :: " + crId));

        cr.setTermin(crDetails.getTermin());
        cr.setNr_kortu(crDetails.getNr_kortu());
        final CourtReservation updatedCourtReservation = courtReservationRepo.save(cr);
        return ResponseEntity.ok(updatedCourtReservation);
    }

    @DeleteMapping("/reservations/{id}")
    public Map<String, Boolean> deleteCourtReservation(@PathVariable(value = "id") Long crId)
      throws ResourceNotFoundException {
    	CourtReservation cr = courtReservationRepo.findById(crId)
          .orElseThrow(() -> new ResourceNotFoundException("Court reservation not found for this id :: " + crId));

    	courtReservationRepo.delete(cr);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}


