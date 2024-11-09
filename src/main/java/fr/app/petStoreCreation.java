package fr.app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class petStoreCreation {
    public static void main(String[] args) {
        //Open
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petStoreCreation-jpa");
        EntityManager em = emf.createEntityManager();


        em.close();
        emf.close();
    }
}