package com.ua.rd.Hotel.rest;

import com.ua.rd.Hotel.domain.Room;
import com.ua.rd.Hotel.dto.RoomDto;
import com.ua.rd.Hotel.service.RoomService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor


public class RoomController {

    @Autowired
    private final RoomService roomService;

    @GetMapping("/rooms")
    public ResponseEntity<List<RoomDto>> findAll() {
        return ResponseEntity.ok(roomService.findAll());
    }


    //    @GetMapping("/room/{id}")
//    public ResponseEntity<Optional<Room>> findById(@PathVariable Long id) {
//        return ResponseEntity.ok(roomService.findById(id));
//    }
    @GetMapping("/room/{id}")
    public Optional<RoomDto> findById(@PathVariable Long id) {
        return roomService.findById(id);
    }


    @PostMapping("/rooms")
    public ResponseEntity<Void> save(@RequestBody Room room) {
        roomService.save(room);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/room/{id}")
    public void deleteRoom(@PathVariable(value = "id") Long id) {
        roomService.deleteById(id);
    }

    @PostMapping("/rooms/{id}/status/{roomStatusId}")
    public ResponseEntity<Void> update(@PathVariable Long id, @PathVariable Long roomStatusId) {
        roomService.addStatus(id, roomStatusId);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }


}
