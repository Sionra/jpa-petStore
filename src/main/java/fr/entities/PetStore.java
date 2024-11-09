package fr.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class PetStore implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "MANAGER_NAME")
    private String managerName;
    @OneToOne
    private Address address;
    @ManyToMany
    @JoinTable(name = "PETSTORE_PRODUCT",
            joinColumns = @JoinColumn(name = "ID_PETSTORE", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_PRODUCT", referencedColumnName = "ID")
    )
    private List<Product> products;
    @OneToMany(mappedBy = "petStore")
    private List<Animal> animals;

    public PetStore() {}

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

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
