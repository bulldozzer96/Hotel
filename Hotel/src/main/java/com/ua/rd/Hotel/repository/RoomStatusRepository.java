package com.ua.rd.Hotel.repository;

import com.ua.rd.Hotel.domain.RoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomStatusRepository extends JpaRepository<RoomStatus, Integer> {

}
