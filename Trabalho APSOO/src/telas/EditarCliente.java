package telas;

import javax.swing.*;
import java.awt.*;

public class EditarCliente extends JFrame {

	private JFrame frame;
	private JTextField txtCPF;
	private JTextField txtNome;
	private JTextField txtEndereco;
	private JTextField txtEmail;
	private JTextField txtCidade;
	private JTextField txtTelefone;
	private JTextField dataAtual;
	private JTextField txtMs;
	private Button buttonSalvar;

	public EditarCliente() {
		initialize();
	}

	private void initialize() {
		// Criacao do frame
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 930, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		dataAtual = new JTextField();
		dataAtual.setColumns(10);
		dataAtual.setBounds(742, 10, 140, 30);
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

		JLabel lblRua = new JLabel("Endere\u00e7o*:");
		lblRua.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRua.setBounds(10, 120, 100, 30);
		panelLabels.add(lblRua);

		JLabel lblBairro = new JLabel("Email*:");
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

		JLabel lblUF = new JLabel("UF*:");
		lblUF.setBounds(360, 220, 45, 30);
		panel.add(lblUF);
		lblUF.setHorizontalAlignment(SwingConstants.LEFT);
		lblUF.setFont(new Font("Tahoma", Font.PLAIN, 18));


		// Criacao dos textFields
		txtCPF = new JTextField();
		txtCPF.setBounds(130, 20, 200, 30);
		panel.add(txtCPF);
		txtCPF.setForeground(SystemColor.controlDkShadow);
		txtCPF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCPF.setColumns(10);

		txtNome = new JTextField();
		txtNome.setBounds(130, 70, 250, 30);
		panel.add(txtNome);
		txtNome.setForeground(SystemColor.controlDkShadow);
		txtNome.setToolTipText("");
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNome.setColumns(10);

		txtEndereco = new JTextField();
		txtEndereco.setBounds(130, 120, 400, 30);
		panel.add(txtEndereco);
		txtEndereco.setForeground(SystemColor.controlDkShadow);
		txtEndereco.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEndereco.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(130, 170, 250, 30);
		panel.add(txtEmail);
		txtEmail.setForeground(SystemColor.controlDkShadow);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmail.setColumns(10);

		txtCidade = new JTextField();
		txtCidade.setBounds(130, 220, 200, 30);
		panel.add(txtCidade);
		txtCidade.setForeground(SystemColor.controlDkShadow);
		txtCidade.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCidade.setColumns(10);

		txtTelefone = new JTextField();
		txtTelefone.setBounds(130, 270, 200, 30);
		panel.add(txtTelefone);
		txtTelefone.setForeground(SystemColor.controlDkShadow);
		txtTelefone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTelefone.setColumns(10);



		txtMs = new JTextField();
		txtMs.setBounds(410, 220, 50, 30);
		panel.add(txtMs);
		txtMs.setHorizontalAlignment(SwingConstants.CENTER);
		txtMs.setForeground(SystemColor.controlDkShadow);
		txtMs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMs.setColumns(10);

		// Criacao dos botões de cancelar e confirmar
		Button buttonCancelar = new Button("CANCELAR");
		buttonCancelar.setFont(new Font("Dialog", Font.PLAIN, 15));
		buttonCancelar.setBounds(130, 365, 100, 50);
		panel.add(buttonCancelar);
		buttonCancelar.setBackground(SystemColor.activeCaption);

		buttonSalvar = new Button("SALVAR");
		buttonSalvar.setFont(new Font("Dialog", Font.PLAIN, 15));
		buttonSalvar.setBounds(244, 365, 100, 50);
		panel.add(buttonSalvar);
		buttonSalvar.setBackground(SystemColor.activeCaption);
	}

	public JFrame getFrame() {
		return frame;
	}
}
