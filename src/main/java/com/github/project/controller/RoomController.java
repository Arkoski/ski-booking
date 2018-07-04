package com.github.project.controller;

import com.github.project.dto.RoomDTO;
import com.github.project.model.Room;
import com.github.project.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/room")
public class RoomController {
    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public RoomDTO findOneById(@PathVariable Long id) {
        return new RoomDTO(roomService.findById(id));
    }

    @GetMapping
    public String findAll(Model model) {
        Set<Room> all = roomService.findAll();
        model.addAttribute("rooms", all.stream().map(RoomDTO::new).collect(Collectors.toSet()));
        return "room";
    }

    @PostMapping
    @ResponseBody
    public RoomDTO createRoom(@RequestBody RoomDTO roomDTO) {
        return new RoomDTO(roomService.createRoom(roomDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
    }
}
