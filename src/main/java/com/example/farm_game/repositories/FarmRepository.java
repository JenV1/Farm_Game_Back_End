package com.example.farm_game.repositories;

import com.example.farm_game.models.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmRepository extends JpaRepository<Farm,Long> {
}
