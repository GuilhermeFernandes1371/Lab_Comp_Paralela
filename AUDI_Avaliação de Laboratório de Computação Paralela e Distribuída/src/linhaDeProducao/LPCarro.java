package linhaDeProducao;

import controlador.Core;
import modelo.*;

import java.util.ArrayList;

public class LPCarro extends Thread {

    private int QUANTIDADE_MOTORES_POR_CARRO = 1;
    private int QUANTIDADE_CARROCERIAS_POR_CARRO = 1;
    private int QUANTIDADE_PNEUS_POR_CARRO = 4;
    private int QUANTIDADE_BANCOS_POR_CARRO = 5;
    private int QUANTIDADE_ELETRONICA_POR_CARRO = 1;

    private int carrosFabricados = 0;
    private ArrayList<Carro> estoque = new ArrayList<Carro>();
    private LPBanco lpBanco;
    private LPCarroceria lpCarroceria;
    private LPEletronica lpEletronica;
    private LPMotores lpMotores;
    private LPPneu lpPneu;

    public LPCarro(LPBanco lpBanco, LPCarroceria lpCarroceria, LPEletronica lpEletronica, LPMotores lpMotores, LPPneu lpPneu) {
        this.lpBanco = lpBanco;
        this.lpCarroceria = lpCarroceria;
        this.lpEletronica = lpEletronica;
        this.lpMotores = lpMotores;
        this.lpPneu = lpPneu;
    }

    public synchronized void run() {
        while(true) {
            this.verificaPecasParaAtualizarInterface();
            if (this.verificaDisponibilidadePecas()) {
                Carro carro = this.produz();
                estoque.add(carro);

            }else{
                try {
                    this.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void verificaPecasParaAtualizarInterface() {
        int contador = 0;

        //Verifica motor
        if (this.lpMotores.getEstoque().size() >= 1) {
            Core.interfaceGrafica.motor.setSelected(true);
            contador++;
        }

        //Verifica carroceria
        if (this.lpCarroceria.getEstoque().size() >= 1) {
            Core.interfaceGrafica.carroceria.setSelected(true);
            contador++;
        }

        //Verifica eletronica
        if (this.lpEletronica.getEstoque().size() >= 1) {
            Core.interfaceGrafica.eletronica.setSelected(true);
            contador++;
        }

        //Verifica pneus
        if (this.lpPneu.getEstoque().size() == 1) {
            Core.interfaceGrafica.pneu1.setSelected(true);
            Core.interfaceGrafica.pneu2.setSelected(false);
            Core.interfaceGrafica.pneu3.setSelected(false);
            Core.interfaceGrafica.pneu4.setSelected(false);
            contador = contador +1;
        } else if (this.lpPneu.getEstoque().size() == 2) {
            Core.interfaceGrafica.pneu1.setSelected(true);
            Core.interfaceGrafica.pneu2.setSelected(true);
            Core.interfaceGrafica.pneu3.setSelected(false);
            Core.interfaceGrafica.pneu4.setSelected(false);
            contador = contador +2;
        } else if (this.lpPneu.getEstoque().size() == 3) {
            Core.interfaceGrafica.pneu1.setSelected(true);
            Core.interfaceGrafica.pneu2.setSelected(true);
            Core.interfaceGrafica.pneu3.setSelected(true);
            Core.interfaceGrafica.pneu4.setSelected(false);
            contador = contador +3;
        } else if (this.lpPneu.getEstoque().size() == 4) {
            Core.interfaceGrafica.pneu1.setSelected(true);
            Core.interfaceGrafica.pneu2.setSelected(true);
            Core.interfaceGrafica.pneu3.setSelected(true);
            Core.interfaceGrafica.pneu4.setSelected(true);
            contador = contador +4;
        } else {
            Core.interfaceGrafica.pneu1.setSelected(false);
            Core.interfaceGrafica.pneu2.setSelected(false);
            Core.interfaceGrafica.pneu3.setSelected(false);
            Core.interfaceGrafica.pneu4.setSelected(false);
            contador = contador +0;
        }

        //Verifica bancos
        if (this.lpBanco.getEstoque().size() == 1) {
            Core.interfaceGrafica.banco1.setSelected(true);
            Core.interfaceGrafica.banco2.setSelected(false);
            Core.interfaceGrafica.banco3.setSelected(false);
            Core.interfaceGrafica.banco4.setSelected(false);
            Core.interfaceGrafica.banco5.setSelected(false);
            contador = contador +1;
        } else if (this.lpBanco.getEstoque().size() == 2) {
            Core.interfaceGrafica.banco1.setSelected(true);
            Core.interfaceGrafica.banco2.setSelected(true);
            Core.interfaceGrafica.banco3.setSelected(false);
            Core.interfaceGrafica.banco4.setSelected(false);
            Core.interfaceGrafica.banco5.setSelected(false);
            contador = contador +2;
        } else if (this.lpBanco.getEstoque().size() == 3) {
            Core.interfaceGrafica.banco1.setSelected(true);
            Core.interfaceGrafica.banco2.setSelected(true);
            Core.interfaceGrafica.banco3.setSelected(true);
            Core.interfaceGrafica.banco4.setSelected(false);
            Core.interfaceGrafica.banco5.setSelected(false);
            contador = contador +3;
        } else if (this.lpBanco.getEstoque().size() == 4) {
            Core.interfaceGrafica.banco1.setSelected(true);
            Core.interfaceGrafica.banco2.setSelected(true);
            Core.interfaceGrafica.banco3.setSelected(true);
            Core.interfaceGrafica.banco4.setSelected(true);
            Core.interfaceGrafica.banco5.setSelected(false);
            contador = contador +4;
        } else if (this.lpBanco.getEstoque().size() == 5) {
            Core.interfaceGrafica.banco1.setSelected(true);
            Core.interfaceGrafica.banco2.setSelected(true);
            Core.interfaceGrafica.banco3.setSelected(true);
            Core.interfaceGrafica.banco4.setSelected(true);
            Core.interfaceGrafica.banco5.setSelected(true);
            contador = contador +5;
        } else {
            Core.interfaceGrafica.banco1.setSelected(false);
            Core.interfaceGrafica.banco2.setSelected(false);
            Core.interfaceGrafica.banco3.setSelected(false);
            Core.interfaceGrafica.banco4.setSelected(false);
            Core.interfaceGrafica.banco5.setSelected(false);
            contador = contador +0;
        }

        Core.interfaceGrafica.barraDeProgressoCarro.setValue(contador);
    }

    private Carro produz() {
        int id = this.carrosFabricados;
        Motor motor = this.lpMotores.getEstoque().remove(0);
        Carroceria carroceria = this.lpCarroceria.getEstoque().remove(0);
        Eletronica eletronica = this.lpEletronica.getEstoque().remove(0);
        Pneu pneuDianteiroEsquerdo = this.lpPneu.getEstoque().remove(0);
        Pneu pneuDianteiroDireito = this.lpPneu.getEstoque().remove(0);
        Pneu pneuTraseiroEsquerdo = this.lpPneu.getEstoque().remove(0);
        Pneu pneuTraseiroDireito = this.lpPneu.getEstoque().remove(0);
        Banco bancoDianteiroEsquerdo = this.lpBanco.getEstoque().remove(0);
        Banco bancoDianteiroDireito = this.lpBanco.getEstoque().remove(0);
        Banco bancoTraseiroCentral = this.lpBanco.getEstoque().remove(0);
        Banco bancoTraseiroEsquerdo = this.lpBanco.getEstoque().remove(0);
        Banco bancoTraseiroDireito = this.lpBanco.getEstoque().remove(0);

        Carro carro = new Carro(
                id,
                motor,
                carroceria,
                eletronica,
                pneuDianteiroEsquerdo,
                pneuDianteiroDireito,
                pneuTraseiroEsquerdo,
                pneuTraseiroDireito,
                bancoDianteiroEsquerdo,
                bancoDianteiroDireito,
                bancoTraseiroCentral,
                bancoTraseiroEsquerdo,
                bancoTraseiroDireito
        );

        this.carrosFabricados++;
        Core.interfaceGrafica.carrosFabricados.setText("Carros Fabricados: " + Core.fabricaCarro.getCarrosFabricados());
        this.atualizaBarraProgressoEstoque();

        return carro;
    }

    private void atualizaBarraProgressoEstoque() {
        String texto1 = Core.fabricaMotores.getEstoque().size() + "/" + Core.fabricaMotores.getESTOQUE_MAXIMO();
        Core.interfaceGrafica.barraDeProgressoEstoqueMotores.setString(texto1);
        Core.interfaceGrafica.barraDeProgressoEstoqueMotores.setValue(Core.fabricaMotores.getEstoque().size());

        String texto2 = Core.fabricaBanco.getEstoque().size() + "/" + Core.fabricaBanco.getESTOQUE_MAXIMO();
        Core.interfaceGrafica.barraDeProgressoEstoqueBanco.setString(texto2);
        Core.interfaceGrafica.barraDeProgressoEstoqueBanco.setValue(Core.fabricaBanco.getEstoque().size());

        String texto3 = Core.fabricaPneu.getEstoque().size() + "/" + Core.fabricaPneu.getESTOQUE_MAXIMO();
        Core.interfaceGrafica.barraDeProgressoEstoquePneus.setString(texto3);
        Core.interfaceGrafica.barraDeProgressoEstoquePneus.setValue(Core.fabricaPneu.getEstoque().size());

        String texto4 = Core.fabricaEletronica.getEstoque().size() + "/" + Core.fabricaEletronica.getESTOQUE_MAXIMO();
        Core.interfaceGrafica.barraDeProgressoEstoqueEletronica.setString(texto4);
        Core.interfaceGrafica.barraDeProgressoEstoqueEletronica.setValue(Core.fabricaEletronica.getEstoque().size());

        String texto5 = Core.fabricaCarroceria.getEstoque().size() + "/" + Core.fabricaCarroceria.getESTOQUE_MAXIMO();
        Core.interfaceGrafica.barraDeProgressoEstoqueCarroceria.setString(texto5);
        Core.interfaceGrafica.barraDeProgressoEstoqueCarroceria.setValue(Core.fabricaCarroceria.getEstoque().size());
    }

    private boolean verificaDisponibilidadePecas() {
        if (
                this.verificaBanco() &&
                this.verificaEletronica() &&
                this.verificaMotores() &&
                this.verificaPneu() &&
                this.verificaCarroceria()
        ) {
            return true;
        }else{
            return false;
        }
    }

    private boolean verificaMotores() {
        if (this.lpMotores.getEstoque().size() >= QUANTIDADE_MOTORES_POR_CARRO) {
            return true;
        }else{
            return false;
        }
    }

    private boolean verificaCarroceria() {
        if (this.lpCarroceria.getEstoque().size() >= QUANTIDADE_CARROCERIAS_POR_CARRO) {
            return true;
        }else{
            return false;
        }
    }

    private boolean verificaEletronica() {
        if (this.lpEletronica.getEstoque().size() >= QUANTIDADE_ELETRONICA_POR_CARRO) {
            return true;
        }else{
            return false;
        }
    }

    private boolean verificaPneu() {
        if (this.lpPneu.getEstoque().size() >= QUANTIDADE_PNEUS_POR_CARRO) {
            return true;
        }else{
            return false;
        }
    }

    private boolean verificaBanco() {
        if (this.lpBanco.getEstoque().size() >= QUANTIDADE_BANCOS_POR_CARRO) {
            return true;
        }else{
            return false;
        }
    }

    public int getCarrosFabricados() {
        return carrosFabricados;
    }

    public void setCarrosFabricados(int carrosFabricados) {
        this.carrosFabricados = carrosFabricados;
    }

    public ArrayList<Carro> getEstoque() {
        return estoque;
    }

    public void setEstoque(ArrayList<Carro> estoque) {
        this.estoque = estoque;
    }
}
