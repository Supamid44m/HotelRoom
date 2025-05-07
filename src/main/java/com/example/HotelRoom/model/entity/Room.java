package com.example.HotelRoom.model.entity;


import com.example.HotelRoom.constant.room.RoomStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "room")
@Data
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "room_number")
    private String roomNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private RoomStatusEnum status = RoomStatusEnum.EMPTY;


    @ManyToOne()
    @JoinColumn(name = "room_type_Id", nullable = false)
    private RoomType roomType;

}
