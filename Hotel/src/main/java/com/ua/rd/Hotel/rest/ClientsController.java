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
import java.util.Optional;


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

    @PutMapping("/clients/{id}")
    public ResponseEntity<Void> updateClient(@PathVariable("id") Long id, @RequestBody ClientDto clientsDto) {
        Optional<Clients> optionalClient = clientService.findById(id);

        if (optionalClient.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Clients client = optionalClient.get();


        client.setName(clientsDto.getName());
        client.setSurname(clientsDto.getSurname());
        client.setPassport(clientsDto.getPassport());
        client.setPhone(clientsDto.getPhone());
        client.setSex(clientsDto.getSex());

        clientService.save(client);

        return ResponseEntity.ok().build();
    }

}
