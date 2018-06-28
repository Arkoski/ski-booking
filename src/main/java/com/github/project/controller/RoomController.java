package com.github.project.controller;

import com.github.project.dto.RoomDTO;
import com.github.project.model.Room;
import com.github.project.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/room")
public class RoomController {
    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/{id}")
    public Room findOneById(@PathVariable Long id) {
        return roomService.findById(id);
    }

    @GetMapping
    public Set<Room> findAll() {
        Set<Room> all = roomService.findAll();
        return new HashSet<>(all);
    }

    @PostMapping
    public Room createRoom(@RequestBody RoomDTO roomDTO) {
        return roomService.createRoom(roomDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
    }
}
