package com.example.BookMyShow.ResponseDto;

import com.example.BookMyShow.Enums.Genre;
import com.example.BookMyShow.Enums.Language;
import com.example.BookMyShow.Models.ShowEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class MovieResponseDto {

    private String movieName;

    private double ratings;

    private int duration;

    private Language language;

    private Genre genre;

}
