package com.ua.rd.Hotel.service;


import com.ua.rd.Hotel.domain.Clients;
import com.ua.rd.Hotel.domain.ReservationList;
import com.ua.rd.Hotel.dto.ClientDto;
import com.ua.rd.Hotel.dto.ReservationListDto;
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
                .map(ClientService::buildClientDto)
                .collect(Collectors.toList());
    }

public void save(Clients clients) {
    clientRepository.save(clients);
}
    private static ClientDto buildClientDto(Clients clients) {

        return ClientDto.builder()
                .name(clients.getName())
                .reservations(clients.getReservationList()
                        .stream()
                        .map(reservationList -> reservationList.getRoomId().getName())
                        .collect(Collectors.toList()))

                .build();
    }


}
