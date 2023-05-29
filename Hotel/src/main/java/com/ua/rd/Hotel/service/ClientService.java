package com.ua.rd.Hotel.service;
import com.ua.rd.Hotel.domain.Client;
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
                .map((Client client) -> buildClientDto(client))
                .collect(Collectors.toList());
    }

public void save(Client client) {
    clientRepository.save(client);
}
    private static ClientDto buildClientDto(Client client) {

        return ClientDto.builder()
                .name(client.getName())
                .surname(client.getSurname())
                .passport(client.getPassport())
                .phone(client.getPhone())
                .sex(client.getSex())
                .reservationsId(client.getReservation()
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

    public Client findById(Long id) {
        return clientRepository.findById(id).get();
    }
}
