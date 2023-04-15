package com.example.BookMyShow.DTOS;

import lombok.Data;

@Data
public class TheatreEntryDto {

    private String name;

    private String location;

    private int classicSeatsCount;

    private int premiumSeatsCount;
}
