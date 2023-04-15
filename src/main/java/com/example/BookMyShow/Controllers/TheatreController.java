package com.example.BookMyShow.Controllers;

import com.example.BookMyShow.DTOS.MovieEntryDto;
import com.example.BookMyShow.DTOS.TheatreEntryDto;
import com.example.BookMyShow.ResponseDto.MovieResponseDto;
import com.example.BookMyShow.ResponseDto.TheatreResponseDto;
import com.example.BookMyShow.Services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

    @Autowired
    TheatreService theatreService;

    @PostMapping("/add")
    public ResponseEntity<String> addTheatre(@RequestBody TheatreEntryDto theatreEntryDto){

        try {
            theatreService.addTheatre(theatreEntryDto);
        }catch (Exception e){
            return new ResponseEntity<>("Theatre could not added", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Theatre added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get-all")
    public ResponseEntity getAllTheatres(){

        List<TheatreResponseDto> theatreResponseDtoList = new ArrayList<>();

        try {
            theatreResponseDtoList = theatreService.findAllTheatres();
        }catch (Exception e){
            return new ResponseEntity<>("Request could not be proceed", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(theatreResponseDtoList, HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-all-movies/{id}")
    public ResponseEntity getAllMoviesInTheatre(@PathVariable Integer id){

        List<MovieResponseDto> movieResponseDtoList = new ArrayList<>();

        try {
            movieResponseDtoList = theatreService.findAllMoviesFromTheatre(id);
        }catch (Exception e){
            return new ResponseEntity<>("Request could not be proceed", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(movieResponseDtoList, HttpStatus.ACCEPTED);
    }
}
