package com.ua.rd.Hotel.rest;


import com.ua.rd.Hotel.domain.Room;

import com.ua.rd.Hotel.dto.RoomDto;
import com.ua.rd.Hotel.service.RoomService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @GetMapping("/room/{id}")
    public Optional<RoomDto> findById(@PathVariable Long id) {
        return roomService.findById(id);
    }

    @PostMapping("/rooms")
    public ResponseEntity<Void> save(@RequestBody Room room) {
        roomService.save(room);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

//    @DeleteMapping("/room/{id}")
//    public ResponseEntity<Object> deleteRoom(@PathVariable(value = "id") Long id) {
//        Optional<Room> room = roomService.findByIdUpdate(id);
//        if (room.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//        roomService.deleteById(id);
//        return null;
//    }


    @GetMapping("/rooms/unreserved")
    public List<String> getUnreservedRoomNames
            (@RequestParam("checkInDate")

             LocalDate checkIn,
             @RequestParam("checkOutDate")

             LocalDate checkOut) {
        return roomService.findRoomNamesNotReservedInRange(checkIn, checkOut);
    }

    @GetMapping("/rooms/unreserved/all")
    public List<RoomDto> getUnreservedRooms
            (@RequestParam("checkInDate")
             LocalDate checkIn,
             @RequestParam("checkOutDate")
             LocalDate checkOut) {
        return roomService.findRoomsNotReservationListInRange(checkIn, checkOut);
    }

    @PutMapping("/room/{id}")
    public ResponseEntity<Void> updateRoom(@PathVariable("id") Long id, @RequestBody RoomDto roomDto) {
        Optional<Room> optionalRoom = roomService.findByIdUpdate(id);

        if (optionalRoom.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Room room = optionalRoom.get();


        room.setName(roomDto.getName());
        room.setCapacity(roomDto.getCapacity());
        room.setFloor(roomDto.getFloor());
        room.setNumberOfBeds(roomDto.getNumberOfBeds());



        roomService.save(room);

        return ResponseEntity.ok().build();
    }

}
