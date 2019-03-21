package view;

import controlador.Core;
import modelo.Carro;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Interface {

    JFrame frame;
    JLabel velocidade;

    JPanel panel_fabrica_motores;
    JPanel panel_fabrica_banco;
    JPanel panel_fabrica_carroceria;
    JPanel panel_fabrica_eletronica;
    JPanel panel_fabrica_pneu;
    JPanel panel_fabrica_carro;
    JPanel panel_fabrica_caminhao;

    JLabel tempoFabricacaoMotores;
    JLabel tempoFabricacaoPneu;
    JLabel tempoFabricacaoCarroceria;
    JLabel tempoFabricacaoEletronica;
    JLabel tempoFabricacaoBanco;

    public JProgressBar barraDeProgressoBanco;
    public JProgressBar barraDeProgressoMotores;
    public JProgressBar barraDeProgressoCarroceria;
    public JProgressBar barraDeProgressoEletronica;
    public JProgressBar barraDeProgressoPneus;
    public JProgressBar barraDeProgressoCarro;

    public JProgressBar barraDeProgressoEstoqueBanco;
    public JProgressBar barraDeProgressoEstoqueMotores;
    public JProgressBar barraDeProgressoEstoqueCarroceria;
    public JProgressBar barraDeProgressoEstoqueEletronica;
    public JProgressBar barraDeProgressoEstoquePneus;

    public JLabel caminhoesCarregados;
    public JLabel carrosFabricados;
    public JLabel motoresFabricados;
    public JLabel bancosFabricados;
    public JLabel eletronicosFabricados;
    public JLabel carroceriasFabricados;
    public JLabel pneusFabricados;

    public JCheckBox motor;
    public JCheckBox eletronica;
    public JCheckBox carroceria;
    public JCheckBox pneu1;
    public JCheckBox pneu2;
    public JCheckBox pneu3;
    public JCheckBox pneu4;
    public JCheckBox banco1;
    public JCheckBox banco2;
    public JCheckBox banco3;
    public JCheckBox banco4;
    public JCheckBox banco5;

    public JLabel motorProducaoHora;
    public JLabel carroceriaProducaoHora;
    public JLabel eletronicaProducaoHora;
    public JLabel bancoProducaoHora;
    public JLabel pneusProducaoHora;
    public JLabel carroProducaoHora;
    public JLabel caminhaoProducaoHora;

    public JPanel panelInformacoes;

    public ArrayList<JButton> listaCarrosASeremTransportados = new ArrayList<>();

    private Rectangle barraDeProgressoTamanho = new Rectangle(18, 459, 419, 25);

    public Interface() {
        this.frame = new JFrame();
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setTitle("AUDI");
        this.frame.setVisible(true);

        this.InicializarPainelPrincipal();
        this.frame.pack();
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private void InicializarPainelPrincipal() {
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setBackground(Color.WHITE);
        panelPrincipal.setLayout(new BorderLayout());
        this.frame.add(panelPrincipal);

        JPanel panelMenu = new JPanel();
        panelMenu.setLayout(new BorderLayout());

        panelPrincipal.add(panelMenu, BorderLayout.NORTH);

        JPanel panelFabricas = new JPanel();
        panelFabricas.setBackground(Color.red);
        panelFabricas.setLayout(new GridLayout(7,1));
        panelPrincipal.add(panelFabricas, BorderLayout.CENTER);

        this.estruturaPainelMenu(panelMenu);
        this.estruturaPainelFabricas(panelFabricas);
    }

    private void estruturaPainelMenu(JPanel panelMenu) {
        JPanel panelVelocidade = new JPanel();
        this.estruturaPainelMenuVelocidade(panelVelocidade);

        this.panelInformacoes = new JPanel();
        this.estruturaPainelMenuInformacoes(this.panelInformacoes);

        panelMenu.add(panelVelocidade, BorderLayout.WEST);
        panelMenu.add(this.panelInformacoes, BorderLayout.CENTER);
    }

    private void estruturaPainelMenuInformacoes(JPanel panelInformacoes) {
        panelInformacoes.setBorder(
                BorderFactory.createTitledBorder("Métricas - (Atualizado a cada 10 segundos)")
        );

        panelInformacoes.setLayout(new GridLayout(1,7));

        this.motorProducaoHora = new JLabel("0 Motores/Hora");
        this.carroceriaProducaoHora = new JLabel("0 Carrocerias/Hora");
        this.eletronicaProducaoHora = new JLabel("0 Eletrônicos/Hora");
        this.bancoProducaoHora = new JLabel("0 Bancos/Hora");
        this.pneusProducaoHora = new JLabel("0 Pneus/Hora");
        this.carroProducaoHora = new JLabel("0 Carros/Hora");
        this.caminhaoProducaoHora = new JLabel("0 Caminhoẽs/Hora");

        this.motorProducaoHora.setBorder(
                BorderFactory.createTitledBorder("Produção de Motores")
        );
        this.carroceriaProducaoHora.setBorder(
                BorderFactory.createTitledBorder("Produção de Carrocerias")
        );
        this.eletronicaProducaoHora.setBorder(
                BorderFactory.createTitledBorder("Produção de Eletrônicos")
        );
        this.bancoProducaoHora.setBorder(
                BorderFactory.createTitledBorder("Produção de Bancos")
        );
        this.pneusProducaoHora.setBorder(
                BorderFactory.createTitledBorder("Produção de Pneus")
        );
        this.carroProducaoHora.setBorder(
                BorderFactory.createTitledBorder("Montagem")
        );
        this.caminhaoProducaoHora.setBorder(
                BorderFactory.createTitledBorder("Transportadora")
        );

        panelInformacoes.add(this.motorProducaoHora);
        panelInformacoes.add(this.carroceriaProducaoHora);
        panelInformacoes.add(this.eletronicaProducaoHora);
        panelInformacoes.add(this.bancoProducaoHora);
        panelInformacoes.add(this.pneusProducaoHora);
        panelInformacoes.add(this.carroProducaoHora);
        panelInformacoes.add(this.caminhaoProducaoHora);
    }

    private void estruturaPainelMenuVelocidade(JPanel panelVelocidade) {
        panelVelocidade.setBorder(
                BorderFactory.createTitledBorder("Controlador de Velocidade")
        );

        JButton velocidadePlus = new JButton("+");
        JButton velocidadeLess = new JButton("-");
        JLabel velocidadeLabel = new JLabel("Velocidade: ");
        this.velocidade = new JLabel(Core.ACELERADOR_DE_VELOCIDADE_INICIAL_DAS_FABRICAS + "");

        velocidadePlus.addActionListener(this::velocidadePlusOnClick);
        velocidadeLess.addActionListener(this::velocidadeLessOnClick);

        panelVelocidade.add(velocidadeLess);
        panelVelocidade.add(velocidadeLabel);
        panelVelocidade.add(this.velocidade);
        panelVelocidade.add(velocidadePlus);


    }

    private void velocidadePlusOnClick(ActionEvent event) {
        int velocidadeAtual = Integer.parseInt(this.velocidade.getText());

        if (velocidadeAtual < 20) {
            this.velocidade.setText( ( velocidadeAtual + 1 ) + "");
            Core.controladorDeVelocidade.setVelocidadeBase(velocidadeAtual + 1);
            this.atualizaLabelTempoFabricacao();
        }
    }

    private void velocidadeLessOnClick(ActionEvent event) {
        int velocidadeAtual = Integer.parseInt(this.velocidade.getText());

        if (velocidadeAtual > 1) {
            this.velocidade.setText( ( velocidadeAtual - 1 ) + "");
            Core.controladorDeVelocidade.setVelocidadeBase(velocidadeAtual - 1);
            this.atualizaLabelTempoFabricacao();
        }
    }

    private void atualizaLabelTempoFabricacao() {
        this.tempoFabricacaoBanco.setText("Tempo de Fabricação: " + Core.fabricaBanco.getTEMPO_DE_FABRICACAO() + " MS");
        this.tempoFabricacaoCarroceria.setText("Tempo de Fabricação: " + Core.fabricaCarroceria.getTEMPO_DE_FABRICACAO() + " MS");
        this.tempoFabricacaoMotores.setText("Tempo de Fabricação: " + Core.fabricaMotores.getTEMPO_DE_FABRICACAO() + " MS");
        this.tempoFabricacaoEletronica.setText("Tempo de Fabricação: " + Core.fabricaEletronica.getTEMPO_DE_FABRICACAO() + " MS");
        this.tempoFabricacaoPneu.setText("Tempo de Fabricação: " + Core.fabricaPneu.getTEMPO_DE_FABRICACAO() + " MS");
    }

    private void estruturaPainelFabricas(JPanel panelFabricas) {
        panelFabricas.setLayout(new BorderLayout());

        JPanel panelEsquerda = new JPanel();
        panelEsquerda.setLayout(new GridLayout(5,1));
        JPanel panelDireita = new JPanel();
        panelDireita.setLayout(new GridLayout(1,2));

        panelFabricas.add(panelEsquerda, BorderLayout.CENTER);
        panelFabricas.add(panelDireita, BorderLayout.EAST);

        this.panel_fabrica_motores = new JPanel();
        this.panel_fabrica_banco = new JPanel();
        this.panel_fabrica_carroceria = new JPanel();
        this.panel_fabrica_eletronica = new JPanel();
        this.panel_fabrica_pneu = new JPanel();
        this.panel_fabrica_carro = new JPanel();
        this.panel_fabrica_caminhao = new JPanel();

        this.panel_fabrica_motores.setLayout(new BorderLayout());
        this.panel_fabrica_banco.setLayout(new BorderLayout());
        this.panel_fabrica_carroceria.setLayout(new BorderLayout());
        this.panel_fabrica_eletronica.setLayout(new BorderLayout());
        this.panel_fabrica_pneu.setLayout(new BorderLayout());
        this.panel_fabrica_carro.setLayout(new BorderLayout());
        this.panel_fabrica_caminhao.setLayout(new BorderLayout());

        Font fonteTitulo = new Font("TimesRoman", Font.BOLD, 20);

        panel_fabrica_motores.setBorder(
                BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(3, 4, 4, 3, Color.RED),"Fábrica de Motores", TitledBorder.LEFT,TitledBorder.ABOVE_TOP,fonteTitulo)
        );
        this.panel_fabrica_banco.setBorder(
                BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(3, 4, 4, 3, Color.RED),"Fábrica de Bancos", TitledBorder.LEFT,TitledBorder.ABOVE_TOP,fonteTitulo)
        );
        this.panel_fabrica_carroceria.setBorder(
                BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(3, 4, 4, 3, Color.RED),"Fábrica de Carroceria", TitledBorder.LEFT,TitledBorder.ABOVE_TOP,fonteTitulo)
        );
        this.panel_fabrica_eletronica.setBorder(
                BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(3, 4, 4, 3, Color.RED),"Fábrica de Eletrônica", TitledBorder.LEFT,TitledBorder.ABOVE_TOP,fonteTitulo)
        );
        this.panel_fabrica_pneu.setBorder(
                BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(3, 4, 4, 3, Color.RED),"Fábrica de Pneus", TitledBorder.LEFT,TitledBorder.ABOVE_TOP,fonteTitulo)
        );
        this.panel_fabrica_carro.setBorder(
                BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(3, 4, 4, 3, Color.BLUE),"Fábrica de Carro", TitledBorder.LEFT,TitledBorder.ABOVE_TOP,fonteTitulo)
        );
        this.panel_fabrica_caminhao.setBorder(
                BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(3, 4, 4, 3, Color.GREEN),"Transportadora", TitledBorder.LEFT,TitledBorder.ABOVE_TOP,fonteTitulo)
        );

        panelEsquerda.add(panel_fabrica_motores);
        panelEsquerda.add(panel_fabrica_banco);
        panelEsquerda.add(panel_fabrica_carroceria);
        panelEsquerda.add(panel_fabrica_eletronica);
        panelEsquerda.add(panel_fabrica_pneu);

        panelDireita.add(panel_fabrica_carro);
        panelDireita.add(panel_fabrica_caminhao);

        this.inicializaPaineisDeFabrica();
    }

    private void inicializaPaineisDeFabrica() {
        this.inicializaPainelBanco();
        this.inicializaPainelCaminhao();
        this.inicializaPainelCarroceria();
        this.inicializaPainelCarros();
        this.inicializaPainelEletronica();
        this.inicializaPainelMotores();
        this.inicializaPainelPneu();
    }

    private void inicializaPainelBanco() {
        //Panel Superior
        JPanel panelSuperior = new JPanel();
        panelSuperior.setBorder(
                BorderFactory.createTitledBorder("Geral")
        );
        panelSuperior.setLayout(new GridLayout(1,2));

        this.bancosFabricados = new JLabel("Bancos Fabricados: " + Core.fabricaBanco.getEstoque().size());
        panelSuperior.add(this.bancosFabricados);

        this.tempoFabricacaoBanco = new JLabel("Tempo de Fabricação: " + Core.fabricaBanco.getTEMPO_DE_FABRICACAO() + " MS");
        panelSuperior.add(this.tempoFabricacaoBanco);


        //Panel central
        JPanel panelFabricacaoBancos = new JPanel();
        panelFabricacaoBancos.setLayout(new BorderLayout());
        panelFabricacaoBancos.setBorder(
                BorderFactory.createTitledBorder("Status Fabricação")
        );

        this.barraDeProgressoBanco = new JProgressBar();
        this.barraDeProgressoBanco.setBounds(this.barraDeProgressoTamanho);
        this.barraDeProgressoBanco.setStringPainted(true);
        this.barraDeProgressoBanco.setMinimum(0);
        this.barraDeProgressoBanco.setMaximum(Core.QUANTIDADE_PARTICOES_TEMPO_FABRICACAO_BARRA_DE_PROGRESSO);
        this.barraDeProgressoBanco.setValue(0);
        panelFabricacaoBancos.add(this.barraDeProgressoBanco, BorderLayout.CENTER);

        //Panel Inferior
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new BorderLayout());
        panelInferior.setBorder(
                BorderFactory.createTitledBorder("Estoque")
        );

        this.barraDeProgressoEstoqueBanco = new JProgressBar();
        this.barraDeProgressoEstoqueBanco.setBounds(this.barraDeProgressoTamanho);
        this.barraDeProgressoEstoqueBanco.setStringPainted(true);
        this.barraDeProgressoEstoqueBanco.setString("0/" + Core.fabricaBanco.getESTOQUE_MAXIMO());
        this.barraDeProgressoEstoqueBanco.setMinimum(0);
        this.barraDeProgressoEstoqueBanco.setMaximum(Core.fabricaBanco.getESTOQUE_MAXIMO());
        this.barraDeProgressoEstoqueBanco.setValue(0);
        panelInferior.add(barraDeProgressoEstoqueBanco, BorderLayout.CENTER);

        //Adicionando panel
        this.panel_fabrica_banco.add(panelSuperior, BorderLayout.NORTH);
        this.panel_fabrica_banco.add(panelFabricacaoBancos, BorderLayout.CENTER);
        this.panel_fabrica_banco.add(panelInferior, BorderLayout.SOUTH);
    }

    private void inicializaPainelCarroceria() {
        //Panel Superior
        JPanel panelSuperior = new JPanel();
        panelSuperior.setBorder(
                BorderFactory.createTitledBorder("Geral")
        );
        panelSuperior.setLayout(new GridLayout(1,2));

        this.carroceriasFabricados = new JLabel("Carroceria Fabricados: " + Core.fabricaCarroceria.getEstoque().size());
        panelSuperior.add(this.carroceriasFabricados);

        this.tempoFabricacaoCarroceria = new JLabel("Tempo de Fabricação: " + Core.fabricaCarroceria.getTEMPO_DE_FABRICACAO() + " MS");
        panelSuperior.add(this.tempoFabricacaoCarroceria);


        //Panel central
        JPanel panelFabricacaoCarroceria = new JPanel();
        panelFabricacaoCarroceria.setLayout(new BorderLayout());
        panelFabricacaoCarroceria.setBorder(
                BorderFactory.createTitledBorder("Status Fabricação")
        );

        this.barraDeProgressoCarroceria = new JProgressBar();
        this.barraDeProgressoCarroceria.setBounds(this.barraDeProgressoTamanho);
        this.barraDeProgressoCarroceria.setStringPainted(true);
        this.barraDeProgressoCarroceria.setMinimum(0);
        this.barraDeProgressoCarroceria.setMaximum(Core.QUANTIDADE_PARTICOES_TEMPO_FABRICACAO_BARRA_DE_PROGRESSO);
        this.barraDeProgressoCarroceria.setValue(0);
        panelFabricacaoCarroceria.add(this.barraDeProgressoCarroceria, BorderLayout.CENTER);

        //Panel Inferior
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new BorderLayout());
        panelInferior.setBorder(
                BorderFactory.createTitledBorder("Estoque")
        );

        this.barraDeProgressoEstoqueCarroceria = new JProgressBar();
        this.barraDeProgressoEstoqueCarroceria.setBounds(this.barraDeProgressoTamanho);
        this.barraDeProgressoEstoqueCarroceria.setStringPainted(true);
        this.barraDeProgressoEstoqueCarroceria.setString("0/" + Core.fabricaCarroceria.getESTOQUE_MAXIMO());
        this.barraDeProgressoEstoqueCarroceria.setMinimum(0);
        this.barraDeProgressoEstoqueCarroceria.setMaximum(Core.fabricaCarroceria.getESTOQUE_MAXIMO());
        this.barraDeProgressoEstoqueCarroceria.setValue(0);
        panelInferior.add(barraDeProgressoEstoqueCarroceria, BorderLayout.CENTER);

        //Adicionando panel
        this.panel_fabrica_carroceria.add(panelSuperior, BorderLayout.NORTH);
        this.panel_fabrica_carroceria.add(panelFabricacaoCarroceria, BorderLayout.CENTER);
        this.panel_fabrica_carroceria.add(panelInferior, BorderLayout.SOUTH);
    }

    private void inicializaPainelEletronica() {
        //Panel Superior
        JPanel panelSuperior = new JPanel();
        panelSuperior.setBorder(
                BorderFactory.createTitledBorder("Geral")
        );
        panelSuperior.setLayout(new GridLayout(1,2));

        this.eletronicosFabricados = new JLabel("Eletrônica Fabricados: " + Core.fabricaEletronica.getEstoque().size());
        panelSuperior.add(this.eletronicosFabricados);

        this.tempoFabricacaoEletronica = new JLabel("Tempo de Fabricação: " + Core.fabricaEletronica.getTEMPO_DE_FABRICACAO() + " MS");
        panelSuperior.add(this.tempoFabricacaoEletronica);


        //Panel central
        JPanel panelFabricacaoEletronica = new JPanel();
        panelFabricacaoEletronica.setLayout(new BorderLayout());
        panelFabricacaoEletronica.setBorder(
                BorderFactory.createTitledBorder("Status Fabricação")
        );

        this.barraDeProgressoEletronica = new JProgressBar();
        this.barraDeProgressoEletronica.setBounds(this.barraDeProgressoTamanho);
        this.barraDeProgressoEletronica.setStringPainted(true);
        this.barraDeProgressoEletronica.setMinimum(0);
        this.barraDeProgressoEletronica.setMaximum(Core.QUANTIDADE_PARTICOES_TEMPO_FABRICACAO_BARRA_DE_PROGRESSO);
        this.barraDeProgressoEletronica.setValue(0);
        panelFabricacaoEletronica.add(this.barraDeProgressoEletronica, BorderLayout.CENTER);

        //Panel Inferior
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new BorderLayout());
        panelInferior.setBorder(
                BorderFactory.createTitledBorder("Estoque")
        );

        this.barraDeProgressoEstoqueEletronica = new JProgressBar();
        this.barraDeProgressoEstoqueEletronica.setBounds(this.barraDeProgressoTamanho);
        this.barraDeProgressoEstoqueEletronica.setStringPainted(true);
        this.barraDeProgressoEstoqueEletronica.setString("0/" + Core.fabricaEletronica.getESTOQUE_MAXIMO());
        this.barraDeProgressoEstoqueEletronica.setMinimum(0);
        this.barraDeProgressoEstoqueEletronica.setMaximum(Core.fabricaEletronica.getESTOQUE_MAXIMO());
        this.barraDeProgressoEstoqueEletronica.setValue(0);
        panelInferior.add(barraDeProgressoEstoqueEletronica, BorderLayout.CENTER);

        //Adicionando panel
        this.panel_fabrica_eletronica.add(panelSuperior, BorderLayout.NORTH);
        this.panel_fabrica_eletronica.add(panelFabricacaoEletronica, BorderLayout.CENTER);
        this.panel_fabrica_eletronica.add(panelInferior, BorderLayout.SOUTH);
    }

    private void inicializaPainelPneu() {
        //Panel Superior
        JPanel panelSuperior = new JPanel();
        panelSuperior.setBorder(
                BorderFactory.createTitledBorder("Geral")
        );
        panelSuperior.setLayout(new GridLayout(1,2));

        this.pneusFabricados = new JLabel("Pneus Fabricados: " + Core.fabricaPneu.getEstoque().size());
        panelSuperior.add(this.pneusFabricados);

        this.tempoFabricacaoPneu = new JLabel("Tempo de Fabricação: " + Core.fabricaPneu.getTEMPO_DE_FABRICACAO() + " MS");
        panelSuperior.add(this.tempoFabricacaoPneu);


        //Panel central
        JPanel panelFabricacaoPneu = new JPanel();
        panelFabricacaoPneu.setLayout(new BorderLayout());
        panelFabricacaoPneu.setBorder(
                BorderFactory.createTitledBorder("Status Fabricação")
        );

        this.barraDeProgressoPneus = new JProgressBar();
        this.barraDeProgressoPneus.setBounds(this.barraDeProgressoTamanho);
        this.barraDeProgressoPneus.setStringPainted(true);
        this.barraDeProgressoPneus.setMinimum(0);
        this.barraDeProgressoPneus.setMaximum(Core.QUANTIDADE_PARTICOES_TEMPO_FABRICACAO_BARRA_DE_PROGRESSO);
        this.barraDeProgressoPneus.setValue(0);
        panelFabricacaoPneu.add(this.barraDeProgressoPneus, BorderLayout.CENTER);

        //Panel Inferior
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new BorderLayout());
        panelInferior.setBorder(
                BorderFactory.createTitledBorder("Estoque")
        );

        this.barraDeProgressoEstoquePneus = new JProgressBar();
        this.barraDeProgressoEstoquePneus.setBounds(this.barraDeProgressoTamanho);
        this.barraDeProgressoEstoquePneus.setStringPainted(true);
        this.barraDeProgressoEstoquePneus.setString("0/" + Core.fabricaPneu.getESTOQUE_MAXIMO());
        this.barraDeProgressoEstoquePneus.setMinimum(0);
        this.barraDeProgressoEstoquePneus.setMaximum(Core.fabricaPneu.getESTOQUE_MAXIMO());
        this.barraDeProgressoEstoquePneus.setValue(0);
        panelInferior.add(barraDeProgressoEstoquePneus, BorderLayout.CENTER);

        //Adicionando panel
        this.panel_fabrica_pneu.add(panelSuperior, BorderLayout.NORTH);
        this.panel_fabrica_pneu.add(panelFabricacaoPneu, BorderLayout.CENTER);
        this.panel_fabrica_pneu.add(panelInferior, BorderLayout.SOUTH);
    }

    private void inicializaPainelMotores() {
        //Panel Superior
        JPanel panelSuperior = new JPanel();
        panelSuperior.setBorder(
                BorderFactory.createTitledBorder("Geral")
        );
        panelSuperior.setLayout(new GridLayout(1,2));

        this.motoresFabricados = new JLabel("Motores Fabricados: " + Core.fabricaMotores.getEstoque().size());
        panelSuperior.add(this.motoresFabricados);

        this.tempoFabricacaoMotores = new JLabel("Tempo de Fabricação: " + Core.fabricaMotores.getTEMPO_DE_FABRICACAO() + " MS");
        panelSuperior.add(this.tempoFabricacaoMotores);


        //Panel central
        JPanel panelFabricacaoMotores = new JPanel();
        panelFabricacaoMotores.setLayout(new BorderLayout());
        panelFabricacaoMotores.setBorder(
                BorderFactory.createTitledBorder("Status Fabricação")
        );

        this.barraDeProgressoMotores = new JProgressBar();
        this.barraDeProgressoMotores.setBounds(this.barraDeProgressoTamanho);
        this.barraDeProgressoMotores.setStringPainted(true);
        this.barraDeProgressoMotores.setMinimum(0);
        this.barraDeProgressoMotores.setMaximum(Core.QUANTIDADE_PARTICOES_TEMPO_FABRICACAO_BARRA_DE_PROGRESSO);
        this.barraDeProgressoMotores.setValue(0);
        panelFabricacaoMotores.add(this.barraDeProgressoMotores, BorderLayout.CENTER);

        //Panel Inferior
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new BorderLayout());
        panelInferior.setBorder(
                BorderFactory.createTitledBorder("Estoque")
        );

        this.barraDeProgressoEstoqueMotores = new JProgressBar();
        this.barraDeProgressoEstoqueMotores.setBounds(this.barraDeProgressoTamanho);
        this.barraDeProgressoEstoqueMotores.setStringPainted(true);
        this.barraDeProgressoEstoqueMotores.setString("0/" + Core.fabricaMotores.getESTOQUE_MAXIMO());
        this.barraDeProgressoEstoqueMotores.setMinimum(0);
        this.barraDeProgressoEstoqueMotores.setMaximum(Core.fabricaMotores.getESTOQUE_MAXIMO());
        this.barraDeProgressoEstoqueMotores.setValue(0);
        panelInferior.add(barraDeProgressoEstoqueMotores, BorderLayout.CENTER);

        //Adicionando panel
        this.panel_fabrica_motores.add(panelSuperior, BorderLayout.NORTH);
        this.panel_fabrica_motores.add(panelFabricacaoMotores, BorderLayout.CENTER);
        this.panel_fabrica_motores.add(panelInferior, BorderLayout.SOUTH);

    }

    private void inicializaPainelCarros() {
        //Panel Superior
        JPanel panelSuperior = new JPanel();
        panelSuperior.setBorder(
                BorderFactory.createTitledBorder("Geral")
        );


        this.carrosFabricados = new JLabel("Carros Fabricados: " + Core.fabricaCarro.getCarrosFabricados());
        panelSuperior.add(this.carrosFabricados);

        //Panel central
        JPanel panelFabricacaoCarro = new JPanel();
        panelFabricacaoCarro.setLayout(new BorderLayout());
        panelFabricacaoCarro.setBorder(
                BorderFactory.createTitledBorder("Componentes de Montagem")
        );
        panelFabricacaoCarro.setLayout(new GridLayout(4,3));

        this.motor = new JCheckBox("Motor");
        panelFabricacaoCarro.add(motor);
        this.motor.setEnabled(false);

        this.carroceria = new JCheckBox("Carroceria");
        panelFabricacaoCarro.add(carroceria);
        this.carroceria.setEnabled(false);

        this.eletronica = new JCheckBox("Eletronica");
        panelFabricacaoCarro.add(eletronica);
        this.eletronica.setEnabled(false);

        this.pneu1 = new JCheckBox("Pneu1");
        panelFabricacaoCarro.add(pneu1);
        this.pneu1.setEnabled(false);

        this.pneu2 = new JCheckBox("Pneu2");
        panelFabricacaoCarro.add(pneu2);
        this.pneu2.setEnabled(false);

        this.pneu3 = new JCheckBox("Pneu3");
        panelFabricacaoCarro.add(pneu3);
        this.pneu3.setEnabled(false);

        this.pneu4 = new JCheckBox("Pneu4");
        panelFabricacaoCarro.add(pneu4);
        this.pneu4.setEnabled(false);

        this.banco1 = new JCheckBox("Banco1");
        panelFabricacaoCarro.add(banco1);
        this.banco1.setEnabled(false);

        this.banco2 = new JCheckBox("Banco2");
        panelFabricacaoCarro.add(banco2);
        this.banco2.setEnabled(false);

        this.banco3 = new JCheckBox("Banco3");
        panelFabricacaoCarro.add(banco3);
        this.banco3.setEnabled(false);

        this.banco4 = new JCheckBox("Banco4");
        panelFabricacaoCarro.add(banco4);
        this.banco4.setEnabled(false);

        this.banco5 = new JCheckBox("Banco5");
        panelFabricacaoCarro.add(banco5);
        this.banco5.setEnabled(false);

        //Panel Inferior
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new BorderLayout());
        panelInferior.setBorder(
                BorderFactory.createTitledBorder("Status Fabricação")
        );
        panelInferior.setLayout(new GridLayout(1,1));

        this.barraDeProgressoCarro = new JProgressBar();
        this.barraDeProgressoCarro.setBounds(this.barraDeProgressoTamanho);
        this.barraDeProgressoCarro.setStringPainted(true);
        this.barraDeProgressoCarro.setMinimum(0);
        this.barraDeProgressoCarro.setMaximum(12);
        this.barraDeProgressoCarro.setValue(0);
        panelInferior.add(barraDeProgressoCarro);

        //Adicionando panel
        this.panel_fabrica_carro.add(panelSuperior, BorderLayout.NORTH);
        this.panel_fabrica_carro.add(panelFabricacaoCarro, BorderLayout.CENTER);
        this.panel_fabrica_carro.add(panelInferior, BorderLayout.SOUTH);
    }

    private void inicializaPainelCaminhao() {
        //Panel Superior
        JPanel panelSuperior = new JPanel();
        panelSuperior.setBorder(
                BorderFactory.createTitledBorder("Geral")
        );

        this.caminhoesCarregados = new JLabel("Caminhoes Carregados: " + Core.fabricaCaminhao.getCaminhoes().size());
        panelSuperior.add(this.caminhoesCarregados);

        //Panel central
        JPanel panelFabricacaoCaminhao = new JPanel();
        panelFabricacaoCaminhao.setLayout(new BorderLayout());
        panelFabricacaoCaminhao.setBorder(
                BorderFactory.createTitledBorder("Status Carregamento")
        );
        panelFabricacaoCaminhao.setLayout(new GridLayout(Core.fabricaCaminhao.getQUANTIDADE_DE_CARROS_TRANSPORTADOS_POR_CAMINHAO()/2, 2));

        for (int i=0; i<Core.fabricaCaminhao.getQUANTIDADE_DE_CARROS_TRANSPORTADOS_POR_CAMINHAO(); i++) {
            JButton carro = new JButton("Espaço vazio");
            carro.setBackground(new Color(205,50,50));
            carro.addActionListener(this::visualizaCarro);

            panelFabricacaoCaminhao.add(carro);
            this.listaCarrosASeremTransportados.add(carro);
        }

        //Panel Inferior
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new BorderLayout());
        panelInferior.setBorder(
                BorderFactory.createTitledBorder("Informações")
        );
        JButton botao = new JButton("Ver todos os caminhoẽs");
        botao.addActionListener(this::verTodosCaminhoes);
        panelInferior.add(botao);

        //Adicionando panel
        this.panel_fabrica_caminhao.add(panelSuperior, BorderLayout.NORTH);
        this.panel_fabrica_caminhao.add(panelFabricacaoCaminhao, BorderLayout.CENTER);
        this.panel_fabrica_caminhao.add(panelInferior, BorderLayout.SOUTH);
    }

    private void visualizaCarro(ActionEvent event) {
        int i=0;
        for (JButton botao : this.listaCarrosASeremTransportados) {
            if (event.getSource() == botao) {
                Carro carro = Core.fabricaCaminhao.getCarrosASeremTransportados().get(i);
                InterfaceVisualizaCarro detalhesCarro = new InterfaceVisualizaCarro(carro);
                return;
            }
            i++;
        }
    }

    private void verTodosCaminhoes(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "Ainda não disponivel!");
    }

}
