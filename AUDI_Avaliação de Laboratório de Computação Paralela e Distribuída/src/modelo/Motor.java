package modelo;

public class Motor {

    private int id;
    private int cavalos;
    private String combustão;
    private boolean turbinado;

    public Motor(int id, int cavalos, String combustão, boolean turbinado) {
        this.id = id;
        this.cavalos = cavalos;
        this.combustão = combustão;
        this.turbinado = turbinado;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "id=" + id +
                ", cavalos=" + cavalos +
                ", combustão='" + combustão + '\'' +
                ", turbinado=" + turbinado +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCavalos() {
        return cavalos;
    }

    public void setCavalos(int cavalos) {
        this.cavalos = cavalos;
    }

    public String getCombustão() {
        return combustão;
    }

    public void setCombustão(String combustão) {
        this.combustão = combustão;
    }

    public boolean isTurbinado() {
        return turbinado;
    }

    public void setTurbinado(boolean turbinado) {
        this.turbinado = turbinado;
    }
}
