package com.example.BookMyShow.Convertors;

import com.example.BookMyShow.DTOS.UserEntryDto;
import com.example.BookMyShow.Models.UserEntity;

public class UserConvertor {

    // Static is kept to avoid calling it via objects/instances
    public static UserEntity convertDtoToEntity(UserEntryDto userEntityDto){

        UserEntity userEntity = UserEntity.builder().age(userEntityDto.getAge()).address(userEntityDto.getAddress()).email(userEntityDto.getEmail()).name(userEntityDto.getName()).mobileNumber(userEntityDto.getMobileNumber()).password(userEntityDto.getPassword()).build();
        return userEntity;
    }
}
