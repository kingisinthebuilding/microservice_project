package com.microservice.userservice.serviceImpl;

import com.microservice.userservice.exception.ResourceNotFoundException;
import com.microservice.userservice.model.Hotel;
import com.microservice.userservice.model.Rating;
import com.microservice.userservice.model.User;
import com.microservice.userservice.repository.UserRepository;
import com.microservice.userservice.service.HotelService;
import com.microservice.userservice.service.RatingService;
import com.microservice.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService
{

    @Autowired
    private UserRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RatingService ratingService;

    @Override
    public User saveUser(User user)
    {
        try
        {
            String randomUserId = UUID.randomUUID().toString();
            user.setUserId(randomUserId);
            return repository.save(user);
        }
        catch (Exception e)
        {
            throw new RuntimeException("Failed to save user: " + e.getMessage());
        }
    }

    @Override
    public List<User> getAllUser()
    {
        try
        {
            return repository.findAll();
        }
        catch (Exception e)
        {
            throw new RuntimeException("Failed to retrieve all users: " + e.getMessage());
        }
    }

    @Override
    public User getUserById(String id)
    {
        try
        {
            User user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
            //Fetching Ratings
            Rating[] userRatings = restTemplate.getForObject("http://RATINGSERVICE/rating/users/" + user.getUserId(), Rating[].class);
            System.out.println("Ratings : " + userRatings);
            System.out.println("User : " + user);

            List<Rating> ratings = Arrays.stream(userRatings).toList();

            List<Rating> ratingList = ratings.stream().map(rating -> {
                //Calling API
//                ResponseEntity<Hotel> responseEntity = restTemplate.getForEntity(
//                        "http://HOTELSERVICE/hotels/" + rating.getHotelId(),
//                        Hotel.class
//                );
                Hotel hotel = hotelService.getHotel(rating.getHotelId());

                rating.setHotel(hotel);

                System.out.println("Hotel&Rating : " + rating);

                return rating;
            }).collect(Collectors.toList());

            user.setRating(ratings);

            return user;
        }
        catch (Exception e)
        {
            throw new RuntimeException("Failed to retrieve user by id: " + id, e);
        }
    }


    @Override
    public User updateUser(String id, User updatedUser)
    {
        try
        {
            User existingUser = repository.findById(id).orElse(null);
            if (existingUser != null)
            {
                existingUser.setEmail(updatedUser.getUserId());
                existingUser.setName(updatedUser.getName());
                existingUser.setEmail(updatedUser.getEmail());
                existingUser.setAbout(updatedUser.getAbout());
                existingUser.setMobileNo(updatedUser.getMobileNo());
                return repository.save(existingUser);
            }
            return null;
        }
        catch (Exception e)
        {
            throw new RuntimeException("Failed to update user: " + e.getMessage());
        }
    }

    @Override
    public void deleteUserById(String id)
    {
        try
        {
            repository.deleteById(id);
        }
        catch (Exception e)
        {
            throw new RuntimeException("Failed to delete user: " + e.getMessage());
        }
    }
}
