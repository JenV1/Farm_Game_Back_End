package com.example.farm_game.service;

import com.example.farm_game.models.Field;
import com.example.farm_game.models.FieldType;
import com.example.farm_game.repositories.CropRepository;
import com.example.farm_game.repositories.FieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;


@Service
public class FieldService {

    private final FieldRepository fieldRepository;

    @Autowired
    public FieldService(
            FieldRepository fieldRepository) {
        this.fieldRepository = fieldRepository;
    }
    public List<Field> getField() {
        return fieldRepository.findAll();
    }

    public Field getField(Long id) throws NotFoundException {
        return fieldRepository
                .findById(id)
                .orElseThrow(
                        () -> new NotFoundException(
                                "Field with id " + id + " not found. Please try again."));
    }

    public void saveField(Field field) {
        fieldRepository.save(field);
    }
}