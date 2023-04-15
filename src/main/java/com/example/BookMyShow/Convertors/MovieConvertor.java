package com.example.BookMyShow.Convertors;

import com.example.BookMyShow.DTOS.MovieEntryDto;
import com.example.BookMyShow.Models.MovieEntity;
import com.example.BookMyShow.ResponseDto.MovieResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Type;

public class MovieConvertor {

    @Autowired
    static
    ModelMapper modelMapper = new ModelMapper();

    public static MovieEntity convertDtoToEntity(MovieEntryDto movieEntryDto){

        MovieEntity movieEntity = MovieEntity.builder().movieName(movieEntryDto.getMovieName()).duration(movieEntryDto.getDuration()).genre(movieEntryDto.getGenre()).language(movieEntryDto.getLanguage()).ratings(movieEntryDto.getRatings()).build();
        return movieEntity;
    }

    public static MovieResponseDto convertEntityToDto(MovieEntity movieEntity){

        MovieResponseDto movieResponseDto = modelMapper.map(movieEntity, MovieResponseDto.class);

        return movieResponseDto;
    }
}
