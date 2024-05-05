package com.microservice.userservice.service;

import com.microservice.userservice.model.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@FeignClient(name = "RATINGSERVICE")
public interface RatingService
{
    @GetMapping("/rating/{ratingId}")
    Rating getRating(@PathVariable("ratingId") String ratingId);

    @PostMapping("/rating")
    public Rating createRating(Rating values);

    @PutMapping("/rating/{ratingId}")
    public Rating updateRating(@PathVariable("ratingId") String ratingId, Rating values);

    @DeleteMapping("/rating/{ratingId}")
    public void deleteRating(@PathVariable String ratingId);
}
