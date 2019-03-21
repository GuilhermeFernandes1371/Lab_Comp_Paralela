package linhaDeProducao;

import controlador.Core;
import controlador.Velocidade;
import modelo.Eletronica;

import java.awt.*;
import java.util.ArrayList;

public class LPEletronica extends Thread {

    private int TEMPO_DE_FABRICACAO_BASE = 7000;
    private int TEMPO_DE_FABRICACAO = 7000;
    private int ESTOQUE_MAXIMO      = 8;

    private boolean estoqueCheio = false;

    private int eletronicaFabricados = 0;
    private ArrayList<Eletronica> estoque = new ArrayList<Eletronica>();

    public synchronized void run() {
        while(true) {
            try {

                this.checkEstoque();
                this.esperaTempoDeFabricacao();

                Eletronica eletronica = this.produz();
                estoque.add(eletronica);

                String texto = this.estoque.size() + "/" + this.ESTOQUE_MAXIMO;
                Core.interfaceGrafica.barraDeProgressoEstoqueEletronica.setString(texto);
                Core.interfaceGrafica.barraDeProgressoEstoqueEletronica.setValue(this.estoque.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void checkEstoque() throws InterruptedException {
        if (estoque.size() >= ESTOQUE_MAXIMO) {
            Core.interfaceGrafica.barraDeProgressoEletronica.setIndeterminate(true);
            Core.interfaceGrafica.barraDeProgressoEletronica.setString("Fábrica Parada");
            Core.interfaceGrafica.barraDeProgressoEletronica.setBackground(Color.RED);
            this.estoqueCheio = true;
            this.wait();
            Core.interfaceGrafica.barraDeProgressoEletronica.setIndeterminate(false);
            Core.interfaceGrafica.barraDeProgressoEletronica.setBackground(Color.WHITE);
        }
    }

    private void esperaTempoDeFabricacao() throws InterruptedException {
        int particoes = Core.QUANTIDADE_PARTICOES_TEMPO_FABRICACAO_BARRA_DE_PROGRESSO;
        int sleep_time = TEMPO_DE_FABRICACAO / particoes;
        Core.interfaceGrafica.barraDeProgressoEletronica.setValue(0);
        Core.interfaceGrafica.barraDeProgressoEletronica.setString("0%");
        for (int i=0; i< particoes ; i++) {
            String texto = (100 / particoes) * (i+1) + "%";
            Thread.sleep(sleep_time);
            Core.interfaceGrafica.barraDeProgressoEletronica.setValue(Core.interfaceGrafica.barraDeProgressoEletronica.getValue()+1);
            Core.interfaceGrafica.barraDeProgressoEletronica.setString(texto);
        }
    }

    private Eletronica produz() {
        int id = this.eletronicaFabricados;
        boolean arCondicionado = this.sorteiaArCondicionado();
        boolean vidroEletrico = this.sorteiaVidroEletrico();
        boolean centralMultimidia = this.sorteiaCentralMultimidia();

        Eletronica eletronica = new Eletronica(id, arCondicionado, vidroEletrico, centralMultimidia);
        this.eletronicaFabricados++;
        Core.interfaceGrafica.eletronicosFabricados.setText("Eletrônicas Fabricados: " +this.eletronicaFabricados);

        return eletronica;
    }

    private boolean sorteiaArCondicionado() {
        int sorteio = (int) (Math.random() * 1);

        if (sorteio == 0) {
            return true;
        }else if (sorteio == 1) {
            return false;
        }else{
            System.out.println("Erro ao sortear ar condicionado em Fabrica de eletronica");
            return false;
        }
    }

    private boolean sorteiaVidroEletrico() {
        int sorteio = (int) (Math.random() * 1);

        if (sorteio == 0) {
            return true;
        }else if (sorteio == 1) {
            return false;
        }else{
            System.out.println("Erro ao sortear vidro eletrico em Fabrica de eletronica");
            return false;
        }
    }

    private boolean sorteiaCentralMultimidia() {
        int sorteio = (int) (Math.random() * 1);

        if (sorteio == 0) {
            return true;
        }else if (sorteio == 1) {
            return false;
        }else{
            System.out.println("Erro ao sortear central multimidia em Fabrica de eletronica");
            return false;
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

    public int getEletronicaFabricados() {
        return eletronicaFabricados;
    }

    public void setEletronicaFabricados(int eletronicaFabricados) {
        this.eletronicaFabricados = eletronicaFabricados;
    }

    public ArrayList<Eletronica> getEstoque() {
        return estoque;
    }

    public void setEstoque(ArrayList<Eletronica> estoque) {
        this.estoque = estoque;
    }

    public boolean isEstoqueCheio() {
        return estoqueCheio;
    }

    public void setEstoqueCheio(boolean estoqueCheio) {
        this.estoqueCheio = estoqueCheio;
    }
}
