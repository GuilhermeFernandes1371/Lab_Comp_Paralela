package controle_estoque;

public class Consumidor implements Runnable{

    private Estoque estoque;
    public static int SLEEP_TIME = 200;

    public Consumidor(Estoque estoque, int sleep_time) {
        this.estoque = estoque;
        Consumidor.SLEEP_TIME = sleep_time;
    }

    public void consome() throws Exception {
        this.estoque.remove();
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(Consumidor.SLEEP_TIME);
                synchronized (this) {
                    try {
                        this.consome();
                    } catch (Exception e) {
                        wait();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
