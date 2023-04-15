package com.example.BookMyShow.DTOS;

import javax.persistence.*;
import lombok.Data;

@Data
public class UserEntryDto {

    private String name;

    private String email;

    private String mobileNumber;

    private String address;

    private int age;

    private String password;
}
