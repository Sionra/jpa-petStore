package fr.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.io.Serializable;

@Entity
public class Fish extends Animal implements Serializable {

    @Column(name = "LIVING_ENV")
    private FishLivEnv livingEnv;

    public Fish() {}

    public Fish(String birth, String couleur) {
        super(birth, couleur);
    }

    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }

    public void setLivingEnv(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }
}
