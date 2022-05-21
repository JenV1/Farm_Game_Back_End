package com.example.farm_game.controllers;

import com.example.farm_game.repositories.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FarmController {

    @Autowired
    public final FarmRepository farmRepository;

    public FarmController (FarmRepository farmRepository) {
        this.farmRepository = farmRepository;
    }
}
