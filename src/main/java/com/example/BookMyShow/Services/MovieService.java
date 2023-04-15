package com.example.BookMyShow.Services;

import com.example.BookMyShow.Convertors.MovieConvertor;
import com.example.BookMyShow.DTOS.MovieEntryDto;
import com.example.BookMyShow.Models.MovieEntity;
import com.example.BookMyShow.Repositories.MovieRepository;
import com.example.BookMyShow.ResponseDto.MovieResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    ModelMapper modelMapper = new ModelMapper();

    public void addMovie(MovieEntryDto movieEntryDto){

        MovieEntity movieEntity = MovieConvertor.convertDtoToEntity(movieEntryDto);
        movieRepository.save(movieEntity);
    }

    public MovieResponseDto findMovie(Integer id){

        MovieEntity movieEntity = movieRepository.findById(id).get();

        MovieResponseDto movieResponseDto = MovieConvertor.convertEntityToDto(movieEntity);

        return movieResponseDto;
    }

    public List<MovieResponseDto> findAllMovies(){

        List<MovieEntity> movieEntityList = movieRepository.findAll();

        List<MovieResponseDto> movieResponseDtoList = new ArrayList<>();
        for (MovieEntity movieEntity : movieEntityList){

            MovieResponseDto movieResponseDto = MovieConvertor.convertEntityToDto(movieEntity);

            movieResponseDtoList.add(movieResponseDto);
        }

        return movieResponseDtoList;
    }


}
