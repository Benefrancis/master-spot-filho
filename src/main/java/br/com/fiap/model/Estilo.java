package br.com.fiap.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TB_ESTILO")
public class Estilo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ESTILO")
    @SequenceGenerator(name = "SQ_ESTILO", sequenceName = "SQ_ESTILO")
    @Column(name = "ID_ESTILO")
    private long id;

    @Column(name = "NM_ESTILO")
    private String nome;

    @ManyToMany(mappedBy = "estilos")
    @OrderBy("nome DESC")
    private Set<Musica> musicas = new HashSet<>();

    public Set<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(Set<Musica> musicas) {
        this.musicas = musicas;
    }

    public Estilo() {
    }

    public Estilo(long id, String nome, Set<Musica> musicas) {
        this.id = id;
        this.nome = nome;
        this.musicas = musicas;
    }

    public long getId() {
        return id;
    }

    public Estilo setId(long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Estilo setNome(String nome) {
        this.nome = nome;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Estilo{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
