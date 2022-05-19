package telas;

import javax.swing.*;
import java.awt.*;

public class Menu {
	public JMenuItem SubMenu1;
	public JMenuItem mntmNewMenuItem;
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
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{101, 0};
		gridBagLayout.rowHeights = new int[]{22, 34, 22, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JMenuBar menuBar_1 = new JMenuBar();
		frame.setJMenuBar(menuBar_1);
		//menu para a venda
		JMenu Menu = new JMenu("VENDA");
		menuBar_1.add(Menu);
		Menu.setHorizontalAlignment(SwingConstants.CENTER);
		Menu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		
		 SubMenu1 = new JMenuItem("Nova Venda");
		Menu.add(SubMenu1);
		SubMenu1.addActionListener(e -> EventQueue.invokeLater(() -> {
			try {
				EfetuarVenda window = new EfetuarVenda();
				window.getFrame().setVisible(true);


			} catch (Exception f) {
				f.printStackTrace();
			}

		}));

		//menu para a devolução
		JMenu mnNewMenu = new JMenu("DEVOLU\u00c7\u00c3O");
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar_1.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Nova Devolu\u00e7\u00e3o");
		mnNewMenu.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(f -> EventQueue.invokeLater(() -> {
			try {
				EfetuarDevolucao window = new EfetuarDevolucao();
				window.getFrame().setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}));
		//menu para a troca
		JMenu mnNewMenu_1 = new JMenu("TROCA");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnNewMenu_1.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar_1.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Nova Troca");
		mnNewMenu_1.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(e -> EventQueue.invokeLater(() -> {
			try {
				JOptionPane.showMessageDialog(null,"Funcionalidade ainda n\u00e3o implementada!");


			} catch (Exception f) {
				f.printStackTrace();
			}
		}));
		
	}
}
