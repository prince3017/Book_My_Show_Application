package com.example.BookMyShow.Models;

import javax.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "tickets")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double price;

    private String movieName;

    private LocalTime showTiming;

    private LocalDate showDate;

    private String bookedSeats;

    private String theatreName;

    private String ticketId = UUID.randomUUID().toString();

    // This is child wrt to userEntity
    @ManyToOne
    @JoinColumn
    private UserEntity userEntity;

    // This is child wrt showEntity
    @ManyToOne
    @JoinColumn
    private ShowEntity showEntity;

}
