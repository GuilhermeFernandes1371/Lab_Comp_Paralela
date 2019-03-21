package linhaDeProducao;

import controlador.Core;
import controlador.Velocidade;
import modelo.Motor;

import java.awt.*;
import java.util.ArrayList;

public class LPMotores extends Thread {

    private int TEMPO_DE_FABRICACAO_BASE = 12000;
    private int TEMPO_DE_FABRICACAO = 12000;
    private int ESTOQUE_MAXIMO      = 10;

    private boolean estoqueCheio = false;

    private int motoresFabricados = 0;
    private ArrayList<Motor> estoque = new ArrayList<Motor>();

    public synchronized void run() {
        while(true) {
            try {

                this.checkEstoque();
                this.esperaTempoDeFabricacao();

                Motor motor = this.produz();
                estoque.add(motor);

                String texto = this.estoque.size() + "/" + this.ESTOQUE_MAXIMO;
                Core.interfaceGrafica.barraDeProgressoEstoqueMotores.setString(texto);
                Core.interfaceGrafica.barraDeProgressoEstoqueMotores.setValue(this.estoque.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void checkEstoque() throws InterruptedException {
        if (estoque.size() >= ESTOQUE_MAXIMO) {
            Core.interfaceGrafica.barraDeProgressoMotores.setIndeterminate(true);
            Core.interfaceGrafica.barraDeProgressoMotores.setString("Fábrica Parada");
            Core.interfaceGrafica.barraDeProgressoMotores.setBackground(Color.RED);
            this.estoqueCheio = true;
            this.wait();
            Core.interfaceGrafica.barraDeProgressoMotores.setIndeterminate(false);
            Core.interfaceGrafica.barraDeProgressoMotores.setBackground(Color.WHITE);
        }
    }

    private void esperaTempoDeFabricacao() throws InterruptedException {
        int particoes = Core.QUANTIDADE_PARTICOES_TEMPO_FABRICACAO_BARRA_DE_PROGRESSO;
        int sleep_time = TEMPO_DE_FABRICACAO / particoes;
        Core.interfaceGrafica.barraDeProgressoMotores.setValue(0);
        Core.interfaceGrafica.barraDeProgressoMotores.setString("0%");
        for (int i=0; i< particoes ; i++) {
            String texto = (100 / particoes) * (i+1) + "%";
            Thread.sleep(sleep_time);
            Core.interfaceGrafica.barraDeProgressoMotores.setValue(Core.interfaceGrafica.barraDeProgressoMotores.getValue()+1);
            Core.interfaceGrafica.barraDeProgressoMotores.setString(texto);
        }
    }

    private Motor produz() {
        int id = this.motoresFabricados;
        int cv = this.sorteiaCavalos();
        String combustao = this.sorteiaCombustao();
        boolean isTurbinado = this.sorteiaTurbo();

        Motor motor = new Motor(id, cv,combustao,isTurbinado);
        this.motoresFabricados++;
        Core.interfaceGrafica.motoresFabricados.setText("Motores Fabricados: " +this.motoresFabricados);

        return motor;
    }

    private int sorteiaCavalos() {
        //Sorteia um numero entre 100 e 340, referente aos CV (Horse Power) do motor
        return (100 + (int) (Math.random() * 340));
    }

    private String sorteiaCombustao() {
        int sorteio = (1 + (int) (Math.random() * 5));

        switch (sorteio) {
            case 1:
                return "Diesel";
            case 2:
                return "Gasolina";
            case 3:
                return "Eletrico";
            case 4:
                return "Alchool";
            case 5:
                return "Gás";
            default:
                System.out.println("Erro em SorteiaCombustao|FabricaDeMotores");
                return "Indefinido";
        }
    }

    private boolean sorteiaTurbo() {
        int sorteio = 1 + ((int) (Math.random() * 2));

        if (sorteio == 1) {
            return true;
        }else if (sorteio == 2) {
            return false;
        }else{
            System.out.println("Erro ao sortear turbo em Fabrica de motores");
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

    public int getMotoresFabricados() {
        return motoresFabricados;
    }

    public void setMotoresFabricados(int motoresFabricados) {
        this.motoresFabricados = motoresFabricados;
    }

    public ArrayList<Motor> getEstoque() {
        return estoque;
    }

    public void setEstoque(ArrayList<Motor> estoque) {
        this.estoque = estoque;
    }

    public boolean isEstoqueCheio() {
        return estoqueCheio;
    }

    public void setEstoqueCheio(boolean estoqueCheio) {
        this.estoqueCheio = estoqueCheio;
    }
}
