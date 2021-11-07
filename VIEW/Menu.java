package VIEW;

import MODEL.Aluno;
import java.util.ArrayList;
import java.util.Scanner;
import CONTROLLER.ControllerMenu;
import CONTROLLER.ControllerAluno;

public class Menu {
    
    private static Scanner get = new Scanner(System.in);
    private static int escolha;
    
    public static void MenuPrincipal(ArrayList<Aluno> aluno){
        
        while(0==0){
         
            System.out.println("\n==========================");
            System.out.println("        MENU PRINCIPAL");
            System.out.println("==========================\n");
            System.out.println("1 - CADASTRO");
            System.out.println("2 - CONSULTA");
            System.out.println("3 - **SAIR**");
            System.out.print("Opção escolhida: ");
            escolha = get.nextInt();
            
            switch(escolha){
                
                case 1:
                    MenuCadastro(aluno);
                    break;
                    
                case 2:
                    MenuConsulta(aluno);
                    break;
                    
                case 3:
                    ControllerMenu.Sair();
                    break;
                    
                default:
                    ControllerMenu.OpInvalida();
                    break;
            }
        }
    }
    
    
    private static void MenuCadastro(ArrayList<Aluno> aluno){
        
        while(0==0){
         
            System.out.println("\n==========================");
            System.out.println("       MENU DE CADASTRO");
            System.out.println("==========================\n");
            System.out.println("1 - ALUNO");
            System.out.println("2 - **VOLTAR P/ O MENU PRINCIPAL");
            System.out.println("3 - **SAIR**");
            System.out.print("Opção escolhida: ");
            escolha = get.nextInt();
            
            switch(escolha){
                
                case 1:
                    ControllerAluno.Cadastro(aluno);
                    break;
                    
                case 2:
                    MenuPrincipal(aluno);
                    break;
                    
                case 3:
                    ControllerMenu.Sair();
                    break;
                    
                default:
                    ControllerMenu.OpInvalida();
                    break;
            }
        }
    }
    
    
    private static void MenuConsulta(ArrayList<Aluno> aluno){
        
        while(0==0){
         
            System.out.println("\n==========================");
            System.out.println("       MENU DE CONSULTA");
            System.out.println("==========================\n");
            System.out.println("1 - ALUNOS MAIORES DE IDADE");
            System.out.println("2 - ALUNOS MENORES DE IDADE");
            System.out.println("3 - ALUNO MAIS VELHO DA MANHÃ");
            System.out.println("4 - ALUNO MAIS NOVO DA NOITE");
            System.out.println("5 - ALUNOS POR ORDEM DO MAIS VELHO PARA O MAIS NOVO");
            System.out.println("6 - **VOLTAR P/ O MENU PRINCIPAL");
            System.out.println("7 - **SAIR**");
            System.out.print("Opção escolhida: ");
            escolha = get.nextInt();
            
            switch(escolha){
                
                case 1:
                    ControllerAluno.RelatorioMaiorIdade(true, aluno);
                    break;
                    
                case 2:
                    ControllerAluno.RelatorioMaiorIdade(false, aluno);
                    break;
                    
                case 3:
                    ControllerAluno.RelatorioMaisVelhoPorTurno(true, "MANHA", aluno);
                    break;
                    
                case 4:
                    ControllerAluno.RelatorioMaisVelhoPorTurno(false, "NOITE", aluno);
                    break;
                    
                case 5:
                    ControllerAluno.RelatorioMaisVelhoMaisNovo(aluno);
                    break;
                    
                case 6:
                    MenuPrincipal(aluno);
                    break;
                    
                case 7:
                    ControllerMenu.Sair();
                    break;
                    
                default:
                    ControllerMenu.OpInvalida();
                    break;
            }
        }
    }
}
