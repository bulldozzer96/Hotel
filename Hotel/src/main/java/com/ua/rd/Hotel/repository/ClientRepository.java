package com.ua.rd.Hotel.repository;

import com.ua.rd.Hotel.domain.Clients;

import com.ua.rd.Hotel.dto.ClientDto;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ClientRepository extends JpaRepository<Clients, Long> {

        Optional<Clients> findById(Long id);
        Optional<Clients> findBySurname(String surname);

        Optional<Clients> findByPassport(String passport);

}
