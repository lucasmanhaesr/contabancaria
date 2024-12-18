import controller.ContaController;
import model.ContaCorrente;
import model.ContaPoupanca;
import util.Cores;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner scanf = new Scanner(System.in);

        ContaController contas = new ContaController();

        int opcao, numero, agencia, tipo, aniversario, numeroDestino;
        String titular;
        float saldo, limite, valor;

//        TESTE MOCK
//        ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
//        contas.cadastrar(cc1);
//
//        ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100.0f);
//        contas.cadastrar(cc2);
//
//        ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Mariana dos Santos", 4000f, 12);
//        contas.cadastrar(cp1);
//
//        ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Juliana Ramos", 8000f, 15);
//        contas.cadastrar(cp2);

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

            if (opcao == 9) {
                System.out.println("\n\nBanco Itaú - Feito pra você");
                sobre();
                scanf.close();
                System.exit(0);
            }

            switch (opcao) {
                case 1:
                    System.out.println("\nCriar Conta");
                    Random random = new Random();
                    agencia = random.nextInt(999);
                    System.out.println("Digite o Nome do Titular: ");
                    scanf.skip("\\R?");
                    titular = scanf.nextLine();

                    do {
                        System.out.println("Digite o Tipo da Conta (1-CC ou 2-CP): ");
                        tipo = scanf.nextInt();
                    }while(tipo < 1 && tipo > 2);

                    System.out.println("Digite o Saldo da Conta (R$): ");
                    saldo = scanf.nextFloat();

                    switch(tipo) {
                        case 1 -> {
                            System.out.println("Digite o Limite de Crédito (R$): ");
                            limite = scanf.nextFloat();
                            contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
                        }
                        case 2 -> {
                            System.out.println("Digite o dia do Aniversario da Conta: ");
                            aniversario = scanf.nextInt();
                            contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
                        }
                    }

                    keyPress();
                    break;
                case 2:
                    System.out.println("\n Listar todas as Contas");
                    contas.listarTodas();
                    keyPress();
                    break;
                case 3:
                    System.out.println("\n Buscar Conta por número");
                    System.out.println("Digite o número da conta: ");
                    numero = scanf.nextInt();

                    contas.procurarPorNumero(numero);
                    keyPress();
                    break;
                case 4:
                    System.out.println("\n Atualizar dados da Conta");
                    System.out.println("Digite o número da conta: ");
                    numero = scanf.nextInt();

                    var buscaConta = contas.buscarNaCollection(numero);

                    if (buscaConta != null) {

                        System.out.println("Digite o Numero da Agência: ");
                        agencia = scanf.nextInt();
                        System.out.println("Digite o Nome do Titular: ");
                        scanf.skip("\\R?");
                        titular = scanf.nextLine();

                        System.out.println("Digite o Saldo da Conta (R$): ");
                        saldo = scanf.nextFloat();

                        tipo = buscaConta.getTipo();

                        switch(tipo) {
                            case 1 -> {
                                System.out.println("Digite o Limite de Crédito (R$): ");
                                limite = scanf.nextFloat();
                                contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
                            }
                            case 2 -> {
                                System.out.println("Digite o dia do Aniversario da Conta: ");
                                aniversario = scanf.nextInt();
                                contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
                            }
                            default -> System.out.println("Tipo de conta inválido!");
                        }

                    }else {
                        System.out.println("\nConta não encontrada!");
                    }

                    keyPress();
                    break;
                case 5:
                    System.out.println("\n Apagar Conta");
                    System.out.println("Digite o número da conta: ");
                    numero = scanf.nextInt();
                    contas.deletar(numero);
                    keyPress();
                    break;
                case 6:
                    System.out.println(Cores.TEXT_WHITE + "Saque\n\n");

                    System.out.println("Digite o Numero da conta: ");
                    numero = scanf.nextInt();

                    do {
                        System.out.println("Digite o Valor do Saque (R$): ");
                        valor = scanf.nextFloat();
                    } while (valor <= 0);

                    contas.sacar(numero, valor);

                    keyPress();
                    break;
                case 7:
                    System.out.println(Cores.TEXT_WHITE + "Depósito\n\n");

                    System.out.println("Digite o Numero da conta: ");
                    numero = scanf.nextInt();

                    do {
                        System.out.println("Digite o Valor do Depósito (R$): ");
                        valor = scanf.nextFloat();
                    } while (valor <= 0);

                    contas.depositar(numero, valor);

                    keyPress();
                    break;
                case 8:
                    System.out.println(Cores.TEXT_WHITE + "Transferência entre Contas\n\n");

                    System.out.println("Digite o Numero da Conta de Origem: ");
                    numero = scanf.nextInt();
                    System.out.println("Digite o Numero da Conta de Destino: ");
                    numeroDestino = scanf.nextInt();

                    do {
                        System.out.println("Digite o Valor da Transferência (R$): ");
                        valor = scanf.nextFloat();
                    } while (valor <= 0);

                    contas.transferir(numero, numeroDestino, valor);

                    keyPress();
                    break;
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
