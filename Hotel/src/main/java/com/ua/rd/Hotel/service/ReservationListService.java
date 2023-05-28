package com.ua.rd.Hotel.service;

import com.ua.rd.Hotel.domain.ReservationList;
import com.ua.rd.Hotel.dto.ReservationListDto;
import com.ua.rd.Hotel.repository.ReservationListRepository;
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
        reservationList.setStatus(1);
        reservationList.setStatusName("Reserved");


//            if (isReserveExists(reservationList)) {
//                throw new InvalidDataAccessApiUsageException("Reservation already exists");
//            }

        reservationListRepository.save(reservationList);
    }

    public void changeRoom(Long roomId, Long reservationId) {

        var reservation = reservationListRepository.findById(reservationId).get();
        var room = roomRepository.findById(roomId).get();
        reservation.setRoomId(room);
        reservationListRepository.save(reservation);
    }

    @Scheduled(fixedRate = 60000)
    private void updateBookingStatus() {
        List<ReservationList> reservationList = reservationListRepository.findAll();
        LocalDate currentDate = LocalDate.now();

        for (ReservationList reservations : reservationList) {
            if ( reservations.getStatus() == 1) {
                if (currentDate.isAfter(reservations.getCheckOut())) {
                    reservations.setStatus(2);
                    reservations.setStatusName("Past Reservation");
                    reservationListRepository.save(reservations);
                }
            } else if (reservations.getStatus() == 2) {
                if (currentDate.isBefore(reservations.getCheckOut())) {
                    reservations.setStatusName("Reserved");
                    reservations.setStatus(1);
                    reservationListRepository.save(reservations);
                }
            }
        }
    }

//    private boolean isReserveExists(ReservationList reservationList) {
//        return reservationListRepository.existsByRoomIdAndCheckInAndCheckOut(
//                reservationList.getRoomId().getId(), reservationList.getCheckIn(), reservationList.getCheckOut());
//    }


    public void deleteById(Long id) {
        reservationListRepository.deleteById(id);
    }
}








