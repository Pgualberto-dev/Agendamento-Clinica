package entities;

public class Recepcionista extends Funcionario{

    public Recepcionista(int id, String nome, String documentoFuncionario) {
        super(id, nome, documentoFuncionario, Cargo.RECEPCIONISTA);
    }

}
