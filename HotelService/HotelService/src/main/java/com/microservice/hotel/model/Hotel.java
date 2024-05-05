package com.microservice.hotel.model;

import javax.persistence.*;

@Entity
@Table(name = "Hotels")
public class Hotel
{
    @Id
    private String id;
    private String name;
    private String location;
    private String about;
    private long mobileNo;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getAbout() {
        return about;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Hotel(String id, String name, String location, String about, long mobileNo) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.about = about;
        this.mobileNo = mobileNo;
    }

    public Hotel() {
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", about='" + about + '\'' +
                ", mobileNo=" + mobileNo +
                '}';
    }
}
