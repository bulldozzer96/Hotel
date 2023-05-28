package com.ua.rd.Hotel.rest;

import com.ua.rd.Hotel.domain.Clients;
import com.ua.rd.Hotel.dto.ClientDto;
import com.ua.rd.Hotel.service.ClientService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class ClientsController {

    @Autowired
    private final ClientService clientService;

    @GetMapping("/clients")
    public ResponseEntity<List<ClientDto>> findAll() {
        return ResponseEntity.ok(clientService.findAll());
    }

    @PostMapping("/clients")
    public ResponseEntity<Void> save(@RequestBody Clients clients) {
        clientService.save(clients);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping("/client/passport/{passport}")
    public ResponseEntity<ClientDto> findByPassport(@PathVariable String passport) {
        try {
            return ResponseEntity.ok(clientService.findByPassport(passport));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @GetMapping("/client/surname/{surname}")
    public ResponseEntity<ClientDto> findBySurname(@PathVariable String surname) {
        try {
        return ResponseEntity.ok(clientService.findBySurname(surname));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PutMapping("/client/{id}")
    public ResponseEntity<Void> updateClient(@PathVariable("id") Long id, @RequestBody ClientDto clientsDto) {
        Clients client = clientService.findById(id);
        if (client == null) {
            return ResponseEntity.notFound().build();
        }
        client.setName(clientsDto.getName());
        client.setSurname(clientsDto.getSurname());
        client.setPassport(clientsDto.getPassport());
        client.setPhone(clientsDto.getPhone());
        client.setSex(clientsDto.getSex());
        clientService.save(client);
        return ResponseEntity.ok().build();
    }




}



