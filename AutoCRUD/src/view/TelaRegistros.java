package view;

import com.mysql.fabric.xmlrpc.Client;
import dados.Dados;
import model.bean.Cliente;
import model.dao.ClienteDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class TelaRegistros implements Runnable{
    private JFrame frame;
    private JPanel panel;
    private JButton btnAlterar;
    private JButton btnExcluir;
    private JButton btnVoltar;
    private JButton btnNovo;
    private JButton btnAtualizar;
    private JTable tabela;
    private JScrollPane barraRolagem;
    private DefaultTableModel model;
    private Thread autoInclusao;

    public TelaRegistros(){
        this.frame = new JFrame();
        this.panel = new JPanel();
        this.btnAlterar = new JButton("Alterar");
        this.btnExcluir = new JButton("Excluir");
        this.btnVoltar = new JButton("Voltar");
        this.btnNovo = new JButton("Novo");
        this.btnAtualizar = new JButton("Atualizar");
        this.model = new DefaultTableModel();
        this.preencheCamposTabela();
        this.barraRolagem = new JScrollPane(this.tabela);

        iniciarTela();
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setVisible(true);

        Thread thread = new Thread(this::run);
        thread.start();
    }
    private void preencheCamposTabela(){
        this.tabela = new JTable(this.model);
        this.model.addColumn("Id");
        this.model.addColumn("Nome");
        this.model.addColumn("Email");
        this.model.addColumn("Telefone");
        tabela.getColumnModel().getColumn(0).setPreferredWidth(3);

        this.model.setNumRows(0);
        ClienteDAO clienteDAO = new ClienteDAO();

        for(Cliente c : clienteDAO.selecionaTodosRegistros()){
            this.model.addRow(new Object[]{c.getId(), c.getNome(), c.getEmail(), c.getTelefone()});
        }
    }
    public void atualizaTabela(){
        this.model.setNumRows(0);
        ClienteDAO clienteDAO = new ClienteDAO();

        for(Cliente c: clienteDAO.selecionaTodosRegistros()){
            this.model.addRow(new Object[]{c.getId(), c.getNome(), c.getEmail(), c.getTelefone()});
        }
    }
    private void iniciarTela(){
        this.frame.setSize(730, 550);
        this.panel.setSize(730,550);
        this.frame.add(this.panel);
        this.panel.setLayout(null);
        this.panel.add(this.barraRolagem);
        this.panel.add(this.btnNovo);
        this.panel.add(this.btnAtualizar);
        this.panel.add(this.btnVoltar);
        this.panel.add(this.btnAlterar);
        this.panel.add(this.btnExcluir);
        this.barraRolagem.setBounds(20,10,690,400);
        this.btnNovo.setBounds(20,450,130,25);
        this.btnAtualizar.setBounds(160,450,130,25);
        this.btnAlterar.setBounds(300,450,130,25);
        this.btnExcluir.setBounds(440,450,130,25);
        this.btnVoltar.setBounds(580,450,130,25);

        this.btnVoltar.addActionListener(this::btnVoltarActionPerformed);
        this.btnExcluir.addActionListener(this::btnExcluirActionPerformed);
        this.btnNovo.addActionListener(this::btnNovoActionPerformed);
        this.btnAlterar.addActionListener(this::btnAlterarActionPerformed);
        this.btnAtualizar.addActionListener(this::btnAtualizarActionPerformed);

        this.autoInclusao = new Thread(new Runnable() {
            @Override
            public void run() {
                Dados dados = new Dados();
                int i =0;
                while(i<10){
                    System.out.println("Iniciando CRUD automatico!");
                    ClienteDAO dao = new ClienteDAO();
                    if(dao.inserirCliente(new Cliente(0,dados.getNomes(), dados.getTelefones(), dados.getEmails(), dados.getSenhas()))){
                        atualizaTabela();
                    }
                    i++;
                }
            }
        });

        this.autoInclusao.run();

    }
    private void btnAlterarActionPerformed(ActionEvent evt) {
        Cliente cliente;
        ClienteDAO clienteDAO = new ClienteDAO();
        int linhaSelecionada = -1;

        linhaSelecionada = this.tabela.getSelectedRow();

        if (linhaSelecionada >= 0) {
            int id = (int) this.tabela.getValueAt(linhaSelecionada, 0);
            cliente = clienteDAO.selecionaPeloId(id);
            cliente.setNome((String) this.tabela.getValueAt(linhaSelecionada,1));
            cliente.setEmail((String) this.tabela.getValueAt(linhaSelecionada,2));
            cliente.setTelefone((String) this.tabela.getValueAt(linhaSelecionada,3));

            clienteDAO.atualizarCliente(cliente);
        } else {
            JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
        }
    }
    private void btnExcluirActionPerformed(ActionEvent evt){
        Cliente cliente;
        ClienteDAO clienteDAO = new ClienteDAO();
        int linhaSelecionada = this.tabela.getSelectedRow();

        if(linhaSelecionada >= 0){
            int id = (int) this.tabela.getValueAt(linhaSelecionada, 0);
            cliente = clienteDAO.selecionaPeloId(id);

            clienteDAO.deletarCliente(cliente);
        }
        else{
            JOptionPane.showMessageDialog(null, "É necessário selecionar uma linha.");
        }
        this.btnAtualizar.doClick();
    }
    private void btnVoltarActionPerformed(ActionEvent evt){
        this.frame.dispose();
    }
    private void btnNovoActionPerformed(ActionEvent evt){
        TelaCadastro telaCadastro = new TelaCadastro();
        telaCadastro.iniciaTela(this);
    }
    private void btnAtualizarActionPerformed(ActionEvent evt){
        this.atualizaTabela();
    }
    public void run(){
        this.atualizaTabela();
    }
}
