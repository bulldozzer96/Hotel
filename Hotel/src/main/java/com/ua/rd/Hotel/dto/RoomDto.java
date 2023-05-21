package com.ua.rd.Hotel.dto;
import lombok.Builder;
import lombok.Data;




@Data
@Builder
public class RoomDto {

    private String name;
    private int price;
    private int floor;
    private String roomStatus;



}
