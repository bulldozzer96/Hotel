package com.ua.rd.Hotel.repository;

import com.ua.rd.Hotel.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



@Repository

public interface RoomRepository extends JpaRepository<Room, Long> {

//    Optional<City> findCityByName(String name);


}
