package com.traffic.trafficApp.Ticket;

import com.traffic.trafficApp.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ticketController {
    @Autowired
    private UserRepository repo;

    @GetMapping("/ticket")
    public String  viewTicketForm()
    {
        return "ticket";
    }
}
