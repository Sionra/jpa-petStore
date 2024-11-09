package fr.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "BIRTH")
    private String birth;
    @Column(name = "COULEUR")
    private String couleur;
    @ManyToOne
    @JoinColumn(name = "PETSTORE_ID")
    private PetStore petStore;

    public Animal() {}

    public Animal(String birth, String couleur) {
        this.birth = birth;
        this.couleur = couleur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public PetStore getPetStore() {
        return petStore;
    }

    public void setPetStore(PetStore petStore) {
        this.petStore = petStore;
    }

    public void addPetStore(PetStore petStore) {
        this.petStore = petStore;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Animal{ ");
        sb.append("id = ").append(id);
        sb.append(", birth = '").append(birth).append('\'');
        sb.append(", couleur = '").append(couleur).append('\'');
        sb.append(" }");
        return sb.toString();
    }
}
