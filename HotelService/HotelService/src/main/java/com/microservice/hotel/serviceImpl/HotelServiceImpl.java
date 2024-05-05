package com.microservice.hotel.serviceImpl;

import com.microservice.hotel.model.Hotel;
import com.microservice.hotel.repository.HotelRepository;
import com.microservice.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService
{
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        try {
            String randomID = UUID.randomUUID().toString();
            hotel.setId(randomID);
            return hotelRepository.save(hotel);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create hotel: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Hotel> getAll() {
        try {
            return hotelRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve hotels: " + e.getMessage(), e);
        }
    }

    @Override
    public Hotel getAllById(String id) {
        try {
            Optional<Hotel> optionalHotel = hotelRepository.findById(id);
            return optionalHotel.orElseThrow(() -> new RuntimeException("Hotel not found with ID: " + id));
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve hotel by ID: " + id + ", " + e.getMessage(), e);
        }
    }

    @Override
    public Hotel update(String id, Hotel updatedHotel) {
        try {
            Optional<Hotel> optionalExistingHotel = hotelRepository.findById(id);

            if (optionalExistingHotel.isPresent()) {
                Hotel existingHotel = optionalExistingHotel.get();
                existingHotel.setName(updatedHotel.getName());
                existingHotel.setLocation(updatedHotel.getLocation());
                existingHotel.setAbout(updatedHotel.getAbout());
                existingHotel.setMobileNo(updatedHotel.getMobileNo());

                return hotelRepository.save(existingHotel);
            } else {
                throw new RuntimeException("Hotel not found with ID: " + id);
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to update hotel with ID " + id + ": " + e.getMessage(), e);
        }
    }

    @Override
    public void delete(String id) {
        try {
            hotelRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete hotel with ID: " + id + ", " + e.getMessage(), e);
        }
    }
}
