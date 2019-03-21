package linhaDeProducao;

import controlador.Core;
import modelo.Caminhao;
import modelo.Carro;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LPCaminhao extends Thread {

    private int QUANTIDADE_DE_CARROS_TRANSPORTADOS_POR_CAMINHAO = 10;

    private int caminhoesFechados = 0;
    private ArrayList<Caminhao> caminhoesTransportados = new ArrayList<>();
    private ArrayList<Carro> carrosASeremTransportados = new ArrayList<>();
    private LPCarro lpCarro;

    public LPCaminhao(LPCarro lpCarro) {
        this.lpCarro = lpCarro;
    }

    public synchronized void run() {
        while(true) {
            if (this.verificaCarroDisponivelParaSerTransportado()) {
                this.carrosASeremTransportados.add(this.lpCarro.getEstoque().remove(0));
                this.atualizaInterface();
                if (verificaSeExistemCaminhoesSuficientesParaTransportar()) {
                    Caminhao caminhao = this.produz();
                    this.transporta(caminhao);
                }
            }
            try {
                this.atualizaInterface();
                this.sleep(350);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void atualizaInterface() {
        int i=0;
        for (Carro carro : this.carrosASeremTransportados) {
            JButton button = Core.interfaceGrafica.listaCarrosASeremTransportados.get(i);
            button.setText("Carro ID: " + carro.getId());
            button.setBackground(new Color(169,169,169));

            i++;
        }
        for (i=i;i<this.QUANTIDADE_DE_CARROS_TRANSPORTADOS_POR_CAMINHAO;i++) {
            JButton button = Core.interfaceGrafica.listaCarrosASeremTransportados.get(i);
            button.setText("Espaço vazio");
            button.setBackground(new Color(205,50,50));
        }

    }

    private Caminhao produz() {
        ArrayList<Carro> carros = new ArrayList<>();
        for(int i=0; i<this.QUANTIDADE_DE_CARROS_TRANSPORTADOS_POR_CAMINHAO; i++) {
            carros.add(this.carrosASeremTransportados.remove(0));
        }

        Caminhao caminhao = new Caminhao(caminhoesFechados, carros);

        return caminhao;
    }

    private void transporta(Caminhao caminhao) {
        this.caminhoesTransportados.add(caminhao);
        this.carrosASeremTransportados.clear();
        this.caminhoesFechados++;
        Core.interfaceGrafica.caminhoesCarregados.setText("Caminhoes Carregados: " + Core.fabricaCaminhao.getCaminhoes().size());
    }

    private boolean verificaSeExistemCaminhoesSuficientesParaTransportar() {
        if ((this.carrosASeremTransportados.size() >= this.QUANTIDADE_DE_CARROS_TRANSPORTADOS_POR_CAMINHAO)) {
            return true;
        }else{
            return false;
        }
    }

    private boolean verificaCarroDisponivelParaSerTransportado() {
        if ((this.lpCarro.getEstoque().size() > 0)) {
            return true;
        }else{
            return false;
        }
    }

    public ArrayList<Caminhao> getCaminhoes() {
        return caminhoesTransportados;
    }

    public void setCaminhoes(ArrayList<Caminhao> caminhoes) {
        this.caminhoesTransportados = caminhoes;
    }

    public int getQUANTIDADE_DE_CARROS_TRANSPORTADOS_POR_CAMINHAO() {
        return QUANTIDADE_DE_CARROS_TRANSPORTADOS_POR_CAMINHAO;
    }

    public ArrayList<Carro> getCarrosASeremTransportados() {
        return carrosASeremTransportados;
    }
}
