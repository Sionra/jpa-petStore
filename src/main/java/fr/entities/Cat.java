package fr.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.io.Serializable;

@Entity
public class Cat extends Animal implements Serializable {

    @Column(name = "CHIP_ID")
    private String chipId;

    public Cat(){}

    public Cat(String birth, String couleur) {
        super(birth, couleur);
    }

    public String getChipId() {
        return chipId;
    }

    public void setChipId(String chipId) {
        this.chipId = chipId;
    }
}
