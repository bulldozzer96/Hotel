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



    public Optional<RoomDto> findById(Long id) {
        return roomRepository.findById(id).map(RoomService::buildRoomDto);
    }



    public void save(Room room) {
        roomRepository.save(room);
    }

//    public Optional<RoomDto> getRoomById(Long id) {
//        return roomRepository.findById(id);
//    }


    private static RoomDto buildRoomDto(Room room) {

        return RoomDto.builder()
                .name(room.getName())
                .floor(room.getFloor())
                .price(room.getPrice())
                .roomStatus(room.getRoomStatus_id().getName())
                .build();
    }

//    public void addStatus(Long roomId, Long statusId) {
//
//        var status = RoomStatusRepository.findById(statusId).get();
//        var room = RoomRepository.findById(roomId).get();
//        room.setRoomStatus_id(status);
//
//        roomRepository.save(room);
//    }




    public void deleteById(Long id) {
        roomRepository.deleteById(id);
    }









}
