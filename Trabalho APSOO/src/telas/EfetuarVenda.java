package telas;

import controladora.ControlaEV;


import javax.swing.*;
import java.awt.*;



public class EfetuarVenda  {

	private JFrame frame;
	private JTextField campoVendedor;
	private JTextField campoCliente;
	private JTextField campoDesconto;
	private JTextField campoParcelas;
	private JTextField codigoVenda;
	private JTextField dataAtual;
	private JTextField codigo_sapato;
	private JTextField campoMarca;
	private JTextField campocolecao;
	private JTextField campomodelo;
	private JTextField campotipo;
	private JTextField campotam;
	private JTextField campovaloruni;
	private JComboBox escolhePagamento;
	private JPanel panel;
	private JButton remover;
	private JButton confirmar;
	private JButton cancelar;
	private JButton adicionar_item;
	private JTextField campototal;
	private JTextField campoNomeVendedor;
	private JTextField campoNomeCliente;


	

	/**
	 * Create the application.
	 */
	public EfetuarVenda() {
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
		ControlaEV contEV = new ControlaEV(this);


// cria��o das legendas para os campos de preenchimento
		JLabel tela_label = new JLabel("Venda Sapatos");
		tela_label.setForeground(Color.MAGENTA);
		tela_label.setFont(new Font("Tahoma", Font.PLAIN, 32));

		tela_label.setBounds(10, 11, 211, 40);
		frame.getContentPane().add(tela_label);
		
		JLabel lblCodigoVenda = new JLabel("C\u00F3digo da venda");
		lblCodigoVenda.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigoVenda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodigoVenda.setBounds(324, 15, 148, 30);
		frame.getContentPane().add(lblCodigoVenda);
		
		JLabel lblData = new JLabel("Data");
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblData.setBounds(686, 15, 46, 30);
		frame.getContentPane().add(lblData);
		
		JLabel lblCpfVendedor = new JLabel("CPF Vendedor");
		lblCpfVendedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpfVendedor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCpfVendedor.setBounds(20, 62, 110, 30);
		frame.getContentPane().add(lblCpfVendedor);
		
		JLabel lblCpfCliente = new JLabel("CPF Cliente");
		lblCpfCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCpfCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpfCliente.setBounds(20, 97, 110, 30);
		frame.getContentPane().add(lblCpfCliente);

		
		JLabel lblNomeVendedor = new JLabel("Nome Vendedor");
		lblNomeVendedor.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeVendedor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeVendedor.setBounds(490, 59, 110, 30);
		frame.getContentPane().add(lblNomeVendedor);
		
		JLabel lblNomeCliente = new JLabel("Nome Cliente");
		lblNomeCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeCliente.setBounds(506, 94, 90, 30);
		frame.getContentPane().add(lblNomeCliente);
		
		JLabel lblFormaPag = new JLabel("Forma de pagamento");
		lblFormaPag.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormaPag.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFormaPag.setBounds(20, 147, 150, 30);
		frame.getContentPane().add(lblFormaPag);
		
		JLabel lblDesconto = new JLabel("Desconto");
		lblDesconto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDesconto.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesconto.setBounds(506, 147, 71, 30);
		frame.getContentPane().add(lblDesconto);
		
		JLabel lblParcelas = new JLabel("Parcelas");
		lblParcelas.setHorizontalAlignment(SwingConstants.CENTER);
		lblParcelas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblParcelas.setBounds(721, 147, 71, 30);
		frame.getContentPane().add(lblParcelas);
// fim da cria��o das legendas para os campos de preenchimento


// cria��o do campo da data (receber� a data do dia em que ser� feita a venda)
		dataAtual = new JTextField();
		dataAtual.setColumns(10);
		dataAtual.setBounds(742, 15, 140, 30);
		contEV.atualizaData();
		frame.getContentPane().add(dataAtual);

//campo onde ser� exibido a venda
		codigoVenda = new JTextField();
		codigoVenda.setColumns(10);
		codigoVenda.setBounds(466, 15, 160, 30);
		contEV.iniciaVenda();
		frame.getContentPane().add(codigoVenda);

		escolhePagamento = new JComboBox();
		escolhePagamento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		escolhePagamento.setModel(new DefaultComboBoxModel(new String[] {"Selecionar", "Dinheiro", "D\u00E9bito", "Cr\u00E9dito"}));
		escolhePagamento.setBounds(180, 147, 160, 30);
		escolhePagamento.addFocusListener(contEV);
		frame.getContentPane().add(escolhePagamento);

//campo para inserir o CPF do vendedor e o sistema retornar o nome
		campoVendedor = new JTextField();
		campoVendedor.setBounds(140, 62, 276, 30);
		campoVendedor.addFocusListener(contEV);
		frame.getContentPane().add(campoVendedor);
		campoVendedor.setColumns(10);

		campoCliente = new JTextField();
		campoCliente.setColumns(10);
		campoCliente.setBounds(140, 99, 276, 30);
		campoCliente.addFocusListener(contEV);
		frame.getContentPane().add(campoCliente);


		campoNomeVendedor = new JTextField();
		campoNomeVendedor.setColumns(10);
		campoNomeVendedor.setBounds(606, 56, 276, 30);
		campoNomeVendedor.addFocusListener(contEV);
		frame.getContentPane().add(campoNomeVendedor);
		
		campoNomeCliente = new JTextField();
		campoNomeCliente.setColumns(10);
		campoNomeCliente.setBounds(606, 97, 276, 30);
		frame.getContentPane().add(campoNomeCliente);
		
		campoDesconto = new JTextField();
		campoDesconto.setColumns(10);
		campoDesconto.setBounds(606, 149, 75, 30);
		campoDesconto.addFocusListener(contEV);
		frame.getContentPane().add(campoDesconto);
		campoDesconto.setText("0");
		
		campoParcelas = new JTextField();
		campoParcelas.setColumns(10);
		campoParcelas.setBounds(807, 147, 75, 30);
		campoParcelas.addFocusListener(contEV);

		frame.getContentPane().add(campoParcelas);
		campoParcelas.setText("1");
		


//painel de cadastro de sapatos
		panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setForeground(SystemColor.activeCaption);
		panel.setBounds(0, 238, 880, 247);

		panel.setLayout(null);
		frame.getContentPane().add(panel);
		
//campo para inserir o c�digo de barras do sapato
		codigo_sapato = new JTextField();
		codigo_sapato.setHorizontalAlignment(SwingConstants.LEFT);
		codigo_sapato.setFont(new Font("Tahoma", Font.PLAIN, 13));
		codigo_sapato.setBounds(12, 10, 120, 30);
		codigo_sapato.addFocusListener(contEV);
		panel.add(codigo_sapato);
		codigo_sapato.setColumns(10);
		
//campos de descri��o do sapato
		//campos de descrição do sapato
		campoMarca = new JTextField();
		campoMarca.setHorizontalAlignment(SwingConstants.LEFT);
		campoMarca.setFont(new Font("Tahoma", Font.PLAIN, 13));
		campoMarca.setColumns(10);
		campoMarca.setBounds(142, 10, 120, 30);
		panel.add(campoMarca);

		campocolecao = new JTextField();
		campocolecao.setHorizontalAlignment(SwingConstants.LEFT);
		campocolecao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		campocolecao.setColumns(10);
		campocolecao.setBounds(272, 10, 120, 30);
		panel.add(campocolecao);

		campomodelo = new JTextField();
		campomodelo.setHorizontalAlignment(SwingConstants.LEFT);
		campomodelo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		campomodelo.setColumns(10);
		campomodelo.setBounds(402, 10, 120, 30);
		panel.add(campomodelo);

		campotipo = new JTextField();
		campotipo.setHorizontalAlignment(SwingConstants.LEFT);
		campotipo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		campotipo.setColumns(10);
		campotipo.setBounds(532, 10, 120, 30);
		panel.add(campotipo);

		campotam = new JTextField();
		campotam.setHorizontalAlignment(SwingConstants.LEFT);
		campotam.setFont(new Font("Tahoma", Font.PLAIN, 13));
		campotam.setColumns(10);
		campotam.setBounds(662, 10, 50, 30);
		panel.add(campotam);

		campovaloruni = new JTextField();
		campovaloruni.setHorizontalAlignment(SwingConstants.LEFT);
		campovaloruni.setFont(new Font("Tahoma", Font.PLAIN, 13));
		campovaloruni.setColumns(10);
		campovaloruni.setBounds(722, 10, 90, 30);
		panel.add(campovaloruni);
		//botão para remover esse sapato (inserção incorreta)
		remover = new JButton("X");
		remover.setHorizontalAlignment(SwingConstants.LEFT);
		remover.setFont(new Font("Tahoma", Font.PLAIN, 10));
		remover.setForeground(Color.MAGENTA);
		remover.setBounds(820, 10, 40, 30);
		remover.addActionListener(contEV);
		panel.add(remover);
		
//legenda para descri��o do sapato
		JLabel lblCodigoSapato = new JLabel("C\u00F3digo do Sapato");
		lblCodigoSapato.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigoSapato.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigoSapato.setBounds(10, 210, 114, 30);
		frame.getContentPane().add(lblCodigoSapato);
				
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMarca.setBounds(146, 210, 46, 30);
		frame.getContentPane().add(lblMarca);
				
		JLabel lblColecao = new JLabel("Cole\u00E7\u00E3o");
		lblColecao.setHorizontalAlignment(SwingConstants.CENTER);
		lblColecao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblColecao.setBounds(268, 210, 57, 30);
		frame.getContentPane().add(lblColecao);
				
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setHorizontalAlignment(SwingConstants.CENTER);
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblModelo.setBounds(410, 210, 46, 30);
		frame.getContentPane().add(lblModelo);
				
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTipo.setBounds(533, 210, 34, 30);
		frame.getContentPane().add(lblTipo);
				
		JLabel lblTamanho = new JLabel("TAM");
		lblTamanho.setHorizontalAlignment(SwingConstants.CENTER);
		lblTamanho.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTamanho.setBounds(665, 210, 34, 30);
		frame.getContentPane().add(lblTamanho);
				
		JLabel lblValorUNIT = new JLabel("Valor UNIT");
		lblValorUNIT.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorUNIT.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblValorUNIT.setBounds(723, 210, 80, 30);
		frame.getContentPane().add(lblValorUNIT);

		JLabel lblRemover = new JLabel("Remover");
		lblRemover.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemover.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRemover.setBounds(800, 210, 80, 30);
		frame.getContentPane().add(lblRemover);

//legenda do Campo que exibir� o total parcial e final da venda
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTotal.setBounds(10, 490, 34, 30);
		frame.getContentPane().add(lblTotal);

//bot�o de confirmar
		confirmar = new JButton("CONFIRMAR");
		confirmar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		confirmar.setBounds(700, 490, 122, 30);
		confirmar.addActionListener(contEV);
		frame.getContentPane().add(confirmar);

// termina a execu��o.
		cancelar = new JButton("CANCELAR");
		cancelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cancelar.setBounds(570, 490, 122, 30);
		cancelar.addActionListener(contEV);
		frame.getContentPane().add(cancelar);
		
//campo do total
		campototal = new JTextField();
		campototal.setHorizontalAlignment(SwingConstants.LEFT);
		campototal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		campototal.setColumns(10);
		campototal.setBounds(50, 490, 80, 30);
		frame.getContentPane().add(campototal);
		campototal.setText(String.format("%.2f", 0.00));

// aumenta os campos de adicionar itens de venda
		adicionar_item = new JButton("Adicionar");
		adicionar_item.setBounds(356, 490, 140, 30);
		frame.getContentPane().add(adicionar_item);
		adicionar_item.addActionListener(contEV);

	} // FIM DO INICIALIZE

	public JFrame getFrame(){
		return frame;
	}
	
	public JTextField getCampoVendedor(){
		return campoVendedor;
	}

	public JTextField getCampoCliente() {
		return campoCliente;
	}

	public JTextField getCampoDesconto() {
		return campoDesconto;
	}

	public JComboBox getEscolhePagamento() {
		return escolhePagamento;
	}

	public JPanel getPanel() {
		return panel;
	}

	public JTextField getCampocolecao() {
		return campocolecao;
	}

	public JTextField getCampoMarca() {
		return campoMarca;
	}

	public JTextField getCampomodelo() {
		return campomodelo;
	}

	public JTextField getCampoParcelas() {
		return campoParcelas;
	}

	public JTextField getCampotam() {
		return campotam;
	}

	public JTextField getCampotipo() {
		return campotipo;
	}

	public JTextField getCodigoVenda() {
		return codigoVenda;
	}

	public JTextField getDataAtual() {
		return dataAtual;
	}

	public JTextField getCodigo_sapato() {
		return codigo_sapato;
	}

	public JButton getAdicionar_item() {
		return adicionar_item;
	}

	public JButton getCancelar() {
		return cancelar;
	}

	public JButton getConfirmar() {
		return confirmar;
	}

	public JButton getRemover() {
		return remover;
	}

	public JTextField getCampototal() {
		return campototal;
	}

	public JTextField getCampovaloruni() {
		return campovaloruni;
	}



	public JTextField getCampoNomeCliente() {
		return campoNomeCliente;
	}

	public JTextField getCampoNomeVendedor() {
		return campoNomeVendedor;
	}
}
