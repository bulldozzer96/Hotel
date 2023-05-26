package com.ua.rd.Hotel.repository;
import com.ua.rd.Hotel.domain.Clients;

import com.ua.rd.Hotel.domain.ReservationList;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Repository
public interface ReservationListRepository extends JpaRepository<ReservationList, Long> {

//    Optional<ReservationList> findByCheckIn(LocalDate checkIn);
//    Optional<ReservationList> findByCheckOut(LocalDate checkOut);

//    Optional<ReservationList> findAllByCheckInLessThanEqualAndCheckOutGreaterThanEqual(LocalDate checkIn, LocalDate checkOut);
//
//    Optional<ReservationList> findAllAvailableForReservationRooms(LocalDate checkIn, LocalDate checkOut);
}
