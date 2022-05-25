package com.example.farm_game.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FieldRepositoryTest {

    @Autowired
    FieldRepository fieldRepository;

    @Test
    void updateMoneyUponAutomaticSelling() {
        assertEquals(840, fieldRepository.updateMoneyUponAutomaticSelling(4l));
    }
}