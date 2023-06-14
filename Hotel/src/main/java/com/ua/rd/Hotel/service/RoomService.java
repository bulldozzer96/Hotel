package com.ua.rd.Hotel.service;

import com.ua.rd.Hotel.domain.Room;
import com.ua.rd.Hotel.dto.RoomDto;
import com.ua.rd.Hotel.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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



    public List<RoomDto> findRoomsNotReservationListInRange(LocalDate checkIn, LocalDate checkOut) {
        List<Room> rooms = roomRepository.findRoomsNotReservationListInRange(checkIn, checkOut);


        List<RoomDto> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            RoomDto roomDto = RoomDto.builder()
                    .name(room.getName())
                    .capacity(room.getCapacity())
                    .numberOfBeds(room.getNumberOfBeds())
                    .floor(room.getFloor())
                    .build();
            availableRooms.add(roomDto);
        }

        return availableRooms;
    }


    public Optional<RoomDto> findById(Long id) {
        return roomRepository.findById(id).map(RoomService::buildRoomDto);
    }


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

    public Optional<Room> findByIdUpdate(Long id) {
        return roomRepository.findById(id);
    }

    public void deleteById(Long id) {
        roomRepository.deleteById(id);
    }

}
