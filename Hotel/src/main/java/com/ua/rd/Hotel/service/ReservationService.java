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
        reservation.setStatus(1);
        reservation.setStatusName("Present Reservation");


//            if (isReserveExists(reservationList)) {
//                throw new InvalidDataAccessApiUsageException("Reservation already exists");
//            }

        reservationRepository.save(reservation);
    }

    public void changeRoom(Long roomId, Long reservationId) {

        var reservation = reservationRepository.findById(reservationId).get();
        var room = roomRepository.findById(roomId).get();
        reservation.setRoomId(room);
        reservationRepository.save(reservation);
    }

    @Scheduled(fixedRate = 60000)
    private void updateBookingStatus() {
        List<Reservation> reservation = reservationRepository.findAll();
        LocalDate currentDate = LocalDate.now();

        for (Reservation reservations : reservation) {
            if ( reservations.getStatus() == 1) {
                if (currentDate.isAfter(reservations.getCheckOut())) {
                    reservations.setStatus(2);
                    reservations.setStatusName("Past Reservation");
                    reservationRepository.save(reservations);
                }
            } else if (reservations.getStatus() == 2) {
                if (currentDate.isBefore(reservations.getCheckOut())) {
                    reservations.setStatusName("Reserved");
                    reservations.setStatus(1);
                    reservationRepository.save(reservations);
                }
            }
        }
    }

//    private boolean isReserveExists(ReservationList reservationList) {
//        return reservationListRepository.existsByRoomIdAndCheckInAndCheckOut(
//                reservationList.getRoomId().getId(), reservationList.getCheckIn(), reservationList.getCheckOut());
//    }


    public void deleteById(Long id) {
        reservationRepository.deleteById(id);
    }
}








