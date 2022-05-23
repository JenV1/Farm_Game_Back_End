package com.example.farm_game.service;

import com.example.farm_game.models.Farm;
import com.example.farm_game.models.Field;
import com.example.farm_game.repositories.CropRepository;
import com.example.farm_game.repositories.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class FarmService {

    private final FarmRepository farmRepository;

    @Autowired
    public FarmService(
            FarmRepository farmRepository) {
        this.farmRepository = farmRepository;
    }

    public List<Farm> getFarm() {
        return farmRepository.findAll();
    }

    public Farm getFarm(Long id) throws NotFoundException {
        return farmRepository
                .findById(id)
                .orElseThrow(
                        () -> new NotFoundException(
                                "Farm with id " + id + " not found. Please try again."));
    }

    public void saveFarm(Farm farm) {
        farmRepository.save(farm);
    }

//    public Field buyField(String name, Long int){
//
//    }

}