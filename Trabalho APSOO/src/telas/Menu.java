package telas;

import javax.swing.*;
import java.awt.*;

public class Menu {
	public JMenuItem novaVenda;
	public JMenuItem novaDevolucao;
	public JMenuItem novaTroca;
	public JMenuItem novoCliente;
	public JMenuItem editarCliente;
	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Menu window = new Menu();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 930, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar barraDeMenu = new JMenuBar();
		frame.setJMenuBar(barraDeMenu);

		// menu para a venda
		JMenu menuVenda = new JMenu("VENDA");
		barraDeMenu.add(menuVenda);
		menuVenda.setHorizontalAlignment(SwingConstants.CENTER);
		menuVenda.setFont(new Font("Segoe UI", Font.PLAIN, 18));

		novaVenda = new JMenuItem("Nova Venda");
		menuVenda.add(novaVenda);
		novaVenda.addActionListener(e -> EventQueue.invokeLater(() -> {
			try {
				EfetuarVenda efetuarVenda = new EfetuarVenda();
				efetuarVenda.getFrame().setVisible(true);

			} catch (Exception f) {
				f.printStackTrace();
			}

		}));

		// menu para a devolu��o
		JMenu menuDevolucao = new JMenu("DEVOLU\u00c7\u00c3O");
		menuDevolucao.setHorizontalAlignment(SwingConstants.CENTER);
		menuDevolucao.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		barraDeMenu.add(menuDevolucao);

		novaDevolucao = new JMenuItem("Nova Devolu\u00e7\u00e3o");
		menuDevolucao.add(novaDevolucao);
		novaDevolucao.addActionListener(f -> EventQueue.invokeLater(() -> {
			try {
				EfetuarDevolucao efetuarDevolucao = new EfetuarDevolucao();
				efetuarDevolucao.getFrame().setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}));

		// menu para a troca
		JMenu menuTroca = new JMenu("TROCA");
		menuTroca.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuTroca.setHorizontalAlignment(SwingConstants.CENTER);
		barraDeMenu.add(menuTroca);

		novaTroca = new JMenuItem("Nova Troca");
		menuTroca.add(novaTroca);
		novaTroca.addActionListener(e -> EventQueue.invokeLater(() -> {
			try {
				JOptionPane.showMessageDialog(null, "Funcionalidade ainda n\u00e3o implementada!");

			} catch (Exception f) {
				f.printStackTrace();
			}
		}));

		// menu para o cliente
		JMenu menuCliente = new JMenu("CLIENTE");
		menuCliente.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuCliente.setHorizontalAlignment(SwingConstants.CENTER);
		barraDeMenu.add(menuCliente);

		novoCliente = new JMenuItem("Inserir Cliente");
		menuCliente.add(novoCliente);
		novoCliente.addActionListener(e -> EventQueue.invokeLater(() -> {
			try {
				InserirCliente inserirCliente = new InserirCliente();
				inserirCliente.getFrame().setVisible(true);

				// JPANELInserirCliente inserirCliente = new JPANELInserirCliente();
				// frame.add(inserirCliente);
				
				// Tornar o frame Menu invisível
				// frame.setVisible(false);
			} catch (Exception g) {
				g.printStackTrace();
			}

		}));
		
		editarCliente = new JMenuItem("Editar Cliente");
		menuCliente.add(editarCliente);
		editarCliente.addActionListener(e -> EventQueue.invokeLater(() -> {
			try {
				EditarCliente editarCliente = new EditarCliente();
				editarCliente.getFrame().setVisible(true);
				
				// JPANELInserirCliente inserirCliente = new JPANELInserirCliente();
				// frame.add(inserirCliente);
				
				// Tornar o frame Menu invisível
				// frame.setVisible(false);
			} catch (Exception g) {
				g.printStackTrace();
			}

		}));
	}
}
