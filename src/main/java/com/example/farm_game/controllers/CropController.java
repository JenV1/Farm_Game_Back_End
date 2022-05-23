package com.example.farm_game.controllers;

import com.example.farm_game.models.Crop;
import com.example.farm_game.repositories.CropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CropController {

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
    public void createCrop(@RequestParam String cropName, @RequestParam int price, @RequestParam int stock,
                           @RequestParam int growTime) {
        Crop newCrop = new Crop(null, cropName, price, stock, growTime, null);
        cropRepository.save(newCrop);
    }
}
