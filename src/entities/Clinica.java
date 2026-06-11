package entities;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class Clinica {

    private ZoneId zoneId;
    private List<Consulta> consultasList = new ArrayList<>();
    private List<Agendamento> agendamentoList = new ArrayList<>();
    private List<Paciente> pacienteList = new ArrayList<>();
    private List<Funcionario> funcionarioList = new ArrayList<>();
    private List<Medico> medicoList = new ArrayList<>();

    public List<Consulta> getConsultasList() {
        return consultasList;
    }

    public List<Paciente> getPacienteList() {
        return pacienteList;
    }

    public void setPacienteList(List<Paciente> pacienteList) {
        this.pacienteList = pacienteList;
    }

    public ZoneId getZoneId() {
        return zoneId;
    }

    public List<Agendamento> getAgendamentoList() {
        return agendamentoList;
    }

    public void setConsultasList(List<Consulta> consultasList) {
        this.consultasList = consultasList;
    }

    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public List<Medico> getMedicoList() {
        return medicoList;
    }

    
}
