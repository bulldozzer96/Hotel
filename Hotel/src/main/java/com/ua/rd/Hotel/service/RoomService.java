package com.ua.rd.Hotel.service;



import com.ua.rd.Hotel.domain.Room;

import com.ua.rd.Hotel.dto.RoomDto;
import com.ua.rd.Hotel.repository.ReservationListRepository;
import com.ua.rd.Hotel.repository.RoomRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
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

    public List<String> findRoomNamesNotReservedInRange(LocalDate checkIn, LocalDate checkOut) {
        return roomRepository.findRoomNamesNotReservationListInRange(checkIn, checkOut);
    }

    public List<RoomDto> findRoomsNotReservationListInRange(LocalDate checkInDate, LocalDate checkOutDate) {
        List<Room> rooms = roomRepository.findRoomsNotReservationListInRange(checkInDate, checkOutDate);


        List<RoomDto> roomDtos = new ArrayList<>();
        for (Room room : rooms) {
            RoomDto roomDto = RoomDto.builder()
                    .name(room.getName())
                    .capacity(room.getCapacity())
                    .numberOfBeds(room.getNumberOfBeds())
                    .floor(room.getFloor())
                    .build();
            roomDtos.add(roomDto);
        }

        return roomDtos;
    }


    public Optional<RoomDto> findById(Long id) {
        return roomRepository.findById(id).map(RoomService::buildRoomDto);
    }

    @Transactional
    public void save(Room room) {
        try {
            if ((room.getName().startsWith(String.valueOf(room.getFloor())))) {
                roomRepository.save(room);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Room name must start with floor number");
        }
    }

    private static RoomDto buildRoomDto(Room room) {

        return RoomDto.builder()
                .name(room.getName())
                .capacity(room.getCapacity())
                .numberOfBeds(room.getNumberOfBeds())
                .floor(room.getFloor())
                .build();
    }

    public void deleteById(Long id) {
        roomRepository.deleteById(id);
    }

}
