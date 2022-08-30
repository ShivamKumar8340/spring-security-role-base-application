package com.sunglowsys.service;

import com.sunglowsys.domain.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface HotelService {

    Hotel save(Hotel hotel);

    Hotel update(Hotel hotel);

    Optional<Hotel> findOne(Long id);

    Page<Hotel> findAll(Pageable pageable);

    void delete(Long id);
}