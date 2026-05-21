package services;

import entities.Clinica;
import entities.Consulta;
import entities.TypeSpecialty;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsultaServices {

    public void criaConsulta(Scanner sc, Clinica clinica) {
        int id = 0;
        TypeSpecialty especialidade1 = null;
        boolean idTeste = false;
        System.out.println("--Criação de Consulta--");
        while (!idTeste) {
            try {
                System.out.println("Digite o ID do Consulta:");
                id = sc.nextInt();
                sc.nextLine();
                idTeste = true;
            } catch (InputMismatchException e) {
                System.out.println("______________________________________");
                System.out.println("       Digite numeros inteiros        ");
                System.out.println("______________________________________");
                sc.nextLine();
            }
        }
        boolean esp = false;
        System.out.println("Digite a especialidade da Consulta:");
        while (!esp) {
            try {
                String especialidade = sc.nextLine();
                especialidade1 = TypeSpecialty.valueOf(especialidade);
                esp = true;
            } catch (IllegalArgumentException e) {
                System.out.println("______________________________________");
                System.out.println("Especialidade digitada de forma errada");
                System.out.println("______________________________________");
            }
        }
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
            } catch (DateTimeParseException e) {
                // Se der erro, avisa o usuário e o loop repete
                System.out.println("Formato inválido! Por favor, use o padrão dd/MM/yyyy HH:mm.");
            }
        }
        System.out.println("Digite o nome do medico");
        String nomeMedico = sc.nextLine();
        Instant dataHoraInstant = datHora.atZone(ZoneId.systemDefault()).toInstant();
        Consulta novaConsulta = new Consulta(id, especialidade1, nomeMedico, dataHoraInstant);
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
