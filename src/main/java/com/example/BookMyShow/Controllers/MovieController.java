package com.example.BookMyShow.Controllers;

import com.example.BookMyShow.DTOS.MovieEntryDto;
import com.example.BookMyShow.Models.MovieEntity;
import com.example.BookMyShow.ResponseDto.MovieResponseDto;
import com.example.BookMyShow.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add")
    public ResponseEntity<String> addMovie(@RequestBody MovieEntryDto movieEntryDto){

        try {
            movieService.addMovie(movieEntryDto);
        }catch (Exception e){
            return new ResponseEntity<>("Movie could not added", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Movie added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity getMovieById(@RequestParam("id") Integer id) {

        MovieResponseDto movieResponseDto = movieService.findMovie(id);
        try {
            movieResponseDto = movieService.findMovie(id);
        } catch (Exception e) {
            return new ResponseEntity<>("Movie is not present", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(movieResponseDto, HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-all")
    public ResponseEntity getAllMovies(){

        List<MovieResponseDto> movieEntityList = new ArrayList<>();
        try {
            movieEntityList = movieService.findAllMovies();
        }catch (Exception e){
            return new ResponseEntity<>("Request could not proceed", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(movieEntityList, HttpStatus.ACCEPTED);
    }

}
