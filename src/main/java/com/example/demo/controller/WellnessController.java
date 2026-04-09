package com.example.demo.controller;

import com.example.demo.entity.WellnessData;
import com.example.demo.service.WellnessService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wellness")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5173"})
public class WellnessController {

    private final WellnessService service;

    public WellnessController(WellnessService service) {
        this.service = service;
    }

    @GetMapping("/{userId}")
    public List<WellnessData> getUserData(@PathVariable Long userId) {
        return service.getUserData(userId);
    }

    @PostMapping
    public WellnessData saveData(@RequestBody WellnessData data) {
        return service.saveOrUpdateData(data);
    }
}