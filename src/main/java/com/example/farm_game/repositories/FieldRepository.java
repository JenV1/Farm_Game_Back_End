package com.example.farm_game.repositories;

import com.example.farm_game.models.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface FieldRepository extends JpaRepository<Field,Long> {

    @Modifying
    @Query(value = "UPDATE FIELDS SET (CROP_ID, TIMELEFT) = (:CROP_ID, :NEW_TIME) WHERE FIELDS.ID = :FIELD_ID", nativeQuery = true)
    @Transactional
    void assignCropToField(@Param("FIELD_ID") Long fieldID, @Param("CROP_ID") Long cropID,
                           @Param("NEW_TIME") int newTime);
}
