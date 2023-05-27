package com.ua.rd.Hotel.service;


import com.ua.rd.Hotel.domain.Room;
import com.ua.rd.Hotel.domain.RoomStatus;
import com.ua.rd.Hotel.dto.RoomStatusDto;
import com.ua.rd.Hotel.repository.RoomStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class RoomStatusService {

    private final RoomStatusRepository roomStatusRepository;

    public void save(RoomStatus roomStatus) {
        roomStatusRepository.save(roomStatus);
    }

    public List<RoomStatusDto> findAll() {
        return roomStatusRepository.findAll()
                .stream()
                .map(RoomStatusService::buildRoomStatusDto)
                .collect(Collectors.toList());
    }

    private static RoomStatusDto buildRoomStatusDto(RoomStatus roomStatus) {
        return RoomStatusDto.builder()
                .id(roomStatus.getId())
                .name(roomStatus.getName())
                .rooms(roomStatus.getRoom().stream().map(Room::getName).collect(Collectors.toList()))
                .build();

    }

}
