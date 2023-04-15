package com.example.BookMyShow.Controllers;

import com.example.BookMyShow.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show-seat")
public class ShowSeatController {

    @Autowired
    ShowService showService;


}
