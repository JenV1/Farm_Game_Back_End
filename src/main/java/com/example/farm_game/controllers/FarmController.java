package com.example.farm_game.controllers;

import com.example.farm_game.models.Farm;
import com.example.farm_game.repositories.FarmRepository;
import com.example.farm_game.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FarmController {

    public final FarmService farmService;

    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }

    @GetMapping("/farms")
    public ResponseEntity<List<Farm>> getAllFarms() {
        List<Farm> farms = farmService.getUsers();
        return ResponseEntity.ok().body(farms);
    }

    @GetMapping("/farm/{id}")
    public ResponseEntity<Farm> getSpecificFarm(Long id) {
        Farm farm = farmService.getFarm(id);
        return ResponseEntity.ok().body(farm);
    }

    @PostMapping("/farms")
    public void createFarm(@RequestParam String farmName) {
        Farm newFarm = new Farm(null, farmName, 1000, 0, null);
        farmService.saveFarm(newFarm);
    }


}
