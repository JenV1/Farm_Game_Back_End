package com.example.farm_game.controllers;

import com.example.farm_game.models.Crop;
import com.example.farm_game.repositories.CropRepository;
import com.example.farm_game.service.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CropController {

    public final CropService cropService;

    public CropController(CropService cropService) {
        this.cropService = cropService;
    }

    @GetMapping("/crops")
    public ResponseEntity<List<Crop>> getAllCrops() {
        List<Crop> crops = cropService.getCrop();
        return ResponseEntity.ok().body(crops);
    }

    @GetMapping("/crop/{id}")
    public ResponseEntity<Crop> getSpecificCrop(Long id) {
        Crop crop = cropService.getCrop(id);
        return ResponseEntity.ok().body(crop);
    }

    @PostMapping("/crops")
    public void createCrop(@RequestParam String cropName, @RequestParam int price, @RequestParam int stock,
                           @RequestParam int growTime) {
        Crop newCrop = new Crop(null, cropName, price, stock, growTime, null);
        cropService.saveCrop(newCrop);
    }
}
