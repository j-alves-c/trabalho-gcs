package telas;

import controladora.ControlaED;

import javax.swing.*;
import java.awt.*;

public class EfetuarDevolucao {

	private JFrame frame;
	private JTextField campoCodigoDevolucao;
	private JTextField campoDataDevolucao;
	private JTextField campoCpfVendedor;
	private JTextField campoNomeVendedor;
	private JTextField campoCodigoVenda;
	private JTextField campoDataVenda;
	private JTextField campoCpfCliente;
	private JTextField campoNomeCliente;
	private JPanel panel;
	private JTextField campoValor;
	private JButton btnCancelar;
	private JButton btnConfirmar;



	/**
	 * Create the application.
	 */
	public EfetuarDevolucao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 930, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		ControlaED controlaED = new ControlaED(this);

		JLabel txtDevoluoSapatos = new JLabel();
		txtDevoluoSapatos.setText("Devolu\u00E7\u00E3o Sapatos");
		txtDevoluoSapatos.setForeground(Color.MAGENTA);
		txtDevoluoSapatos.setBackground(SystemColor.control);
		txtDevoluoSapatos.setFont(new Font("Tahoma", Font.PLAIN, 32));
		txtDevoluoSapatos.setBounds(10, 11, 276, 45);
		frame.getContentPane().add(txtDevoluoSapatos);

		JLabel txtCufdigoDeDevoluo = new JLabel();
		txtCufdigoDeDevoluo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCufdigoDeDevoluo.setText("C\u00F3digo de Devolu\u00E7\u00E3o:");
		txtCufdigoDeDevoluo.setBackground(SystemColor.control);
		txtCufdigoDeDevoluo.setBounds(310, 15, 157, 30);
		frame.getContentPane().add(txtCufdigoDeDevoluo);

		campoDataDevolucao = new JTextField();
		campoDataDevolucao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		campoDataDevolucao.setColumns(10);
		campoDataDevolucao.setBackground(Color.WHITE);
		campoDataDevolucao.setBounds(759, 15, 136, 30);
		controlaED.atualizaData();
		frame.getContentPane().add(campoDataDevolucao);
		
		campoCodigoDevolucao = new JTextField();
		campoCodigoDevolucao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		campoCodigoDevolucao.setBackground(Color.WHITE);
		campoCodigoDevolucao.setBounds(466, 15, 160, 30);
		campoCodigoDevolucao.setColumns(10);
		controlaED.comecaDevolucao();
		frame.getContentPane().add(campoCodigoDevolucao);


		JLabel txtData = new JLabel();
		txtData.setText("Data Devolu\u00E7\u00E3o:");
		txtData.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtData.setBackground(SystemColor.control);
		txtData.setBounds(636, 15, 122, 30);
		frame.getContentPane().add(txtData);
		



		JLabel txtCpfVendedor = new JLabel();
		txtCpfVendedor.setText("CPF Vendedor:");
		txtCpfVendedor.setBackground(SystemColor.control);
		txtCpfVendedor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCpfVendedor.setBounds(20, 62, 110, 30);
		frame.getContentPane().add(txtCpfVendedor);
		
		campoCpfVendedor = new JTextField();
		campoCpfVendedor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		campoCpfVendedor.setBounds(140, 62, 276, 30);
		campoCpfVendedor.addFocusListener(controlaED);
		campoCpfVendedor.setColumns(10);
		campoCpfVendedor.addFocusListener(controlaED);
		frame.getContentPane().add(campoCpfVendedor);


		JLabel txtNomeVendedor = new JLabel();
		txtNomeVendedor.setText("Nome Vendedor:");
		txtNomeVendedor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNomeVendedor.setBackground(SystemColor.menu);
		txtNomeVendedor.setBounds(487, 62, 122, 30);
		frame.getContentPane().add(txtNomeVendedor);
		
		campoNomeVendedor = new JTextField();
		campoNomeVendedor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		campoNomeVendedor.setColumns(10);
		campoNomeVendedor.setBounds(619, 62, 276, 30);
		frame.getContentPane().add(campoNomeVendedor);

		JLabel txtCdigoVenda = new JLabel();
		txtCdigoVenda.setText("C\u00F3digo Venda:");
		txtCdigoVenda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCdigoVenda.setBackground(SystemColor.menu);
		txtCdigoVenda.setBounds(20, 105, 110, 30);
		frame.getContentPane().add(txtCdigoVenda);
		
		campoCodigoVenda = new JTextField();
		campoCodigoVenda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		campoCodigoVenda.setColumns(10);
		campoCodigoVenda.setBounds(140, 105, 276, 30);
		campoCodigoVenda.addFocusListener(controlaED);
		frame.getContentPane().add(campoCodigoVenda);

		JLabel txtDataDaVenda = new JLabel();
		txtDataDaVenda.setText("Data da Venda:");
		txtDataDaVenda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDataDaVenda.setBackground(SystemColor.menu);
		txtDataDaVenda.setBounds(487, 105, 122, 30);
		frame.getContentPane().add(txtDataDaVenda);
		
		campoDataVenda = new JTextField();
		campoDataVenda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		campoDataVenda.setColumns(10);
		campoDataVenda.setBounds(619, 105, 136, 30);
		frame.getContentPane().add(campoDataVenda);

		JLabel txtCpfCliente = new JLabel();
		txtCpfCliente.setText("CPF Cliente:");
		txtCpfCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCpfCliente.setBackground(SystemColor.menu);
		txtCpfCliente.setBounds(20, 151, 110, 30);
		frame.getContentPane().add(txtCpfCliente);
		
		campoCpfCliente = new JTextField();
		campoCpfCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		campoCpfCliente.setColumns(10);
		campoCpfCliente.setBounds(140, 151, 276, 30);
		frame.getContentPane().add(campoCpfCliente);

		JLabel txtNomeCliente = new JLabel();
		txtNomeCliente.setText("Nome Cliente:");
		txtNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNomeCliente.setBackground(SystemColor.menu);
		txtNomeCliente.setBounds(487, 151, 122, 30);
		frame.getContentPane().add(txtNomeCliente);
		
		campoNomeCliente = new JTextField();
		campoNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		campoNomeCliente.setColumns(10);
		campoNomeCliente.setBounds(619, 151, 276, 30);
		frame.getContentPane().add(campoNomeCliente);
		
		JLabel lblCodigoDeBarras = new JLabel("C\u00F3digo de Barras:");
		lblCodigoDeBarras.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodigoDeBarras.setBounds(20, 198, 129, 30);
		frame.getContentPane().add(lblCodigoDeBarras);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMarca.setBounds(190, 198, 61, 30);
		frame.getContentPane().add(lblMarca);
		
		JLabel lblColecao = new JLabel("Cole\u00E7\u00E3o");
		lblColecao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblColecao.setBounds(300, 198, 76, 30);
		frame.getContentPane().add(lblColecao);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblModelo.setBounds(415, 198, 61, 30);
		frame.getContentPane().add(lblModelo);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTipo.setBounds(570, 198, 61, 30);
		frame.getContentPane().add(lblTipo);
		
		JLabel lblTamanho = new JLabel("TAM");
		lblTamanho.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTamanho.setBounds(670, 198, 45, 30);
		frame.getContentPane().add(lblTamanho);
		
		JLabel lblValor = new JLabel("Valor UNI");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblValor.setBounds(730, 198, 77, 30);
		frame.getContentPane().add(lblValor);

		panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setForeground(SystemColor.activeCaption);
		panel.setBounds(0, 238, 930, 247);

		panel.setLayout(null);
		frame.getContentPane().add(panel);
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancelar.setBounds(570, 495, 122, 30);
		btnCancelar.addActionListener(controlaED);
		frame.getContentPane().add(btnCancelar);
		
		btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConfirmar.setBounds(700, 495, 122, 30);
		btnConfirmar.addActionListener(controlaED);
		frame.getContentPane().add(btnConfirmar);

		JLabel lblNewLabel = new JLabel("Valor a devolver R$:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 495, 139, 30);
		frame.getContentPane().add(lblNewLabel);
		
		campoValor = new JTextField();
		campoValor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		campoValor.setText("0, 00");
		campoValor.setBounds(159, 495, 80, 30);
		frame.getContentPane().add(campoValor);
		campoValor.setColumns(10);

	}

	public JFrame getFrame(){
		return frame;
	}

	public JTextField getCampoNomeVendedor() {
		return campoNomeVendedor;
	}

	public JTextField getCampoNomeCliente() {
		return campoNomeCliente;
	}

	public JTextField getCampoDataVenda() {
		return campoDataVenda;
	}

	public JTextField getCampoCodigoDevolucao() {
		return campoCodigoDevolucao;
	}

	public JTextField getCampoCodigoVenda() {
		return campoCodigoVenda;
	}

	public JTextField getCampoCpfCliente() {
		return campoCpfCliente;
	}

	public JTextField getCampoCpfVendedor() {
		return campoCpfVendedor;
	}

	public JTextField getCampoValor() {
		return campoValor;
	}

	public JTextField getCampoDataDevolucao() {
		return campoDataDevolucao;
	}

	public JPanel getPanel() {
		return panel;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}

}
