package com.example.HotelRoom.model.repository;

import com.example.HotelRoom.constant.room.ReservationConstant;
import com.example.HotelRoom.model.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {


    Optional<Reservation> findTopByRoomIdAndStatusOrderByIdDesc(Long roomId, ReservationConstant.Status status);
}
