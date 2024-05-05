package com.microservice.rating.service;

import com.microservice.rating.model.Rating;

import java.util.List;

public interface RatingService
{
    //create
    Rating create(Rating rating);

    //read all
    List<Rating> getAll();

    //readAll by ID
    Rating getAllById(String id);

    //update
    Rating update(String id, Rating rating);

    //delete
    void delete(String id);

    //get all by UserId
    List<Rating> getRatingByUserId(String userId);

    //get all by hotel
    List<Rating> getRatingByHotelId(String hotelId);
}
