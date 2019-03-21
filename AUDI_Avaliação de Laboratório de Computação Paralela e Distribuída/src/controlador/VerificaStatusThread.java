package controlador;

import linhaDeProducao.*;

public class VerificaStatusThread extends Thread {

    private int TEMPO_DE_VERIFICACAO = 150;

    private LPBanco fabricaBanco;
    private LPCarroceria fabricaCarroceria;
    private LPEletronica fabricaEletronica;
    private LPMotores fabricaMotores;
    private LPPneu fabricaPneu;
    private LPCarro fabricaCarro;

    public VerificaStatusThread() {
        this.fabricaBanco = Core.fabricaBanco;
        this.fabricaCarroceria = Core.fabricaCarroceria;
        this.fabricaEletronica = Core.fabricaEletronica;
        this.fabricaMotores = Core.fabricaMotores;
        this.fabricaPneu = Core.fabricaPneu;
        this.fabricaCarro = Core.fabricaCarro;
    }

    public void run() {
        new Thread() {
            public void run() {
                verificaFabricaPneu();
            }
        }.start();
        new Thread() {
            public void run() {
                verificaFabricaMotores();
            }
        }.start();
        new Thread() {
            public void run() {
                verificaFabricaEletronica();
            }
        }.start();
        new Thread() {
            public void run() {
                verificaFabricaCarroceria();
            }
        }.start();
        new Thread() {
            public void run() {
                verificaFabricaBanco();
            }
        }.start();
    }


    private void verificaFabricaEletronica() {
        try {
            while(true) {
                Thread.currentThread().sleep(TEMPO_DE_VERIFICACAO);
                if (this.fabricaEletronica.getEstoque().size() < this.fabricaEletronica.getESTOQUE_MAXIMO() && this.fabricaEletronica.isEstoqueCheio()) {
                    synchronized (this.fabricaEletronica) {
                        this.fabricaEletronica.notify();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void verificaFabricaMotores() {
        try {
            while(true) {
                Thread.currentThread().sleep(TEMPO_DE_VERIFICACAO);
                if (this.fabricaMotores.getEstoque().size() < this.fabricaMotores.getESTOQUE_MAXIMO() && this.fabricaMotores.isEstoqueCheio()) {
                    synchronized (this.fabricaMotores) {
                        this.fabricaMotores.notify();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void verificaFabricaPneu() {
        try {
            while(true) {
                Thread.currentThread().sleep(TEMPO_DE_VERIFICACAO);
                if (this.fabricaPneu.getEstoque().size() < this.fabricaPneu.getESTOQUE_MAXIMO() && this.fabricaPneu.isEstoqueCheio()) {
                    synchronized (this.fabricaPneu) {
                        this.fabricaPneu.notify();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    private void verificaFabricaBanco() {
        try {
            while(true) {
                Thread.currentThread().sleep(TEMPO_DE_VERIFICACAO);
                if (this.fabricaBanco.getEstoque().size() < this.fabricaBanco.getESTOQUE_MAXIMO() && this.fabricaBanco.isEstoqueCheio()) {
                    synchronized (this.fabricaBanco) {
                        this.fabricaBanco.notify();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void verificaFabricaCarroceria() {
        try {
            while(true) {
                Thread.currentThread().sleep(TEMPO_DE_VERIFICACAO);
                if (this.fabricaCarroceria.getEstoque().size() < this.fabricaCarroceria.getESTOQUE_MAXIMO() && this.fabricaCarroceria.isEstoqueCheio()) {
                    synchronized (this.fabricaCarroceria) {
                        this.fabricaCarroceria.notify();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getTEMPO_DE_VERIFICACAO() {
        return TEMPO_DE_VERIFICACAO;
    }

    public void setTEMPO_DE_VERIFICACAO(int TEMPO_DE_VERIFICACAO) {
        this.TEMPO_DE_VERIFICACAO = TEMPO_DE_VERIFICACAO;
    }
}
