package telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controladora.ControlaIS;

public class InserirSapato extends JFrame {
	private JFrame frame;
	private JTextField codigoSapato;
	private JTextField campoMarca;
	private JTextField campoColecao;
	private JTextField campoModelo;
	private JTextField campoTipo;
	private JTextField campoTam;
	private JTextField campoValorUni;
	private JTextField dataAtual;

	public JButton getButtonCancelar() {
		return buttonCancelar;
	}

	public JButton getButtonConfirmar() {
		return buttonConfirmar;
	}

	private JButton buttonCancelar;
	private JButton buttonConfirmar;

	public InserirSapato() {
		initialize();
	}

	private void initialize() {
		// Criacao do frame
		ControlaIS controlaIS = new ControlaIS(this);
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 930, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		dataAtual = new JTextField();
		dataAtual.setColumns(10);
		dataAtual.setBounds(742, 10, 140, 30);
		controlaIS.atualizaData();
		frame.getContentPane().add(dataAtual);

		JLabel legendaData = new JLabel("Data");
		legendaData.setHorizontalAlignment(SwingConstants.CENTER);
		legendaData.setFont(new Font("Tahoma", Font.PLAIN, 15));
		legendaData.setBounds(686, 10, 46, 30);
		frame.getContentPane().add(legendaData);
		// Criacao de um painel content para desing
		JPanel panel = new JPanel();
		panel.setBounds(0, 40, 914, 468);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		// Criacao de um segundo painel content par design
		Panel panelLabels = new Panel();
		panelLabels.setBounds(0, 0, 150, 468);
		panel.add(panelLabels);
		panelLabels.setBackground(new Color(192, 192, 192));
		panelLabels.setLayout(null);

		// Criacao das labels

		JLabel legendaCodigoSapato = new JLabel("C\u00f3d. Sapato");
		legendaCodigoSapato.setFont(new Font("Tahoma", Font.PLAIN, 18));
		legendaCodigoSapato.setBounds(10, 20, 120, 30);
		panelLabels.add(legendaCodigoSapato);

		JLabel legendaMarca = new JLabel("Marca");
		legendaMarca.setFont(new Font("Tahoma", Font.PLAIN, 18));
		legendaMarca.setBounds(10, 70, 90, 30);
		panelLabels.add(legendaMarca);

		JLabel legendaColecao = new JLabel("Cole\u00e7\u00e3o:");
		legendaColecao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		legendaColecao.setBounds(10, 120, 90, 30);
		panelLabels.add(legendaColecao);

		JLabel legendaModelo = new JLabel("Modelo:");
		legendaModelo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		legendaModelo.setBounds(10, 170, 90, 30);
		panelLabels.add(legendaModelo);

		JLabel legendaTipo = new JLabel("Tipo:");
		legendaTipo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		legendaTipo.setBounds(10, 220, 90, 30);
		panelLabels.add(legendaTipo);

		JLabel legendaTamanho = new JLabel("TAM:");
		legendaTamanho.setHorizontalAlignment(SwingConstants.LEFT);
		legendaTamanho.setFont(new Font("Tahoma", Font.PLAIN, 18));
		legendaTamanho.setBounds(10, 320, 250, 30);

		panelLabels.add(legendaTamanho);

		JLabel legendaValorUnit = new JLabel("Val. Unit\u00e1rio:");
		legendaValorUnit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		legendaValorUnit.setBounds(10, 270, 120, 30);
		panelLabels.add(legendaValorUnit);

		// Criacao dos textFields
		codigoSapato = new JTextField();
		codigoSapato.setBounds(160, 20, 200, 30);
		panel.add(codigoSapato);
		codigoSapato.setForeground(SystemColor.controlDkShadow);
		codigoSapato.setFont(new Font("Tahoma", Font.PLAIN, 16));
		codigoSapato.addFocusListener(controlaIS);
		codigoSapato.setColumns(10);

		campoMarca = new JTextField();
		campoMarca.setBounds(160, 70, 200, 30);
		panel.add(campoMarca);
		campoMarca.setForeground(SystemColor.controlDkShadow);
		campoMarca.setToolTipText("");
		campoMarca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		campoMarca.addFocusListener(controlaIS);
		campoMarca.setColumns(10);

		campoColecao = new JTextField();
		campoColecao.setBounds(160, 120, 200, 30);
		panel.add(campoColecao);
		campoColecao.setForeground(SystemColor.controlDkShadow);
		campoColecao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		campoColecao.addFocusListener(controlaIS);
		campoColecao.setColumns(10);

		campoModelo = new JTextField();
		campoModelo.setBounds(160, 170, 200, 30);
		panel.add(campoModelo);
		campoModelo.setForeground(SystemColor.controlDkShadow);
		campoModelo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		campoModelo.addFocusListener(controlaIS);
		campoModelo.setColumns(10);

		campoTipo = new JTextField();
		campoTipo.setBounds(160, 220, 200, 30);
		panel.add(campoTipo);
		campoTipo.setForeground(SystemColor.controlDkShadow);
		campoTipo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		campoTipo.addFocusListener(controlaIS);
		campoTipo.setColumns(10);

		campoTam = new JTextField();
		campoTam.setBounds(160, 320, 200, 30);
		panel.add(campoTam);
		campoTam.setForeground(SystemColor.controlDkShadow);
		campoTam.setFont(new Font("Tahoma", Font.PLAIN, 16));
		campoTam.addFocusListener(controlaIS);
		campoTam.setColumns(10);

		campoValorUni = new JTextField();
		campoValorUni.setBounds(160, 270, 200, 30);
		panel.add(campoValorUni);
		campoValorUni.setHorizontalAlignment(SwingConstants.CENTER);
		campoValorUni.setForeground(SystemColor.controlDkShadow);
		campoValorUni.setFont(new Font("Tahoma", Font.PLAIN, 16));
		campoValorUni.addFocusListener(controlaIS);
		campoValorUni.setColumns(10);

		// Criacao dos botões de cancelar e confirmar
		buttonCancelar = new JButton("CANCELAR");
		buttonCancelar.setFont(new Font("Dialog", Font.PLAIN, 15));
		buttonCancelar.setBounds(160, 390, 150, 50);
		panel.add(buttonCancelar);
		buttonCancelar.setBackground(SystemColor.activeCaption);
		buttonCancelar.addActionListener(controlaIS);

		buttonConfirmar = new JButton("CONFIRMAR");
		buttonConfirmar.setFont(new Font("Dialog", Font.PLAIN, 15));
		buttonConfirmar.setBounds(330, 390, 150, 50);
		panel.add(buttonConfirmar);
		buttonConfirmar.setBackground(SystemColor.activeCaption);
		buttonConfirmar.addActionListener(controlaIS);
	}

	public JFrame getFrame() {
		return frame;
	}

	public JTextField getCodigoSapato() {
		return codigoSapato;
	}

	public JTextField getCampoMarca() {
		return campoMarca;
	}

	public JTextField getCampoColecao() {
		return campoColecao;
	}

	public JTextField getCampoModelo() {
		return campoModelo;
	}

	public JTextField getCampoTipo() {
		return campoTipo;
	}

	public JTextField getCampoTam() {
		return campoTam;
	}

	public JTextField getCampoValorUni() {
		return campoValorUni;
	}
	
	public JTextField getDataAtual() {
		return dataAtual;
	}

}
