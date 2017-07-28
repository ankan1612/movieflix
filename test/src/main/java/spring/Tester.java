package spring;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.*;

/**
 * Created by Ankan on 7/27/2017.
 */
public class Tester {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
//        List<Movie> mystry = new ArrayList<Movie>();
//        List<Movie> horror = new ArrayList<Movie>();
//        List<Movie> thriller = new ArrayList<Movie>();
//        List<Genre> harry = new ArrayList<Genre>();
//        List<Genre> conjuring = new ArrayList<Genre>();
//        List<Genre> paranormal = new ArrayList<Genre>();
        Movie m1 = new Movie();
        Movie m2 = new Movie();
        Movie m3 = new Movie();
        Genre g1 = new Genre();
        Genre g2 = new Genre();
        Genre g3 = new Genre();
        Type t1 = new Type();
        Type t2 = new Type();
        m1.setTitle("Harry Porter");
        m2.setTitle("Conjuring");
        m3.setTitle("Paranormal");
        g1.setName("Mystry");
        g2.setName("Horror");
        g3.setName("Thriller");
        t1.setName("Movie");
        t2.setName("TVShow");

        m1.getGenre().add(g1);
        m1.getGenre().add(g3);
        m2.getGenre().add(g2);
        m3.getGenre().add(g1);
        m3.getGenre().add(g2);
        m3.getGenre().add(g3);
        m1.setType(t1);
        m2.setType(t2);
        m3.setType(t1);
        g1.getMovie().add(m1);
        g1.getMovie().add(m3);
        g2.getMovie().add(m2);
        g2.getMovie().add(m3);
        g3.getMovie().add(m1);
        g3.getMovie().add(m3);
        t1.getMovie().add(m1);
        t1.getMovie().add(m3);
        t2.getMovie().add(m2);

//        mystry.add(m1);
//        mystry.add(m3);
//        horror.add(m2);
//        horror.add(m3);
//        thriller.add(m1);
//        thriller.add(m3);
//        harry.add(g1);
//        harry.add(g3);
//        conjuring.add(g2);
//        paranormal.add(g1);
//        paranormal.add(g2);
//        paranormal.add(g3);
//        m1.setGenre(harry);
//        m2.setGenre(conjuring);
//        m3.setGenre(paranormal);
//        g1.setMovie(mystry);
//        g2.setMovie(horror);
//        g3.setMovie(thriller);




//        m1.getGenre().add(g1);
//        m1.getGenre().add(g3);
//
//        m2.getGenre().add(g2);
//
//        m3.getGenre().add(g1);
//        m3.getGenre().add(g2);
//        m3.getGenre().add(g3);

        em.persist(m1);
        em.persist(m2);
        em.persist(m3);
        em.getTransaction().commit();


        System.out.println("-------------------------------------------------------------------------");

        String name = "Mystry";
        TypedQuery<Genre> query = em.createNamedQuery("Genre.findByName",Genre.class);
        query.setParameter("pName",name);
        List<Genre> genres =  query.getResultList();
        if(genres!=null && genres.size()==1)
        {
            System.out.println(genres.get(0));
            for(Movie m : genres.get(0).getMovie())
            {
                System.out.println("->"+m);
            }
        }
        name = "Horror";
        query.setParameter("pName",name);
        genres =  query.getResultList();
        if(genres!=null && genres.size()==1)
        {
            System.out.println(genres.get(0));
            for(Movie m : genres.get(0).getMovie())
            {
                System.out.println("->"+m);
            }
        }

        name = "Harry Porter";
        TypedQuery<Movie> query2 = em.createNamedQuery("Movie.findByName",Movie.class);
        query2.setParameter("pName",name);
        List<Movie> movies =  query2.getResultList();
        if(movies!=null && movies.size()==1)
        {
            System.out.println(movies.get(0));
            for(Genre g : movies.get(0).getGenre())
            {
                System.out.println("->"+g);
            }
        }
        name = "Conjuring";
        query2.setParameter("pName",name);
        movies =  query2.getResultList();
        if(movies!=null && movies.size()==1)
        {
            System.out.println(movies.get(0));
            for(Genre g : movies.get(0).getGenre())
            {
                System.out.println("->"+g);
            }
        }

        name = "Movie";
        TypedQuery<Type> query3 = em.createNamedQuery("Type.findByName",Type.class);
        query3.setParameter("pName",name);
        List<Type> types =  query3.getResultList();
        if(types!=null && types.size()==1)
        {
            System.out.println(types.get(0));
            for(Movie m : types.get(0).getMovie())
            {
                System.out.println("->"+m);
            }
        }
        name = "TVShow";
        query3.setParameter("pName",name);
        types =  query3.getResultList();
        if(types!=null && types.size()==1)
        {
            System.out.println(types.get(0));
            for(Movie m : types.get(0).getMovie())
            {
                System.out.println("->"+m);
            }
        }
    }
}


