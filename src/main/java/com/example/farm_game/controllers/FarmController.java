package com.example.farm_game.controllers;

import com.example.farm_game.models.Farm;
import com.example.farm_game.repositories.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class FarmController {

    @Autowired
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
    public ResponseEntity<Farm> createFarm(@RequestBody Farm farm) {
        Farm result = farmRepository.save(farm);
        return ResponseEntity.ok().body(result);
    }
}
