package com.ua.rd.Hotel.repository;

import com.ua.rd.Hotel.domain.ReservationList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationListRepository extends JpaRepository<ReservationList, Long> {


}
