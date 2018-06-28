package com.github.project.service;

import com.github.project.dto.RoomDTO;
import com.github.project.model.Room;

import java.util.Set;

public interface RoomService {
    Room findById(Long id);
    Set<Room> findAll();
    Room createRoom(RoomDTO client);
    void deleteRoom(Long id);
}
