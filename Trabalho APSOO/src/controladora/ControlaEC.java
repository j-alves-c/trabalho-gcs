package controladora;

import dominio.Cliente;
import persistencia.ClienteDao;
import persistencia.ConexaoBD;
import persistencia.InterfaceDAO;
import telas.EditarCliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ControlaEC implements ActionListener, FocusListener {
	private final Connection CONEXAO;
	private static InterfaceDAO<Cliente, String> persistCliente = null;
	private static Cliente cliente;
	private boolean cpf = false, nome = false, endereco = false, cidade = false, estado = false, telefone = false,
			email = false;
	private final EditarCliente EDITAR_CLIENTE;

	public ControlaEC(EditarCliente EDITAR_CLIENTE) {
		this.EDITAR_CLIENTE = EDITAR_CLIENTE;
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

		EDITAR_CLIENTE.getDataAtual().setText(formatarDate.format(data));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(EDITAR_CLIENTE.getButtonSalvar())) {
			confirma();
		} else if (e.getSource().equals(EDITAR_CLIENTE.getButtonCancelar())) {
			cancelaEdicao();
		} else if (e.getSource().equals(EDITAR_CLIENTE.getButtonLimparCampos())) {
			limpaCampo();
		}

	}

	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource().equals(EDITAR_CLIENTE.getTxtCPF())) {
			JPopupMenu menu = new JPopupMenu();
			ArrayList<Cliente> clientes = persistCliente.listaTodos();
			for (Cliente cliente : clientes) {
				JMenuItem item = new JMenuItem();
				item.setText(cliente.getCPF());
				item.addActionListener(e1 -> {
					EDITAR_CLIENTE.getTxtCPF().setText(item.getText());
					menu.setVisible(false);
				});
				menu.add(item);

			}
			EDITAR_CLIENTE.getTxtCPF().setComponentPopupMenu(menu);
			menu.setLocation(EDITAR_CLIENTE.getTxtCPF().getX() + 90,
					EDITAR_CLIENTE.getTxtCPF().getY() + 6 * EDITAR_CLIENTE.getTxtCPF().getHeight());
			menu.setVisible(true);
		}

	}

	@Override
	public void focusLost(FocusEvent e) {
		// ValidaCpfCliente()
		if (e.getSource().equals(EDITAR_CLIENTE.getTxtCPF())) {
			validaCpfCliente();
			EDITAR_CLIENTE.getTxtCPF().getComponentPopupMenu().setVisible(false);
		} else if (e.getSource().equals(EDITAR_CLIENTE.getTxtNome())) {
			validaNome();

		} else if (e.getSource().equals(EDITAR_CLIENTE.getTxtEndereco())) {
			validaEndereco();

		} else if (e.getSource().equals(EDITAR_CLIENTE.getTxtCidade())) {
			validaCidade();

		} else if (e.getSource().equals(EDITAR_CLIENTE.getTxtMs())) {
			validaUF();
		} else if (e.getSource().equals(EDITAR_CLIENTE.getTxtTelefone())) {
			validaTelefone();
		} else if (e.getSource().equals(EDITAR_CLIENTE.getTxtEmail())) {
			validaEmail();
		}
	}

	private void cancelaEdicao() {
		JOptionPane.showMessageDialog(null, "Fechando o Sistema!");
		ConexaoBD.closeconexao();
		EDITAR_CLIENTE.getFrame().setVisible(false);
	}

	private void validaCpfCliente() {

		if (EDITAR_CLIENTE.getTxtCPF().getText() == null || EDITAR_CLIENTE.getTxtCPF().getText().equals("")
				|| EDITAR_CLIENTE.getTxtCPF().getText().equals(" ")) {
			JOptionPane.showMessageDialog(new JFrame(), "Cliente n\u00e3o preenchido!");
			cpf = false;
		} else {
			cliente = persistCliente.buscarPorCodigo(EDITAR_CLIENTE.getTxtCPF().getText());
			if (cliente == null) {
				JOptionPane.showMessageDialog(new JFrame(), "Cliente  n\u00e3o  existente!");
				EDITAR_CLIENTE.getTxtCPF().setText("");
				cpf = false;
			} else {
				EDITAR_CLIENTE.getTxtCPF().setText(cliente.getCPF());
				EDITAR_CLIENTE.getTxtNome().setText(cliente.getNome());
				EDITAR_CLIENTE.getTxtEmail().setText(cliente.getEmail());
				EDITAR_CLIENTE.getTxtEndereco().setText(cliente.getEndereco());
				EDITAR_CLIENTE.getTxtCidade().setText(cliente.getCidade());
				EDITAR_CLIENTE.getTxtMs().setText(cliente.getEstado());
				EDITAR_CLIENTE.getTxtTelefone().setText(cliente.getTelefone());
				cpf = true;
			}
		}

	}

	private void validaNome() {
		if (EDITAR_CLIENTE.getTxtNome().getText() == null || EDITAR_CLIENTE.getTxtNome().getText().equals("")
				|| EDITAR_CLIENTE.getTxtNome().getText().equals(" ")) {
			nome = false;
		} else {
			nome = true;

		}
	}

	private void validaEndereco() {
		if (EDITAR_CLIENTE.getTxtEndereco().getText() == null || EDITAR_CLIENTE.getTxtEndereco().getText().equals("")
				|| EDITAR_CLIENTE.getTxtEndereco().getText().equals(" ")) {
			endereco = false;
		} else {
			endereco = true;

		}
	}

	private void validaCidade() {
		if (EDITAR_CLIENTE.getTxtCidade().getText() == null || EDITAR_CLIENTE.getTxtCidade().getText().equals("")
				|| EDITAR_CLIENTE.getTxtCidade().getText().equals(" ")) {

			cidade = false;
		} else {
			cidade = true;

		}
	}

	private void validaUF() {
		if (EDITAR_CLIENTE.getTxtMs().getText() == null || EDITAR_CLIENTE.getTxtMs().getText().equals("")
				|| EDITAR_CLIENTE.getTxtMs().getText().equals(" ")) {
			estado = false;
		} else if (EDITAR_CLIENTE.getTxtMs().getText().length() >= 3) {
			EDITAR_CLIENTE.getTxtMs().setText("");
			estado = false;
		} else {
			estado = true;

		}
	}

	private void validaTelefone() {
		if (EDITAR_CLIENTE.getTxtTelefone().getText() == null || EDITAR_CLIENTE.getTxtTelefone().getText().equals("")
				|| EDITAR_CLIENTE.getTxtTelefone().getText().equals(" ")) {
			telefone = false;
		} else {
			telefone = true;

		}
	}

	private void validaEmail() {
		if (EDITAR_CLIENTE.getTxtEmail().getText() == null || EDITAR_CLIENTE.getTxtEmail().getText().equals("")
				|| EDITAR_CLIENTE.getTxtEmail().getText().equals(" ")) {
			email = false;
		} else if (!EDITAR_CLIENTE.getTxtEmail().getText().contains("@")) {
			email = false;
		} else {
			email = true;

		}

	}

	private void confirma() {
		int conf = JOptionPane.showConfirmDialog(null, "Deseja confirmar a atualiza\u00e7\u00e3o", "Confirmar",
				JOptionPane.YES_NO_OPTION);
		if (conf == JOptionPane.YES_OPTION)
			atualizarCliente();

	}

	private void limpaCampo() {
		cliente = null;
		cpf = false;
		nome = false;
		endereco = false;
		estado = false;
		cidade = false;
		telefone = false;
		email = false;
		EDITAR_CLIENTE.getTxtCPF().setText("");
		EDITAR_CLIENTE.getTxtNome().setText("");
		EDITAR_CLIENTE.getTxtEmail().setText("");
		EDITAR_CLIENTE.getTxtEndereco().setText("");
		EDITAR_CLIENTE.getTxtCidade().setText("");
		EDITAR_CLIENTE.getTxtMs().setText("");
		EDITAR_CLIENTE.getTxtTelefone().setText("");

	}

	private void atualizarCliente() {
		validaCidade();
		validaEmail();
		validaEndereco();
		validaNome();
		validaTelefone();
		validaUF();
		if (cpf && nome && endereco && estado && cidade && telefone && email) {
			cliente = new Cliente();
			cliente.setCPF(EDITAR_CLIENTE.getTxtCPF().getText());
			cliente.setNome(EDITAR_CLIENTE.getTxtNome().getText());
			cliente.setEndereco(EDITAR_CLIENTE.getTxtEndereco().getText());
			cliente.setCidade(EDITAR_CLIENTE.getTxtCidade().getText());
			cliente.setEstado(EDITAR_CLIENTE.getTxtMs().getText().toUpperCase());
			cliente.setTelefone(EDITAR_CLIENTE.getTxtTelefone().getText());
			cliente.setEmail(EDITAR_CLIENTE.getTxtEmail().getText());

			persistCliente.atualizar(cliente);
			limpaCampo();
		} else {
			JOptionPane.showMessageDialog(new JFrame(), "Os campos  n\u00e3o foram preenchidos corretamente.");
		}
	}
}