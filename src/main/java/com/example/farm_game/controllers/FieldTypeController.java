package com.example.farm_game.controllers;

import com.example.farm_game.models.FieldType;
import com.example.farm_game.repositories.FieldTypeRepository;
import com.example.farm_game.service.FieldTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FieldTypeController {

    public final FieldTypeService fieldTypeService;

    public FieldTypeController(FieldTypeService fieldTypeService) {
        this.fieldTypeService = fieldTypeService;
    }

    @GetMapping("/fieldtypes")
    public ResponseEntity<List<FieldType>> getAllFieldTypes() {
        List<FieldType> fieldtypes = fieldTypeService.getAll();
        return ResponseEntity.ok().body(fieldtypes);
    }

    @GetMapping("/fieldtype/{id}")
    public ResponseEntity<FieldType> getSpecificFieldType(Long id) {
        FieldType fieldtype = fieldTypeService.getFieldType(id);
        return ResponseEntity.ok().body(fieldtype);
    }

    @PostMapping("/fieldtypes")
    public void createFieldType(@RequestParam String fieldTypeName, @RequestParam int fieldTypeSize,
                                @RequestParam int fieldTypeCost) {
        FieldType newFieldType = new FieldType(null, fieldTypeName, fieldTypeSize, fieldTypeCost,
                null);
        fieldTypeService.saveFieldType(newFieldType);
    }
}
