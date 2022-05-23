package com.example.farm_game.repositories;

import com.example.farm_game.models.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldRepository extends JpaRepository<Field,Long> {
}
