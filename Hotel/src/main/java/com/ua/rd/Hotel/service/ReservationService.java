package com.ua.rd.Hotel.service;

import com.ua.rd.Hotel.domain.Reservation;
import com.ua.rd.Hotel.dto.ReservationDto;
import com.ua.rd.Hotel.repository.ReservationRepository;
import com.ua.rd.Hotel.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service

@RequiredArgsConstructor
public class ReservationService {

    @Autowired
    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;

    public List<ReservationDto> findAll() {
        return reservationRepository.findAll()
                .stream()
                .map(ReservationService::buildReservationListDto)
                .collect(Collectors.toList());
    }

    private static ReservationDto buildReservationListDto(Reservation reservation) {
        return ReservationDto.builder()
                .orderDate(reservation.getOrderDate())
                .checkIn(reservation.getCheckIn())
                .checkOut(reservation.getCheckOut())
                .roomName(reservation.getRoomId().getName())
                .clientName(reservation.getClientId().getName())
                .build();
    }

    public void save(Reservation reservation) {

        reservation.setOrderDate(new Date());


            if (isReserveExists(reservation)) {
                throw new IllegalArgumentException("Reservation already exists");

            } else {
                reservationRepository.save(reservation);
            }


    }

    private boolean isReserveExists(Reservation reservation) {
        return reservationRepository.existsByRoomIdAndCheckInAndCheckOut(
                reservation.getRoomId(), reservation.getCheckIn(), reservation.getCheckOut());
    }

    public void changeRoom(Long roomId, Long reservationId) {

        var reservation = reservationRepository.findById(reservationId).get();
        var room = roomRepository.findById(roomId).get();
        reservation.setRoomId(room);

        if (isReserveExists(reservation)) {
            throw new IllegalArgumentException("Reservation already exists");

        } else {
            reservationRepository.save(reservation);
        }
    }


    public void deleteById(Long id) {
        reservationRepository.deleteById(id);
    }
}








