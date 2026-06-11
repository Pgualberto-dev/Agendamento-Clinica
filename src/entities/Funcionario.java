package entities;

import entities.Cargo;

public abstract class Funcionario extends Pessoa {

    protected String documentoFuncionario;
    protected Cargo cargo;

    public Funcionario(int id, String nome, String documentoFuncionario, Cargo cargo) {
        super(id, nome);
        this.documentoFuncionario = documentoFuncionario;
        this.cargo = cargo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public String getDocumentoFuncionario() {
        return documentoFuncionario;
    }

    @Override
    public String getDocumento() {
        return documentoFuncionario;
    }
}
