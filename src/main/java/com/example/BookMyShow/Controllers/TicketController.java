package com.example.BookMyShow.Controllers;

import com.example.BookMyShow.DTOS.TicketEntryDto;
import com.example.BookMyShow.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/book")
    public ResponseEntity<String> bookTicket(@RequestBody TicketEntryDto ticketEntryDto){

        try {
            ticketService.bookTicket(ticketEntryDto);
        }catch (Exception e){
            return new ResponseEntity<>("Ticket could not be booked", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Ticket booked successfully", HttpStatus.CREATED);
    }
}
