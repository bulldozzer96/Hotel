package com.ua.rd.Hotel.service;


import com.ua.rd.Hotel.domain.Clients;


import com.ua.rd.Hotel.dto.ClientDto;

import com.ua.rd.Hotel.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;

@Service

@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream()
                .map((Clients clients) -> buildClientDto(clients))
                .collect(Collectors.toList());
    }

public void save(Clients clients) {
    clientRepository.save(clients);
}
    private static ClientDto buildClientDto(Clients clients) {

        return ClientDto.builder()
                .name(clients.getName())
                .surname(clients.getSurname())
                .passport(clients.getPassport())
                .phone(clients.getPhone())
                .sex(clients.getSex())
//                .reservationStatusName(clients.getReservationList()
//                        .stream()
//                        .map(reservationList -> reservationList.getStatusName())
//                        .collect(Collectors.toList()))
                .reservationsId(clients.getReservationList()
                        .stream()
                        .map(reservationList -> reservationList.getId())
                        .collect(Collectors.toList()))
               .build();
    }

    public ClientDto findBySurname(String surname) {
        return buildClientDto(clientRepository.findBySurname(surname));
    }


    public ClientDto findByPassport(String passport) {
        return buildClientDto(clientRepository.findByPassport(passport));
    }

    public Clients findById(Long id) {
        return clientRepository.findById(id).get();
    }






}
