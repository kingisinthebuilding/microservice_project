package com.microservice.userservice;

import com.microservice.userservice.model.Rating;
import com.microservice.userservice.service.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private RatingService ratingService;

//	@Test
//	void createRating()
//	{
//		Rating rating = Rating.builder().rating(10).userId("").hotelId("").feedback("this is created using feign client").build();
//		Rating savedRating = ratingService.createRating(rating);
//		System.out.println("New Rating Created");
//	}

}
