package entities;

public class Gerente extends Funcionario {

    public Gerente(int id, String nome, String documentoFuncionario) {
        super(id, nome, documentoFuncionario, Cargo.GERENTE);
    }
}
