package entities;

import entities.TypeSpecialty;

public class Medico extends Pessoa{

    private String documentoMedico;
    private TypeSpecialty especialidade;


    public TypeSpecialty getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(TypeSpecialty especialidade) {
        this.especialidade = especialidade;
    }

    public Medico(int id, String nome, String documentoMedico, TypeSpecialty especialidade) {
        super(id, nome);
        this.documentoMedico = documentoMedico;
        this.especialidade = especialidade;
    }

    @Override
    public String getDocumento() {
        return documentoMedico;
    }
}
