package view;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class TelaInicial {
    private JFrame frame;
    private JPanel panel;
    private JButton btnNovo;
    private JButton btnAlteracao;

    public TelaInicial(){
        this.frame = new JFrame();
        this.panel = new JPanel();
        this.btnNovo = new JButton("Novo cadastro");
        this.btnAlteracao = new JButton("Alteração");

        iniciaTela();

        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }
    public void iniciaTela(){
        this.frame.setSize(350,150);
        this.panel.setSize(350,150);
        this.frame.add(this.panel);
        this.panel.setLayout(null);
        this.panel.add(this.btnNovo);
        this.panel.add(this.btnAlteracao);

        this.btnNovo.setBounds(20,50,150,25);
        this.btnAlteracao.setBounds(180,50,150,25);

        this.btnNovo.addActionListener(this::btnNovoActionPerformed);
        this.btnAlteracao.addActionListener(this::btnAlteracaoActionPerformed);
    }
    private void btnNovoActionPerformed(ActionEvent evt){
        TelaCadastro telaCadastro = new TelaCadastro();
    }

    private void btnAlteracaoActionPerformed(ActionEvent evt){
        TelaRegistros telaRegistros = new TelaRegistros();
    }
    public void dispose(){
        this.frame.dispose();
        System.exit(0);
    }
}
