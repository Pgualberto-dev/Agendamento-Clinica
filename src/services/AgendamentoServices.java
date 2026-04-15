package services;
import entities.Agendamento;
import entities.Clinica;
import entities.Consulta;
import entities.Paciente;
import java.util.Scanner;
public class AgendamentoServices {

    public void criarAgendamento(Scanner sc, Clinica clinica) {
        System.out.println("--Criação de Agendamento--");

        System.out.println("Digite o ID do Paciente:");
        int idPaciente = sc.nextInt();
        sc.nextLine();

        Paciente pacienteEncontrado = clinica.getPacienteList().stream()
                .filter(p -> p.getIdPaciente() == idPaciente)
                .findFirst() // Pega o primeiro que bater com o ID
                .orElse(null); // Se não achar ninguém, pacienteEncontrado vira null

        if (pacienteEncontrado == null) {
            System.out.println("Erro: Paciente com ID " + idPaciente + " não encontrado.");
            return;
        }

        for (Consulta c : clinica.getConsultasList()) {
            System.out.println(c);
        }
        System.out.println("Digite o ID da Consulta:");
        int idConsulta = sc.nextInt();
        sc.nextLine();

        Consulta consultaEncontrada = clinica.getConsultasList().stream()
                .filter(c -> c.getId() == idConsulta)
                .findFirst() // Pega o primeiro que bater com o ID
                .orElse(null); // Se não achar ninguém, consultaEncontrado vira null

        if (consultaEncontrada == null) {
            System.out.println("Erro: Consulta com ID " + idConsulta + " não foi encontrada no sistema.");
            return; // O return vazio mata a execução do metodo criarAgendamento aqui mesmo!
        }
        // Verifica se a consulta NÃO está disponível
        if (!consultaEncontrada.isDisponivel()) {
            System.out.println("Aviso: Esta consulta já está ocupada!");
            return; // O 'return' encerra o metodo aqui na hora, impedindo o agendamento
        }

            Agendamento novoAgendamento = new Agendamento(pacienteEncontrado, consultaEncontrada);
            clinica.getAgendamentoList().add(novoAgendamento);
            consultaEncontrada.setDisponivel(false); // Marca a consulta como ocupada
            System.out.println("Agendamento criado com sucesso!");

        }

    }

