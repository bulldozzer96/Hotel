package com.ua.rd.Hotel.repository;

import com.ua.rd.Hotel.domain.Client;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {


    Client findBySurname(String surname);
    Client findByPassport(String passport);

}
