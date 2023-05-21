package com.ua.rd.Hotel.rest;



import com.ua.rd.Hotel.domain.RoomStatus;
import com.ua.rd.Hotel.dto.RoomStatusDto;
import com.ua.rd.Hotel.service.RoomStatusService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequiredArgsConstructor

public class RoomStatusController {
    private final RoomStatusService roomStatusService;

    @GetMapping("/status")
    public List<RoomStatusDto> findAll() {
        return roomStatusService.findAll();
    }

    @PostMapping("/status")
    public void save(@RequestBody RoomStatus roomStatus) {
        roomStatusService.save(roomStatus);
    }

}
