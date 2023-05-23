package com.ua.rd.Hotel.service;
import com.ua.rd.Hotel.domain.ReservationList;
import com.ua.rd.Hotel.domain.Room;

import com.ua.rd.Hotel.dto.ReservationListDto;
import com.ua.rd.Hotel.dto.RoomDto;
import com.ua.rd.Hotel.repository.ReservationListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service

@RequiredArgsConstructor
public class ReservationListService {

    private final ReservationListRepository reservationListRepository;

    public List<ReservationListDto> findAll() {
        return reservationListRepository.findAll().stream()
                .map(ReservationListService::buildReservationListDto)
                        .collect(Collectors.toList());
    }



    private static ReservationListDto buildReservationListDto(ReservationList reservationList) {

        return ReservationListDto.builder()
                .checkIn(reservationList.getCheckIn())
                .checkOut(reservationList.getCheckOut())
                .roomName(reservationList.getRoomId().getName())
                .clientName(reservationList.getClients_id().getName())
                .build();
    }


    public void save(ReservationList reservationList) {
        reservationListRepository.save(reservationList);
    }


}
