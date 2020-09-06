package com.example.SpringORM;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringOrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringOrmApplication.class, args);
	}
	
	@Bean
    CommandLineRunner init(CourtReservationRepo repo) {
        return args -> {
        	CourtReservation cr = new CourtReservation("22.07.2020", 1);
            CourtReservation cr2 = new CourtReservation("09.09.2020", 2);
            repo.save(cr);
            repo.save(cr2);
            repo.findAll().forEach(System.out::println);
          
        };
    }
    

}
