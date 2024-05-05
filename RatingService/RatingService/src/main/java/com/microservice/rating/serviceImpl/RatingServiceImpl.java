package com.microservice.rating.serviceImpl;

import com.microservice.rating.model.Rating;
import com.microservice.rating.repository.RatingRepository;
import com.microservice.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService
{
    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating create(Rating rating) {
        try {
            String randomID = UUID.randomUUID().toString();
            rating.setRatingId(randomID);
            return ratingRepository.save(rating);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create rating: " + e.getMessage());
        }
    }

    @Override
    public List<Rating> getAll() {
        try {
            return ratingRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve all ratings: " + e.getMessage());
        }
    }

    @Override
    public Rating getAllById(String id) {
        try {
            Optional<Rating> optionalRating = ratingRepository.findById(id);
            return optionalRating.orElse(null);
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve rating by ID: " + id + ", " + e.getMessage());
        }
    }

    @Override
    public Rating update(String id, Rating rating) {
        try {
            Rating rating1 = ratingRepository.findById(id).orElseThrow(null);
            if (ratingRepository.existsById(id)) {
                rating1.setRating(rating.getRating());
                rating1.setUserId(rating.getUserId());
                rating1.setHotelId(rating.getHotelId());
                rating1.setFeedback(rating.getFeedback());
                return ratingRepository.save(rating);
            } else {
                throw new IllegalArgumentException("Rating with ID " + id + " not found");
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to update rating with ID: " + id + ", " + e.getMessage());
        }
    }

    @Override
    public void delete(String id) {
        try {
            ratingRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete rating with ID: " + id + ", " + e.getMessage());
        }
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        try
        {
            return ratingRepository.findByUserId(userId);
        }
        catch(Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        try
        {
            return ratingRepository.findByHotelId(hotelId);
        }
        catch(Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }
    }
}
