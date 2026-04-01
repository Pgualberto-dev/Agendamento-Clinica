package entities;

public class Agendamento {

    private Paciente paciente;
    private Consulta consulta;

    public Paciente getPaciente() {
        return paciente;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public Agendamento(Paciente paciente, Consulta consulta) {
        this.paciente = paciente;
        this.consulta = consulta;
    }
}
