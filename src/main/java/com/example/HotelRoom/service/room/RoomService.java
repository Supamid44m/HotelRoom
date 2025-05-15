package com.example.HotelRoom.service.room;


import com.example.HotelRoom.constant.room.ReservationConstant;
import com.example.HotelRoom.constant.room.RoomStatusEnum;
import com.example.HotelRoom.model.dto.ContractInfoDto;
import com.example.HotelRoom.model.dto.RoomInfoDto;
import com.example.HotelRoom.model.dto.TenantInfoDto;
import com.example.HotelRoom.model.entity.*;
import com.example.HotelRoom.model.mapper.ContractMapper;
import com.example.HotelRoom.model.mapper.RoomMapper;
import com.example.HotelRoom.model.mapper.TenantMapper;
import com.example.HotelRoom.model.repository.*;
import com.example.HotelRoom.model.request.ContractRequest;
import com.example.HotelRoom.model.request.RoomRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RoomService {

    private final RoomRepository roomRepository;
    private final RoomTypeRepository roomTypeRepository;
    private final RoomMapper roomMapper;
    private final ContractRepository contractRepository;
    private final ContractMapper contractMapper;
    private final TenantRepository tenantRepository;
    private final TenantMapper tenantMapper;

    @Autowired
    public RoomService(
            RoomRepository roomRepository,
            RoomTypeRepository roomTypeRepository,
            RoomMapper roomMapper,
            ContractRepository contractRepository,
            TenantRepository tenantRepository,
            TenantMapper tenantMapper,
            ContractMapper contractMapper
    ) {
        this.roomRepository = roomRepository;
        this.roomTypeRepository = roomTypeRepository;
        this.roomMapper = roomMapper;
        this.contractRepository = contractRepository;
        this.tenantRepository = tenantRepository;
        this.tenantMapper = tenantMapper;
        this.contractMapper = contractMapper;
    }

    public ResponseEntity<List<RoomInfoDto>> getAllRooms() {
        try {
            List<Room> rooms = roomRepository.findAll();
            List<RoomInfoDto> roomsDto = this.roomMapper.toDtoList(rooms);

            return ResponseEntity.ok(roomsDto);

        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }


    public ResponseEntity<RoomInfoDto> createRoom(RoomRequest body) {
        try {
            Room room = new Room();
            RoomType roomType = roomTypeRepository.findById(body.getRoomTypeId()).orElseThrow(() -> new RuntimeException("Room Type not found"));
            room.setRoomNumber(body.getRoomNumber());
            room.setRoomType(roomType);
            roomRepository.save(room);

            RoomInfoDto dto = roomMapper.toDto(room);

            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public ResponseEntity<ContractInfoDto> createContract(String roomId, ContractRequest request) {
        try {
            Contract contract = new Contract();
            ContractInfoDto contractInfoDto = new ContractInfoDto();
            Long id = Long.parseLong(roomId);
            Optional<Room> room = roomRepository.findById(id);
            Optional<Tenant> tenant = tenantRepository.findById(request.getTenantId());


            TenantInfoDto tenantInfoDto = new TenantInfoDto();
            RoomInfoDto roomInfoDto = new RoomInfoDto();

            if (tenant.isPresent()) {
                Tenant existingTenant = tenant.get();
                tenantInfoDto = tenantMapper.toDto(existingTenant);
                contract.setTenant(existingTenant);
            }


            if (room.isPresent()) {
                Room existingRoom = room.get();
                existingRoom.setStatus(RoomStatusEnum.RESERVED);
                roomRepository.save(existingRoom);
                roomInfoDto = this.roomMapper.toDto(existingRoom);
                contract.setRoom(existingRoom);
            }


            contract.setCreateDate(LocalDate.now());
            contract.setEndDate(LocalDate.now());
            contract.setStartDate(LocalDate.now());
            contract.setStatus("paid");
            contract.setUpdateDate(LocalDate.now());
            contractRepository.save(contract);


            contractInfoDto.setStartDate(contract.getStartDate());
            contractInfoDto.setEndDate(contract.getEndDate());
            contractInfoDto.setRoomInfo(roomInfoDto);
            contractInfoDto.setTenantInfo(tenantInfoDto);

            return ResponseEntity.ok(contractInfoDto);
        } catch (Exception error) {
            throw new RuntimeException(error);
        }
    }


    public ResponseEntity<ContractInfoDto> getContract(String id) {
        try {
            Long roomId = Long.parseLong(id);
            Optional<Contract> contract = contractRepository.findByRoomId(roomId);
            ContractInfoDto contractInfoDto = new ContractInfoDto();


            if (contract.isPresent()) {
                Contract existingContract = contract.get();
                Optional<Room> room = roomRepository.findById(existingContract.getRoom().getId());
                Optional<Tenant> tenant = tenantRepository.findById(existingContract.getTenant().getId());


                contractInfoDto = this.contractMapper.toDto(existingContract);

                if (tenant.isPresent()) {
                    contractInfoDto.setTenantInfo(this.tenantMapper.toDto(tenant.get()));
                }
                if (room.isPresent()) {
                    contractInfoDto.setRoomInfo(this.roomMapper.toDto(room.get()));
                }
            }



            return ResponseEntity.ok(contractInfoDto);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
