package com.example.SpringORM;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends CrudRepository<Client, Long>{
	List<Client> findByName(String name);
	Client findById(long id);
}
