package com.example.BookMyShow.Services;

import com.example.BookMyShow.Repositories.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowSeatService {

    @Autowired
    ShowSeatRepository showSeatRepository;
}
