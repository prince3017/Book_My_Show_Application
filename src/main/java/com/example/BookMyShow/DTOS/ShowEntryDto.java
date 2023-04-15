package com.example.BookMyShow.DTOS;

import com.example.BookMyShow.Enums.ShowType;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ShowEntryDto {

    private LocalDate localDate;

    private LocalTime localTime;

    private ShowType showType;

    private int movieId;

    private int theatreId;

    private int classicSeatPrice;

    private int premiumSeatPrice;
}
