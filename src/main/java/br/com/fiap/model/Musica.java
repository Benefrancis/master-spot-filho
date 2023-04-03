package br.com.fiap.model;

import java.util.HashSet;
import java.util.Set;

public class Musica {

    private long id;
    private String nome;
    private Estilo estilo;
    private Set<Artista> artistas = new HashSet<>();

    public Musica() {
    }

    public Musica(long id, String nome, Estilo estilo, Set<Artista> artistas) {
        this.id = id;
        this.nome = nome;
        this.estilo = estilo;
        this.artistas = artistas;
    }

    public long getId() {
        return id;
    }

    public Musica setId(long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Musica setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Estilo getEstilo() {
        return estilo;
    }

    public Musica setEstilo(Estilo estilo) {
        this.estilo = estilo;
        return this;
    }

    public Set<Artista> getArtistas() {
        return artistas;
    }

    public Musica setArtistas(Set<Artista> artistas) {
        this.artistas = artistas;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Musica{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", estilo=").append(estilo);
        sb.append(", artistas=").append(artistas);
        sb.append('}');
        return sb.toString();
    }
}
