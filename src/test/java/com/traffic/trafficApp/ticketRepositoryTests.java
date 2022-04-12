package com.traffic.trafficApp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ticketRepositoryTests {
     @Autowired private TicketRepository repo;

     @Test
     public void testAddTicket(){
          Ticket ticket = new Ticket();
          ticket.setFirstName("Joyce");
          ticket.setLastName("machaba.nokubonga@gmail.com");
          ticket.setGender("Female");
          ticket.setInitial("JN");
          ticket.setDateOfBirth("1995/08/03");
          ticket.setForeignCode("fgt");
          ticket.setIDNumber("95080307456");
          ticket.setIdType("sa");
          ticket.setLearnerCode("code");
          ticket.setPrdpCode("fjru");
          ticket.setLicenceCode("frtg");


          Ticket savedTicket = repo.save(ticket);



     }

     @Test
     public void testListAll(){
          Iterable<Ticket> ticket = repo.findAll();
//        Assertions.assertThat(users).hasSizeGreaterThan(0);

          for (Ticket ticketS : ticket) {
               System.out.println(ticketS);
          }
     }

     @Test
     public void testUpdate(){


     }
}
