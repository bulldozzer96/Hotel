package com.ua.rd.Hotel.repository;

import com.ua.rd.Hotel.domain.Clients;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ClientRepository extends JpaRepository<Clients, Long> {


    Clients findBySurname(String surname);
    Clients findByPassport(String passport);

//    Optional<Clients> findById(Long id);
}
