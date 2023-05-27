package com.ua.rd.Hotel.repository;

import com.ua.rd.Hotel.domain.Clients;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



@Repository
public interface ClientRepository extends JpaRepository<Clients, Long> {
}
