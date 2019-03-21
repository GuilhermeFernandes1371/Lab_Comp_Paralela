package controle_estoque;

public class Main {

    //Enviar para ilorivero@uit.br
    public static void main(String[] args) throws InterruptedException {
        int SLEEP_PRODUTOR = 200;
        int SLEEP_CONSUMIDOR = 300;

        Estoque estoque = new Estoque();
        Produtor produtor = new Produtor(estoque, SLEEP_PRODUTOR);
        Consumidor consumidor = new Consumidor(estoque, SLEEP_CONSUMIDOR);



        Thread threadProdutor = new Thread(produtor);
        Thread threadConsumidor = new Thread(consumidor);

        Interface intefaceGrafica = new Interface(estoque, threadProdutor, threadConsumidor );

        threadConsumidor.start();
        threadProdutor.start();

        while(true) {
            if (estoque.size() >= estoque.max()) {
                synchronized (consumidor) {
                    consumidor.notify();
                }
            }
            if (estoque.size() <= 0) {
                synchronized (produtor) {
                    produtor.notify();
                }
            }
            intefaceGrafica.atualiza();
        }
    }
}
