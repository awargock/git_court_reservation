package com.example.SpringORM;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
/*
public interface CourtReservationRepo extends CrudRepository< CourtReservation, Long>{
	//List< CourtReservation> findByNumber(int nr_kortu);
	CourtReservation findById(long id);
}
*/
public interface CourtReservationRepo extends JpaRepository<CourtReservation, Long>{

}