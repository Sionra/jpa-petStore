package fr.entities;

import jakarta.persistence.*;

/**
 * Cette classe definie une adresse pour un magasin animalier
 */
@Entity
public class Address {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NUMBER")
    private String number;
    @Column(name = "STREET")
    private String street;
    @Column(name = "ZIPCODE")
    private String zipcode;
    @Column(name = "CITY")
    private String city;
    @OneToOne
    private PetStore petStore;

    public Address() {}

    public Address(String number, String street, String zipcode, String city, PetStore petStore) {
        this.number = number;
        this.street = street;
        this.zipcode = zipcode;
        this.city = city;
        this.petStore = petStore;
    }

    /**
     * Retourne l'ID de l'adresse
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * Permet de changer l'ID de l'adresse
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Permet de recuperer le nom ded la rue de l'adresse
     * @return
     */
    public String getNumber() {
        return number;
    }

    /**
     * permet de changer le numero de l'adresse
     * @param number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Permet de recuperer la rue de l'adresse
     * @return
     */
    public String getStreet() {
        return street;
    }

    /**
     * Permet de changer le nom de la rue de l'adresse
     * @param street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Permet de recupere le code Postal de l'adresse
     * @return
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * Permet de changer le code Postal avec le parametre
     * @param zipcode
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * Permet de recuperer le nom de la ville de l'adresse
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     * permet de changer la ville de l'adresse
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Permet de recuperer le magasin animalier de l'adresse
     * @return
     */
    public PetStore getPetStore() {
        return petStore;
    }

    /**
     * permet de changer le magasin attribuer a l'adresse
     * @param petStore
     */
    public void setPetStore(PetStore petStore) {
        this.petStore = petStore;
    }
}
