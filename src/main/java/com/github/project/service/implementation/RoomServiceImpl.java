package com.github.project.service.implementation;

import com.github.project.dto.RoomDTO;
import com.github.project.exceptions.ValidationError;
import com.github.project.exceptions.ValidationException;
import com.github.project.model.Room;
import com.github.project.repository.RoomRepository;
import com.github.project.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
        Room room = roomRepository.findOne(id);
        validateFindById(room);
        return room;
    }

    @Override
    public Set<Room> findAll() {
        return new HashSet<>(roomRepository.findAll());
    }

    @Override
    public Room createRoom(RoomDTO roomDTO) {
        validateCreation(roomDTO.getPrice(), roomDTO.getRoomSize());
        Room room = new Room();
        room.setPrice(roomDTO.getPrice());
        room.setRoomSize(roomDTO.getRoomSize());

        return roomRepository.save(room);
    }

    @Override
    public void deleteRoom(Long id) {
        Room room = roomRepository.findOne(id);
        validateFindById(room);
        roomRepository.delete(id);
    }

    private void validateCreation(BigDecimal price, Integer roomSize) {
        List<ValidationError> errors = new ArrayList<>();
        if (price == null) {
            ValidationError error = new ValidationError("price", "May not be null");
            errors.add(error);
        }

        if (roomSize == null) {
            ValidationError error = new ValidationError("Room Size", "May not be null");
            errors.add(error);
        }

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }

    private void validateFindById(Room room) {
        List<ValidationError> errors = new ArrayList<>();
        if (room == null) {
            ValidationError error = new ValidationError("id", "Wrong id");
            errors.add(error);
        }

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }
    }
}
