package com.example.BookMyShow.DTOS;

import com.example.BookMyShow.Enums.Genre;
import com.example.BookMyShow.Enums.Language;
import lombok.Data;

@Data
public class MovieEntryDto {

    private String movieName;

    private int duration;

    private Language language;

    private Genre genre;

    private double ratings;
}
