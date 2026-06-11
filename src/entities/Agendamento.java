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

    public Agendamento(int idAgendamento, Paciente paciente, Consulta consulta) {
        this.idAgendamento = idAgendamento;
        this.paciente = paciente;
        this.consulta = consulta;

        if (idAgendamento >= contadorId) {
            contadorId = idAgendamento + 1;
        }
    }

    @Override
    public String toString() {
        return " [Consulta] - " + this.consulta + " | " +
                "[Paciente] - " + paciente.getNome() + " | ";
    }
}
