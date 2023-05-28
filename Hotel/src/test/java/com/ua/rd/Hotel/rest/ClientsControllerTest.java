package com.ua.rd.Hotel.rest;

import com.ua.rd.Hotel.domain.Clients;
import com.ua.rd.Hotel.dto.ClientDto;
import com.ua.rd.Hotel.service.ClientService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

import static org.junit.Assert.*;;


@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class ClientsControllerTest {
    @Mock
    private ClientService clientsService;
    @InjectMocks
    private ClientsController clientsController;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(clientsController).build();
    }

    @Test
    public void findAll() throws Exception {

        List<ClientDto> clientList = new ArrayList<>();
        clientList.add(ClientDto.builder().name("John").surname("Doe").passport("ABC123").phone("1234567890").sex("Male").build());
        clientList.add(ClientDto.builder().name("Jane").surname("Smith").passport("DEF456").phone("9876543210").sex("Female").build());
        when(clientsService.findAll()).thenReturn(clientList);
        mockMvc.perform(get("/clients"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", is("John")))
                .andExpect(jsonPath("$[0].surname", is("Doe")))
                .andExpect(jsonPath("$[0].passport", is("ABC123")))
                .andExpect(jsonPath("$[0].phone", is("1234567890")))
                .andExpect(jsonPath("$[0].sex", is("Male")))
                .andExpect(jsonPath("$[1].name", is("Jane")))
                .andExpect(jsonPath("$[1].surname", is("Smith")))
                .andExpect(jsonPath("$[1].passport", is("DEF456")))
                .andExpect(jsonPath("$[1].phone", is("9876543210")))
                .andExpect(jsonPath("$[1].sex", is("Female")));
    }


    @Test
    public void save() throws Exception {
        ClientDto clientDto = ClientDto.builder().name("John").surname("Doe").passport("ABC123").phone("1234567890").sex("Male").build();
        String requestBody = new ObjectMapper().writeValueAsString(clientDto);

        mockMvc.perform(post("/clients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isCreated());
    }

    @Test
    public void findByPassport() throws Exception {
        String passport = "ABC123";
        ClientDto clientDto = ClientDto.builder()
                .name("John")
                .surname("Doe")
                .passport(passport)
                .phone("1234567890")
                .sex("Male")
                .build();

        when(clientsService.findByPassport("ABC123")).thenReturn(clientDto);


        mockMvc.perform(get("/client/passport/{passport}", passport))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("John")))
                .andExpect(jsonPath("$.surname", is("Doe")))
                .andExpect(jsonPath("$.passport", is(passport)))
                .andExpect(jsonPath("$.phone", is("1234567890")))
                .andExpect(jsonPath("$.sex", is("Male")));
    }

    @Test
    public void findBySurname() throws Exception {
        String surname = "ABC123";
        ClientDto clientDto = ClientDto.builder()
                .name("John")
                .surname(surname)
                .passport("ABC123")
                .phone("1234567890")
                .sex("Male")
                .build();

        when(clientsService.findBySurname("ABC123")).thenReturn(clientDto);


        mockMvc.perform(get("/client/surname/{surname}", surname))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("John")))
                .andExpect(jsonPath("$.surname", is(surname)))
                .andExpect(jsonPath("$.passport", is("ABC123")))
                .andExpect(jsonPath("$.phone", is("1234567890")))
                .andExpect(jsonPath("$.sex", is("Male")));

    }

    @Test
    public void updateClient() throws Exception {

//        Long clientId = 1L;
//        ClientDto updatedClientDto = ClientDto.builder()
//                .name("John")
//                .surname("Doe")
//                .passport("ABC123")
//                .phone("1234567890")
//                .sex("Male")
//                .build();
//
//
//        when(clientsService.findById(anyLong())).thenReturn(new Clients());
//
//
//        mockMvc.perform(put("/client/{id}", clientId)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(asJsonString(updatedClientDto)))
//                .andExpect(status().isOk());




//        Long clientId = 1L;
//        ClientDto updatedClientDto = ClientDto.builder()
//                .name("John")
//                .surname("Doe")
//                .passport("ABC123")
//                .phone("9876543210")
//                .sex("Male")
//                .build();
//
//        Clients existingClient = new Clients();
//        existingClient.setId(clientId);
//        existingClient.setName("Jane");
//        existingClient.setSurname("Smith");
//        existingClient.setPassport("DEF456");
//        existingClient.setPhone("1234567890");
//        existingClient.setSex("Female");
//
//        when(clientsService.findById(anyLong())).thenReturn(existingClient);
//
//
//        mockMvc.perform(put("/client/{id}", clientId)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{ \"name\": \"John\", \"surname\": \"Doe\", \"passport\": \"ABC123\", \"phone\": \"9876543210\", \"sex\": \"Male\" }"))
//                .andExpect(status().isOk());
//
//        assertEquals("John", existingClient.getName());
//        assertEquals("Doe", existingClient.getSurname());
//        assertEquals("ABC123", existingClient.getPassport());
//        assertEquals("9876543210", existingClient.getPhone());
//        assertEquals("Male", existingClient.getSex());
//

    }


    private static String asJsonString(Object object) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }

    }
