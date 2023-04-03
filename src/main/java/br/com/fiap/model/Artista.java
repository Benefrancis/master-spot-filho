package br.com.fiap.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Entity
@Table(name = "TB_ARTISTA")
public class Artista {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ARTISTA")
    @SequenceGenerator(name = "SQ_ARTISTA", sequenceName = "SQ_ARTISTA")
    @Column(name = "ID_ARTISTA")
    private long id;

    @Column(name = "NM_ARTISTA")
    private String nome;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "TB_MUSICA_ARTISTA",
            joinColumns = @JoinColumn(name = "ID_ARTISTA",
                    foreignKey = @ForeignKey(name = "FK_MA_ARTISTA",
                            value = ConstraintMode.CONSTRAINT)
            ),
            inverseJoinColumns = @JoinColumn(name = "ID_MUSICA",
                foreignKey = @ForeignKey(name = "FK_MA_MUSICA",
                        value = ConstraintMode.CONSTRAINT)
            )
    )
    private Set<Musica> musicas = new HashSet<>();

    public Artista() {
    }

    public Artista(long id, String nome, Set<Musica> musicas) {
        this.id = id;
        this.nome = nome;
        this.musicas = musicas;
    }

    /**
     * Adiciona uma música na coleção de músicas do artista
     *
     * @param m
     * @return
     */
    public Artista addMusica(Musica m) {
        this.musicas.add(m);
        m.getArtistas().add(this);
        return this;
    }

    /**
     * remove uma música da coleção de músicas do Artista
     *
     * @param m
     * @return
     */
    public Artista removeMusica(Musica m) {
        this.musicas.remove(m);
        m.getArtistas().remove(this);
        return this;
    }

    /**
     * Remove todas as músicas do Artista
     *
     * @return
     */
    public Artista removeMusicas() {
        Iterator<Musica> iterator = this.musicas.iterator();
        while (iterator.hasNext()) {
            Musica musica = iterator.next();
            musica.getArtistas().remove(this);
            iterator.remove();
        }
        return this;
    }

    public long getId() {
        return id;
    }

    public Artista setId(long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Artista setNome(String nome) {
        this.nome = nome;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Artista{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
