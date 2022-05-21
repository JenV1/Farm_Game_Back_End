package com.example.farm_game.repositories;

import com.example.farm_game.models.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CropRespository extends JpaRepository<Crop,Long> {
}
