package Aula04;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class Interface {
	
	int resultado, num1, num2;
	static int n1;
	static int n2;
	//private static Scanner scan;
	static int somatorio;
	static int subtracao;
	static int multiplicacao;
	static int divisao;

	JFrame framePrincipal;
	JPanel painelInNum1;
	JPanel painelInNum2;
	JPanel painelInButton;
	JPanel painelOutResultado;
	JPanel painelPrincipal;
	JTextField inputNum1;
	JTextField inputNum2;
	JButton botaoEnviar;
	JLabel labelNum1;
	JLabel labelNum2;
	JLabel labelResult1;
	JLabel labelResult2;
	JLabel labelResult3;
	JLabel labelResult4;
	
	public void fazTela () {
		
		this.framePrincipal = new JFrame("Calculadora");
		this.painelPrincipal = new JPanel(new BorderLayout());
		this.painelInNum1 = new JPanel();
		this.painelInNum2 = new JPanel();
		this.painelInButton = new JPanel();
		this.painelOutResultado = new JPanel();
		this.inputNum1 = new JTextField();
		this.inputNum2 = new JTextField();
		
		//Adicionando Paineis no Frame
		framePrincipal.setSize(600, 470);
		framePrincipal.setVisible(true);
		framePrincipal.add(painelPrincipal);
		framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Painel Principal
		painelPrincipal.setVisible(true);
		painelPrincipal.setLayout(new GridLayout(4, 1));
		
		//Adicionando componentes no Painel de Entradas
		painelInNum1.setVisible(true);
		painelInNum2.setVisible(true);
		painelInButton.setVisible(true);
		
		JLabel labelNum1 = new JLabel("Digite um número: ");
		painelInNum1.add(labelNum1);
		labelNum1.setFont(new Font("Arial", Font.BOLD, 13));
		JLabel labelNum2 = new JLabel("Digite outro número: ");
		painelInNum2.add(labelNum2);
		labelNum2.setFont(new Font("Arial", Font.BOLD, 13));
		
		painelInNum1.add(inputNum1);
		painelInNum2.add(inputNum2);
	    inputNum1.setPreferredSize(new Dimension(100, 20));
		inputNum2.setPreferredSize(new Dimension(100, 20));
		
		JButton botaoEnviar = new JButton("Calcular");
		painelInButton.add(botaoEnviar);
		botaoEnviar.setSize(50, 100);
		
		//Painel de Saída
		painelOutResultado.setVisible(true);
		
		this.labelResult1 = new JLabel("Aqui irá retornar o resultado da operação acima");
		painelOutResultado.add(labelResult1);
		labelResult1.setFont(new Font("Arial", Font.BOLD, 13));
		this.labelResult2 = new JLabel();
		painelOutResultado.add(labelResult2);
		labelResult2.setFont(new Font("Arial", Font.BOLD, 13));
		this.labelResult3 = new JLabel();
		painelOutResultado.add(labelResult3);
		labelResult3.setFont(new Font("Arial", Font.BOLD, 13));
		this.labelResult4 = new JLabel();
		painelOutResultado.add(labelResult4);
		labelResult4.setFont(new Font("Arial", Font.BOLD, 13));
			
		//Adicionando Paineis no Principal
		painelPrincipal.add(painelInNum1);
		painelPrincipal.add(painelInNum2);
		painelPrincipal.add(painelInButton);
		painelPrincipal.add(painelOutResultado);
		botaoEnviar.addActionListener(this::clicaBotaoCalular);		
	}

	public void clicaBotaoCalular(ActionEvent eventoButton) {
      
		n1 = Integer.parseInt(this.inputNum1.getText());
		n2 = Integer.parseInt(this.inputNum2.getText());

		Conta conta1 = new Conta(n1,n2);
		Thread t1 = new Thread(conta1);
		Conta conta2 = new Conta(n1,n2);
		Thread t2 = new Thread(conta2);
		Conta conta3 = new Conta(n1,n2);
		Thread t3 = new Thread(conta3);
		Conta conta4 = new Conta(n1,n2);
		Thread t4 = new Thread(conta4);
		
		

		
		
		t1.setName("nulo1");
		t2.setName("nulo2");
		t3.setName("nulo3");
		t4.setName("nulo4");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		//boolean x = true;
		//while(x == true) {
		//if(t1.getName()!="nulo1"&&t2.getName()!="nulo2"&&t3.getName()!="nulo3"&&t4.getName()!="nulo4") {
			
			try {
				Thread.currentThread().sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.labelResult1.setText("Resultado " + t1.getName());
			this.labelResult2.setText("Resultado "+ t2.getName());
			this.labelResult3.setText("Resultado " + t3.getName());
			this.labelResult4.setText("Resultado " + t4.getName());
			
			//x = false;
		this.inputNum1.setText("");
		this.inputNum2.setText("");
		//}
	//}	
	}
}

