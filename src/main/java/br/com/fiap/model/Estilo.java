package br.com.fiap.model;

public class Estilo {

    private long id;

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
