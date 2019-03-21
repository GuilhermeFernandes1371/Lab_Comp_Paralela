package linhaDeProducao;

import controlador.Core;
import controlador.Velocidade;
import modelo.Pneu;

import java.awt.*;
import java.util.ArrayList;

public class LPPneu extends Thread {

    private int TEMPO_DE_FABRICACAO_BASE = 9000;
    private int TEMPO_DE_FABRICACAO = 9000;
    private int ESTOQUE_MAXIMO      = 100;

    private boolean estoqueCheio = false;

    private int pneusFabricados = 0;
    private ArrayList<Pneu> estoque = new ArrayList<Pneu>();

    public synchronized void run() {
        while(true) {
            try {

                this.checkEstoque();
                this.esperaTempoDeFabricacao();

                Pneu pneu = this.produz();
                estoque.add(pneu);

                String texto = this.estoque.size() + "/" + this.ESTOQUE_MAXIMO;
                Core.interfaceGrafica.barraDeProgressoEstoquePneus.setString(texto);
                Core.interfaceGrafica.barraDeProgressoEstoquePneus.setValue(this.estoque.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void checkEstoque() throws InterruptedException {
        if (estoque.size() >= ESTOQUE_MAXIMO) {
            Core.interfaceGrafica.barraDeProgressoPneus.setIndeterminate(true);
            Core.interfaceGrafica.barraDeProgressoPneus.setString("Fábrica Parada");
            Core.interfaceGrafica.barraDeProgressoPneus.setBackground(Color.RED);
            this.estoqueCheio = true;
            this.wait();
            Core.interfaceGrafica.barraDeProgressoPneus.setIndeterminate(false);
            Core.interfaceGrafica.barraDeProgressoPneus.setBackground(Color.WHITE);
        }
    }

    private void esperaTempoDeFabricacao() throws InterruptedException {
        int particoes = Core.QUANTIDADE_PARTICOES_TEMPO_FABRICACAO_BARRA_DE_PROGRESSO;
        int sleep_time = TEMPO_DE_FABRICACAO / particoes;
        Core.interfaceGrafica.barraDeProgressoPneus.setValue(0);
        Core.interfaceGrafica.barraDeProgressoPneus.setString("0%");
        for (int i=0; i< particoes ; i++) {
            String texto = (100 / particoes) * (i+1) + "%";
            Thread.sleep(sleep_time);
            Core.interfaceGrafica.barraDeProgressoPneus.setValue(Core.interfaceGrafica.barraDeProgressoPneus.getValue() + 1);
            Core.interfaceGrafica.barraDeProgressoPneus.setString(texto);
        }
    }

    private Pneu produz() {
        int id = this.pneusFabricados;
        int aro = this.sorteiaAro();
        String especialidade = this.sorteiaEspecialidade();

        Pneu pneu = new Pneu(id, aro, especialidade);
        this.pneusFabricados++;
        Core.interfaceGrafica.pneusFabricados.setText("Pneus Fabricados: " +this.pneusFabricados);

        return pneu;
    }

    private int sorteiaAro() {
        //Sorteia um numero entre 10 e 20, referente aro do pneu (tamanho do pneu)
        return (10 + (int) (Math.random() * 20));
    }

    private String sorteiaEspecialidade() {
        int sorteio = (1 + (int) (Math.random() * 4));

        switch (sorteio) {
            case 1:
                return "Chuva";
            case 2:
                return "Corrida";
            case 3:
                return "Neve";
            case 4:
                return "Barro";
            default:
                System.out.println("Erro em SorteiaEspecialidade|FabricaDePneu");
                return "Indefinido";
        }
    }

    public int getTEMPO_DE_FABRICACAO() {
        return TEMPO_DE_FABRICACAO;
    }

    public void setTEMPO_DE_FABRICACAO(int TEMPO_DE_FABRICACAO) {
        this.TEMPO_DE_FABRICACAO = TEMPO_DE_FABRICACAO_BASE / Velocidade.getVelocidadeBase();
    }

    public int getESTOQUE_MAXIMO() {
        return ESTOQUE_MAXIMO;
    }

    public void setESTOQUE_MAXIMO(int ESTOQUE_MAXIMO) {
        this.ESTOQUE_MAXIMO = ESTOQUE_MAXIMO;
    }

    public int getPneusFabricados() {
        return pneusFabricados;
    }

    public void setPneusFabricados(int pneusFabricados) {
        this.pneusFabricados = pneusFabricados;
    }

    public ArrayList<Pneu> getEstoque() {
        return estoque;
    }

    public void setEstoque(ArrayList<Pneu> estoque) {
        this.estoque = estoque;
    }

    public boolean isEstoqueCheio() {
        return estoqueCheio;
    }

    public void setEstoqueCheio(boolean estoqueCheio) {
        this.estoqueCheio = estoqueCheio;
    }
}
