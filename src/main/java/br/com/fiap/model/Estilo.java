package br.com.fiap.model;

import jakarta.persistence.*;

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

    public Estilo() {
    }

    public Estilo(long id, String nome) {
        this.id = id;
        this.nome = nome;
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
