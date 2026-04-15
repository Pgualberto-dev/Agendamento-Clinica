package entities;

import java.util.ArrayList;
import java.util.List;

public class Paciente {

    private int idPaciente;
    private String nomePaciente;
    private List <Consulta> consultaCliente = new ArrayList<>();

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

    public List<Consulta> getConsultaCliente() {
        return consultaCliente;
    }

    public void setConsultaCliente(List<Consulta> consultaCliente) {
        this.consultaCliente = consultaCliente;
    }

    public Paciente(int idPaciente, String nomePaciente) {
        this.idPaciente = idPaciente;
        this.nomePaciente = nomePaciente;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                " " + nomePaciente + "";
    }
}
