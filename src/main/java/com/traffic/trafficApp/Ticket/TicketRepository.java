package com.traffic.trafficApp.Ticket;

import com.traffic.trafficApp.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
