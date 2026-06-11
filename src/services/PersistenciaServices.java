package services;

import entities.Clinica;
import entities.Medico;
import entities.Paciente;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.List;

public class PersistenciaServices {

    public void salvarPacientes(Clinica clinica) {
        List<Paciente> listaPacientes = clinica.getPacienteList();

        try (java.io.FileWriter writer = new java.io.FileWriter("pacientes.txt")) {
            for (Paciente paciente : listaPacientes) {
                List<String> consultas = paciente.getConsultaCliente().stream()
                        .map(c -> String.valueOf(c.getId()))
                        .toList();
                writer.write(paciente.getId() + " | " + paciente.getNome() + " | " + paciente.getDocumento() + " | " + String.join(",", consultas) + "\n");
            }
        } catch (java.io.IOException e) {
            System.out.println("Erro ao salvar pacientes: " + e.getMessage());

        }
    }

    public void salvarConsultas(Clinica clinica) {
        List<entities.Consulta> listaConsultas = clinica.getConsultasList();

        try (java.io.FileWriter writer = new java.io.FileWriter("consultas.txt")) {
            for (entities.Consulta consulta : listaConsultas) {
                writer.write(consulta.getId() + " | " + consulta.getNomeMedico() + " | " + consulta.getEspecialidade() + " | " + consulta.getDataHora() + " | " + consulta.getStatusConsulta() + "\n");
            }
        } catch (java.io.IOException e) {
            System.out.println("Erro ao salvar consultas: " + e.getMessage());
        }
    }

    public void salvarMedicos(Clinica clinica) {
        List<entities.Medico> listaMedicos = clinica.getMedicoList();

        try (java.io.FileWriter writer = new java.io.FileWriter("medicos.txt")) {
            for (entities.Medico medico : listaMedicos) {
                writer.write(medico.getId() + " | " + medico.getNome() + " | " + medico.getEspecialidade() + " | "+ medico.getDocumento() + "\n");
            }
        } catch (java.io.IOException e) {
            System.out.println("Erro ao salvar medicos: " + e.getMessage());
        }
    }

    public void salvarAgendamentos(Clinica clinica) {
        List<entities.Agendamento> listaAgendamentos = clinica.getAgendamentoList();

        try (java.io.FileWriter writer = new java.io.FileWriter("agendamentos.txt")) {
            for (entities.Agendamento agendamento : listaAgendamentos) {
                writer.write(agendamento.getIdAgendamento() + " | " + agendamento.getPaciente().getId() + " | " + agendamento.getConsulta().getId() + "\n");
            }
        } catch (java.io.IOException e) {
            System.out.println("Erro ao salvar agendamentos: " + e.getMessage());
        }
    }

    public void salvarFuncionarios(Clinica clinica) {
        List<entities.Funcionario> listaFuncionarios = clinica.getFuncionarioList();

        try (java.io.FileWriter writer = new java.io.FileWriter("funcionarios.txt")) {
            for (entities.Funcionario funcionario : listaFuncionarios) {
                writer.write(funcionario.getId() + " | " + funcionario.getNome() + " | " + funcionario.getDocumentoFuncionario() + " | " + funcionario.getCargo() + "\n");
            }
        } catch (java.io.IOException e) {
            System.out.println("Erro ao salvar funcionarios: " + e.getMessage());
        }
    }

    public void carregarConsultas(Clinica clinica) {
        try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader("consultas.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" \\| ");
                if (parts.length == 5) {
                    int id = Integer.parseInt(parts[0]);
                    String nomeMedico = parts[1];
                    String especialidade = parts[2];
                    String dataHora = parts[3];
                    entities.Status statusConsulta = entities.Status.valueOf(parts[4]);
                    entities.Consulta consulta = new entities.Consulta(id, entities.TypeSpecialty.valueOf(especialidade), nomeMedico, java.time.Instant.parse(dataHora));
                    consulta.setStatusConsulta(statusConsulta);
                    clinica.getConsultasList().add(consulta);
                }
            }
        }catch (FileNotFoundException e) {
            System.out.println("Arquivo de consultas não encontrado. Iniciando com lista vazia.");

        } catch (java.io.IOException e) {
            System.out.println("Erro ao carregar consultas: " + e.getMessage());
        }
    }

    public void carregarMedicos(Clinica clinica){
        try(java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader("medicos.txt"))){
            String line;
            while((line = reader.readLine()) != null){
                String [] parts = line.split(" \\| ");
                if (parts.length == 4){
                    int id = Integer.parseInt(parts[0]);
                    String nome = parts[1];
                    String espacialidade = parts[2];
                    String documento = parts[3];
                    entities.TypeSpecialty espec = entities.TypeSpecialty.valueOf(espacialidade);
                    Medico medico = new Medico(id, nome, documento, espec);
                    clinica.getMedicoList().add(medico);
                }

            }

        }catch (FileNotFoundException e) {
            System.out.println("Arquivo de medicos não encontrado. Iniciando com lista vazia.");

        }catch(java.io.IOException e ){
            System.out.println("Erro ao carregar medicos: " + e.getMessage());
        }
    }

    public void carregarFuncionarios(Clinica clinica){
        try(java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader("funcionarios.txt"))){
            String line;
            while((line = reader.readLine()) != null){
                String [] parts = line.split(" \\| ");
                if (parts.length == 4){
                    int id = Integer.parseInt(parts[0]);
                    String nome = parts[1];
                    String documento = parts[2];
                    String cargo = parts[3];
                    entities.Funcionario funcionario;
                    switch (cargo) {
                        case "RECEPCIONISTA" -> funcionario = new entities.Recepcionista(id, nome, documento);
                        case "GERENTE" -> funcionario = new entities.Gerente(id, nome, documento);
                        default -> throw new IllegalArgumentException("Cargo desconhecido: " + cargo);
                    }
                    clinica.getFuncionarioList().add(funcionario);
                }

            }

        }catch (FileNotFoundException e) {
            System.out.println("Arquivo de funcionarios não encontrado. Iniciando com lista vazia.");

        }catch(java.io.IOException e ){
            System.out.println("Erro ao carregar funcionarios: " + e.getMessage());
        }
    }

        public void carregarPacientes(Clinica clinica){
            try(java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader("pacientes.txt"))){
                String line;
                while((line = reader.readLine()) != null){
                    String [] parts = line.split(" \\| ");
                    if (parts.length == 4){
                        int id = Integer.parseInt(parts[0]);
                        String nome = parts[1];
                        String documento = parts[2];
                        String consultasStr = parts[3];
                        Paciente paciente = new Paciente(id, nome, documento);
                        if (!consultasStr.isEmpty()) {
                            String[] consultaIds = consultasStr.split(",");
                            for (String consultaId : consultaIds) {
                                int idConsulta = Integer.parseInt(consultaId);
                                entities.Consulta consultaEncontrada = clinica.getConsultasList().stream()
                                        .filter(c -> c.getId() == idConsulta)
                                        .findFirst()
                                        .orElse(null);
                                if (consultaEncontrada != null) {
                                    paciente.getConsultaCliente().add(consultaEncontrada);
                                }
                            }
                        }
                        clinica.getPacienteList().add(paciente);
                    }

                }

            }catch (FileNotFoundException e) {
                System.out.println("Arquivo de pacientes não encontrado. Iniciando com lista vazia.");

            }catch(java.io.IOException e ){
                System.out.println("Erro ao carregar pacientes: " + e.getMessage());
            }
        }

        public void carregarAgendamentos(Clinica clinica){
            try(java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader("agendamentos.txt"))){
                String line;
                while((line = reader.readLine()) != null){
                    String [] parts = line.split(" \\| ");
                    if (parts.length == 3){
                        int idAgendamento = Integer.parseInt(parts[0]);
                        int idPaciente = Integer.parseInt(parts[1]);
                        int idConsulta = Integer.parseInt(parts[2]);

                        Paciente pacienteEncontrado = clinica.getPacienteList().stream()
                                .filter(p -> p.getId() == idPaciente)
                                .findFirst()
                                .orElse(null);

                        entities.Consulta consultaEncontrada = clinica.getConsultasList().stream()
                                .filter(c -> c.getId() == idConsulta)
                                .findFirst()
                                .orElse(null);

                        if (pacienteEncontrado != null && consultaEncontrada != null) {
                            entities.Agendamento agendamento = new entities.Agendamento(idAgendamento, pacienteEncontrado, consultaEncontrada);
                            clinica.getAgendamentoList().add(agendamento);
                        }
                    }

                }

            }catch (FileNotFoundException e) {
                System.out.println("Arquivo de agendamentos não encontrado. Iniciando com lista vazia.");

            }catch(java.io.IOException e ){
                System.out.println("Erro ao carregar agendamentos: " + e.getMessage());
            }
        }

        public void carregarDados(Clinica clinica) {
            carregarMedicos(clinica);
            carregarConsultas(clinica);
            carregarFuncionarios(clinica);
            carregarPacientes(clinica);
            carregarAgendamentos(clinica);
        }

        public void salvarDados(Clinica clinica) {
            salvarMedicos(clinica);
            salvarConsultas(clinica);
            salvarPacientes(clinica);
            salvarAgendamentos(clinica);
            salvarFuncionarios(clinica);
        }

}

