package com.example.farm_game.service;

import com.example.farm_game.models.Farm;
import com.example.farm_game.models.Field;
import com.example.farm_game.models.FieldType;
import com.example.farm_game.repositories.CropRepository;
import com.example.farm_game.repositories.FarmRepository;
import org.apache.commons.lang3.ObjectUtils;
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

    public Field purchaseField(Farm farm, String name, FieldType fieldType){
        if(fieldType == null) {
            throw new RuntimeException();
        } else {
            Field newField = new Field();
            newField.setName(name);
            newField.setFieldType(fieldType);
            newField.setFarm(farm);
            farm.addField(newField);
            return newField;
        }
    }

}