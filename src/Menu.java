import controller.ContaController;
import model.Conta;
import model.ContaCorrente;
import model.Titular;
import util.Cores;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner scanf = new Scanner(System.in);

        ContaController contas = new ContaController();

        int opcao;

        while (true) {
            System.out.println("***************************************************");
            System.out.println("                                                   ");
            System.out.println("                        ITAÚ                       ");
            System.out.println("                                                   ");
            System.out.println("***************************************************");
            System.out.println("                                                   ");
            System.out.println("            1 - Criar conta                        ");
            System.out.println("            2 - Listar todas as contas             ");
            System.out.println("            3 - Buscar conta por número            ");
            System.out.println("            4 - Atualizar dados da conta           ");
            System.out.println("            5 - Apagar conta                       ");
            System.out.println("            6 - Sacar                              ");
            System.out.println("            7 - Depositar                          ");
            System.out.println("            8 - Tranferir                          ");
            System.out.println("            9 - Sair                               ");
            System.out.println("                                                   ");
            System.out.println("***************************************************");
            System.out.println("                                                   ");
            System.out.print("Entre com a opção desejada: ");

            try{
                opcao = scanf.nextInt();
            }catch(InputMismatchException exception){
                System.err.println("Excessão: " + exception.getLocalizedMessage() + " (" + exception.getCause() + ") ");
                System.out.print("Digite um número inteiros entre 1 - 9: ");
                scanf.nextLine();
                opcao = 0;
            }

            switch (opcao) {
                case 1:
                    System.out.println("\n Criar Conta");
                    System.out.print("\n Digite o nome completo: ");
                    String nome = scanf.nextLine();

                    System.out.print("\n Digite o nome do conta: ");
                    String cpf = scanf.nextLine();

                    System.out.print("\n Digite 1 para Conta Corrente ou 2 para Conta Poupança: ");
                    int tipo = scanf.nextInt();


                    Titular titular = new Titular(nome, cpf);
                    //Conta cc = new ContaCorrente();

                    keyPress();
                    break;
                case 2:
                    System.out.println("\n Listar todas as Contas");
                    contas.listarTodas();
                    keyPress();
                    break;
                case 3:
                    System.out.println("\n Buscar Conta por número");

                    keyPress();
                    break;
                case 4:
                    System.out.println("\n Atualizar dados da Conta");

                    keyPress();
                    break;
                case 5:
                    System.out.println("\n Apagar Conta");

                    keyPress();
                    break;
                case 6:
                    System.out.println("\n Sacar");

                    keyPress();
                    break;
                case 7:
                    System.out.println("\n Depositar");

                    keyPress();
                    break;
                case 8:
                    System.out.println("\n Transferir");

                    keyPress();
                    break;
                case 9:
                    keyPress();
                    System.exit(0);
                default:
                    System.out.println("Opção Inválida" + Cores.TEXT_RESET);

                    keyPress();
                    break;
            }
        }
    }

    public static void sobre(){
        System.out.println("*********************************************");
        System.out.println("                                             ");
        System.out.println("Projeto desenvolvido por: Lucas Ramos Manhães");
        System.out.println("https://github.com/lucasmanhaesr/contabancaria");
        System.out.println("                                             ");
        System.out.println("*********************************************");
    }

    public static void keyPress() {
        try {

            System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
            System.in.read();

        } catch (IOException e) {

            System.out.println("Você pressionou uma tecla diferente de enter!");

        }
    }

}
