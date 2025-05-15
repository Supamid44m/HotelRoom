package com.example.HotelRoom.service.tenant;


import com.example.HotelRoom.model.dto.TenantInfoDto;
import com.example.HotelRoom.model.entity.Tenant;
import com.example.HotelRoom.model.mapper.TenantMapper;
import com.example.HotelRoom.model.repository.TenantRepository;
//import com.example.HotelRoom.model.request.RoomRequest;
import com.example.HotelRoom.model.request.TenantRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TenantService {

    private final TenantRepository tenantRepository;
    private final TenantMapper tenantMapper;

    @Autowired
    public TenantService(TenantRepository tenantRepository, TenantMapper tenantMapper) {
        this.tenantRepository = tenantRepository;
        this.tenantMapper = tenantMapper;
    }

    public ResponseEntity<TenantInfoDto> register(TenantRequest request) {
        try {
            Tenant tenant = new Tenant();
            tenant.setFirstName(request.getFirstName());
            tenant.setLastName(request.getLastName());
            tenant.setEmail(request.getEmail());
            tenant.setPhone(request.getPhone());
            tenant.setIdCard(request.getIdCard());

            this.tenantRepository.save(tenant);

            TenantInfoDto response = this.tenantMapper.toDto(tenant);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
