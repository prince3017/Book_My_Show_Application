package com.example.BookMyShow.Services;

import com.example.BookMyShow.Convertors.MovieConvertor;
import com.example.BookMyShow.Convertors.TheatreConvertor;
import com.example.BookMyShow.DTOS.TheatreEntryDto;
import com.example.BookMyShow.Enums.SeatType;
import com.example.BookMyShow.Models.MovieEntity;
import com.example.BookMyShow.Models.ShowEntity;
import com.example.BookMyShow.Models.TheatreEntity;
import com.example.BookMyShow.Models.TheatreSeatEntity;
import com.example.BookMyShow.Repositories.TheatreRepository;
import com.example.BookMyShow.Repositories.TheatreSeatRepository;
import com.example.BookMyShow.ResponseDto.MovieResponseDto;
import com.example.BookMyShow.ResponseDto.TheatreResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreService {

    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    TheatreSeatRepository theatreSeatRepository;

    // 1. Create theatre seats
    // 2. I need to save theatre : I need theatreEntity
    // 3. Always set the attribute before saving.

    public void addTheatre(TheatreEntryDto theatreEntryDto) throws Exception{

        // Do some validation
        if(theatreEntryDto.getName()==null || theatreEntryDto.getLocation()==null){
            throw new Exception("Name or location should be valid");
        }

        // Dto to Entity
        TheatreEntity theatreEntity = TheatreConvertor.convertDtoToEntity(theatreEntryDto);

        // Calling another method of createTheatreSeats
        List<TheatreSeatEntity> theatreSeatEntityList = createTheatreSeats(theatreEntryDto, theatreEntity);

        // Set attribute
        theatreEntity.setTheatreSeatEntityList(theatreSeatEntityList);

        // Save in repository
        theatreRepository.save(theatreEntity);
    }

    private List<TheatreSeatEntity> createTheatreSeats(TheatreEntryDto theatreEntryDto, TheatreEntity theatreEntity) {

        int noClassicSeats = theatreEntryDto.getClassicSeatsCount();
        int noPremiumSeats = theatreEntryDto.getPremiumSeatsCount();

        List<TheatreSeatEntity> theatreSeatEntityList = new ArrayList<>();

        // Create classic(Silver) seats
        for(int count = 1; count <= noClassicSeats;count++){

            // We need to make a new TheatreSeatEntity
            TheatreSeatEntity theatreSeatEntity = TheatreSeatEntity.builder()
                    .seatType(SeatType.SILVER)
                    .seatNo(String.valueOf(count+"S"))
                    .theatreEntity(theatreEntity)
                    .build();

            // Add in the list
            theatreSeatEntityList.add(theatreSeatEntity);
        }

        // Create (premium)Gold seats
        for(int count = 1; count <= noPremiumSeats; count++){

            // We need to make a new TheatreSeatEntity
            TheatreSeatEntity theatreSeatEntity = TheatreSeatEntity.builder()
                    .seatType(SeatType.GOLD)
                    .seatNo(String.valueOf(count+"G"))
                    .theatreEntity(theatreEntity)
                    .build();

            // Add in the list
            theatreSeatEntityList.add(theatreSeatEntity);
        }

        // Not saving child here
        //theatreSeatRepository.saveAll(theatreSeatEntityList);

        return theatreSeatEntityList;
    }

    public List<TheatreResponseDto> findAllTheatres(){

        List<TheatreEntity> theatreEntityList = theatreRepository.findAll();

        List<TheatreResponseDto> theatreResponseDtoList = new ArrayList<>();
        for (TheatreEntity theatreEntity : theatreEntityList){

            TheatreResponseDto theatreResponseDto = TheatreConvertor.covertEntityToDto(theatreEntity);

            theatreResponseDtoList.add(theatreResponseDto);
        }

        return theatreResponseDtoList;
    }

    public List<MovieResponseDto> findAllMoviesFromTheatre(Integer id) throws Exception{

        TheatreEntity theatreEntity = theatreRepository.findById(id).get();

        if(theatreEntity==null){
            throw new Exception("Theatre not found");
        }

        List<ShowEntity> showEntityList = theatreEntity.getShowEntityList();

        List<MovieResponseDto> movieResponseDtoList = new ArrayList<>();

        for (ShowEntity showEntity : showEntityList){

            MovieEntity movieEntity = showEntity.getMovieEntity();

            MovieResponseDto movieResponseDto = MovieConvertor.convertEntityToDto(movieEntity);

            movieResponseDtoList.add(movieResponseDto);
        }

        return movieResponseDtoList;
    }
}
