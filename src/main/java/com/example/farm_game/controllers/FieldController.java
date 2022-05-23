package com.example.farm_game.controllers;

import com.example.farm_game.models.Crop;
import com.example.farm_game.models.Field;
import com.example.farm_game.repositories.CropRepository;
import com.example.farm_game.repositories.FarmRepository;
import com.example.farm_game.repositories.FieldRepository;
import com.example.farm_game.repositories.FieldTypeRepository;
import com.example.farm_game.service.CropService;
import com.example.farm_game.service.FarmService;
import com.example.farm_game.service.FieldService;
import com.example.farm_game.service.FieldTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FieldController {

//    public final FieldRepository fieldRepository;
//    public final FieldTypeRepository fieldTypeRepository;
//    public final FarmRepository farmRepository;
//    public final CropRepository cropRepository;
//
//    public FieldController(FieldRepository fieldRepository, FieldTypeRepository fieldTypeRepository,
//                           FarmRepository farmRepository, CropRepository cropRepository) {
//        this.fieldRepository = fieldRepository;
//        this.fieldTypeRepository = fieldTypeRepository;
//        this.farmRepository = farmRepository;
//        this.cropRepository = cropRepository;
//    }

    public final FieldService fieldService;
    public final FieldTypeService fieldTypeService;
    public final FarmService farmService;
    public final CropService cropService;

    public FieldController(FieldService fieldService, FieldTypeService fieldTypeService,
                           FarmService farmService, CropService cropService) {
        this.fieldService = fieldService;
        this.fieldTypeService = fieldTypeService;
        this.farmService = farmService;
        this.cropService = cropService;
    }

    @GetMapping("/fields")
    public ResponseEntity<List<Field>> getAllFields() {
        List<Field> fields = fieldService.getField();
        return ResponseEntity.ok().body(fields);
    }

    @GetMapping("/field/{id}")
    public ResponseEntity<Field> getSpecificField(Long id) {
        Field field = fieldService.getField(id);
        return ResponseEntity.ok().body(field);
    }

    @PostMapping("/fields")
    public void createField(@RequestParam String fieldName, @RequestParam int size,
                                             @RequestParam int cost, @RequestParam Long farmID,
                            @RequestParam Long fieldTypeID, @RequestParam Long cropID) {
        if (cropService.getCrop(cropID) != null && fieldTypeService.getFieldType(fieldTypeID) != null
        && farmService.getFarm(farmID) != null) {
            Field newField = new Field(null, fieldName, cropService.getCrop(cropID).getGrowTime(),
                    fieldTypeService.getFieldType(fieldTypeID),
                    cropService.getCrop(cropID), farmService.getFarm(farmID));
            fieldService.saveField(newField);
        }

    }
}
