package com.example.farm_game.service;


import com.example.farm_game.models.Crop;
import com.example.farm_game.repositories.CropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class CropService {

    private final CropRepository cropRepository;

    @Autowired
    public CropService(
            CropRepository cropRepository) {
        this.cropRepository = cropRepository;
    }

    List<Crop> getCrop() {
        return (List<Crop>) cropRepository.findAll();
    }

    Crop getCrop(Long id) throws NotFoundException {
        return cropRepository
                .findById(id)
                .orElseThrow(
                        () -> new NotFoundException(
                                "Crop with id " + id + " not found. Please try again."));
    }
}