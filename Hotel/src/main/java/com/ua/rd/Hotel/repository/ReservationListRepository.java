package com.ua.rd.Hotel.repository;

import com.ua.rd.Hotel.domain.ReservationList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ReservationListRepository extends JpaRepository<ReservationList, Long> {


    @Query("SELECT CASE WHEN COUNT(rl) > 0 THEN true ELSE false END FROM ReservationList rl " +
            "WHERE rl.roomId = :roomId " +
            "AND rl.checkIn = :checkIn " +
            "AND rl.checkOut = :checkOut")
    boolean existsByRoomIdAndCheckInAndCheckOut(
            @Param("roomId") Long roomId,
            @Param("checkIn") LocalDate checkIn,
            @Param("checkOut") LocalDate checkOut);

}
