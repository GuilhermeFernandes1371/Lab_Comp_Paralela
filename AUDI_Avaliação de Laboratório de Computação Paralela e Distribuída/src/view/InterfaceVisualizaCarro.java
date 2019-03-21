package view;

import modelo.Banco;
import modelo.Carro;
import modelo.Pneu;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class InterfaceVisualizaCarro {

    JFrame frame = new JFrame();
    Carro carro;

    public InterfaceVisualizaCarro(Carro carro) {
        this.carro = carro;
        this.frame.setTitle("Detalhes do Carro - ID " + carro.getId());
        this.frame.setSize(500,630);
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.setVisible(true);
        this.frame.setLayout(new BorderLayout());

        JPanel panelSuperior = new JPanel();
        JPanel panelCentral = new JPanel();

        frame.add(panelSuperior, BorderLayout.NORTH);
        frame.add(panelCentral, BorderLayout.CENTER);

        this.renderizaPanelSuperior(panelSuperior);
        this.renderizaPanelCentral(panelCentral);
    }

    private void renderizaPanelSuperior(JPanel panelSuperior) {
        JLabel label = new JLabel("ID Carro: " + this.carro.getId());

        panelSuperior.add(label);
    }

    private void renderizaPanelCentral(JPanel panelCentral) {
        JPanel panelMotor = new JPanel();
        JPanel panelCarroceria = new JPanel();
        JPanel panelEletronica = new JPanel();
        JPanel panelPneus = new JPanel();
        JPanel panelBancos = new JPanel();

        panelCentral.setLayout(new GridLayout(5,1));

        panelCentral.add(panelMotor);
        panelCentral.add(panelCarroceria);
        panelCentral.add(panelEletronica);
        panelCentral.add(panelPneus);
        panelCentral.add(panelBancos);

        Font fonteTitulo = new Font("TimesRoman", Font.BOLD, 20);

        panelMotor.setBorder(
                BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(3, 4, 4, 3, Color.RED),"Motor", TitledBorder.LEFT,TitledBorder.ABOVE_TOP,fonteTitulo)
        );
        panelCarroceria.setBorder(
                BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(3, 4, 4, 3, Color.RED),"Carroceria", TitledBorder.LEFT,TitledBorder.ABOVE_TOP,fonteTitulo)
        );
        panelEletronica.setBorder(
                BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(3, 4, 4, 3, Color.RED),"Eletrônica", TitledBorder.LEFT,TitledBorder.ABOVE_TOP,fonteTitulo)
        );
        panelPneus.setBorder(
                BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(3, 4, 4, 3, Color.RED),"Pneus", TitledBorder.LEFT,TitledBorder.ABOVE_TOP,fonteTitulo)
        );
        panelBancos.setBorder(
                BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(3, 4, 4, 3, Color.RED),"Bancos", TitledBorder.LEFT,TitledBorder.ABOVE_TOP,fonteTitulo)
        );

        this.detalhaBancos(panelBancos);
        this.detalhaCarroceria(panelCarroceria);
        this.detalhaEletronica(panelEletronica);
        this.detalhaMotor(panelMotor);
        this.detalhaPneus(panelPneus);
    }

    private void detalhaMotor(JPanel panel) {
        panel.setLayout(new BorderLayout());

        JLabel cavalos = new JLabel("Motor " + this.carro.getMotor().getCavalos() + " CV");
        JLabel combustão = new JLabel("Combustão " + this.carro.getMotor().getCombustão());
        JLabel turbinado = new JLabel("Turbinado: " + this.carro.getMotor().isTurbinado());

        panel.add(cavalos, BorderLayout.NORTH);
        panel.add(combustão, BorderLayout.CENTER);
        panel.add(turbinado, BorderLayout.SOUTH);
    }

    private void detalhaCarroceria(JPanel panel) {
        panel.setLayout(new BorderLayout());

        JLabel formato = new JLabel("Formato " + this.carro.getCarroceria().getFormato());
        JLabel cor = new JLabel("Cor da carroceria");
        cor.setForeground(this.carro.getCarroceria().getCor());

        panel.add(formato, BorderLayout.NORTH);
        panel.add(cor, BorderLayout.CENTER);
    }

    private void detalhaPneus(JPanel panel) {
        panel.setLayout(new GridLayout(2,2));

        JPanel panelPneu1 = new JPanel();
        JPanel panelPneu2 = new JPanel();
        JPanel panelPneu3 = new JPanel();
        JPanel panelPneu4 = new JPanel();

        panelPneu1.setBorder(
                BorderFactory.createTitledBorder("Dianteiro Esquerdo")
        );
        panelPneu2.setBorder(
                BorderFactory.createTitledBorder("Dianteiro Direito")
        );
        panelPneu3.setBorder(
                BorderFactory.createTitledBorder("Traseiro Esquerdo")
        );
        panelPneu4.setBorder(
                BorderFactory.createTitledBorder("Traseiro Direito")
        );

        this.detalhaPneuEspecifico(this.carro.getPneuDianteiroEsquerdo(),panelPneu1);
        this.detalhaPneuEspecifico(this.carro.getPneuDianteiroDireito(),panelPneu2);
        this.detalhaPneuEspecifico(this.carro.getPneuTraseiroEsquerdo(),panelPneu3);
        this.detalhaPneuEspecifico(this.carro.getPneuTraseiroDireito(),panelPneu4);

        panel.add(panelPneu1);
        panel.add(panelPneu2);
        panel.add(panelPneu3);
        panel.add(panelPneu4);
    }

    private void detalhaPneuEspecifico(Pneu pneu, JPanel panel) {

        JLabel especialidade = new JLabel("Especialiade:  " + pneu.getEspecialidade());
        JLabel aro = new JLabel("Aro:  " + pneu.getAro());

        panel.add(especialidade);
        panel.add(aro);
    }

    private void detalhaEletronica(JPanel panel) {
        panel.setLayout(new BorderLayout());

        JLabel arCondicionado = new JLabel("Ar Condificonado:  " + this.carro.getEletronica().isArCondicionado());
        JLabel centralMultimidia = new JLabel("Central Multimidia:  " + this.carro.getEletronica().isCentralMultimidia());
        JLabel vidroEletrico = new JLabel("Vidro Eletrico:  " + this.carro.getEletronica().isVidroEletrico());

        panel.add(arCondicionado, BorderLayout.NORTH);
        panel.add(centralMultimidia, BorderLayout.CENTER);
        panel.add(vidroEletrico, BorderLayout.SOUTH);
    }

    private void detalhaBancos(JPanel panel) {
        panel.setLayout(new GridLayout(1,5));

        JPanel panelBanco1 = new JPanel();
        JPanel panelBanco2 = new JPanel();
        JPanel panelBanco3 = new JPanel();
        JPanel panelBanco4 = new JPanel();
        JPanel panelBanco5 = new JPanel();

        panelBanco1.setBorder(
                BorderFactory.createTitledBorder("Dianteiro Esquerdo")
        );
        panelBanco2.setBorder(
                BorderFactory.createTitledBorder("Dianteiro Direito")
        );
        panelBanco3.setBorder(
                BorderFactory.createTitledBorder("Traseiro Esquerdo")
        );
        panelBanco4.setBorder(
                BorderFactory.createTitledBorder("Traseiro Direito")
        );
        panelBanco5.setBorder(
                BorderFactory.createTitledBorder("Traseiro Central")
        );

        this.detalhaBancoEspecifico(this.carro.getBancoDianteiroEsquerdo(),panelBanco1);
        this.detalhaBancoEspecifico(this.carro.getBancoDianteiroDireito(),panelBanco2);
        this.detalhaBancoEspecifico(this.carro.getBancoTraseiroEsquerdo(),panelBanco3);
        this.detalhaBancoEspecifico(this.carro.getBancoTraseiroDireito(),panelBanco4);
        this.detalhaBancoEspecifico(this.carro.getBancoTraseiroCentral(),panelBanco5);

        panel.add(panelBanco1);
        panel.add(panelBanco2);
        panel.add(panelBanco3);
        panel.add(panelBanco4);
        panel.add(panelBanco5);

    }

    private void detalhaBancoEspecifico(Banco banco, JPanel panel) {
        panel.setLayout(new BorderLayout());

        JLabel material = new JLabel("" + banco.getMaterial());
        material.setForeground(banco.getCor());

        panel.add(material);
    }


}
