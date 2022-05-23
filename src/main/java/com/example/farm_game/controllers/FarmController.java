package com.example.farm_game.controllers;

import com.example.farm_game.models.Farm;
import com.example.farm_game.repositories.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FarmController {

    public final FarmRepository farmRepository;

    public FarmController (FarmRepository farmRepository) {
        this.farmRepository = farmRepository;
    }

    @GetMapping("/farms")
    public ResponseEntity<List<Farm>> getAllFarms() {
        List<Farm> farms = farmRepository.findAll();
        return ResponseEntity.ok().body(farms);
    }

    @GetMapping("/farm/{id}")
    public ResponseEntity<Optional<Farm>> getSpecificFarm(Long id) {
        Optional<Farm> farm = farmRepository.findById(id);
        return ResponseEntity.ok().body(farm);
    }

    @PostMapping("/farms")
    public void createFarm(@RequestParam String farmName) {
        Farm newFarm = new Farm(null, farmName, 1000, 0, null);
        farmRepository.save(newFarm);
    }
}
