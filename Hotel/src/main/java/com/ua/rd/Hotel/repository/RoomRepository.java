package com.ua.rd.Hotel.repository;

import com.ua.rd.Hotel.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository

public interface RoomRepository extends JpaRepository<Room, Long> {

    Optional<Room> findRoomByName(String name);

    Optional<Room> deleteRoomByName(String name);

    Optional<Room> findByFloor(int floor);

    Optional<Room> findById(Long id);




}
