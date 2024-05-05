package com.microservice.rating.model;

import javax.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Ratings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Rating
{
    @Id
    private String ratingId;
    private String userId;
    private String hotelId;
    private  int rating;
    private  String feedback;
}
