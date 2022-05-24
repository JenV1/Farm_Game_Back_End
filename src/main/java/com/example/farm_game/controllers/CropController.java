package com.example.farm_game.controllers;

import com.example.farm_game.models.Crop;
import com.example.farm_game.repositories.CropRepository;
import com.example.farm_game.service.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Date;
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
                           @RequestParam int growTime, @RequestParam int sellPrice) {
        Crop newCrop = new Crop(null, cropName, price, stock, growTime, null, sellPrice);
        cropService.saveCrop(newCrop);
    }

    @DeleteMapping("/deleteCrop/{id}")
    public void deleteCrop(@PathVariable Long id){cropService.deleteCrop(cropService.getCrop(id));
    }

    @PutMapping("/updateCrop/{id}")
    @Transactional
    public void updateCrop(@PathVariable Long id,
                               @RequestParam(required = false) String name,
                               @RequestParam(required = false) int price,
                               @RequestParam(required = false) int stock,
                           @RequestParam(required = false) int growTime){
        Crop crop = cropService.cropRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("A crop with ID " + id + " does not exist"));
        if(name != null){
            crop.setName(name);
        }
        if(price != 0){
            crop.setPrice(price);
        }
        if(stock != 0){
            crop.setStock(stock);
        }
        if(growTime != 0){
            crop.setGrowTime(growTime);
        }
    }

}
