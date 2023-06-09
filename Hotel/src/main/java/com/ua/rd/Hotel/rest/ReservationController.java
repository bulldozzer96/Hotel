package com.ua.rd.Hotel.rest;
import com.ua.rd.Hotel.domain.Reservation;
import com.ua.rd.Hotel.dto.ReservationDto;
import com.ua.rd.Hotel.service.ReservationService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController

@RequiredArgsConstructor
public class ReservationController {
    @Autowired
    private final ReservationService reservationService;

    @GetMapping("/reservations")
    public ResponseEntity<List<ReservationDto>> findAll() {
        return ResponseEntity.ok(reservationService.findAll());
    }

    @PostMapping("/reservation")
    public ResponseEntity<Void> save(@RequestBody Reservation reservation) {
        reservationService.save(reservation);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @PostMapping("/reservation/{reservationId}/room/{roomId}")
    public ResponseEntity<Void> update(@PathVariable Long roomId, @PathVariable Long reservationId) {
        reservationService.changeRoom(roomId, reservationId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/reservation/{reservationId}")
    public void delete(@PathVariable Long reservationId) {
        reservationService.deleteById(reservationId);
    }


}
