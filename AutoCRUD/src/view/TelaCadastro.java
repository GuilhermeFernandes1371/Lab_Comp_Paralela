package view;

import model.bean.Cliente;
import model.dao.ClienteDAO;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class TelaCadastro {
    private JFrame frame;
    private JPanel panel;
    private JButton buttonLimpar;
    private JButton buttonConfirmar;
    private JButton buttonVoltar;
    private JLabel labelNome;
    private JLabel labelTelefone;
    private JLabel labelEmail;
    private JLabel labelSenha;
    private JTextField textNome;
    private JFormattedTextField textTelefone;
    private JTextField textEmail;
    private JPasswordField textSenha;
    private TelaRegistros telaRegistros;

    public TelaCadastro(){
        this.frame = new JFrame();

        this.panel = new JPanel();

        this.buttonLimpar = new JButton("Limpar");
        this.buttonConfirmar = new JButton("Confirmar");
        this.buttonVoltar = new JButton("Voltar");

        this.labelEmail = new JLabel("Email: ");
        this.labelNome = new JLabel("Nome: ");
        this.labelSenha = new JLabel("Senha: ");
        this.labelTelefone = new JLabel("Telefone: ");

        this.textEmail = new JTextField();
        this.textNome = new JTextField();
        this.textSenha = new JPasswordField();
        this.textTelefone = new JFormattedTextField();

    }
    public void iniciaTela(TelaRegistros telaRegistros){
        this.adicionaComponentes();
        this.posicionaComponentes();
        this.criaAcaoComponentes();
        this.mascaraComponentes();

        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setVisible(TRUE);
        this.telaRegistros = telaRegistros;
    }
    private void criaAcaoComponentes(){
        this.buttonConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if(confereConteudoCampos()){
                    ClienteDAO dao = new ClienteDAO();
                    if(dao.inserirCliente(new Cliente(0,textNome.getText(), textTelefone.getText(), textEmail.getText(), String.valueOf(textSenha.getPassword())))){
                        telaRegistros.atualizaTabela();
                        frame.dispose();
                    }
                }
            }
        });
        this.buttonLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                limparDadosInseridos();
            }
        });

        this.buttonVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

    }
    private boolean confereConteudoCampos(){
        if(this.textNome.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Campo nome não pode vazio!");
            return FALSE;
        }
        if(this.textTelefone.getText().equals("") || (this.textTelefone.getText().equals("(  )      -    "))){
            JOptionPane.showMessageDialog(null, "Campo de telefone não pode vazio!");
            return FALSE;
        }
        if(this.textEmail.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Campo email não pode vazio!");
            return FALSE;
        }
        if(this.textSenha.getPassword().equals("")){
            JOptionPane.showMessageDialog(null, "Campo de senha não pode ser vazio!");
            return FALSE;
        }
        return TRUE;
    }
    private void limparDadosInseridos(){
        this.textTelefone.setText("");
        this.textSenha.setText("");
        this.textNome.setText("");
        this.textEmail.setText("");
    }
    private void adicionaComponentes(){
        this.frame.setSize(450,250);
        this.panel.setSize(450,250);
        this.frame.add(this.panel);
        this.panel.setLayout(null);

        this.panel.add(this.labelNome);
        this.panel.add(this.textNome);
        this.panel.add(this.labelTelefone);
        this.panel.add(this.textTelefone);
        this.panel.add(this.labelEmail);
        this.panel.add(this.textEmail);
        this.panel.add(this.labelSenha);
        this.panel.add(this.textSenha);
        this.panel.add(this.buttonVoltar);
        this.panel.add(this.buttonLimpar);
        this.panel.add(this.buttonConfirmar);
    }
    private void posicionaComponentes(){
        int y = 30;
        for(int i=0; i<8;i++){
            if(i%2==0){
                this.panel.getComponent(i).setBounds(30,y,150,25);
            }
            else{
                this.panel.getComponent(i).setBounds(100,y,330,25);
                y += 30;
            }
        }
        this.buttonVoltar.setBounds(30,y,130,25);
        this.buttonLimpar.setBounds(170, y, 130,25);
        this.buttonConfirmar.setBounds(310,y,130,25);
    }
    private void mascaraComponentes(){
        try {
            MaskFormatter mascaraTelefone = new MaskFormatter("(##) #####-####");
            mascaraTelefone.install(this.textTelefone);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
