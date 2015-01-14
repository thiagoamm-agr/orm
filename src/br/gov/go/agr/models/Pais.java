package br.gov.go.agr.models;


import jedi.db.models.*;

@Table(name = "paises")
public class Pais extends Model {

    private static final long serialVersionUID = -8563344379891933613L;

    @CharField(max_length = 50)
    private String nome;

    @CharField(max_length = 2)
    private String sigla;

    public static Manager objects = new Manager(Pais.class);

    public Pais() {

    }

    public Pais(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String unicode() {
        return String.format("%s [%s]", nome, sigla);
    }

    // Generated by Jedi ORM
    public QuerySet<Estado> getEstadoSet() {
        return Estado.objects.getSet(Pais.class, this.id);
    }
}
