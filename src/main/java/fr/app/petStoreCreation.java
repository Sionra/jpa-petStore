package fr.app;

import fr.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class petStoreCreation {
    public static void main(String[] args) {
        //Object creation
        List<Product> products = new ArrayList<>();
        List<Animal> animals = new ArrayList<>();
        Address address;
        PetStore mainStore = new PetStore("The Endless Spinning Cat", "Goldpaw");

        //Product creation
        Product p1 = new Product("001", "Cat Food", ProdType.FOOD, 2.35);
        Product p2 = new Product("002", "Cat Toy", ProdType.ACCESSORY, 5.10);
        Product p3 = new Product("003", "Cat Brush", ProdType.CLEANING, 1.24);
        p1.addPetStore(mainStore);
        p2.addPetStore(mainStore);
        p3.addPetStore(mainStore);
        products.add(p1);
        products.add(p2);
        products.add(p3);

        //Animal Creation
        Animal a1 = new Cat("2024/11/01", "Orange");
        Animal a2 = new Cat("2024/10/25", "Black");
        Animal a3 = new Cat("2001/10/14", "Rainbow");
        Animal f1 = new Fish("2020/06/10", "Red");
        Animal f2 = new Fish("2022/08/7", "Blue");
        Animal f3 = new Fish("2016/07/25", "Green");
        a1.addPetStore(mainStore);
        a2.addPetStore(mainStore);
        a3.addPetStore(mainStore);
        f1.addPetStore(mainStore);
        f2.addPetStore(mainStore);
        f3.addPetStore(mainStore);
        animals.add(a1);
        animals.add(a2);
        animals.add(a3);
        animals.add(f1);
        animals.add(f2);
        animals.add(f3);

        //Adress Creation
        address = new Address("23", "Roundaboud Street", "42777", "Cat City", mainStore);

        //PetStore Creation
        mainStore.setAddress(address);
        mainStore.setAnimals(animals);
        mainStore.setProducts(products);
        //Connection to the database to create the table and insert item in them
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petStoreCreation-jpa");
        EntityManager em = emf.createEntityManager();

        //Begin transaction
        em.getTransaction().begin();
        //Insertion

        for (Product p : products) {
            em.persist(p);
        }
        for (Animal a : animals) {
            em.persist(a);
        }
        em.persist(address);
        em.persist(mainStore);

        //Commit and close
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}