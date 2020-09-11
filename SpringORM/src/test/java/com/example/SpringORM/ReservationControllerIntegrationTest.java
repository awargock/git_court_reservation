package com.example.SpringORM;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringOrmApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReservationControllerIntegrationTest {
	@Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void contextLoads() {

    }

    @Test
    public void testGetAllReservations() {
    HttpHeaders headers = new HttpHeaders();
       HttpEntity<String> entity = new HttpEntity<String>(null, headers);
       ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/reservations",
       HttpMethod.GET, entity, String.class);  
       assertNotNull(response.getBody());
   }

   @Test
   public void testGetReservationById() {
       CourtReservation cr = restTemplate.getForObject(getRootUrl() + "/reservations/1", CourtReservation.class);
       System.out.println(cr.getTermin());
       assertNotNull(cr);
   }

   @Test
   public void testCreateReservation() {
	   CourtReservation cr = new CourtReservation();
       cr.setTermin("30.01.2021");
       cr.setNr_kortu(1);
       ResponseEntity<CourtReservation> postResponse = restTemplate.postForEntity(getRootUrl() + "/reservations", cr, CourtReservation.class);
       assertNotNull(postResponse);
       assertNotNull(postResponse.getBody());
   }

   @Test
   public void testUpdateReservation() {
       int id = 1;
       CourtReservation cr = restTemplate.getForObject(getRootUrl() + "/reservations/" + id, CourtReservation.class);
       cr.setTermin("01.01.2021");
       cr.setNr_kortu(2);
       restTemplate.put(getRootUrl() + "/reservations/" + id, cr);
       CourtReservation updatedReservation = restTemplate.getForObject(getRootUrl() + "/reservations/" + id, CourtReservation.class);
       assertNotNull(updatedReservation);
   }

   @Test
   public void testDeleteReservation() {
        int id = 2;
        CourtReservation cr = restTemplate.getForObject(getRootUrl() + "/reservations/" + id, CourtReservation.class);
        assertNotNull(cr);
        restTemplate.delete(getRootUrl() + "/cr/" + id);
        try {
             cr = restTemplate.getForObject(getRootUrl() + "/reservations/" + id, CourtReservation.class);
        } catch (final HttpClientErrorException e) {
             assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
   }
}
