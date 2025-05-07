package com.example.HotelRoom.controller.tanent;

import com.example.HotelRoom.model.dto.TenantInfoDto;
import com.example.HotelRoom.model.request.TenantRequest;
import com.example.HotelRoom.service.tenant.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tenant")
public class TenantController {

    private final TenantService tenantService;

    @Autowired
    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @PostMapping("/register")
    public ResponseEntity<TenantInfoDto> register(@RequestBody TenantRequest request) {
        return this.tenantService.register(request);
    }
}
