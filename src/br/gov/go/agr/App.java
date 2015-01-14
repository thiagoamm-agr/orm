package br.gov.go.agr;

import jedi.db.engine.JediORMEngine;

import jedi.types.DateTime;

import br.gov.go.agr.models.Cidade;
import br.gov.go.agr.models.Contato;
import br.gov.go.agr.models.Estado;
import br.gov.go.agr.models.Pais;

public class App {
    public static void main(String[] args) {
        // Retornando o SQL gerado a partir de uma classe.
        System.out.println(JediORMEngine.getSQL(Contato.class));
        // Desabilita a integridade referencial.
        JediORMEngine.FOREIGN_KEY_CHECKS = false;
        // Cria a estrutura do banco de dados.
        JediORMEngine.syncdb();
        Contato contato = new Contato(
            "Thiago",
            "Monteiro",
            "thicmp@gmail.com",
            new DateTime(1982, 11, 19),
            new Cidade(
                "Goiânia",
                new Estado(
                    "Goiás",
                    "GO",
                    new Pais(
                        "Brasil", "BR"
                    )
                ),
                "74.000.000"
            )
        );
        contato.save();
        System.out.println(Contato.objects.all());
        JediORMEngine.droptables();
    }
}
