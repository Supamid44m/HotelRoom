package com.example.HotelRoom.model.repository;


import com.example.HotelRoom.model.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
}
