package com.example.HotelRoom.model.request;

import lombok.Data;

@Data
public class TenantRequest {

    private String firstName;

    private String lastName;

    private String phone;

    private String email;

    private String idCard;
}
