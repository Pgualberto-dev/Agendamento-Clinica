package main;

import entities.Clinica;
import entities.Consulta;
import services.ConsultaServices;

import java.util.Locale;
import java.util.Scanner;

public class Main {
         static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Clinica clinica = new Clinica();
        Consulta consulta;
        ConsultaServices cServices = new ConsultaServices();
        boolean finalizar = true;


            System.out.println("______________________");
            System.out.println(" SISTEMA CLINICA BVDS ");
            System.out.println("______________________");
            System.out.println(" CADASTRAR NOVA CONSULTA [ 1 ]");
            System.out.println("    AGENDAR CONSULTA    [ 2 ]");
            System.out.println("    CANCELAR CONSULTA   [ 3 ]");
            System.out.println("  LISTAR CONSULTAS DIA  [ 4 ]");


            switch (sc.nextInt()) {
                case 1:
                    cServices.criaConsulta(sc,clinica );
                    for (Consulta c : clinica.getConsultasList()) {
                        System.out.println(c);
                    }
                    break;
                case 2:
                    //metodo de agendamento
                    break;
                case 3:
                    //metodo de cancelamento
                    break;
                case 4:
                    //metodo de listar consultas do dia
                    break;
                default:



            }
        }
    }
