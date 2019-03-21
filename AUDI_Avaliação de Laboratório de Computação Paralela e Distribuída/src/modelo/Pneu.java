package modelo;

public class Pneu {

    private int id;
    private int aro;
    private String especialidade;

    public Pneu(int id, int aro, String especialidade) {
        this.id = id;
        this.aro = aro;
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return "Pneu{" +
                "id=" + id +
                ", aro=" + aro +
                ", especialidade='" + especialidade + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAro() {
        return aro;
    }

    public void setAro(int aro) {
        this.aro = aro;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
