package com.example.farm_game.controllers;

import com.example.farm_game.repositories.CropRespository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CropController {

    public final CropRespository cropRespository;

    public CropController (CropRespository cropRespository) {
        this.cropRespository = cropRespository;
    }
}
