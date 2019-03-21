package modelo;

public class Eletronica {

    private int id;
    private boolean arCondicionado;
    private boolean vidroEletrico;
    private boolean centralMultimidia;

    public Eletronica(int id, boolean arCondicionado, boolean vidroEletrico, boolean centralMultimidia) {
        this.id = id;
        this.arCondicionado = arCondicionado;
        this.vidroEletrico = vidroEletrico;
        this.centralMultimidia = centralMultimidia;
    }

    @Override
    public String toString() {
        return "Eletronica{" +
                "id=" + id +
                ", arCondicionado=" + arCondicionado +
                ", vidroEletrico=" + vidroEletrico +
                ", centralMultimidia=" + centralMultimidia +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isArCondicionado() {
        return arCondicionado;
    }

    public void setArCondicionado(boolean arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    public boolean isVidroEletrico() {
        return vidroEletrico;
    }

    public void setVidroEletrico(boolean vidroEletrico) {
        this.vidroEletrico = vidroEletrico;
    }

    public boolean isCentralMultimidia() {
        return centralMultimidia;
    }

    public void setCentralMultimidia(boolean centralMultimidia) {
        this.centralMultimidia = centralMultimidia;
    }
}
