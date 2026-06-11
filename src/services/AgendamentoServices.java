package services;
import entities.*;

import java.util.InputMismatchException;
import java.util.Scanner;
public class AgendamentoServices {

    public void criarAgendamento(Scanner sc, Clinica clinica) {
        System.out.println("--Criação de Agendamento--");

        int idPaciente = 0;
        boolean idPacienteValido = false;
        while (!idPacienteValido) {
            try {
                System.out.println("Digite o ID do Paciente:");
                idPaciente = sc.nextInt();
                sc.nextLine();
                idPacienteValido = true;
            } catch (InputMismatchException e) {
                System.out.println("_____________________________");
                System.out.println("Digite um numero de ID valido");
                System.out.println("_____________________________");
                sc.nextLine();
            }
        }
        final int idPacienteFinal = idPaciente;

        Paciente pacienteEncontrado = clinica.getPacienteList().stream()
                .filter(p -> p.getId() == idPacienteFinal)
                .findFirst()
                .orElse(null);

        if (pacienteEncontrado == null) {
            System.out.println("Erro: Paciente com ID " + idPacienteFinal + " não encontrado.");
            return;
        }

        for (Consulta c : clinica.getConsultasList()) {
            System.out.println(c);
        }

        int idConsulta = 0;
        boolean idConsultaValido = false;
        while (!idConsultaValido) {
            try {
                System.out.println("Digite o ID da Consulta:");
                idConsulta = sc.nextInt();
                sc.nextLine();
                idConsultaValido = true;
            } catch (InputMismatchException e) {
                System.out.println("_____________________________");
                System.out.println("Digite um numero de ID valido");
                System.out.println("_____________________________");
                sc.nextLine();
            }
        }
        final int idConsultaFinal = idConsulta;

        Consulta consultaEncontrada = clinica.getConsultasList().stream()
                .filter(c -> c.getId() == idConsultaFinal)
                .findFirst()
                .orElse(null);

        if (consultaEncontrada == null) {
            System.out.println("Erro: Consulta com ID " + idConsultaFinal + " não foi encontrada no sistema.");
            return;
        }

        if (consultaEncontrada.getStatusConsulta() != Status.DISPONIVEL) {
            System.out.println("Aviso: Esta consulta já está ocupada!");
            return;
        }

        Agendamento novoAgendamento = new Agendamento(pacienteEncontrado, consultaEncontrada);
        clinica.getAgendamentoList().add(novoAgendamento);
        consultaEncontrada.setStatusConsulta(Status.AGENDADA);
        System.out.println("Agendamento criado com sucesso!");
    }

    public void cancelarAgendamento(Scanner sc, Clinica clinica) {
        System.out.println("--Cancelando Agendamento--");
        for (Agendamento ag : clinica.getAgendamentoList()) {
            System.out.println(ag);
        }

        int idAgendamento = 0;
        boolean idValido = false;
        while (!idValido) {
            try {
                System.out.println("Digite o ID do Agendamento:");
                idAgendamento = sc.nextInt();
                sc.nextLine();
                idValido = true;
            } catch (InputMismatchException e) {
                System.out.println("_____________________________");
                System.out.println("Digite um numero de ID valido");
                System.out.println("_____________________________");
                sc.nextLine();
            }
        }

        final int id = idAgendamento; // ✅ effectively final para o lambda

        Agendamento agendamentoEncontrado = clinica.getAgendamentoList().stream()
                .filter(a -> a.getIdAgendamento() == id)
                .findFirst()
                .orElse(null);

        if (agendamentoEncontrado == null) {
            System.out.println("Erro: Agendamento com ID " + id + " não foi encontrado.");
            return;
        }
        clinica.getAgendamentoList().remove(agendamentoEncontrado);
        agendamentoEncontrado.getConsulta().setStatusConsulta(Status.DISPONIVEL);
        System.out.println("Agendamento cancelado com sucesso!");
    }


}


