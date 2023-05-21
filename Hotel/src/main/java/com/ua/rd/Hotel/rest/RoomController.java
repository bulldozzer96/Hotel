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

    @PostMapping("/rooms")
    public ResponseEntity<Void> save(@RequestBody Room room) {
        roomService.save(room);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/rooms/delete/{id}")
    public void deleteRoom(@PathVariable(value = "id") Long id){
        roomService.deleteById(id);
    }





}
