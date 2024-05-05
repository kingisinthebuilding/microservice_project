package com.microservice.userservice.model;

import javax.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "userservice")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User
{
    @Id
    @Column(name = "ID")
    private String userId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ABOUT")
    private String about;

    @Column(name = "PHONE_NO")
    private long mobileNo;

    @Transient
    private List<Rating> rating = new ArrayList<>();
}
