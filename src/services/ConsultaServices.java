package services;

import entities.Clinica;
import entities.Consulta;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsultaServices {

    public void criaConsulta(Scanner sc, Clinica clinica) {
        int id;
        System.out.println("--Criação de Consulta--");
        System.out.println("Digite o ID do Consulta:");
        id = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite a especialidade da Consulta:");
        String especialidade = sc.nextLine();
        String dataHora = null;
        LocalDateTime datHora = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        boolean dataValida = false;
        while (!dataValida) {
            System.out.println("Digite a data e hora da Consulta:");
            dataHora = sc.nextLine();

            try {
                // Tenta converter se converter sai do loop.
                datHora = LocalDateTime.parse(dataHora, formatter);
                dataValida = true;
            } catch (java.time.format.DateTimeParseException e) {
                // Se der erro, avisa o usuário e o loop repete
                System.out.println("Formato inválido! Por favor, use o padrão dd/MM/yyyy HH:mm.");
            }
        }
        System.out.println("Digite o nome do medico");
        String nomeMedico = sc.nextLine();
        Instant dataHoraInstant = datHora.atZone(ZoneId.systemDefault()).toInstant();
        Consulta novaConsulta = new Consulta(id, especialidade, nomeMedico, dataHoraInstant);
        clinica.getConsultasList().add(novaConsulta);
    }

    public void listarConsultasDoDia(Scanner sc, Clinica clinica) {
        System.out.println("--Listar Consultas do Dia--");
        System.out.println("Digite a data (dd/MM/yyyy):");
        String dataInput = sc.nextLine();
        LocalDate data = LocalDate.parse(dataInput, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        for (Consulta c : clinica.getConsultasList()) {
            LocalDate dataConsulta = c.getDataHora().atZone(ZoneId.systemDefault()).toLocalDate();
            if (dataConsulta.equals(data)) {
                System.out.println(c);
            }
        }
    }
}
