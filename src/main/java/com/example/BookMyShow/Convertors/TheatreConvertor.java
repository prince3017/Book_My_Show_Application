package com.example.BookMyShow.Convertors;

import com.example.BookMyShow.DTOS.TheatreEntryDto;
import com.example.BookMyShow.Models.TheatreEntity;
import com.example.BookMyShow.ResponseDto.TheatreResponseDto;
import org.modelmapper.ModelMapper;

public class TheatreConvertor {

    static ModelMapper modelMapper = new ModelMapper();

    public static TheatreEntity convertDtoToEntity(TheatreEntryDto theatreEntryDto){

        TheatreEntity theatreEntity = TheatreEntity.builder().name(theatreEntryDto.getName()).location(theatreEntryDto.getLocation()).build();
        return theatreEntity;
    }

    public static TheatreResponseDto covertEntityToDto(TheatreEntity theatreEntity){

        TheatreResponseDto theatreResponseDto = modelMapper.map(theatreEntity, TheatreResponseDto.class);

        return theatreResponseDto;
    }
}
