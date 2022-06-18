package telas;

import controladora.ControlaIC;

import javax.swing.*;
import java.awt.*;

public class InserirCliente extends JFrame {
	private JFrame frame;
	private JTextField txtCPF;
	private JTextField txtNome;
	private JTextField txtRua;
	private JTextField textBairro;
	private JTextField txtCidade;
	private JTextField txtTelefone;
	private JTextField textNumero;
	private JTextField dataAtual;
	private JTextField txtEmail;
	private JTextField txtUF;

	public JButton getButtonCancelar() {
		return buttonCancelar;
	}

	public JButton getButtonConfirmar() {
		return buttonConfirmar;
	}

	private  JButton buttonCancelar;
	private  JButton buttonConfirmar;

	public InserirCliente() {
		initialize();
	}

	private void initialize() {
		// Criacao do frame
		ControlaIC contIC = new ControlaIC(this);
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 930, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		dataAtual = new JTextField();
		dataAtual.setColumns(10);
		dataAtual.setBounds(742, 10, 140, 30);
		contIC.atualizaData();
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
		panelLabels.setBounds(0, 0, 110, 468);
		panel.add(panelLabels);
		panelLabels.setBackground(new Color(192, 192, 192));
		panelLabels.setLayout(null);

		// Criacao das labels
		JLabel lblCPF = new JLabel("CPF*:");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCPF.setBounds(10, 20, 90, 30);
		panelLabels.add(lblCPF);

		JLabel lblNome = new JLabel("Nome*:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNome.setBounds(10, 70, 90, 30);
		panelLabels.add(lblNome);

		JLabel lblRua = new JLabel("Rua*:");
		lblRua.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRua.setBounds(10, 120, 90, 30);
		panelLabels.add(lblRua);

		JLabel lblBairro = new JLabel("Bairro*:");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBairro.setBounds(10, 170, 90, 30);
		panelLabels.add(lblBairro);

		JLabel lblCidade = new JLabel("Cidade*:");
		lblCidade.setHorizontalAlignment(SwingConstants.LEFT);
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCidade.setBounds(10, 220, 90, 30);
		panelLabels.add(lblCidade);

		JLabel lblTelefone = new JLabel("Telefone*:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTelefone.setBounds(10, 270, 90, 30);
		panelLabels.add(lblTelefone);

		JLabel lblEmail = new JLabel("Email*:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(10, 320, 90, 30);
		panelLabels.add(lblEmail);

		JLabel lblUF = new JLabel("UF*:");
		lblUF.setBounds(360, 220, 45, 30);
		panel.add(lblUF);
		lblUF.setHorizontalAlignment(SwingConstants.LEFT);
		lblUF.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblNumero = new JLabel("Numero*:");
		lblNumero.setBounds(415, 120, 80, 30);
		panel.add(lblNumero);
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 18));

		// Criacao dos textFields
		txtCPF = new JTextField();
		txtCPF.setBounds(130, 20, 200, 30);
		txtCPF.addFocusListener(contIC);
		panel.add(txtCPF);
		txtCPF.setForeground(SystemColor.controlDkShadow);
		txtCPF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCPF.setColumns(10);
		txtCPF.addFocusListener(contIC);

		txtNome = new JTextField();
		txtNome.setBounds(130, 70, 250, 30);
		panel.add(txtNome);
		txtNome.setForeground(SystemColor.controlDkShadow);
		txtNome.setToolTipText("");
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNome.setColumns(10);
		txtNome.addFocusListener(contIC);

		txtRua = new JTextField();
		txtRua.setBounds(130, 120, 250, 30);
		panel.add(txtRua);
		txtRua.setForeground(SystemColor.controlDkShadow);
		txtRua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtRua.setColumns(10);
		txtRua.addFocusListener(contIC);

		textBairro = new JTextField();
		textBairro.setBounds(130, 170, 200, 30);
		panel.add(textBairro);
		textBairro.setForeground(SystemColor.controlDkShadow);
		textBairro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textBairro.setColumns(10);
		textBairro.addFocusListener(contIC);

		txtCidade = new JTextField();
		txtCidade.setBounds(130, 220, 200, 30);
		panel.add(txtCidade);
		txtCidade.setForeground(SystemColor.controlDkShadow);
		txtCidade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCidade.setColumns(10);
		txtCidade.addFocusListener(contIC);

		txtTelefone = new JTextField();
		txtTelefone.setBounds(130, 270, 200, 30);
		panel.add(txtTelefone);
		txtTelefone.setForeground(SystemColor.controlDkShadow);
		txtTelefone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTelefone.setColumns(10);
		txtTelefone.addFocusListener(contIC);

		txtEmail = new JTextField();
		txtEmail.setBounds(130, 320, 250, 30);
		panel.add(txtEmail);
		txtEmail.setForeground(SystemColor.controlDkShadow);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmail.setColumns(10);
		txtEmail.addFocusListener(contIC);

		textNumero = new JTextField();
		textNumero.setBounds(505, 120, 50, 30);
		panel.add(textNumero);
		textNumero.setHorizontalAlignment(SwingConstants.CENTER);
		textNumero.setForeground(SystemColor.controlDkShadow);
		textNumero.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textNumero.setColumns(10);
		textNumero.addFocusListener(contIC);

		txtUF = new JTextField();
		txtUF.setBounds(410, 220, 50, 30);
		panel.add(txtUF);
		txtUF.setHorizontalAlignment(SwingConstants.CENTER);
		txtUF.setForeground(SystemColor.controlDkShadow);
		txtUF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtUF.setColumns(10);
		txtUF.addFocusListener(contIC);

		// Criacao dos botões de cancelar e confirmar
		buttonCancelar = new JButton("CANCELAR");
		buttonCancelar.setFont(new Font("Dialog", Font.PLAIN, 15));
		buttonCancelar.setBounds(130, 390, 150, 50);
		buttonCancelar.addActionListener(contIC);
		panel.add(buttonCancelar);
		buttonCancelar.setBackground(SystemColor.activeCaption);

		buttonConfirmar = new JButton("CONFIRMAR");
		buttonConfirmar.setFont(new Font("Dialog", Font.PLAIN, 15));
		buttonConfirmar.setBounds(300, 390, 150, 50);
		buttonConfirmar.addActionListener(contIC);
		panel.add(buttonConfirmar);
		buttonConfirmar.setBackground(SystemColor.activeCaption);
	}

	public JFrame getFrame() {
		return frame;
	}
	public JTextField getTxtCPF() {
		return txtCPF;
	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public JTextField getTxtRua() {
		return txtRua;
	}

	public JTextField getTextBairro() {
		return textBairro;
	}

	public JTextField getTxtCidade() {
		return txtCidade;
	}

	public JTextField getTxtTelefone() {
		return txtTelefone;
	}

	public JTextField getTextNumero() {
		return textNumero;
	}

	public JTextField getTxtUF() {
		return txtUF;
	}

	public JTextField getDataAtual() {
		return dataAtual;
	}
	public JTextField getTxtEmail() {
		return txtEmail;
	}


}
