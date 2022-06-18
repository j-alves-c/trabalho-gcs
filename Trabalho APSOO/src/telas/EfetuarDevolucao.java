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
	private JPanel painel;
	private JTextField campoValor;
	private JButton cancelar;
	private JButton confirmar;
	private JButton mudarTema;



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

		JLabel legendaDevolSapatos = new JLabel();
		legendaDevolSapatos.setText("Devolu\u00E7\u00E3o Sapatos");
		legendaDevolSapatos.setForeground(new Color(51,153,255));
		legendaDevolSapatos.setBackground(SystemColor.control);
		legendaDevolSapatos.setFont(new Font("Tahoma", Font.PLAIN, 32));
		legendaDevolSapatos.setBounds(10, 11, 276, 45);
		frame.getContentPane().add(legendaDevolSapatos);

		JLabel legendaCodDevol = new JLabel();
		legendaCodDevol.setFont(new Font("Tahoma", Font.PLAIN, 15));
		legendaCodDevol.setText("C\u00F3digo de Devolu\u00E7\u00E3o:");
		legendaCodDevol.setBackground(SystemColor.control);
		legendaCodDevol.setBounds(310, 15, 157, 30);
		frame.getContentPane().add(legendaCodDevol);

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


		JLabel legendaData = new JLabel();
		legendaData.setText("Data Devolu\u00E7\u00E3o:");
		legendaData.setFont(new Font("Tahoma", Font.PLAIN, 15));
		legendaData.setBackground(SystemColor.control);
		legendaData.setBounds(636, 15, 122, 30);
		frame.getContentPane().add(legendaData);

		JLabel legendaCpfVendedor = new JLabel();
		legendaCpfVendedor.setText("CPF Vendedor:");
		legendaCpfVendedor.setBackground(SystemColor.control);
		legendaCpfVendedor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		legendaCpfVendedor.setBounds(20, 62, 110, 30);
		frame.getContentPane().add(legendaCpfVendedor);
		
		campoCpfVendedor = new JTextField();
		campoCpfVendedor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		campoCpfVendedor.setBounds(140, 62, 276, 30);
		campoCpfVendedor.addFocusListener(controlaED);
		campoCpfVendedor.setColumns(10);
		campoCpfVendedor.addFocusListener(controlaED);
		frame.getContentPane().add(campoCpfVendedor);


		JLabel legendaNomeVendedor = new JLabel();
		legendaNomeVendedor.setText("Nome Vendedor:");
		legendaNomeVendedor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		legendaNomeVendedor.setBackground(SystemColor.menu);
		legendaNomeVendedor.setBounds(487, 62, 122, 30);
		frame.getContentPane().add(legendaNomeVendedor);
		
		campoNomeVendedor = new JTextField();
		campoNomeVendedor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		campoNomeVendedor.setColumns(10);
		campoNomeVendedor.setBounds(619, 62, 276, 30);
		campoNomeVendedor.addFocusListener(controlaED);
		frame.getContentPane().add(campoNomeVendedor);

		JLabel legendaCodigoVenda = new JLabel();
		legendaCodigoVenda.setText("C\u00F3digo Venda:");
		legendaCodigoVenda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		legendaCodigoVenda.setBackground(SystemColor.menu);
		legendaCodigoVenda.setBounds(20, 105, 110, 30);
		frame.getContentPane().add(legendaCodigoVenda);
		
		campoCodigoVenda = new JTextField();
		campoCodigoVenda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		campoCodigoVenda.setColumns(10);
		campoCodigoVenda.setBounds(140, 105, 276, 30);
		campoCodigoVenda.addFocusListener(controlaED);
		frame.getContentPane().add(campoCodigoVenda);

		JLabel legendaDataVenda = new JLabel();
		legendaDataVenda.setText("Data da Venda:");
		legendaDataVenda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		legendaDataVenda.setBackground(SystemColor.menu);
		legendaDataVenda.setBounds(487, 105, 122, 30);
		frame.getContentPane().add(legendaDataVenda);
		
		campoDataVenda = new JTextField();
		campoDataVenda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		campoDataVenda.setColumns(10);
		campoDataVenda.setBounds(619, 105, 136, 30);
		frame.getContentPane().add(campoDataVenda);

		JLabel legendaCpfCliente = new JLabel();
		legendaCpfCliente.setText("CPF Cliente:");
		legendaCpfCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		legendaCpfCliente.setBackground(SystemColor.menu);
		legendaCpfCliente.setBounds(20, 151, 110, 30);
		frame.getContentPane().add(legendaCpfCliente);
		
		campoCpfCliente = new JTextField();
		campoCpfCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		campoCpfCliente.setColumns(10);
		campoCpfCliente.setBounds(140, 151, 276, 30);
		frame.getContentPane().add(campoCpfCliente);

		JLabel legendaNomeCliente = new JLabel();
		legendaNomeCliente.setText("Nome Cliente:");
		legendaNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		legendaNomeCliente.setBackground(SystemColor.menu);
		legendaNomeCliente.setBounds(487, 151, 122, 30);
		frame.getContentPane().add(legendaNomeCliente);
		
		campoNomeCliente = new JTextField();
		campoNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		campoNomeCliente.setColumns(10);
		campoNomeCliente.setBounds(619, 151, 276, 30);
		frame.getContentPane().add(campoNomeCliente);
		
		JLabel legendaCodigoBarras = new JLabel("C\u00F3digo de Barras:");
		legendaCodigoBarras.setFont(new Font("Tahoma", Font.PLAIN, 15));
		legendaCodigoBarras.setBounds(20, 198, 129, 30);
		frame.getContentPane().add(legendaCodigoBarras);
		
		JLabel legendaMarca = new JLabel("Marca");
		legendaMarca.setFont(new Font("Tahoma", Font.PLAIN, 15));
		legendaMarca.setBounds(190, 198, 61, 30);
		frame.getContentPane().add(legendaMarca);
		
		JLabel legendaColecao = new JLabel("Cole\u00E7\u00E3o");
		legendaColecao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		legendaColecao.setBounds(300, 198, 76, 30);
		frame.getContentPane().add(legendaColecao);
		
		JLabel legendaModelo = new JLabel("Modelo");
		legendaModelo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		legendaModelo.setBounds(415, 198, 61, 30);
		frame.getContentPane().add(legendaModelo);
		
		JLabel legendaTipo = new JLabel("Tipo");
		legendaTipo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		legendaTipo.setBounds(570, 198, 61, 30);
		frame.getContentPane().add(legendaTipo);
		
		JLabel legendaTamanho = new JLabel("TAM");
		legendaTamanho.setFont(new Font("Tahoma", Font.PLAIN, 15));
		legendaTamanho.setBounds(670, 198, 45, 30);
		frame.getContentPane().add(legendaTamanho);
		
		JLabel legendaValor = new JLabel("Valor UNI");
		legendaValor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		legendaValor.setBounds(730, 198, 77, 30);
		frame.getContentPane().add(legendaValor);

		painel = new JPanel();
		painel.setBackground(SystemColor.activeCaption);
		painel.setForeground(SystemColor.activeCaption);
		painel.setBounds(0, 238, 930, 247);

		painel.setLayout(null);
		frame.getContentPane().add(painel);
		
		cancelar = new JButton("CANCELAR");
		cancelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cancelar.setBounds(570, 495, 122, 30);
		cancelar.addActionListener(controlaED);
		frame.getContentPane().add(cancelar);
		
		confirmar = new JButton("CONFIRMAR");
		confirmar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		confirmar.setBounds(700, 495, 122, 30);
		confirmar.addActionListener(controlaED);
		frame.getContentPane().add(confirmar);

		JLabel legendaValorDevol = new JLabel("Valor a devolver R$:");
		legendaValorDevol.setFont(new Font("Tahoma", Font.PLAIN, 15));
		legendaValorDevol.setBounds(100, 495, 139, 30);
		frame.getContentPane().add(legendaValorDevol);
		
		campoValor = new JTextField();
		campoValor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		campoValor.setText("0,00");
		campoValor.setBounds(250, 495, 80, 30);
		frame.getContentPane().add(campoValor);
		campoValor.setColumns(10);
		
// botão de mudar o tema
				mudarTema = new JButton("Modo");
				mudarTema.setHorizontalAlignment(SwingConstants.LEFT);
				mudarTema.setFont(new Font("Tahoma", Font.PLAIN, 13));
				mudarTema.setBounds(10, 495, 65, 30);
				frame.getContentPane().add(mudarTema);
				mudarTema.addActionListener(controlaED);

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

	public JPanel getPainel() {
		return painel;
	}

	public JButton getCancelar() {
		return cancelar;
	}

	public JButton getConfirmar() {
		return confirmar;
	}
	
	public JButton getMudarTema() {
		return mudarTema;
	}

}
