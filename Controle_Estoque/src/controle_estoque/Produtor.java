package controle_estoque;

public class Produtor implements Runnable{

    private Estoque estoque;
    public static int SLEEP_TIME;

    public Produtor(Estoque estoque, int sleep_time) {
        this.estoque = estoque;
        Produtor.SLEEP_TIME = sleep_time;
    }

    public void produz() throws Exception {
        this.estoque.add();
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(Produtor.SLEEP_TIME);
                synchronized (this) {
                    try {
                        this.produz();
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
