package entities;

public class Agendamento {

    private static int contadorId = 1;
    private int idAgendamento;
    private Paciente paciente;
    private Consulta consulta;

    public Paciente getPaciente() {
        return paciente;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public int getIdAgendamento() {
        return idAgendamento;
    }

    public Agendamento(Paciente paciente, Consulta consulta) {
        this.idAgendamento = contadorId++;
        this.paciente = paciente;
        this.consulta = consulta;
    }
}
