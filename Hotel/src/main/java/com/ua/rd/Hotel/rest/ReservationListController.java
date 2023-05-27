package com.ua.rd.Hotel.rest;
import com.ua.rd.Hotel.domain.ReservationList;
import com.ua.rd.Hotel.dto.ReservationListDto;
import com.ua.rd.Hotel.service.ReservationListService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController

@RequiredArgsConstructor
public class ReservationListController {
    @Autowired
    private final ReservationListService reservationListService;

    @GetMapping("/reservations")
    public ResponseEntity<List<ReservationListDto>> findAll() {
        return ResponseEntity.ok(reservationListService.findAll());
    }

    @PostMapping("/reservations")
    public ResponseEntity<Void> save(@RequestBody ReservationList reservationList) {

        reservationListService.save(reservationList);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @PostMapping("/reservations/{reservationId}/room/{roomId}")
    public ResponseEntity<Void> update(@PathVariable Long roomId, @PathVariable Long reservationId) {
        reservationListService.changeRoom(roomId, reservationId);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/reservations/{reservationId}")
    public void delete(@PathVariable Long reservationId) {
        reservationListService.deleteById(reservationId);
    }


}
