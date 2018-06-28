package com.github.project.service.implementation;

import com.github.project.dto.RoomDTO;
import com.github.project.model.Room;
import com.github.project.repository.RoomRepository;
import com.github.project.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RoomServiceImpl implements RoomService {
    private RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Room findById(Long id) {
        return roomRepository.findOne(id);
    }

    @Override
    public Set<Room> findAll() {
        return new HashSet<>(roomRepository.findAll());
    }

    @Override
    public Room createRoom(RoomDTO roomDTO) {
        Room room = new Room();
        room.setPrice(roomDTO.getPrice());
        room.setRoomSize(roomDTO.getRoomSize());

        return roomRepository.save(room);
    }

    @Override
    public void deleteRoom(Long id) {
        roomRepository.delete(id);
    }
}
