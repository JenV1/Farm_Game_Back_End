package com.example.farm_game.models;

import javax.persistence.*;

@Entity
@Table(name = "Fields")
public class Field {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private int timeLeft;

    @Column
    @ManyToOne
    @JoinColumn(name = "field_id", nullable = false)
    private FieldType fieldType;

    @Column
    @ManyToOne
    @JoinColumn(name = "crop_id", nullable = false)
    private Crop crop;

    @Column
    @ManyToOne
    @JoinColumn(name = "farm_id", nullable = false)
    private Farm farm;

    public Field(Long id, String name, int timeLeft, FieldType fieldType, Crop crop, Farm farm) {
        this.id = id;
        this.name = name;
        this.timeLeft = timeLeft;
        this.fieldType = fieldType;
        this.crop = crop;
        this.farm = farm;
    }

    public Field() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(int timeLeft) {
        this.timeLeft = timeLeft;
    }

    public FieldType getFieldType() {
        return fieldType;
    }

    public void setFieldType(FieldType fieldType) {
        this.fieldType = fieldType;
    }

    public Crop getCrop() {
        return crop;
    }

    public void setCrop(Crop crop) {
        this.crop = crop;
    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }
}
