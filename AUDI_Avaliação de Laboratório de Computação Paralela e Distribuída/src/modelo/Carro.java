package modelo;

public class Carro {

    private int id;
    private Motor motor;
    private Carroceria carroceria;
    private Eletronica eletronica;

    private Pneu pneuDianteiroEsquerdo;
    private Pneu pneuDianteiroDireito;
    private Pneu pneuTraseiroEsquerdo;
    private Pneu pneuTraseiroDireito;

    private Banco bancoDianteiroEsquerdo;
    private Banco bancoDianteiroDireito;
    private Banco bancoTraseiroCentral;
    private Banco bancoTraseiroEsquerdo;
    private Banco bancoTraseiroDireito;

    public Carro(int id,
                 Motor motor,
                 Carroceria carroceria,
                 Eletronica eletronica,
                 Pneu pneuDianteiroEsquerdo,
                 Pneu pneuDianteiroDireito,
                 Pneu pneuTraseiroEsquerdo,
                 Pneu pneuTraseiroDireito,
                 Banco bancoDianteiroEsquerdo,
                 Banco bancoDianteiroDireito,
                 Banco bancoTraseiroCentral,
                 Banco bancoTraseiroEsquerdo,
                 Banco bancoTraseiroDireito
    ) {
        this.id = id;
        this.motor = motor;
        this.carroceria = carroceria;
        this.eletronica = eletronica;
        this.pneuDianteiroEsquerdo = pneuDianteiroEsquerdo;
        this.pneuDianteiroDireito = pneuDianteiroDireito;
        this.pneuTraseiroEsquerdo = pneuTraseiroEsquerdo;
        this.pneuTraseiroDireito = pneuTraseiroDireito;
        this.bancoDianteiroEsquerdo = bancoDianteiroEsquerdo;
        this.bancoDianteiroDireito = bancoDianteiroDireito;
        this.bancoTraseiroCentral = bancoTraseiroCentral;
        this.bancoTraseiroEsquerdo = bancoTraseiroEsquerdo;
        this.bancoTraseiroDireito = bancoTraseiroDireito;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "id=" + id +
                ", motor=" + motor +
                ", carroceria=" + carroceria +
                ", eletronica=" + eletronica +
                ", pneuDianteiroEsquerdo=" + pneuDianteiroEsquerdo +
                ", pneuDianteiroDireito=" + pneuDianteiroDireito +
                ", pneuTraseiroEsquerdo=" + pneuTraseiroEsquerdo +
                ", pneuTraseiroDireito=" + pneuTraseiroDireito +
                ", bancoDianteiroEsquerdo=" + bancoDianteiroEsquerdo +
                ", bancoDianteiroDireito=" + bancoDianteiroDireito +
                ", bancoTraseiroCentral=" + bancoTraseiroCentral +
                ", bancoTraseiroEsquerdo=" + bancoTraseiroEsquerdo +
                ", bancoTraseiroDireito=" + bancoTraseiroDireito +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Carroceria getCarroceria() {
        return carroceria;
    }

    public void setCarroceria(Carroceria carroceria) {
        this.carroceria = carroceria;
    }

    public Eletronica getEletronica() {
        return eletronica;
    }

    public void setEletronica(Eletronica eletronica) {
        this.eletronica = eletronica;
    }

    public Pneu getPneuDianteiroEsquerdo() {
        return pneuDianteiroEsquerdo;
    }

    public void setPneuDianteiroEsquerdo(Pneu pneuDianteiroEsquerdo) {
        this.pneuDianteiroEsquerdo = pneuDianteiroEsquerdo;
    }

    public Pneu getPneuDianteiroDireito() {
        return pneuDianteiroDireito;
    }

    public void setPneuDianteiroDireito(Pneu pneuDianteiroDireito) {
        this.pneuDianteiroDireito = pneuDianteiroDireito;
    }

    public Pneu getPneuTraseiroEsquerdo() {
        return pneuTraseiroEsquerdo;
    }

    public void setPneuTraseiroEsquerdo(Pneu pneuTraseiroEsquerdo) {
        this.pneuTraseiroEsquerdo = pneuTraseiroEsquerdo;
    }

    public Pneu getPneuTraseiroDireito() {
        return pneuTraseiroDireito;
    }

    public void setPneuTraseiroDireito(Pneu pneuTraseiroDireito) {
        this.pneuTraseiroDireito = pneuTraseiroDireito;
    }

    public Banco getBancoDianteiroEsquerdo() {
        return bancoDianteiroEsquerdo;
    }

    public void setBancoDianteiroEsquerdo(Banco bancoDianteiroEsquerdo) {
        this.bancoDianteiroEsquerdo = bancoDianteiroEsquerdo;
    }

    public Banco getBancoDianteiroDireito() {
        return bancoDianteiroDireito;
    }

    public void setBancoDianteiroDireito(Banco bancoDianteiroDireito) {
        this.bancoDianteiroDireito = bancoDianteiroDireito;
    }

    public Banco getBancoTraseiroCentral() {
        return bancoTraseiroCentral;
    }

    public void setBancoTraseiroCentral(Banco bancoTraseiroCentral) {
        this.bancoTraseiroCentral = bancoTraseiroCentral;
    }

    public Banco getBancoTraseiroEsquerdo() {
        return bancoTraseiroEsquerdo;
    }

    public void setBancoTraseiroEsquerdo(Banco bancoTraseiroEsquerdo) {
        this.bancoTraseiroEsquerdo = bancoTraseiroEsquerdo;
    }

    public Banco getBancoTraseiroDireito() {
        return bancoTraseiroDireito;
    }

    public void setBancoTraseiroDireito(Banco bancoTraseiroDireito) {
        this.bancoTraseiroDireito = bancoTraseiroDireito;
    }
}
