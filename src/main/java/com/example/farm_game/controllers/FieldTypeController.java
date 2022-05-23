package com.example.farm_game.controllers;

import com.example.farm_game.models.FieldType;
import com.example.farm_game.repositories.FieldTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<FieldType> createFieldType(@RequestBody FieldType fieldtype) {
        FieldType result = fieldTypeRepository.save(fieldtype);
        return ResponseEntity.ok().body(result);
    }
}
