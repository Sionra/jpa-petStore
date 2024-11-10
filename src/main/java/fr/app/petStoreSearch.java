package fr.app;

import fr.entities.Animal;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class petStoreSearch {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petStore-jpa");
        EntityManager em = emf.createEntityManager();

        //Cree une query qui permet de recupere tout les animaux du magasin animallier a l'ID 1
        Query query = em.createQuery("SELECT new fr.entities.Animal(a.birth, a.couleur) FROM Animal a WHERE a.petStore.id = 1");
        //Execution de la query
        List<Animal> animals = query.getResultList();

        //on ferme les transaction
        em.close();
        emf.close();

        //On boucle dans le resultat pour afficher tout les animaux
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

}
