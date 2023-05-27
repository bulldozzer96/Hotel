package com.ua.rd.Hotel.repository;


import com.ua.rd.Hotel.domain.Clients;
import com.ua.rd.Hotel.domain.Room;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Repository

public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("SELECT r.name  FROM Room r WHERE r.id NOT IN (SELECT rl.roomId.id FROM ReservationList rl WHERE rl.checkIn <= :checkOut AND rl.checkOut >= :checkIn)")
    List<String> findRoomNamesNotReservationListInRange(@Param("checkIn") LocalDate checkIn, @Param("checkOut") LocalDate checkOut);

    @Query("SELECT r  FROM Room r WHERE r.id NOT IN (SELECT rl.roomId.id FROM ReservationList rl WHERE rl.checkIn <= :checkOut AND rl.checkOut >= :checkIn)")
    List<Room> findRoomsNotReservationListInRange(@Param("checkIn") LocalDate checkIn, @Param("checkOut") LocalDate checkOut);

    Optional<Room> findById(Long id);
}