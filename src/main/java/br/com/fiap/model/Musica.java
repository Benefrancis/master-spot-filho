package br.com.fiap.model;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import java.io.IOException;
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
        ObjectMapper mapper = new ObjectMapper();
        //By default all fields without explicit view definition are included, disable this
        mapper.configure(SerializationConfig.Feature.DEFAULT_VIEW_INCLUSION, false);
        //display name only
        String jsonInString = null;
        try {
            jsonInString = mapper.writeValueAsString(this);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return jsonInString;
    }
}
