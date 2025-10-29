package com.jdbc.JPA;

import com.jdbc.JPA.music.Artist;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

/*

        - A JPA Tuple is ordered collection of values, retrieved from a database query.
        - It is like a mini-record, holding just the specific data you need fro the database.

        In jpa we can run jpa queries in 3 ways
            1. jpql - jakarta persistence query language
            2. Criteria builder interface.
            3. Native query, relies on sql.


        CriteriaQuery interface methods -
            1. Predicate - represents a condition in a where clause
            2. Expression - represents a computed value
            3. Order - used to represent sorting criteria for the ORDER BY clause.
            4. Selection - represents an attribute,expression, or result used to define the selectable output of the query.

        Precess to create an executable query, suing CriteriaBuilder
            Step 1 - get an instance of CriteriaBuilder, (method - entityManger.getCriteriaBuilder)
            Step 2 - get an instance of CriteriaQuery, (method - entityBuilder.createQuery)
            Step 3 - specify the entity(the query root) , (method - criteriaQuery.from(Entity.class);)
            Step 4 - select data , (method - criteriaQuery.select(root))
            Step 5 - Add expression,predicates, sorting criteria and other parts to the query, (method - invoke various methods on criteriaQuery )
            Step 6 - Retrieve a query instance, (method - entityManager.createQuery(criteriaQuery)
            step 7 - execute and get results - (1. criteriaQuery.getResultsList,
                                                2. criteriaQuery.getResultStream,
                                                3. criteriaQuery.getSingleResult)






 */

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainQuery {
    public static void main(String[] args) {

        List<Artist> artists = null;
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.jdbc.JPA.music.Artist");
        EntityManager entityManager = emf.createEntityManager()
        ){
            var transaction = entityManager.getTransaction();
            transaction.begin();

            artists = getArtistsJPQL(entityManager,"%Greatest Hits%");
            artists.forEach(System.out::println);

            System.out.println("-".repeat(50));

//            Stream<Artist> sartists = getArtistsBuilder(entityManager, "Bl%"); -----------> for CriteriaQuery Builder
            Stream<Artist> sartists = getArtistsSQL(entityManager, "Bl%");
            var map = sartists
                    .limit(10)
                            .collect(Collectors.toMap(
                                    Artist::getArtistName,
                                    (a)->a.getAlbums().size(),
                                    Integer::sum,
                                    TreeMap::new
                            ));
            map.forEach((k,v)-> System.out.println(k + " : " + v));


//            var names = getArtistNames(entityManager,"%Stev%");
//            names
//                    .map(a->new Artist(a.get(0,Integer.class), (String) a.get(1)))
//                    .forEach(System.out::println);

            transaction.commit();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    private static List<Artist> getArtistsJPQL(EntityManager em, String matchedValue){
//        String jpql = "SELECT a FROM Artist a WHERE a.artistName LIKE :partialName"; //there are 2 ways you can perform this, this is the first method and below line is 2nd approach.
//        String jpql = "SELECT a FROM Artist a WHERE a.artistName LIKE ?1";
        String jpql = "SELECT a FROM Artist a JOIN albums album WHERE album.albumName LIKE ?1 OR album.albumName LIKE ?2";
        var query = em.createQuery(jpql,Artist.class);

//        query.setParameter("partialName",matchedValue);
        query.setParameter(1,matchedValue);
        query.setParameter(2,"%Best of%");

        return query.getResultList();
    }

    private static Stream<Tuple> getArtistNames(EntityManager em, String matchedValue){
//        String jpql = "SELECT a FROM Artist a WHERE a.artistName LIKE :partialName"; //there are 2 ways you can perform this, this is the first method and below line is 2nd approach.
        String jpql = "SELECT a.artistId,a.artistName FROM Artist a WHERE a.artistName LIKE ?1";
        var query = em.createQuery(jpql,Tuple.class);

//        query.setParameter("partialName",matchedValue);
        query.setParameter(1,matchedValue);

        return query.getResultStream();
    }

    private static Stream<Artist> getArtistsBuilder(EntityManager em, String matchedValue){

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Artist> criteriaQuery = builder.createQuery(Artist.class);
        Root<Artist> root = criteriaQuery.from(Artist.class);
        criteriaQuery.select(root);
        criteriaQuery.where(builder.like(root.get("artistName"),matchedValue));
        criteriaQuery.orderBy(builder.asc(root.get("artistName")));
        return em.createQuery(criteriaQuery).getResultStream();
    }

    private static Stream<Artist> getArtistsSQL(EntityManager em, String matchedValue){
        var query = em.createNativeQuery(
                "SELECT * FROM music.artists where artist_name like ?1", Artist.class
        );
        query.setParameter(1,matchedValue);
        return query.getResultStream();
    }
}
