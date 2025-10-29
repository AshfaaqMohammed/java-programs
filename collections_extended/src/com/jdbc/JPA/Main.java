package com.jdbc.JPA;

import com.jdbc.JPA.music.Artist;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        try(var sessionFactory =
                    Persistence.createEntityManagerFactory("com.jdbc.JPA.music.Artist");
            EntityManager entityManager = sessionFactory.createEntityManager();
            ){

            var transaction = entityManager.getTransaction();
            transaction.begin();
            Artist artist = entityManager.find(Artist.class,201);
            System.out.println(artist);
            artist.removeDuplicates();
            System.out.println(artist);
//                entityManager.remove(artist);
//                entityManager.persist(new Artist("Muddy Water"));
            transaction.commit();


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
