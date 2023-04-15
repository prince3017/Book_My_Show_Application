package com.example.BookMyShow.Convertors;

import com.example.BookMyShow.DTOS.ShowEntryDto;
import com.example.BookMyShow.Models.ShowEntity;

public  class ShowConvertor {

    public static ShowEntity convertDtoToEntity(ShowEntryDto showEntryDto){

        ShowEntity showEntity = ShowEntity.builder()
                .showDate(showEntryDto.getLocalDate())
                .showTime(showEntryDto.getLocalTime())
                .showType(showEntryDto.getShowType())
                .build();

        return showEntity;
    }
}
