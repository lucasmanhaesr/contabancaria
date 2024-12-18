package controller;

import model.Conta;
import repository.ContaRepository;
import java.util.ArrayList;
import java.util.List;

public class ContaController implements ContaRepository {

    private List<Conta> listaContas = new ArrayList<>();
    int numero = 0;

    @Override
    public void procurarPorNumero(int numero) {
        Conta contaOpt = buscarNaCollection(numero);

        if (contaOpt != null)
            contaOpt.visualizar();
        else{
            System.out.println("\nA Conta número: " + numero + " não foi encontrada!");
        }
    }

    @Override
    public void listarTodas() {
        listaContas.forEach(conta -> conta.visualizar());
    }

    @Override
    public void cadastrar(Conta conta) {
        listaContas.add(conta);
        System.out.println("Conta " + conta.getNumero() + " foi cadastrada com sucesso!");
    }

    @Override
    public void atualizar(Conta conta) {
        Conta contaOpt = buscarNaCollection(conta.getNumero());

        if (contaOpt != null) {
            listaContas.set(listaContas.indexOf(contaOpt), conta);
            System.out.println("\nA Conta numero: " + conta.getNumero() + " foi atualizada com sucesso!");
        }else{
            System.out.println("\nA Conta numero: " + conta.getNumero() + " não foi encontrada!");
        }
    }

    @Override
    public void deletar(int numero) {
        Conta conta = buscarNaCollection(numero);

        if (conta != null) {
            if(listaContas.remove(conta) == true)
                System.out.println("\nA Conta numero: " + numero + " foi deletada com sucesso!");
        }else
            System.out.println("\nA Conta numero: " + numero + " não foi encontrada!");
    }

    @Override
    public void sacar(int numero, float valor) {
        var conta = buscarNaCollection(numero);

        if (conta != null) {

            if(conta.sacar(valor) == true)
                System.out.println("\nO Saque na Conta numero: " + numero + " foi efetuado com sucesso!");

        }else {
            System.out.println("\nA Conta numero: " + numero + " não foi encontrada!");
        }
    }

    @Override
    public void depositar(int numero, float valor) {
        var conta = buscarNaCollection(numero);

        if (conta != null) {
            conta.depositar(valor);
            System.out.println("\nO Depósito na Conta numero: " + numero + " foi efetuado com sucesso!");
        }else {
            System.out.println("\nA Conta numero: " + numero + " não foi encontrada ou a Conta destino não é uma Conta Corrente!");
        }
    }

    @Override
    public void transferir(int numeroOrigem, int numeroDestino, float valor) {
        var contaOrigem = buscarNaCollection(numeroOrigem);
        var contaDestino = buscarNaCollection(numeroDestino);

        if (contaOrigem != null && contaDestino != null) {

            if (contaOrigem.sacar(valor) == true) {
                contaDestino.depositar(valor);
                System.out.println("\nA Transferência foi efetuado com sucesso!");
            }
        } else{
            System.out.println("\nA Conta de Origem e/ou Destino não foram encontradas!");
        }
    }

    public int gerarNumero() {
        return ++ numero;
    }

    public Conta buscarNaCollection(int numero) {
        for (Conta conta : listaContas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }

        return null;
    }
}
