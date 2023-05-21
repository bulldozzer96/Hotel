package com.ua.rd.Hotel.service;


import com.ua.rd.Hotel.domain.Room;

import com.ua.rd.Hotel.dto.RoomDto;
import com.ua.rd.Hotel.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service

@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    public List<RoomDto> findAll() {
        return roomRepository.findAll().stream()
                .map(RoomService::buildRoomDto)
                        .collect(Collectors.toList());
    }

    public List<RoomDto> findById(Long id) {
        return roomRepository.findById(id).stream()
                .map(RoomService::buildRoomDto)
                .collect(Collectors.toList());
    }

    public void save(Room room) {
        roomRepository.save(room);
    }

//    public void deleteById(Long id) {
//        roomRepository.deleteById(id);
//    }


    private static RoomDto buildRoomDto(Room room) {

        return RoomDto.builder()
                .name(room.getName())
                .floor(room.getFloor())
                .price(room.getPrice())
                .build();
    }



    public void deleteById(Long id) {
        roomRepository.deleteById(id);
    }

    public Optional<Room> findRoomByName(String name) {
        return roomRepository.findRoomByName(name);
    }
    public Optional<Room> deleteRoomByName(String name) {
        return roomRepository.deleteRoomByName(name);
    }
//    public Optional<Room> findById(Long id) {
//        return roomRepository.findById(id);
//    }

    public Optional<Room> findByFloor(int floor) {
        return roomRepository.findByFloor(floor);
    }




}
