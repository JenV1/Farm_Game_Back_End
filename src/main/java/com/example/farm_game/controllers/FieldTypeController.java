package com.example.farm_game.controllers;

import com.example.farm_game.models.FieldType;
import com.example.farm_game.repositories.FieldTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FieldTypeController {

    public final FieldTypeRepository fieldTypeRepository;

    public FieldTypeController(FieldTypeRepository fieldTypeRepository) {
        this.fieldTypeRepository = fieldTypeRepository;
    }

    @GetMapping("/fieldtypes")
    public ResponseEntity<List<FieldType>> getAllFieldTypes() {
        List<FieldType> fieldtypes = fieldTypeRepository.findAll();
        return ResponseEntity.ok().body(fieldtypes);
    }

    @GetMapping("/fieldtype/{id}")
    public ResponseEntity<Optional<FieldType>> getSpecificFieldType(Long id) {
        Optional<FieldType> fieldtype = fieldTypeRepository.findById(id);
        return ResponseEntity.ok().body(fieldtype);
    }

    @PostMapping("/fieldtypes")
    public void createFieldType(@RequestParam String fieldTypeName, @RequestParam int fieldTypeSize,
                                @RequestParam int fieldTypeCost) {
        FieldType newFieldType = new FieldType(null, fieldTypeName, fieldTypeSize, fieldTypeCost,
                null);
        fieldTypeRepository.save(newFieldType);
    }
}
