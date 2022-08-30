package com.sunglowsys.resources;

import com.sunglowsys.domain.Hotel;
import com.sunglowsys.service.HotelService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HotelResource {

    private final HotelService hotelService;
    public HotelResource(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/hotels")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
       Hotel result = hotelService.save(hotel);
       return ResponseEntity
               .status(HttpStatus.CREATED)
               .body(result);
    }

    @PutMapping("/hotels")
    public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel) {
        if (hotel.getId()==null) {
            throw new RuntimeException("id must not be null");
        }
        Hotel result =hotelService.update(hotel);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(result);
    }

    @GetMapping("/hotels/{id}")
    public ResponseEntity<Optional<Hotel>> gethotel(@PathVariable Long id) {
        Optional<Hotel> result =hotelService.findOne(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(result);
    }

    @GetMapping("/hotels")
    public ResponseEntity<Page<Hotel>> getAllHotels() {
       Page<Hotel> result = hotelService.findAll(PageRequest.of(0,5));
       return ResponseEntity
               .status(HttpStatus.OK)
               .body(result);
    }

    @DeleteMapping("/hotels/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id) {
        hotelService.delete(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
}
