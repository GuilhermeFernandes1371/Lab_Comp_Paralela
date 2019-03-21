package linhaDeProducao;

import controlador.Core;
import controlador.Velocidade;
import modelo.Carroceria;

import java.awt.*;
import java.util.ArrayList;

public class LPCarroceria extends Thread {

    private int TEMPO_DE_FABRICACAO_BASE = 15000;
    private int TEMPO_DE_FABRICACAO = 15000;
    private int ESTOQUE_MAXIMO      = 20;

    private boolean estoqueCheio = false;

    private int carroceriaFabricados = 0;
    private ArrayList<Carroceria> estoque = new ArrayList<Carroceria>();

    public synchronized void run() {
        while(true) {
            try {

                this.checkEstoque();
                this.esperaTempoDeFabricacao();

                Carroceria carroceria = this.produz();
                estoque.add(carroceria);

                String texto = this.estoque.size() + "/" + this.ESTOQUE_MAXIMO;
                Core.interfaceGrafica.barraDeProgressoEstoqueCarroceria.setString(texto);
                Core.interfaceGrafica.barraDeProgressoEstoqueCarroceria.setValue(this.estoque.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void checkEstoque() throws InterruptedException {
        if (estoque.size() >= ESTOQUE_MAXIMO) {
            Core.interfaceGrafica.barraDeProgressoCarroceria.setIndeterminate(true);
            Core.interfaceGrafica.barraDeProgressoCarroceria.setString("Fábrica Parada");
            Core.interfaceGrafica.barraDeProgressoCarroceria.setBackground(Color.RED);
            this.estoqueCheio = true;
            this.wait();
            Core.interfaceGrafica.barraDeProgressoCarroceria.setIndeterminate(false);
            Core.interfaceGrafica.barraDeProgressoCarroceria.setBackground(Color.WHITE);
        }
    }

    private void esperaTempoDeFabricacao() throws InterruptedException {
        int particoes = Core.QUANTIDADE_PARTICOES_TEMPO_FABRICACAO_BARRA_DE_PROGRESSO;
        int sleep_time = TEMPO_DE_FABRICACAO / particoes;
        Core.interfaceGrafica.barraDeProgressoCarroceria.setValue(0);
        Core.interfaceGrafica.barraDeProgressoCarroceria.setString("0%");
        for (int i=0; i< particoes ; i++) {
            String texto = (100 / particoes) * (i+1) + "%";
            Thread.sleep(sleep_time);
            Core.interfaceGrafica.barraDeProgressoCarroceria.setValue(Core.interfaceGrafica.barraDeProgressoCarroceria.getValue()+1);
            Core.interfaceGrafica.barraDeProgressoCarroceria.setString(texto);
        }
    }

    private Carroceria produz() {
        int id = this.carroceriaFabricados;
        Color cor = this.sorteiaCor();
        String formato = this.sorteiaFormato();

        Carroceria carroceria = new Carroceria(id, cor, formato);
        this.carroceriaFabricados++;
        Core.interfaceGrafica.carroceriasFabricados.setText("Carrocerias Fabricados: " +this.carroceriaFabricados);

        return carroceria;
    }

    private Color sorteiaCor() {
        int sorteio = (1 + (int) (Math.random() * 6));

        switch (sorteio) {
            case 1:
                return Color.BLACK;
            case 2:
                return Color.BLUE;
            case 3:
                return Color.RED;
            case 4:
                return Color.GREEN;
            case 5:
                return Color.ORANGE;
            case 6:
                return Color.PINK;
            default:
                System.out.println("Erro em SorteiaCor|FabricaDeCarroceria");
                return Color.WHITE;
        }
    }

    private String sorteiaFormato() {
        int sorteio = (1 + (int) (Math.random() * 6));

        switch (sorteio) {
            case 1:
                return "Sedan";
            case 2:
                return "Pick-up";
            case 3:
                return "Jipe";
            case 4:
                return "Coupé";
            case 5:
                return "Hatch";
            case 6:
                return "SUV";
            default:
                System.out.println("Erro em SorteiaFormato|FabricaDeCarroceria");
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

    public int getCarroceriaFabricados() {
        return carroceriaFabricados;
    }

    public void setCarroceriaFabricados(int carroceriaFabricados) {
        this.carroceriaFabricados = carroceriaFabricados;
    }

    public ArrayList<Carroceria> getEstoque() {
        return estoque;
    }

    public void setEstoque(ArrayList<Carroceria> estoque) {
        this.estoque = estoque;
    }

    public boolean isEstoqueCheio() {
        return estoqueCheio;
    }

    public void setEstoqueCheio(boolean estoqueCheio) {
        this.estoqueCheio = estoqueCheio;
    }
}
