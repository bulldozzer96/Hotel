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


}
