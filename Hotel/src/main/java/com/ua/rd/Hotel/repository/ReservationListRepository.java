package com.ua.rd.Hotel.repository;
import com.ua.rd.Hotel.domain.Clients;

import com.ua.rd.Hotel.domain.ReservationList;
import com.ua.rd.Hotel.dto.ReservationListDto;
import com.ua.rd.Hotel.dto.RoomDto;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Repository
public interface ReservationListRepository extends JpaRepository<ReservationList, Long> {


}
