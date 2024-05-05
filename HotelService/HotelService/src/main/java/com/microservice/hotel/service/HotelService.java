package com.microservice.hotel.service;

import com.microservice.hotel.model.Hotel;

import java.util.List;

public interface HotelService
{
    //create
    Hotel create(Hotel hotel);

    //read all
    List<Hotel> getAll();

    //read by id
    Hotel getAllById(String id);

    //update
    Hotel update(String id, Hotel hotel);

    //delete
    void delete(String id);
}
