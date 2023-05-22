package com.ua.rd.Hotel.repository;
import com.ua.rd.Hotel.domain.Clients;

import com.ua.rd.Hotel.domain.ReservationList;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ReservationListRepository extends JpaRepository<ReservationList, Long> {
}
