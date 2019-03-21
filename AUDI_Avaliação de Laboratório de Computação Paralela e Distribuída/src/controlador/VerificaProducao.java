package controlador;

import view.Interface;

import javax.swing.*;

public class VerificaProducao extends Thread {

    private Interface interfaceGrafica;
    private int INTERVALO_VERIFICACAO = 10000;

    private int old_motor = 0;
    private int old_carroceria = 0;
    private int old_eletronica = 0;
    private int old_banco = 0;
    private int old_pneu = 0;
    private int old_carro = 0;
    private int old_caminhao = 0;

    public VerificaProducao(Interface interfaceGrafica) {
        this.interfaceGrafica = interfaceGrafica;
    }

    public void run() {
        while(true) {
            try {
                for (int i=0; i<10; i++) {
                    Core.interfaceGrafica.panelInformacoes.setBorder(
                            BorderFactory.createTitledBorder("Métricas - (Atualizado em " + (10-i) + " segundos)")
                    );
                    Thread.currentThread().sleep(this.INTERVALO_VERIFICACAO/10);
                }




                this.atualizaValores();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void atualizaValores() {
        this.interfaceGrafica.motorProducaoHora.setText(this.calculaMotor());
        this.interfaceGrafica.carroceriaProducaoHora.setText(this.calculaCarroceria());
        this.interfaceGrafica.eletronicaProducaoHora.setText(this.calculaEletronica());
        this.interfaceGrafica.pneusProducaoHora.setText(this.calculaPneus());
        this.interfaceGrafica.bancoProducaoHora.setText(this.calculaBanco());
        this.interfaceGrafica.carroProducaoHora.setText(this.calculaCarros());
        this.interfaceGrafica.caminhaoProducaoHora.setText(this.calculaCaminhao());
    }

    private int transformaEmHoras(int producao) {
        float intervaloSegundos = this.INTERVALO_VERIFICACAO / 1000;
        float producao_por_segundo = producao / intervaloSegundos;
        return (int)(producao_por_segundo * 3600);
    }

    private String calculaMotor() {
        int new_motor = Core.fabricaMotores.getMotoresFabricados();
        int producao = new_motor - this.old_motor;
        this.old_motor = new_motor;
        return transformaEmHoras(producao) + " Motores/Hora";
    }

    private String calculaCarroceria() {
        int new_carroceria = Core.fabricaCarroceria.getCarroceriaFabricados();
        int producao = new_carroceria - this.old_carroceria;
        this.old_carroceria = new_carroceria;
        return transformaEmHoras(producao) + " Carrocerias/Hora";
    }

    private String calculaEletronica() {
        int new_eletronica = Core.fabricaEletronica.getEletronicaFabricados();
        int producao = new_eletronica - this.old_eletronica;
        this.old_eletronica = new_eletronica;
        return transformaEmHoras(producao) + " Eletrônicos/Hora";
    }

    private String calculaPneus() {
        int new_pneu = Core.fabricaPneu.getPneusFabricados();
        int producao = new_pneu - this.old_pneu;
        this.old_pneu = new_pneu;
        return transformaEmHoras(producao) + " Pneus/Hora";
    }

    private String calculaBanco() {
        int new_banco = Core.fabricaBanco.getBancosFabricados();
        int producao = new_banco - this.old_banco;
        this.old_banco = new_banco;
        return transformaEmHoras(producao) + " Bancos/Hora";
    }

    private String calculaCarros() {
        int new_carro = Core.fabricaCarro.getCarrosFabricados();
        int producao = new_carro - this.old_carro;
        this.old_carro = new_carro;
        return transformaEmHoras(producao) + " Carros/Hora";
    }

    private String calculaCaminhao() {
        int new_caminhao = Core.fabricaCaminhao.getCaminhoes().size();
        int producao = new_caminhao - this.old_caminhao;
        this.old_caminhao = new_caminhao;
        return transformaEmHoras(producao) + " Caminhoẽs/Hora";
    }

}
