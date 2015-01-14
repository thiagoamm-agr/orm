package br.gov.go.agr.models;


import jedi.db.models.CharField;
import jedi.db.models.DateTimeField;
import jedi.db.models.EmailField;
import jedi.db.models.ForeignKeyField;
import jedi.db.models.Manager;
import jedi.db.models.Model;
import jedi.db.models.Table;

import jedi.types.DateTime;

/**
 * @author Thiago Monteiro
 * @version 1.0
 * @since 1.0
 */
@Table(
    name = "contatos", // esse é o padrão model + s. 
    engine = "InnoDB", 
    charset = "utf8", 
    comment = "Tabela de contatos."
)
public class Contato extends Model {

    private static final long serialVersionUID = 6855233677078698946L;

    @CharField(max_length = 50, unique = false, comment = "Nome do contato.")
    private String nome;

    @CharField(max_length = 50)
    private String sobrenome;

    @EmailField(required=false)
    private String email;

    @DateTimeField(auto_now_add = true, auto_now = true)
    private DateTime dataNascimento;

    @ForeignKeyField
    private Cidade cidade;

    public static Manager objects = new Manager(Contato.class);

    public Contato() {
        
    }

    public Contato(String nome, String sobrenome, String email, DateTime dataNascimento, Cidade cidade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DateTime getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(DateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    
    public String unicode() {
        return String.format("%s %s: %s - %s", nome, sobrenome, email, cidade.getNome());
    }
}
