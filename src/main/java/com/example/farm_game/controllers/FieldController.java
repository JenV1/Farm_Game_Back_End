package com.example.farm_game.controllers;

import com.example.farm_game.models.Field;
import com.example.farm_game.repositories.FarmRepository;
import com.example.farm_game.repositories.FieldRepository;
import com.example.farm_game.repositories.FieldTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FieldController {

    public final FieldRepository fieldRepository;
    public final FieldTypeRepository fieldTypeRepository;
    public final FarmRepository farmRepository;

    public FieldController(FieldRepository fieldRepository, FieldTypeRepository fieldTypeRepository,
                           FarmRepository farmRepository) {
        this.fieldRepository = fieldRepository;
        this.fieldTypeRepository = fieldTypeRepository;
        this.farmRepository = farmRepository;
    }

    @GetMapping("/fields")
    public ResponseEntity<List<Field>> getAllFields() {
        List<Field> fields = fieldRepository.findAll();
        return ResponseEntity.ok().body(fields);
    }

    @GetMapping("/field/{id}")
    public ResponseEntity<Optional<Field>> getSpecificField(Long id) {
        Optional<Field> field = fieldRepository.findById(id);
        return ResponseEntity.ok().body(field);
    }

    @PostMapping("/fields")
    public void createField(@RequestParam String fieldName, @RequestParam int size,
                                             @RequestParam int cost, @RequestParam Long farmID,
                            @RequestParam Long fieldTypeID) {
        Field newField = new Field(null, fieldName, 0, fieldTypeRepository.getById(fieldTypeID),
                null,  farmRepository.getById(farmID));
        fieldRepository.save(newField);
    }
}
