package com.example.farm_game.service;

import com.example.farm_game.models.Farm;
import com.example.farm_game.models.Field;
import com.example.farm_game.models.FieldType;
import com.example.farm_game.repositories.CropRepository;
import com.example.farm_game.repositories.FarmRepository;
import com.example.farm_game.repositories.FieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Map;


@Service
public class FieldService {

    private final FieldRepository fieldRepository;
    private final CropRepository cropRepository;
    public final FarmService farmService;
    public final FarmRepository farmRepository;

    @Autowired
    public FieldService(
            FieldRepository fieldRepository, CropRepository cropRepository, FarmService farmService,
            FarmRepository farmRepository) {
        this.fieldRepository = fieldRepository;
        this.cropRepository = cropRepository;
        this.farmService = farmService;
        this.farmRepository = farmRepository;
    }
    public List<Field> getField() {
        return fieldRepository.findAll();
    }

    public Field getField(Long id) throws NotFoundException {
        return fieldRepository
                .findById(id)
                .orElseThrow(
                        () -> new NotFoundException(
                                "Field with id " + id + " not found. Please try again."));
    }

    public void saveField(Field field) {
        fieldRepository.save(field);
    }
    public void deleteField (Field field){
        fieldRepository.deleteById(field.getId());
    }


    public void putCropInField(Long fieldID, Long cropID) {
        Long farmID = fieldRepository.getById(fieldID).getFarm().getId();
        int farmMoney = farmRepository.getById(farmID).getFunds();
        if (cropRepository.getById(cropID).getStock()>=0 &&
        cropRepository.getById(cropID).getPrice()<=farmMoney) {
            fieldRepository.assignCropToField(fieldID, cropID, cropRepository.getById(cropID).getGrowTime());
            farmService.updateMoneyWhenCropBought(farmID, cropRepository.getById(cropID).getPrice());
            cropRepository.reduceStockByOne(cropID);
        }

    }

    public int sellReadyCropsInFields(Long farmID) {
        int moneyMade = fieldRepository.updateMoneyUponAutomaticSelling(farmID);
        fieldRepository.emptyFields(farmID);
        return moneyMade;
    }
}