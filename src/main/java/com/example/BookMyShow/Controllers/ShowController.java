package com.example.BookMyShow.Controllers;

import com.example.BookMyShow.DTOS.ShowEntryDto;
import com.example.BookMyShow.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shows")
public class ShowController {

    @Autowired
    ShowService showService;

    @PostMapping("/add")
    public ResponseEntity<String> addShow(@RequestBody ShowEntryDto showEntryDto){

        try {
            showService.addShow(showEntryDto);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("show added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get-show-timings")
    public ResponseEntity getShowTime(@RequestParam Integer theatreId, @RequestParam Integer movieId){

        List<LocalTime> showTimeList = new ArrayList<>();

        try {
            showTimeList = showService.findShowTime(theatreId, movieId);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(showTimeList, HttpStatus.ACCEPTED);
    }
}
