package modelo;

import java.util.ArrayList;

public class Caminhao {

    private int id;
    private ArrayList<Carro> carros = new ArrayList<>();

    public Caminhao(int id, ArrayList<Carro> carros) {
        this.id = id;
        this.carros = carros;
    }

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Carro> getCarros() {
        return carros;
    }

    public void setCarros(ArrayList<Carro> carros) {
        this.carros = carros;
    }
}
