package com.example.farm_game.controllers;

import com.example.farm_game.repositories.FieldRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FieldController {

    public final FieldRepository fieldRepository;

    public FieldController(FieldRepository fieldRepository) {
        this.fieldRepository = fieldRepository;
    }
}
