package com.example.farm_game.controllers;

import com.example.farm_game.models.Crop;
import com.example.farm_game.repositories.CropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CropController {

    @Autowired
    public final CropRepository cropRepository;

    public CropController (CropRepository cropRepository) {
        this.cropRepository = cropRepository;
    }

    @GetMapping("/crops")
    public ResponseEntity<List<Crop>> getAllCrops() {
        List<Crop> crops = cropRepository.findAll();
        return ResponseEntity.ok().body(crops);
    }

    @GetMapping("/crop/{id}")
    public ResponseEntity<Optional<Crop>> getSpecificCrop(Long id) {
        Optional<Crop> crop = cropRepository.findById(id);
        return ResponseEntity.ok().body(crop);
    }

    @PostMapping("/crops")
    public ResponseEntity<Crop> createCrop(@RequestBody Crop crop) {
        Crop result = cropRepository.save(crop);
        return ResponseEntity.ok().body(result);
    }
}
