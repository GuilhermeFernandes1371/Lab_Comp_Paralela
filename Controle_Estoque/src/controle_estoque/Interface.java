package controle_estoque;

import javax.swing.*;
import java.awt.*;

public class Interface {
    private Estoque estoque;
    private Thread Tprodutor;
    private Thread Tconsumidor;

    private JFrame frame;
    private JPanel panel;
    private JLabel label;

    public Interface(Estoque estoque, Thread produtor, Thread consumidor) {
        this.Tconsumidor = consumidor;
        this.Tprodutor = produtor;
        this.estoque = estoque;

        this.frame = new JFrame();
        this.panel = new JPanel();

        frame.setVisible(true);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);

        panel.setLayout(new BorderLayout());

        this.label = new JLabel("Produtos no estoque: ");
        this.panel.add(label, BorderLayout.SOUTH);

        JLabel sleep_consumidor = new JLabel("SLEEP CONSUMIDOR: " + Consumidor.SLEEP_TIME + " MS");
        JLabel sleep_produtor = new JLabel("SLEEP PRODUTOR: " + Produtor.SLEEP_TIME + " MS");

        this.panel.add(sleep_consumidor, BorderLayout.NORTH);
        this.panel.add(sleep_produtor, BorderLayout.CENTER);
    }

    public void atualiza() {
        this.label.setText("Produtos: " + this.estoque.size() + "/" + this.estoque.max());
    }
}
