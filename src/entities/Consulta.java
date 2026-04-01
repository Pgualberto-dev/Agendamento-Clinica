package entities;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Consulta {

    private int id;
    private Instant dataHora;
    private String especialidade;
    private String nomeMedico;

    public Instant getDataHora() {
        return dataHora;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }


    public Consulta(int id, String especialidadeConsulta, String nomeMedico, Instant dataHora) {
        this.id = id;
        this.dataHora = dataHora;
        this.especialidade = especialidadeConsulta;
        this.nomeMedico = nomeMedico;

    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy | HH:mm").withZone(ZoneId.systemDefault());
        return "ID: " + id + " | Especialidade: " + especialidade + " | Médico: " + nomeMedico + " | Data e Hora: " + dtf.format(dataHora);
    }
}
