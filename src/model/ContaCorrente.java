package model;

public class ContaCorrente extends Conta{

    private float limite;

    public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
        super(numero, agencia, tipo, titular, saldo);
        this.limite = limite;
    }

    //Sobrecarga
    public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo) {
        super(numero, agencia, tipo, titular, saldo);
        this.limite = 500;
    }


    public float getLimite() {
        return limite;
    }
    public void setLimite(float limite) {
        this.limite = limite;
    }

    //Sobreescrita
    public void visualizar(){
        String tipo = "";

        switch(super.getTipo()){
            case 1:
                tipo = "Conta Corrente";
                break;
            case 2:
                tipo = "Conta Poupanca";
                break;
        }
        System.out.println("\n\n***************************************************");
        System.out.println("                  EXTRATO BANCÁRIO");
        System.out.println("***************************************************");
        System.out.println("Numero da Conta: " + super.getNumero());
        System.out.println("Agência: " + super.getAgencia());
        System.out.println("Tipo da Conta: " + tipo);
        System.out.println("Titular: " + super.getTitular());
        System.out.println("Saldo: " + super.getSaldo());
        System.out.println("Limite: " + getLimite());
        System.out.println("***************************************************\n\n");
    }
}
