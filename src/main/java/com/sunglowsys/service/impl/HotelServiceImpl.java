package com.sunglowsys.service.impl;

import com.sunglowsys.domain.Hotel;
import com.sunglowsys.repository.HotelRepository;
import com.sunglowsys.service.HotelService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public Hotel save(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel update(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Optional<Hotel> findOne(Long id) {
        return hotelRepository.findById(id);
    }

    @Override
    public Page<Hotel> findAll(Pageable pageable) {
        return hotelRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
        hotelRepository.deleteById(id);
    }
}
