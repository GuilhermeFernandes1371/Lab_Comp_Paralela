package controlador;

public class Velocidade {

    private static int VELOCIDADE_BASE = 1;

    public Velocidade() {
    }

    private static void atualizaVelocidade() {
        Core.fabricaBanco.setTEMPO_DE_FABRICACAO(Core.fabricaBanco.getTEMPO_DE_FABRICACAO());
        Core.fabricaCarroceria.setTEMPO_DE_FABRICACAO(Core.fabricaCarroceria.getTEMPO_DE_FABRICACAO());
        Core.fabricaEletronica.setTEMPO_DE_FABRICACAO(Core.fabricaEletronica.getTEMPO_DE_FABRICACAO());
        Core.fabricaMotores.setTEMPO_DE_FABRICACAO(Core.fabricaMotores.getTEMPO_DE_FABRICACAO());
        Core.fabricaPneu.setTEMPO_DE_FABRICACAO(Core.fabricaPneu.getTEMPO_DE_FABRICACAO());
    }

    public static int getVelocidadeBase() {
        return VELOCIDADE_BASE;
    }

    public static void setVelocidadeBase(int velocidadeBase) {
        Velocidade.VELOCIDADE_BASE = velocidadeBase;
        Velocidade.atualizaVelocidade();
    }
}
