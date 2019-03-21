package controle_estoque;

import java.util.ArrayList;

public class Estoque {
    private ArrayList<Integer> lista = new ArrayList();
    private int max = 10;

    public void add() throws Exception {
        if (lista.size() < max) {
            lista.add(1);
            System.out.println("Produzido");
        }else{
            System.out.println("Tentando adicionar! Lista cheia");
            throw new Exception("Estoque cheio");
        }
    }

    public void remove() throws Exception {
        if (lista.size() != 0) {
            lista.remove(lista.size() - 1);
            System.out.println("Consumido");
        }else{
            System.out.println("Tentando remover! Lista vazia");
            throw new Exception("Estoque vazio");
        }
    }

    public int size() {
        return lista.size();
    }

    public int max() {
        return this.max;
    }
}
