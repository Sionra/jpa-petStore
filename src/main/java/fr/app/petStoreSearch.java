package fr.app;

import fr.entities.Animal;
import fr.entities.PetStore;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Queue;

public class petStoreSearch {
    public static void main(String[] args) {
        Long id = 1L;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petStore-jpa");
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("SELECT new fr.entities.Animal(a.birth, a.couleur) FROM Animal a WHERE a.petStore.id = 1");
        List<Animal> animals = query.getResultList();

        em.close();
        emf.close();

        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

}
