import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner scanf = new Scanner(System.in);

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
            opcao = scanf.nextInt();

            if(opcao == 9){
                System.out.println("Banco Itaú - Feito pra você!");
                sobre();
                scanf.close();
                System.exit(0);
            }

            switch (opcao) {
                case 1:
                    System.out.println("Criar conta");
                    break;
                case 2:
                    System.out.println("Listar todas as contas");
                    break;
                case 3:
                    System.out.println("Consultar dados da conta - Por número");
                    break;
                case 4:
                    System.out.println("Atualizar da conta");
                    break;
                case 5:
                    System.out.println("Apagar a conta");
                    break;
                case 6:
                    System.out.println("Saque");
                    break;
                case 7:
                    System.out.println("Deposito");
                    break;
                case 8:
                    System.out.println("Tranferência entre contas");
                    break;
                default:
                    System.out.println("Opcao invalida");
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
}