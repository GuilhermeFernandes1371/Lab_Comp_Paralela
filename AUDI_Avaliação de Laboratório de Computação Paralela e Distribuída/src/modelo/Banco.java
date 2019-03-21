package modelo;

import java.awt.*;

public class Banco {

    private int id;
    private String material;
    private Color cor;

    public Banco(int id, String material, Color cor) {
        this.id = id;
        this.material = material;
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "Banco{" +
                "id=" + id +
                ", material='" + material + '\'' +
                ", cor=" + cor +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }
}
