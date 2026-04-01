package entities;

public class Paciente {

    private int idPaciente;
    private String nomePaciente;

    public int getIdPaciente() {
        return idPaciente;
    }
    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
    public String getNomePaciente() {
        return nomePaciente;
    }
    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public Paciente(int idPaciente, String nomePaciente) {
        this.idPaciente = idPaciente;
        this.nomePaciente = nomePaciente;
    }
}
