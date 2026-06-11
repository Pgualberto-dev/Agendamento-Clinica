package entities;

import java.util.ArrayList;
import java.util.List;

public class Paciente extends Pessoa {

    private String documentoPaciente;
    private List <Consulta> consultaCliente = new ArrayList<>();


    public List<Consulta> getConsultaCliente() {
        return consultaCliente;
    }

    public void setConsultaCliente(List<Consulta> consultaCliente) {
        this.consultaCliente = consultaCliente;
    }

    public Paciente(int idPaciente, String nomePaciente, String documentoPaciente) {
        super(idPaciente, nomePaciente);
        this.documentoPaciente = documentoPaciente;
    }

    @Override
    public String toString() {
        return  "["+id +"] - " + nome + " [" + documentoPaciente + "]";
    }

    @Override
    public String getDocumento() {
        return documentoPaciente;
    }
}
