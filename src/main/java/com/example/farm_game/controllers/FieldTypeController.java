package com.example.farm_game.controllers;

import com.example.farm_game.repositories.FieldTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FieldTypeController {

    @Autowired
    public final FieldTypeRepository fieldTypeRepository;

    public FieldTypeController(FieldTypeRepository fieldTypeRepository) {
        this.fieldTypeRepository = fieldTypeRepository;
    }
}
