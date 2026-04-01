package services;

import entities.Clinica;
import entities.Consulta;

import java.time.Instant;
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
        System.out.println("Digite a data e hora da Consulta:");
        String dataHora = sc.nextLine();
        System.out.println("Digite o nome do medico");
        String nomeMedico = sc.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime  datHora = LocalDateTime.parse(dataHora, formatter);
        Instant dataHoraInstant = datHora.atZone(ZoneId.systemDefault()).toInstant();

        Consulta novaConsulta = new Consulta(id, especialidade, nomeMedico, dataHoraInstant);
        clinica.getConsultasList().add(novaConsulta);
    }
}
