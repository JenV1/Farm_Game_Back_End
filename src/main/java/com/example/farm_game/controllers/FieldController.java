package com.example.farm_game.controllers;

import com.example.farm_game.models.Field;
import com.example.farm_game.repositories.FieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class FieldController {

    @Autowired
    public final FieldRepository fieldRepository;

    public FieldController(FieldRepository fieldRepository) {
        this.fieldRepository = fieldRepository;
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
    public ResponseEntity<Field> createField(@RequestBody Field field) {
        Field result = fieldRepository.save(field);
        return ResponseEntity.ok().body(result);
    }
}
