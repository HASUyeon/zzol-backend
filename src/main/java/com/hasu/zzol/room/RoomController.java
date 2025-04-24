package com.hasu.zzol.room;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/room")
public class RoomController {
    @GetMapping("/detail/{roomNo}")
    public ResponseEntity<Room> getRoomDetail( @PathVariable("roomNo") Integer roomNo) {
        return ResponseEntity.ok(new Room());
    }
}
