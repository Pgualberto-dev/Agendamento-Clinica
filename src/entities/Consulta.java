package entities;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Consulta {

    private int id;
    private Instant dataHora;
    private TypeSpecialty especialidade;
    private String nomeMedico;
    private Status statusConsulta;

    public int getId() {
        return id;
    }
    public Instant getDataHora() {
        return dataHora;
    }

    public TypeSpecialty getEspecialidade() {
        return especialidade;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public Status getStatusConsulta() {
        return statusConsulta;
    }
    public void setStatusConsulta(Status statusConsulta) {
        this.statusConsulta = statusConsulta;
    }
    public Consulta(int id, TypeSpecialty especialidadeConsulta, String nomeMedico, Instant dataHora) {
        this.id = id;
        this.dataHora = dataHora;
        this.especialidade = especialidadeConsulta;
        this.nomeMedico = nomeMedico;
        this.statusConsulta = Status.DISPONIVEL;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy | HH:mm").withZone(ZoneId.systemDefault());
        return "ID: " + id + " | Especialidade: " + especialidade + " | Médico: " + nomeMedico + " | Data e Hora: " + dtf.format(dataHora) + " | " + statusConsulta;
    }
}
