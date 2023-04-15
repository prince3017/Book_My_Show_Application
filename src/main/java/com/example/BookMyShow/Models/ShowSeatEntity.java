package com.example.BookMyShow.Models;

import com.example.BookMyShow.Enums.SeatType;
import javax.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "show_seat")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShowSeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private boolean isBooked;

    private double price;  // Price of the seat for that particular show (seat can be classic or premium)

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private Date bookedAt;

    // This is child wrt showEntity
    @ManyToOne
    @JoinColumn
    private ShowEntity showEntity;
}
