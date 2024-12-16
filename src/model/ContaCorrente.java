package model;

public class ContaCorrente extends Conta {

    public Titular titular;
    private float limite;

    public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite, Titular titular1) {
        super(numero, agencia, tipo, titular, saldo);
        this.limite = limite;
        Titular titular2 = new Titular("", "");
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

}
