package com.example.BookMyShow.Services;

import com.example.BookMyShow.Convertors.UserConvertor;
import com.example.BookMyShow.DTOS.UserEntryDto;
import com.example.BookMyShow.Models.UserEntity;
import com.example.BookMyShow.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addUser(UserEntryDto userEntryDto) throws Exception{

        // This is to set all the attribute in one go.
        // Creating object in smart manner
        UserEntity userEntity = UserConvertor.convertDtoToEntity(userEntryDto);
        userRepository.save(userEntity);

    }

    public String findUserName(Integer id) throws Exception{

        UserEntity userEntity = userRepository.findById(id).get();

        if(userEntity==null){
            throw new Exception("User is not present");
        }

        return userEntity.getName();
    }

    public void updatePassword(Integer id, String password) throws Exception{

        UserEntity userEntity = userRepository.findById(id).get();

        if(userEntity==null){
            throw new Exception("User is not found");
        }

        userEntity.setPassword(password);
        userRepository.save(userEntity);
    }




}
