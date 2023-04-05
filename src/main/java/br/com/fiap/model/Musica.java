package br.com.fiap.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "TB_MUSICA")
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_MUSICA")
    @SequenceGenerator(name = "SQ_MUSICA", sequenceName = "SQ_MUSICA")
    @Column(name = "ID_MUSICA")
    private long id;

    @Column(name = "NM_MUSICA")
    private String nome;


    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "TB_MUSICA_ESTILO",
            joinColumns = @JoinColumn(name = "ID_MUSICA",
                    foreignKey = @ForeignKey(name = "FK_ME_MUSICA")
            ),
            inverseJoinColumns = @JoinColumn(name = "ID_ESTILO",
                    foreignKey = @ForeignKey(name = "FK_ME_ESTILO")
            )
    )
    private Set<Estilo> estilos = new HashSet<>();


    public Musica addEstilo(Estilo e) {
        this.estilos.add(e);
        e.getMusicas().add(this);
        return this;
    }

    public Musica removeEstilo(Estilo e) {
        this.estilos.remove(e);
        e.getMusicas().remove(this);
        return this;
    }

    public Musica removeTodosEstilos(){
        Iterator<Estilo> iterator = this.estilos.iterator();
        while (iterator.hasNext()) {
            Estilo e = iterator.next();
            this.estilos.remove(this);
            iterator.remove();
        }
        return this;
    }

    @ManyToMany(mappedBy = "musicas")
    @OrderBy("nome DESC")
    private Set<Artista> artistas = new LinkedHashSet<>();


    public Musica() {
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


    public Set<Artista> getArtistas() {
        return artistas;
    }

    public Musica setArtistas(Set<Artista> artistas) {
        this.artistas = artistas;
        return this;
    }

    @Override
    public String toString() {
        return "Musica{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", estilos=" + estilos +
                ", artistas=" + artistas +
                '}';
    }
}
