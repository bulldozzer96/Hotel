package com.ua.rd.Hotel.rest;

import com.ua.rd.Hotel.domain.Room;
import com.ua.rd.Hotel.dto.RoomDto;
import com.ua.rd.Hotel.service.RoomService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor


public class RoomController {
    private final RoomService roomService;

    @GetMapping("/rooms")
    public ResponseEntity<List<RoomDto>> findAll() {
        return ResponseEntity.ok(roomService.findAll());
    }
    @GetMapping("/rooms/id/{id}")
    public ResponseEntity <Room> findById(@PathVariable Long id) {
        return roomService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/rooms/floor/{floor}")
    public ResponseEntity<Room> findByFloor(@PathVariable int floor) {
        return roomService.findByFloor(floor)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping("/rooms")
    public ResponseEntity<Void> save(@RequestBody Room room) {
        roomService.save(room);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/rooms/{id}")
    public void deleteRoom(@PathVariable(value = "id") Long id){
        roomService.deleteById(id);
    }

//    @PostMapping("/rooms/{id}/status/{roomStatus_id}")
//    public ResponseEntity<Void> update(@PathVariable Long id, @PathVariable Long roomStatus_id) {
//        roomService.addStatus(id, roomStatus_id);
//
//        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
//    }



}
