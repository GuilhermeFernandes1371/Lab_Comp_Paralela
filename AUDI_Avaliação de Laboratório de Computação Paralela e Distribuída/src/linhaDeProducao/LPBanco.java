package linhaDeProducao;

import controlador.Core;
import controlador.Velocidade;
import modelo.Banco;

import java.awt.*;
import java.util.ArrayList;

public class LPBanco extends Thread {

    private int TEMPO_DE_FABRICACAO_BASE = 6000;
    private int TEMPO_DE_FABRICACAO = 6000;
    private int ESTOQUE_MAXIMO      = 25;

    private boolean estoqueCheio = false;

    private int bancosFabricados = 0;
    private ArrayList<Banco> estoque = new ArrayList<Banco>();

    public synchronized void run() {
        while(true) {
            try {

                this.checkEstoque();
                this.esperaTempoDeFabricacao();

                Banco banco = this.produz();
                estoque.add(banco);

                String texto = this.estoque.size() + "/" + this.ESTOQUE_MAXIMO;
                Core.interfaceGrafica.barraDeProgressoEstoqueBanco.setString(texto);
                Core.interfaceGrafica.barraDeProgressoEstoqueBanco.setValue(this.estoque.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void checkEstoque() throws InterruptedException {
        if (estoque.size() >= ESTOQUE_MAXIMO) {
            Core.interfaceGrafica.barraDeProgressoBanco.setIndeterminate(true);
            Core.interfaceGrafica.barraDeProgressoBanco.setString("Fábrica Parada");
            Core.interfaceGrafica.barraDeProgressoBanco.setBackground(Color.RED);
            this.estoqueCheio = true;
            this.wait();
            Core.interfaceGrafica.barraDeProgressoBanco.setIndeterminate(false);
            Core.interfaceGrafica.barraDeProgressoBanco.setBackground(Color.WHITE);
        }
    }

    private void esperaTempoDeFabricacao() throws InterruptedException {
        int particoes = Core.QUANTIDADE_PARTICOES_TEMPO_FABRICACAO_BARRA_DE_PROGRESSO;
        int sleep_time = TEMPO_DE_FABRICACAO / particoes;
        Core.interfaceGrafica.barraDeProgressoBanco.setValue(0);
        Core.interfaceGrafica.barraDeProgressoBanco.setString("0%");
        for (int i=0; i< particoes ; i++) {
            String texto = (100 / particoes) * (i+1) + "%";
            Thread.sleep(sleep_time);
            Core.interfaceGrafica.barraDeProgressoBanco.setValue(Core.interfaceGrafica.barraDeProgressoBanco.getValue()+1);
            Core.interfaceGrafica.barraDeProgressoBanco.setString(texto);
        }
    }

    private Banco produz() {
        int id = this.bancosFabricados;
        String material = this.sorteiaMaterial();
        Color cor = this.sorteiaCor();

        Banco banco = new Banco(id, material, cor);
        this.bancosFabricados++;
        Core.interfaceGrafica.bancosFabricados.setText("Bancos Fabricados: " +this.bancosFabricados);

        return banco;
    }

    private Color sorteiaCor() {
        int sorteio = (1 + (int) (Math.random() * 4));

        switch (sorteio) {
            case 1:
                return Color.BLACK;
            case 2:
                return Color.BLUE;
            case 3:
                return Color.RED;
            case 4:
                return Color.GREEN;
            default:
                System.out.println("Erro em SorteiaCor|FabricaDeBanco");
                return Color.WHITE;
        }
    }

    private String sorteiaMaterial() {
        int sorteio = (1 + (int) (Math.random() * 3));

        switch (sorteio) {
            case 1:
                return "Couro";
            case 2:
                return "Pano";
            case 3:
                return "Poliester";
            default:
                System.out.println("Erro em SorteiaMaterial|FabricaDeBanco");
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

    public int getBancosFabricados() {
        return bancosFabricados;
    }

    public void setBancosFabricados(int bancosFabricados) {
        this.bancosFabricados = bancosFabricados;
    }

    public ArrayList<Banco> getEstoque() {
        return estoque;
    }

    public void setEstoque(ArrayList<Banco> estoque) {
        this.estoque = estoque;
    }

    public boolean isEstoqueCheio() {
        return estoqueCheio;
    }

    public void setEstoqueCheio(boolean estoqueCheio) {
        this.estoqueCheio = estoqueCheio;
    }
}
