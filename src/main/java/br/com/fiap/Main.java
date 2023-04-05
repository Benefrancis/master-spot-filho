package br.com.fiap;

import br.com.fiap.model.Artista;
import br.com.fiap.model.Estilo;
import br.com.fiap.model.Musica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("fiap");
        EntityManager manager = factory.createEntityManager();

         salvar(manager);
        // long id = 1L;
        // findByID(manager, id);
         findAll(manager);
    }

    private static void findAll(EntityManager manager) {
        String jpql = "From Musica";
        List<Musica> list = manager.createQuery(jpql).getResultList();
        list.stream().forEach(System.out::println);
    }

    private static void findByID(EntityManager manager, long id) {
        Musica musica = manager.find(Musica.class, id);
        System.out.println(musica);
    }

    private static void salvar(EntityManager manager) {
        var rock = new Estilo();
        rock.setNome("Rock");

        var rockNacional = new Estilo();
        rockNacional.setNome("Rock Nacional");

        var mpb = new Estilo();
        mpb.setNome("MPB");

        var musica = new Musica();
        musica.setNome("Zoio de Lula")
                .addEstilo(rock)
                .addEstilo(rockNacional)
                .addEstilo(mpb);

        var vocal = new Artista();
        vocal.setNome("Chorão").addMusica(musica);

        var baixo = new Artista();
        baixo.setNome("Champgnon").addMusica(musica);

        var baterista = new Artista();
        baterista.setNome("Bruno Graveto").addMusica(musica);

        var guitarra = new Artista();
        guitarra.setNome("Marcão Britto").addMusica(musica);

        var guitarra2 = new Artista();
        guitarra2.setNome("Thiago Castanho").addMusica(musica);

        manager.getTransaction().begin();

        Arrays.asList(vocal, baixo, baterista, guitarra, guitarra2).forEach(
                manager::persist
        );


        manager.persist(musica);
        manager.getTransaction().commit();
    }
}