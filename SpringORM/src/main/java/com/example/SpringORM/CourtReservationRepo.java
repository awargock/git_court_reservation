package com.example.SpringORM;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourtReservationRepo extends CrudRepository< CourtReservation, Long>{
	//List< CourtReservation> findByNumber(int nr_kortu);
	CourtReservation findById(long id);
}