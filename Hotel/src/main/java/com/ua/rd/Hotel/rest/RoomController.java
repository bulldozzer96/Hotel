package com.ua.rd.Hotel.rest;

import com.ua.rd.Hotel.domain.Room;
import com.ua.rd.Hotel.dto.RoomDto;
import com.ua.rd.Hotel.service.RoomService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor


public class RoomController {
    private final RoomService roomService;

    @GetMapping("/rooms")
    public ResponseEntity<List<RoomDto>> findAll() {
        return ResponseEntity.ok(roomService.findAll());
    }
    @GetMapping("/rooms/id/{id}")
    public ResponseEntity <List<RoomDto>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(roomService.findById(id));
    }



    @GetMapping("/rooms/floor/{floor}")
    public ResponseEntity<Optional<Room>> findByFloor(@PathVariable(value = "floor") int floor) {
        return ResponseEntity.ok(roomService.findByFloor(floor));

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



//    @DeleteMapping("/rooms/deleteN/{name}")
//    public void deleteByRoomName(@PathVariable(value = "name") String name){
//        roomService.deleteRoomByName(name);
//    }



}
