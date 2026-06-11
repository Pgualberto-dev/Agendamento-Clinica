package services;

import entities.Clinica;
import entities.Paciente;

import java.util.Scanner;

public class PacienteServices {

    public void criaPaciente(Scanner sc, Clinica clinica) {
        System.out.println("--Criação de Paciente--");

        System.out.println("Digite o nome do Paciente:");
        String nome = sc.nextLine();
        System.out.println("Digite o documento do Paciente:");
        String documento = sc.nextLine();
        // Inicializa maxId com 0 para encontrar o maior ID existente
        int maxId = 0;
        // Percorre a lista de pacientes para encontrar o maior ID
        for (Paciente p : clinica.getPacienteList()) {
            // Verifica se o ID do paciente atual é maior que maxId
            if (p.getId() > maxId) {
                // Atualiza maxId com o ID do paciente
                maxId = p.getId();
            }
        }
        // Calcula o próximo ID incrementando maxId
        int id = maxId + 1;

        clinica.getPacienteList().add(new entities.Paciente(id, nome, documento));

    }
}

