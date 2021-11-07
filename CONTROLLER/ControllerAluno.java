package CONTROLLER;

import MODEL.Aluno;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerAluno {

    public static void Cadastro(ArrayList<Aluno> aluno) {

        Scanner recebe = new Scanner(System.in);
        String nome, nascimento, turno;

        System.out.println("\n-------------------------");
        System.out.println("    CADASTRO DE ALUNOS");
        System.out.println("-------------------------\n");

        System.out.print("Nome: ");
        nome = recebe.nextLine();

        System.out.print("Data de nascimento(dd/mm/aaaa): ");
        nascimento = recebe.nextLine();

        String[] data = nascimento.split("/");

        int dia = Integer.parseInt(data[0]);
        int mes = Integer.parseInt(data[1]);
        int ano = Integer.parseInt(data[2]);

        System.out.print("Turno (MANHA / NOITE): ");
        turno = recebe.nextLine();

        aluno.add(new Aluno(nome, turno, ano, mes, dia));
    }

    private static int Idade(Aluno a) {

        int ano = a.getNascimento().getYear();
        int mes = a.getNascimento().getMonthValue();
        int dia = a.getNascimento().getDayOfMonth();

        int IdadeAtual = LocalDate.now().getYear() - ano;

        if (mes > LocalDate.now().getMonthValue()) {

            IdadeAtual--;
        } else {

            if (mes == LocalDate.now().getMonthValue() && dia > LocalDate.now().getDayOfMonth()) {
                IdadeAtual--;
            }
        }

        return IdadeAtual;

    }

    private static void Imprime(Aluno a) {

        DateTimeFormatter ordemBrasil = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        System.out.println("Aluno: " + a.getNome());
        System.out.println("Idade: " + Idade(a));
        System.out.println("Data de nascimento: " + a.getNascimento().format(ordemBrasil));
        System.out.println("Turno: " + a.getTurno().toUpperCase());
        System.out.println("*********************");
    }

    public static void RelatorioMaiorIdade(boolean verifica, ArrayList<Aluno> aluno) {

        boolean vazio = true;

        if (aluno.isEmpty()) {

            System.out.println("\n----------------------------------------------");
            System.out.println("            NENHUM ALUNO CADASTRADO!");
            System.out.println("----------------------------------------------\n");
        } else {

            if (verifica) {

                System.out.println("\n------------------------------");
                System.out.println("     ALUNOS MAIORES DE IDADE");
                System.out.println("------------------------------\n");

                for (Aluno a : aluno) {

                    if (Idade(a) >= 18) {
                        Imprime(a);

                        vazio = false;
                    }
                }

                if (vazio) {

                    System.out.println("NENHUM ALUNO MAIOR DE IDADE CADASTRADO!");
                }

            } else {

                System.out.println("\n------------------------------");
                System.out.println("     ALUNOS MENORES DE IDADE");
                System.out.println("------------------------------\n");

                for (Aluno a : aluno) {

                    if (Idade(a) < 18) {
                        Imprime(a);

                        vazio = false;
                    }
                }

                if (vazio) {

                    System.out.println("NENHUM ALUNO MENOR DE IDADE CADASTRADO!");
                }
            }
        }
    }

    public static void RelatorioMaisVelhoPorTurno(boolean verifica, String turno, ArrayList<Aluno> aluno) {

        if (aluno.isEmpty()) {

            System.out.println("\n----------------------------------------------");
            System.out.println("            NENHUM ALUNO CADASTRADO!");
            System.out.println("----------------------------------------------\n");
        } else {

            ArrayList<Aluno> TurnoAL = new ArrayList<>();

            //Separando os alunos do turno desejado
            for (int i = 0; i < aluno.size(); i++) {

                if (aluno.get(i).getTurno().equalsIgnoreCase(turno)) {

                    TurnoAL.add(aluno.get(i));

                }
            }

            if (TurnoAL.isEmpty()) {

                System.out.println("\n-----------------------------------------------------------------------");
                System.out.println("   NENHUM ALUNO DO TURNO DA " + turno.toUpperCase() + " CADASTRADO!");
                System.out.println("------------------------------------------------------------------------\n");
            } else {

                for (int i = 0; i < TurnoAL.size(); i++) {
                    for (int j = 1; j < TurnoAL.size(); j++) {

                        if (TurnoAL.get(j).getNascimento().isBefore(TurnoAL.get(j - 1).getNascimento())) {

                            Aluno aux = TurnoAL.get(j - 1);
                            TurnoAL.set(j - 1, TurnoAL.get(j));
                            TurnoAL.set(j, aux);
                        }
                    }
                }

                if (verifica) {

                    System.out.println("\n---------------------------------------------");
                    System.out.println("      ALUNO MAIS VELHO DO TURNO DA " + turno);
                    System.out.println("---------------------------------------------\n");
                    Imprime(TurnoAL.get(0));

                } else {

                    System.out.println("\n---------------------------------------------");
                    System.out.println("      ALUNO MAIS NOVO DO TURNO DA " + turno);
                    System.out.println("---------------------------------------------\n");
                    Imprime(TurnoAL.get(TurnoAL.size() - 1));
                }
            }
        }
    }

    public static void RelatorioMaisVelhoMaisNovo(ArrayList<Aluno> aluno) {

        if (aluno.isEmpty()) {

            System.out.println("\n----------------------------------------------");
            System.out.println("            NENHUM ALUNO CADASTRADO!");
            System.out.println("----------------------------------------------\n");
        } else {

            for (int i = 0; i < aluno.size(); i++) {
                for (int j = 1; j < aluno.size(); j++) {

                    if (aluno.get(j).getNascimento().isBefore(aluno.get(j - 1).getNascimento())) {

                        Aluno aux = aluno.get(j - 1);
                        aluno.set(j - 1, aluno.get(j));
                        aluno.set(j, aux);
                    }
                }
            }

            System.out.println("\n-----------------------------------------------------------");
            System.out.println("      RELATÓRIO DE ALUNOS DO MAIS VELHO PARA O MAIS NOVO");
            System.out.println("-----------------------------------------------------------\n");

            for (Aluno a : aluno) {

                Imprime(a);
            }
        }
    }

}
