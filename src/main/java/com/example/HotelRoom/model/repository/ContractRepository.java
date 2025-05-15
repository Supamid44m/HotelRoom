package com.example.HotelRoom.model.repository;


import com.example.HotelRoom.model.entity.Contract;
import com.example.HotelRoom.model.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {

    Optional<Contract> findByRoomId(Long roomId);
}
