package com.ua.rd.Hotel.service;

import com.ua.rd.Hotel.domain.ReservationList;
import com.ua.rd.Hotel.domain.Room;

import com.ua.rd.Hotel.dto.ReservationListDto;
import com.ua.rd.Hotel.dto.RoomDto;
import com.ua.rd.Hotel.repository.ReservationListRepository;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service

@RequiredArgsConstructor
public class ReservationListService {

    @Autowired
    private final ReservationListRepository reservationListRepository;

    public List<ReservationListDto> findAll() {
        return reservationListRepository.findAll().stream()
                .map(ReservationListService::buildReservationListDto)
                .collect(Collectors.toList());
    }


    private static ReservationListDto buildReservationListDto(ReservationList reservationList) {


        return ReservationListDto.builder()
                .orderDate(reservationList.getOrderDate())
                .checkIn(reservationList.getCheckIn())
                .checkOut(reservationList.getCheckOut())
                .roomName(reservationList.getRoomId().getName())
                .clientName(reservationList.getClients_id().getName())
                .build();
    }


    public void save(ReservationList reservationList) {


        reservationList.setOrderDate(new Date());


        reservationListRepository.save(reservationList);
    }


}
