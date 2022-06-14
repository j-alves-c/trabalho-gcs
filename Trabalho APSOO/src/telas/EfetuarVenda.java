package telas;

import controladora.ControlaEV;


import javax.swing.*;
import java.awt.*;



public class EfetuarVenda  {

	private JFrame frame;
	private JTextField campoCpfVendedor;
	private JTextField campoCpfCliente;
	private JTextField campoDesconto;
	private JTextField campoParcelas;
	private JTextField codigoVenda;
	private JTextField dataAtual;
	private JTextField codigoSapato;

	private JTextField campoMarca;
	private JTextField campoColecao;
	private JTextField campoModelo;
	private JTextField campoTipo;
	private JTextField campoTam;
	private JTextField campoValorUni;
	private JComboBox escolhePagamento;
	private JPanel painel;
	private JButton remover;
	private JButton confirmar;
	private JButton cancelar;
	private JButton adicionarItem;
	private JTextField campoTotal;
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
		JLabel legendaTela = new JLabel("Venda Sapatos");
		legendaTela.setForeground(Color.MAGENTA);
		legendaTela.setFont(new Font("Tahoma", Font.PLAIN, 32));

		legendaTela.setBounds(10, 11, 211, 40);
		frame.getContentPane().add(legendaTela);
		
		JLabel legendaCodigoVenda = new JLabel("C\u00F3digo da venda");
		legendaCodigoVenda.setHorizontalAlignment(SwingConstants.CENTER);
		legendaCodigoVenda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		legendaCodigoVenda.setBounds(324, 15, 148, 30);
		frame.getContentPane().add(legendaCodigoVenda);
		
		JLabel legendaData = new JLabel("Data");
		legendaData.setHorizontalAlignment(SwingConstants.CENTER);
		legendaData.setFont(new Font("Tahoma", Font.PLAIN, 15));
		legendaData.setBounds(686, 15, 46, 30);
		frame.getContentPane().add(legendaData);
		
		JLabel legendaCpfVendedor = new JLabel("CPF Vendedor");
		legendaCpfVendedor.setHorizontalAlignment(SwingConstants.CENTER);
		legendaCpfVendedor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		legendaCpfVendedor.setBounds(20, 62, 110, 30);
		frame.getContentPane().add(legendaCpfVendedor);
		
		JLabel legendaCpfCliente = new JLabel("CPF Cliente");
		legendaCpfCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		legendaCpfCliente.setHorizontalAlignment(SwingConstants.CENTER);
		legendaCpfCliente.setBounds(20, 97, 110, 30);
		frame.getContentPane().add(legendaCpfCliente);

		
		JLabel legendaNomeVendedor = new JLabel("Nome Vendedor");
		legendaNomeVendedor.setHorizontalAlignment(SwingConstants.CENTER);
		legendaNomeVendedor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		legendaNomeVendedor.setBounds(490, 59, 110, 30);
		frame.getContentPane().add(legendaNomeVendedor);
		
		JLabel legendaNomeCliente = new JLabel("Nome Cliente");
		legendaNomeCliente.setHorizontalAlignment(SwingConstants.CENTER);
		legendaNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		legendaNomeCliente.setBounds(506, 94, 90, 30);
		frame.getContentPane().add(legendaNomeCliente);
		
		JLabel legendaFormaPag = new JLabel("Forma de pagamento");
		legendaFormaPag.setHorizontalAlignment(SwingConstants.CENTER);
		legendaFormaPag.setFont(new Font("Tahoma", Font.PLAIN, 15));
		legendaFormaPag.setBounds(20, 147, 150, 30);
		frame.getContentPane().add(legendaFormaPag);
		
		JLabel legendaDesconto = new JLabel("Desconto");
		legendaDesconto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		legendaDesconto.setHorizontalAlignment(SwingConstants.CENTER);
		legendaDesconto.setBounds(506, 147, 71, 30);
		frame.getContentPane().add(legendaDesconto);
		
		JLabel legendaParcelas = new JLabel("Parcelas");
		legendaParcelas.setHorizontalAlignment(SwingConstants.CENTER);
		legendaParcelas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		legendaParcelas.setBounds(721, 147, 71, 30);
		frame.getContentPane().add(legendaParcelas);
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
		campoCpfVendedor = new JTextField();
		campoCpfVendedor.setBounds(140, 62, 276, 30);
		campoCpfVendedor.addFocusListener(contEV);
		frame.getContentPane().add(campoCpfVendedor);
		campoCpfVendedor.setColumns(10);

		campoCpfCliente = new JTextField();
		campoCpfCliente.setColumns(10);
		campoCpfCliente.setBounds(140, 99, 276, 30);
		campoCpfCliente.addFocusListener(contEV);
		frame.getContentPane().add(campoCpfCliente);


		campoNomeVendedor = new JTextField();
		campoNomeVendedor.setColumns(10);
		campoNomeVendedor.setBounds(606, 56, 276, 30);
		campoNomeVendedor.addFocusListener(contEV);
		frame.getContentPane().add(campoNomeVendedor);
		
		campoNomeCliente = new JTextField();
		campoNomeCliente.setColumns(10);
		campoNomeCliente.setBounds(606, 97, 276, 30);
		campoNomeCliente.addFocusListener(contEV);
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
		painel = new JPanel();
		painel.setBackground(SystemColor.activeCaption);
		painel.setForeground(SystemColor.activeCaption);
		painel.setBounds(0, 238, 880, 247);

		painel.setLayout(null);
		frame.getContentPane().add(painel);
		
//campo para inserir o c�digo de barras do sapato
		codigoSapato = new JTextField();
		codigoSapato.setHorizontalAlignment(SwingConstants.LEFT);
		codigoSapato.setFont(new Font("Tahoma", Font.PLAIN, 13));
		codigoSapato.setBounds(12, 10, 120, 30);
		codigoSapato.addFocusListener(contEV);
		painel.add(codigoSapato);
		codigoSapato.setColumns(10);
		
//campos de descri��o do sapato
		//campos de descrição do sapato
		campoMarca = new JTextField();
		campoMarca.setHorizontalAlignment(SwingConstants.LEFT);
		campoMarca.setFont(new Font("Tahoma", Font.PLAIN, 13));
		campoMarca.setColumns(10);
		campoMarca.setBounds(142, 10, 120, 30);
		painel.add(campoMarca);

		campoColecao = new JTextField();
		campoColecao.setHorizontalAlignment(SwingConstants.LEFT);
		campoColecao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		campoColecao.setColumns(10);
		campoColecao.setBounds(272, 10, 120, 30);
		painel.add(campoColecao);

		campoModelo = new JTextField();
		campoModelo.setHorizontalAlignment(SwingConstants.LEFT);
		campoModelo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		campoModelo.setColumns(10);
		campoModelo.setBounds(402, 10, 120, 30);
		painel.add(campoModelo);

		campoTipo = new JTextField();
		campoTipo.setHorizontalAlignment(SwingConstants.LEFT);
		campoTipo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		campoTipo.setColumns(10);
		campoTipo.setBounds(532, 10, 120, 30);
		painel.add(campoTipo);

		campoTam = new JTextField();
		campoTam.setHorizontalAlignment(SwingConstants.LEFT);
		campoTam.setFont(new Font("Tahoma", Font.PLAIN, 13));
		campoTam.setColumns(10);
		campoTam.setBounds(662, 10, 50, 30);
		painel.add(campoTam);

		campoValorUni = new JTextField();
		campoValorUni.setHorizontalAlignment(SwingConstants.LEFT);
		campoValorUni.setFont(new Font("Tahoma", Font.PLAIN, 13));
		campoValorUni.setColumns(10);
		campoValorUni.setBounds(722, 10, 90, 30);
		painel.add(campoValorUni);
		//botão para remover esse sapato (inserção incorreta)
		remover = new JButton("X");
		remover.setHorizontalAlignment(SwingConstants.LEFT);
		remover.setFont(new Font("Tahoma", Font.PLAIN, 10));
		remover.setForeground(Color.MAGENTA);
		remover.setBounds(820, 10, 40, 30);
		remover.addActionListener(contEV);
		painel.add(remover);
		
//legenda para descri��o do sapato
		JLabel legendaCodigoSapato = new JLabel("C\u00F3digo do Sapato");
		legendaCodigoSapato.setHorizontalAlignment(SwingConstants.CENTER);
		legendaCodigoSapato.setFont(new Font("Tahoma", Font.PLAIN, 13));
		legendaCodigoSapato.setBounds(10, 210, 114, 30);
		frame.getContentPane().add(legendaCodigoSapato);
				
		JLabel legendaMarca = new JLabel("Marca");
		legendaMarca.setHorizontalAlignment(SwingConstants.CENTER);
		legendaMarca.setFont(new Font("Tahoma", Font.PLAIN, 13));
		legendaMarca.setBounds(146, 210, 46, 30);
		frame.getContentPane().add(legendaMarca);
				
		JLabel legendaColecao = new JLabel("Cole\u00E7\u00E3o");
		legendaColecao.setHorizontalAlignment(SwingConstants.CENTER);
		legendaColecao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		legendaColecao.setBounds(268, 210, 57, 30);
		frame.getContentPane().add(legendaColecao);
				
		JLabel legendaModelo = new JLabel("Modelo");
		legendaModelo.setHorizontalAlignment(SwingConstants.CENTER);
		legendaModelo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		legendaModelo.setBounds(410, 210, 46, 30);
		frame.getContentPane().add(legendaModelo);
				
		JLabel legendaTipo = new JLabel("Tipo");
		legendaTipo.setHorizontalAlignment(SwingConstants.CENTER);
		legendaTipo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		legendaTipo.setBounds(533, 210, 34, 30);
		frame.getContentPane().add(legendaTipo);
				
		JLabel legendaTamanho = new JLabel("TAM");
		legendaTamanho.setHorizontalAlignment(SwingConstants.CENTER);
		legendaTamanho.setFont(new Font("Tahoma", Font.PLAIN, 13));
		legendaTamanho.setBounds(665, 210, 34, 30);
		frame.getContentPane().add(legendaTamanho);
				
		JLabel legendaValorUnit = new JLabel("Valor UNIT");
		legendaValorUnit.setHorizontalAlignment(SwingConstants.CENTER);
		legendaValorUnit.setFont(new Font("Tahoma", Font.PLAIN, 13));
		legendaValorUnit.setBounds(723, 210, 80, 30);
		frame.getContentPane().add(legendaValorUnit);

		JLabel legendaRemover = new JLabel("Remover");
		legendaRemover.setHorizontalAlignment(SwingConstants.CENTER);
		legendaRemover.setFont(new Font("Tahoma", Font.PLAIN, 13));
		legendaRemover.setBounds(800, 210, 80, 30);
		frame.getContentPane().add(legendaRemover);

//legenda do Campo que exibir� o total parcial e final da venda
		JLabel legendaTotal = new JLabel("Total");
		legendaTotal.setHorizontalAlignment(SwingConstants.CENTER);
		legendaTotal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		legendaTotal.setBounds(10, 490, 34, 30);
		frame.getContentPane().add(legendaTotal);

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
		campoTotal = new JTextField();
		campoTotal.setHorizontalAlignment(SwingConstants.LEFT);
		campoTotal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		campoTotal.setColumns(10);
		campoTotal.setBounds(50, 490, 80, 30);
		frame.getContentPane().add(campoTotal);
		campoTotal.setText(String.format("%.2f", 0.00));

// aumenta os campos de adicionar itens de venda
		adicionarItem = new JButton("Adicionar");
		adicionarItem.setBounds(356, 490, 140, 30);
		frame.getContentPane().add(adicionarItem);
		adicionarItem.addActionListener(contEV);

	} // FIM DO INICIALIZE

	public JFrame getFrame(){
		return frame;
	}
	
	public JTextField getCampoCpfVendedor(){
		return campoCpfVendedor;
	}

	public JTextField getCampoCpfCliente() {
		return campoCpfCliente;
	}

	public JTextField getCampoDesconto() {
		return campoDesconto;
	}

	public JComboBox getEscolhePagamento() {
		return escolhePagamento;
	}

	public JPanel getPainel() {
		return painel;
	}

	public JTextField getCampoColecao() {
		return campoColecao;
	}

	public JTextField getCampoMarca() {
		return campoMarca;
	}

	public JTextField getCampoModelo() {
		return campoModelo;
	}

	public JTextField getCampoParcelas() {
		return campoParcelas;
	}

	public JTextField getCampoTam() {
		return campoTam;
	}

	public JTextField getCampoTipo() {
		return campoTipo;
	}

	public JTextField getCodigoVenda() {
		return codigoVenda;
	}

	public JTextField getDataAtual() {
		return dataAtual;
	}

	public JTextField getCodigoSapato() {
		return codigoSapato;
	}

	public JButton getAdicionarItem() {
		return adicionarItem;
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

	public JTextField getCampoTotal() {
		return campoTotal;
	}

	public JTextField getCampoValorUni() {
		return campoValorUni;
	}



	public JTextField getCampoNomeCliente() {
		return campoNomeCliente;
	}

	public JTextField getCampoNomeVendedor() {
		return campoNomeVendedor;
	}
}
