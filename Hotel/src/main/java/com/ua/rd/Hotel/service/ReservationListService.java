package com.ua.rd.Hotel.service;

import com.ua.rd.Hotel.domain.ReservationList;


import com.ua.rd.Hotel.dto.ReservationListDto;

import com.ua.rd.Hotel.repository.ReservationListRepository;
import com.ua.rd.Hotel.repository.RoomRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service

@RequiredArgsConstructor
public class ReservationListService {

    @Autowired
    private final ReservationListRepository reservationListRepository;
    private final RoomRepository roomRepository;






    public List<ReservationListDto> findAll() {


        return reservationListRepository.findAll()
                        .stream()
                        .map(ReservationListService::buildReservationListDto)
                        .collect(Collectors.toList());
    }


    private static ReservationListDto buildReservationListDto(ReservationList reservationList) {


        return ReservationListDto.builder()
                .orderDate(reservationList.getOrderDate())
                .checkIn(reservationList.getCheckIn())
                .checkOut(reservationList.getCheckOut())
                .roomName(reservationList.getRoomId().getName())
                .clientName(reservationList.getClientsId().getName())
                .build();
    }


    public void save(ReservationList reservationList) {

        reservationList.setOrderDate(new Date());

        if (reservationList.getCheckIn().isAfter(reservationList.getCheckOut())) {
            throw new IllegalArgumentException("Check-in date must be before check-out date");
        }else if (reservationList.getCheckOut().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Check-out date can`t be in the past");
        }else
        reservationListRepository.save(reservationList);
    }

    public void changeRoom(Long roomId, Long reservationId) {

        var reservation = reservationListRepository.findById(reservationId).get();
        var room = roomRepository.findById(roomId).get();
        reservation.setRoomId(room);

        reservationListRepository.save(reservation);
    }





    }








