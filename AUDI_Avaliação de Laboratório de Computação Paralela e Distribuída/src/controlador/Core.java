package controlador;

import linhaDeProducao.*;
import view.Interface;

public class Core {

    //Configurações de Inicialização
    public static boolean IS_TO_PRINT_LOG = false;
    public static int ACELERADOR_DE_VELOCIDADE_INICIAL_DAS_FABRICAS = 1;
    public static int QUANTIDADE_PARTICOES_TEMPO_FABRICACAO_BARRA_DE_PROGRESSO = 10;

    //Controladores
    public static VerificaStatusThread controladorDeStatusThread;
    public static Velocidade controladorDeVelocidade;
    public static VerificaProducao controladorDeProducao;

    //Fabricas
    public static LPMotores fabricaMotores;
    public static LPBanco fabricaBanco;
    public static LPCarroceria fabricaCarroceria;
    public static LPEletronica fabricaEletronica;
    public static LPPneu fabricaPneu;
    public static LPCarro fabricaCarro;
    public static LPCaminhao fabricaCaminhao;

    //Interface Grafica
    public static Interface interfaceGrafica;

    public Core() {
        this.fabricaMotores = new LPMotores();
        this.fabricaBanco = new LPBanco();
        this.fabricaCarroceria = new LPCarroceria();
        this.fabricaEletronica = new LPEletronica();
        this.fabricaPneu = new LPPneu();
        this.fabricaCarro = new LPCarro(this.fabricaBanco,this.fabricaCarroceria,this.fabricaEletronica,this.fabricaMotores,this.fabricaPneu);
        this.fabricaCaminhao = new LPCaminhao(this.fabricaCarro);

        this.controladorDeVelocidade = new Velocidade();
        this.controladorDeStatusThread = new VerificaStatusThread();

        Velocidade.setVelocidadeBase(ACELERADOR_DE_VELOCIDADE_INICIAL_DAS_FABRICAS);

        this.interfaceGrafica = new Interface();
        this.controladorDeProducao = new VerificaProducao(interfaceGrafica);

        this.startThreads();
        this.tentarPrintarLogs();
    }

    private void startThreads() {
        fabricaMotores.start();
        fabricaBanco.start();
        fabricaCarroceria.start();
        fabricaEletronica.start();
        fabricaPneu.start();
        fabricaCarro.start();
        fabricaCaminhao.start();
        controladorDeStatusThread.start();
        controladorDeProducao.start();
    }

    private void tentarPrintarLogs() {
        if (this.IS_TO_PRINT_LOG) {
            new Thread() {
                public void run() {
                    while(true) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Motor: " + fabricaMotores.getEstoque().size() + "/" + fabricaMotores.getESTOQUE_MAXIMO());
                        System.out.println("Banco: " + fabricaBanco.getEstoque().size() + "/" + fabricaBanco.getESTOQUE_MAXIMO());
                        System.out.println("Carroceria: " + fabricaCarroceria.getEstoque().size() + "/" + fabricaCarroceria.getESTOQUE_MAXIMO());
                        System.out.println("Eletronica: " + fabricaEletronica.getEstoque().size() + "/" + fabricaEletronica.getESTOQUE_MAXIMO());
                        System.out.println("Pneu: " + fabricaPneu.getEstoque().size() + "/" + fabricaPneu.getESTOQUE_MAXIMO());
                        System.out.println("Carros: " + fabricaCarro.getEstoque().size() + "/999");
                        System.out.println("Carregamentos: " + fabricaCaminhao.getCaminhoes().size() + "/999");
                        System.out.println("--------------------");
                    }
                }
            }.start();
        }
    }
}
