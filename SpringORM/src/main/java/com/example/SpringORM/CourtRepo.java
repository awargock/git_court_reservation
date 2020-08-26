package com.example.SpringORM;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourtRepo extends CrudRepository<Court, Long>{
	//List<Court> findByNumber(int nr_kortu);
	Court findById(long id);
}
