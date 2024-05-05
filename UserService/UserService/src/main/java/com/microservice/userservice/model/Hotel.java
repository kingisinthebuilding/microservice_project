package com.microservice.userservice.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Hotel
{
    private String id;
    private String name;
    private String location;
    private String about;
    private long mobileNo;
}
