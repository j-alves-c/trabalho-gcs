package controladora;

import dominio.Cliente;
import persistencia.ClienteDao;
import persistencia.ConexaoBD;
import persistencia.InterfaceDAO;
import telas.InserirCliente;

import javax.swing.*;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class ControlaIC implements ActionListener, FocusListener {
	private final Connection CONEXAO;
	private static InterfaceDAO<Cliente, String> persistCliente = null;
	private static Cliente cliente;
	private boolean cpf = false, nome = false, dataAtual = false, rua = false, bairro = false, numero = false,
			cidade = false, estado = false, telefone = false, email = false;
	private final InserirCliente INSERIR_CLIENTE;

	public ControlaIC(InserirCliente INSERIR_CLIENTE) {
		this.INSERIR_CLIENTE = INSERIR_CLIENTE;
		this.CONEXAO = ConexaoBD.conectar();
		try {
			persistCliente = new ClienteDao(CONEXAO);
		} catch (Exception e) {

			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}

	public void atualizaData() {
		// criar uma vari\u00e1vel Date para captar a data.
		Date data = new Date(System.currentTimeMillis());
		// formatar pra String
		SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy");
		// settar a data do dia no campo da data.
		dataAtual = true;
		INSERIR_CLIENTE.getDataAtual().setText(formatarDate.format(data));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(INSERIR_CLIENTE.getButtonConfirmar())) {
			confirma();
		} else if (e.getSource().equals(INSERIR_CLIENTE.getButtonCancelar())) {
			cancelaCadastro();
		} else if (e.getSource().equals(INSERIR_CLIENTE.getButtonLimparCampos())) {
			limpaCampo();
		}

	}

	@Override
	public void focusGained(FocusEvent e) {

	}

	@Override
	public void focusLost(FocusEvent e) {
		// ValidaCpfCliente()
		if (e.getSource().equals(INSERIR_CLIENTE.getTxtCPF())) {
			validaCpfCliente();

		} else if (e.getSource().equals(INSERIR_CLIENTE.getTxtNome())) {
			validaNome();

		} else if (e.getSource().equals(INSERIR_CLIENTE.getTxtRua())) {
			validaRua();

		} else if (e.getSource().equals(INSERIR_CLIENTE.getTextBairro())) {
			validaBairro();

		} else if (e.getSource().equals(INSERIR_CLIENTE.getTextNumero())) {
			validaNumero();

		} else if (e.getSource().equals(INSERIR_CLIENTE.getTxtCidade())) {
			validaCidade();

		} else if (e.getSource().equals(INSERIR_CLIENTE.getTxtUF())) {
			validaUF();
		} else if (e.getSource().equals(INSERIR_CLIENTE.getTxtTelefone())) {
			validaTelefone();
		} else if (e.getSource().equals(INSERIR_CLIENTE.getTxtEmail())) {
			validaEmail();
		}
	}

	private void cancelaCadastro() {
		JOptionPane.showMessageDialog(null, "Fechando o Sistema!");
		ConexaoBD.closeconexao();
		INSERIR_CLIENTE.getFrame().setVisible(false);
	}

	private void validaCpfCliente() {

		if (INSERIR_CLIENTE.getTxtCPF().getText() == null || INSERIR_CLIENTE.getTxtCPF().getText().equals("")
				|| INSERIR_CLIENTE.getTxtCPF().getText().equals(" ")) {
			JOptionPane.showMessageDialog(new JFrame(), "Cliente n\u00e3o preenchido!");
			cpf = false;
		} else {
			cliente = persistCliente.buscarPorCodigo(INSERIR_CLIENTE.getTxtCPF().getText());
			if (cliente != null) {
				JOptionPane.showMessageDialog(new JFrame(), "Cliente j\u00e1 existente!");
				cliente = null;
				INSERIR_CLIENTE.getTxtCPF().setText("");
				cpf = false;
			} else {
				cpf = true;
			}
		}

	}

	private void validaNome() {
		if (INSERIR_CLIENTE.getTxtNome().getText() == null || INSERIR_CLIENTE.getTxtNome().getText().equals("")
				|| INSERIR_CLIENTE.getTxtNome().getText().equals(" ")) {
			JOptionPane.showMessageDialog(new JFrame(), "Nome n\u00e3o preenchido!");
			nome = false;
		} else {
			nome = true;

		}
	}

	private void validaRua() {
		if (INSERIR_CLIENTE.getTxtRua().getText() == null || INSERIR_CLIENTE.getTxtRua().getText().equals("")
				|| INSERIR_CLIENTE.getTxtRua().getText().equals(" ")) {
			JOptionPane.showMessageDialog(new JFrame(), "Rua n\u00e3o preenchida!");
			rua = false;

		} else {
			rua = true;
		}
	}

	private void validaBairro() {
		if (INSERIR_CLIENTE.getTextBairro().getText() == null || INSERIR_CLIENTE.getTextBairro().getText().equals("")
				|| INSERIR_CLIENTE.getTextBairro().getText().equals(" ")) {
			JOptionPane.showMessageDialog(new JFrame(), "Bairro n\u00e3o preenchido!");
			bairro = false;
		} else {
			bairro = true;

		}
	}

	private void validaNumero() {
		if (INSERIR_CLIENTE.getTextNumero().getText() == null || INSERIR_CLIENTE.getTextNumero().getText().equals("")
				|| INSERIR_CLIENTE.getTextNumero().getText().equals(" ")) {
			JOptionPane.showMessageDialog(new JFrame(), "N\u00famero n\u00e3o preenchido!");
			numero = false;

		} else {
			numero = true;

		}
	}

	private void validaCidade() {
		if (INSERIR_CLIENTE.getTxtCidade().getText() == null || INSERIR_CLIENTE.getTxtCidade().getText().equals("")
				|| INSERIR_CLIENTE.getTxtCidade().getText().equals(" ")) {
			JOptionPane.showMessageDialog(new JFrame(), "Cidade n\u00e3o preenchida!");
			cidade = false;
		} else {
			cidade = true;

		}
	}

	private void validaUF() {
		if (INSERIR_CLIENTE.getTxtUF().getText() == null || INSERIR_CLIENTE.getTxtUF().getText().equals("")
				|| INSERIR_CLIENTE.getTxtUF().getText().equals(" ")) {
			JOptionPane.showMessageDialog(new JFrame(), "Estado n\u00e3o preenchida!");
			estado = false;
		} else if (INSERIR_CLIENTE.getTxtUF().getText().length() >= 3) {
			JOptionPane.showMessageDialog(new JFrame(), "Sigla inv\u00e1lida!");
			INSERIR_CLIENTE.getTxtUF().setText("");
			estado = false;
		} else {
			estado = true;

		}
	}

	private void validaTelefone() {
		if (INSERIR_CLIENTE.getTxtTelefone().getText() == null || INSERIR_CLIENTE.getTxtTelefone().getText().equals("")
				|| INSERIR_CLIENTE.getTxtTelefone().getText().equals(" ")) {
			JOptionPane.showMessageDialog(new JFrame(), "Telefone n\u00e3o preenchido!");
			telefone = false;
		} else {
			telefone = true;

		}
	}

	private void validaEmail() {
		if (INSERIR_CLIENTE.getTxtEmail().getText() == null || INSERIR_CLIENTE.getTxtEmail().getText().equals("")
				|| INSERIR_CLIENTE.getTxtEmail().getText().equals(" ")) {
			JOptionPane.showMessageDialog(new JFrame(), "Email n\u00e3o preenchido!");
			email = false;
		} else if (!INSERIR_CLIENTE.getTxtEmail().getText().contains("@")) {
			email = false;
			JOptionPane.showMessageDialog(new JFrame(), "Email inv\u00e1lido!");

		} else {
			email = true;

		}

	}

	private void confirma() {
		int conf = JOptionPane.showConfirmDialog(null, "Deseja confirmar o cadastro", "Confirmar",
				JOptionPane.YES_NO_OPTION);
		if (conf == JOptionPane.YES_OPTION)
			cadastrarCliente();

	}

	private void cadastrarCliente() {
		if (cpf && nome && dataAtual && rua && bairro && numero && estado && cidade && telefone && email) {
			cliente = new Cliente();
			cliente.setCPF(INSERIR_CLIENTE.getTxtCPF().getText());
			cliente.setNome(INSERIR_CLIENTE.getTxtNome().getText());
			String endereco = INSERIR_CLIENTE.getTxtRua().getText() + "," + INSERIR_CLIENTE.getTextNumero().getText()
					+ " - " + INSERIR_CLIENTE.getTextBairro().getText();
			cliente.setEndereco(endereco);
			cliente.setCidade(INSERIR_CLIENTE.getTxtCidade().getText());
			cliente.setEstado(INSERIR_CLIENTE.getTxtUF().getText().toUpperCase());
			cliente.setTelefone(INSERIR_CLIENTE.getTxtTelefone().getText());
			cliente.setEmail(INSERIR_CLIENTE.getTxtEmail().getText());
			cliente.setData(INSERIR_CLIENTE.getDataAtual().getText());

			persistCliente.inserir(cliente);
		} else {
			JOptionPane.showMessageDialog(new JFrame(), "Os campos  n\u00e3o foram preenchidos corretamente.");
		}
	}

	private void limpaCampo() {
		INSERIR_CLIENTE.getTxtCPF().setText("");
		INSERIR_CLIENTE.getTxtNome().setText("");
		INSERIR_CLIENTE.getTxtRua().setText("");
		INSERIR_CLIENTE.getTextBairro().setText("");
		INSERIR_CLIENTE.getTxtCidade().setText("");
		INSERIR_CLIENTE.getTxtTelefone().setText("");
		INSERIR_CLIENTE.getTextNumero().setText("");
		INSERIR_CLIENTE.getTxtUF().setText("");
		INSERIR_CLIENTE.getTxtEmail().setText("");

		for (int i = 0; i < INSERIR_CLIENTE.getFrame().getComponentCount(); i++) {
			// varre todos os componentes do painel
			Component c = INSERIR_CLIENTE.getFrame().getComponent(i);

			if (c instanceof JTextField) {
				// apaga os valores das TextField
				JTextField field = (JTextField) c;
				field.setText("");
			}
		}
	}
}
