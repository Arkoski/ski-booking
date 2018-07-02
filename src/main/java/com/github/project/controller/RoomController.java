package com.github.project.controller;

import com.github.project.dto.RoomDTO;
import com.github.project.model.Room;
import com.github.project.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/room")
public class RoomController {
    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/{id}")
    public RoomDTO findOneById(@PathVariable Long id) {
        return new RoomDTO(roomService.findById(id));
    }

    @GetMapping
    public Set<RoomDTO> findAll() {
        Set<Room> all = roomService.findAll();
        return all.stream().map(room -> new RoomDTO(room)).collect(Collectors.toSet());
    }

    @PostMapping
    public RoomDTO createRoom(@RequestBody RoomDTO roomDTO) {
        return new RoomDTO(roomService.createRoom(roomDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
    }
}
