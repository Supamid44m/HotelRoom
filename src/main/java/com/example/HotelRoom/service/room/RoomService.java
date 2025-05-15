package com.example.HotelRoom.service.room;


import com.example.HotelRoom.constant.room.ReservationConstant;
import com.example.HotelRoom.constant.room.RoomStatusEnum;
import com.example.HotelRoom.model.dto.ContractInfoDto;
import com.example.HotelRoom.model.dto.RoomInfoDto;
import com.example.HotelRoom.model.dto.TenantInfoDto;
import com.example.HotelRoom.model.entity.*;
import com.example.HotelRoom.model.mapper.RoomMapper;
import com.example.HotelRoom.model.mapper.TenantMapper;
import com.example.HotelRoom.model.repository.*;
import com.example.HotelRoom.model.request.ContractRequest;
import com.example.HotelRoom.model.request.RoomRequest;
import com.example.HotelRoom.model.request.RoomReservationReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RoomService {

    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;
    private final RoomTypeRepository roomTypeRepository;
    private final RoomMapper roomMapper;
    private final ContractRepository contractRepository;
    private final TenantRepository tenantRepository;
    private final TenantMapper tenantMapper;

    @Autowired
    public RoomService(
            RoomRepository roomRepository,
            ReservationRepository reservationRepository,
            RoomTypeRepository roomTypeRepository,
            RoomMapper roomMapper,
            ContractRepository contractRepository,
            TenantRepository tenantRepository,
            TenantMapper tenantMapper
    ) {
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
        this.roomTypeRepository = roomTypeRepository;
        this.roomMapper = roomMapper;
        this.contractRepository = contractRepository;
        this.tenantRepository = tenantRepository;
        this.tenantMapper = tenantMapper;
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
            ContractInfoDto contractInfoDto = new ContractInfoDto();
            Long id = Long.parseLong(roomId);
            Optional<Room> room = roomRepository.findById(id);
            Optional<Tenant> tenant = tenantRepository.findById(request.getTenantId());

            TenantInfoDto tenantInfoDto = new TenantInfoDto();
            RoomInfoDto roomInfoDto = new RoomInfoDto();

            if (tenant.isPresent()) {
                Tenant existingTenant = tenant.get();
                tenantInfoDto = tenantMapper.toDto(existingTenant);
            }


            if (room.isPresent()) {
                Room existingRoom = room.get();
                existingRoom.setStatus(RoomStatusEnum.RESERVED);
                roomRepository.save(existingRoom);
                roomInfoDto = this.roomMapper.toDto(existingRoom);
            }


            Contract contract = new Contract();
            contract.setRoomId(id);
            contract.setTenantId(request.getTenantId());
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
}
