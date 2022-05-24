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
    @Query(value = "UPDATE FIELDS SET (CROP_ID, TIMELEFT) = (:CROP_ID, :NEW_TIME) WHERE FIELDS.ID = :FIELD_ID",
            nativeQuery = true)
    @Transactional
    void assignCropToField(@Param("FIELD_ID") Long fieldID, @Param("CROP_ID") Long cropID,
                           @Param("NEW_TIME") int newTime);

    @Query(value = "WITH MONEY_BACK_FROM_FIELD AS ( "
            + "SELECT 2*CROPS.PRICE*FIELD_TYPES.SIZE AS MONEY "
            + "FROM FIELDS INNER JOIN CROPS "
            + "ON CROPS.ID = FIELDS.CROP_ID "
            + "INNER JOIN FIELD_TYPES "
            + "ON FIELDS.FIELD_ID = FIELD_TYPES.ID "
            + "WHERE FIELDS.FARM_ID = :FARM_ID "
            + "AND FIELDS.TIMELEFT = 0 AND FIELDS.CROP_ID IS NOT NULL) " +
            "SELECT SUM(MONEY) FROM MONEY_BACK_FROM_FIELD", nativeQuery = true)
    int updateMoneyUponAutomaticSelling(@Param("FARM_ID") Long farmID);

    @Modifying
    @Query(value = "UPDATE FIELDS SET CROP_ID = NULL WHERE FARM_ID = :FARM_ID AND TIMELEFT=0", nativeQuery = true)
    @Transactional
    void emptyFields(@Param("FARM_ID") Long farmID);


}
