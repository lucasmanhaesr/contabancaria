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

    @Override
    public boolean sacar(float valor){
        if(this.getSaldo() + this.getLimite() < valor){
            System.out.println("Saldo insuficiente");
            return false;
        }
        this.setSaldo(this.getSaldo() - valor);
        return true;
    }

    //Sobreescrita
    @Override
    public void visualizar(){
        super.visualizar();
        System.out.println("Limite de crédito: " + this.getLimite());
        System.out.println("***************************************************\n\n");
    }
}
