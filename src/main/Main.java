package main;

import entities.Clinica;
import entities.Consulta;
import services.AgendamentoServices;
import services.ConsultaServices;
import services.PacienteServices;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Clinica clinica = new Clinica();
        ConsultaServices cServices = new ConsultaServices();
        PacienteServices pServices = new PacienteServices();
        AgendamentoServices aServices = new AgendamentoServices();

        boolean finalizar = true;

        while (finalizar) {
            System.out.println("______________________");
            System.out.println(" SISTEMA CLINICA BVDS ");
            System.out.println("______________________");
            System.out.println(" CADASTRAR NOVA CONSULTA    [ 1 ]");
            System.out.println(" CADASTRAR NOVO PACIENTE    [ 2 ]");
            System.out.println(" AGENDAR CONSULTA           [ 3 ]");
            System.out.println(" CANCELAR CONSULTA          [ 4 ]");
            System.out.println(" LISTAR CONSULTAS DO DIA    [ 5 ]");
            System.out.println(" FINALIZAR                  [ 6 ]");

            switch (sc.nextInt()) {
                case 1:
                    cServices.criaConsulta(sc, clinica);
                    for (Consulta c : clinica.getConsultasList()) {
                        System.out.println(c);
                    }
                    break;
                case 2:
                    sc.nextLine();
                    pServices.criaPaciente(sc, clinica);
                    for (entities.Paciente p : clinica.getPacienteList()) {
                        System.out.println(p);
                    }
                    break;
                case 3:
                    aServices.criarAgendamento(sc, clinica);
                    for (entities.Agendamento a : clinica.getAgendamentoList()) {
                        System.out.println(a);
                    }
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    finalizar = false;
                    System.out.println("Finalizando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }

        sc.close();
    }
}