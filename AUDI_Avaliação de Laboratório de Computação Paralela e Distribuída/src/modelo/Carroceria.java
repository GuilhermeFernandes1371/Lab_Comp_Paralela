package modelo;

import java.awt.*;

public class Carroceria {

    private int id;
    private Color cor;
    private String formato;

    public Carroceria(int id, Color cor, String formato) {
        this.id = id;
        this.cor = cor;
        this.formato = formato;
    }

    @Override
    public String toString() {
        return "Carroceria{" +
                "id=" + id +
                ", cor=" + cor +
                ", formato='" + formato + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }
}
