package controladora;

import dominio.*;
import persistencia.*;
import telas.EfetuarVenda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Objects;


public class ControlaEV implements ActionListener, FocusListener {
    private final Connection CONEXAO;
    private final EfetuarVenda EFETUAR_VENDA;
    private static Vendedor vendedor;
    private static Cliente cliente;
    private static InterfaceDAO<Sapato, Double> persistSapato = null;
    private static InterfaceDAO<ItemVenda, Integer> persistItem = null;
    private static InterfaceDAO<Venda, Integer> persistVenda = null;
    private static InterfaceDAO<Vendedor, String> persistVendedor = null;
    private static InterfaceDAO<Cliente, String> persistCliente = null;
    private static Venda venda;
    private static final ArrayList<ItemVenda> PRODUTOS = new ArrayList<>();

    private int posicao = 10;
    private double total = 0;


    public ControlaEV(EfetuarVenda EFETUAR_VENDA) {
        this.CONEXAO = ConexaoBD.conectar();

        this.EFETUAR_VENDA = EFETUAR_VENDA;
        // inicialização das classes Dao necessárias

        try {
            persistSapato = new SapatoDao(CONEXAO);
        } catch (Exception e) {

            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }


        try {
            persistVenda = new VendaDao(CONEXAO);
        } catch (Exception e) {

            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }


        try {
            persistVendedor = new VendedorDao(CONEXAO);
        } catch (Exception e) {

            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }


        try {
            persistCliente = new ClienteDao(CONEXAO);
        } catch (Exception e) {

            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        try {
            persistItem = new ItemVendadao(CONEXAO);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        // fim da inicialização das classes Dao necessárias

    }

    public void iniciaVenda() {
        // busca o código da última venda armazenada no banco e acresce de um para exibir o da venda nova que será armazenada

        assert persistVenda != null;
        int codigo = ((VendaDao) persistVenda).buscarCodigo() + 1;
        EFETUAR_VENDA.getCodigoVenda().setText("" + codigo);
        venda = new Venda();
        venda.setCodigo(Integer.parseInt(EFETUAR_VENDA.getCodigoVenda().getText()));

        //seta a data da venda para a data do dia atual.
        venda.setDatavenda(EFETUAR_VENDA.getDataAtual().getText());
    }

    public void atualizaData() {
        // criar uma variável Date para captar a data.
        Date data = new Date(System.currentTimeMillis());
        //formatar pra String
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy");
        // settar a data do dia no campo da data.
        EFETUAR_VENDA.getDataAtual().setText(formatarDate.format(data));

    }

    private void adicionaField() {
    	// adiciona os textfield extras + botões de remoção.
        posicao += 50;
        
        
        JTextField novoCampoM = new JTextField();
        if (EFETUAR_VENDA.getPainel().getBackground().equals(new Color(2,69,122))) {
        	novoCampoM.setBackground(Color.lightGray);
        	novoCampoM.setForeground(Color.black);
        }
        novoCampoM.setSize(120, 30);
        novoCampoM.setLocation(142, posicao);
        novoCampoM.setText("");
        EFETUAR_VENDA.getPainel().add(novoCampoM);
        novoCampoM.setVisible(true);
        novoCampoM.setHorizontalAlignment(SwingConstants.LEFT);
        novoCampoM.setFont(new Font("Tahoma", Font.PLAIN, 13));
        novoCampoM.setColumns(10);

        JTextField novoCampoC = new JTextField();
        if (EFETUAR_VENDA.getPainel().getBackground().equals(new Color(2,69,122))) {
        	novoCampoC.setBackground(Color.lightGray);
        	novoCampoC.setForeground(Color.black);
        }
        novoCampoC.setSize(120, 30);
        novoCampoC.setLocation(272, posicao);
        novoCampoC.setText("");
        novoCampoC.setVisible(true);
        novoCampoC.setHorizontalAlignment(SwingConstants.LEFT);
        novoCampoC.setFont(new Font("Tahoma", Font.PLAIN, 13));
        novoCampoC.setColumns(10);
        novoCampoC.setText("");
        novoCampoC.setVisible(true);
        EFETUAR_VENDA.getPainel().add(novoCampoC);


        JTextField novoCampoMD = new JTextField();
        if (EFETUAR_VENDA.getPainel().getBackground().equals(new Color(2,69,122))) {
        	novoCampoMD.setBackground(Color.lightGray);
        	novoCampoMD.setForeground(Color.black);
        }
        novoCampoMD.setSize(120, 30);
        novoCampoMD.setLocation(402, posicao);
        novoCampoMD.setText("");
        EFETUAR_VENDA.getPainel().add(novoCampoMD);
        novoCampoMD.setVisible(true);
        novoCampoMD.setHorizontalAlignment(SwingConstants.LEFT);
        novoCampoMD.setFont(new Font("Tahoma", Font.PLAIN, 13));
        novoCampoMD.setColumns(10);

        JTextField novoCampoT = new JTextField();
        if (EFETUAR_VENDA.getPainel().getBackground().equals(new Color(2,69,122))) {
        	novoCampoT.setBackground(Color.lightGray);
        	novoCampoT.setForeground(Color.black);
        }
        novoCampoT.setSize(120, 30);
        novoCampoT.setLocation(532, posicao);
        novoCampoT.setText("");
        EFETUAR_VENDA.getPainel().add(novoCampoT);
        novoCampoT.setVisible(true);
        novoCampoT.setHorizontalAlignment(SwingConstants.LEFT);
        novoCampoT.setFont(new Font("Tahoma", Font.PLAIN, 13));
        novoCampoT.setColumns(10);


        JTextField novoCampoTAM = new JTextField();
        if (EFETUAR_VENDA.getPainel().getBackground().equals(new Color(2,69,122))) {
        	novoCampoTAM.setBackground(Color.lightGray);
        	novoCampoTAM.setForeground(Color.black);
        }
        novoCampoTAM.setSize(50, 30);
        novoCampoTAM.setLocation(662, posicao);
        novoCampoTAM.setText("");
        EFETUAR_VENDA.getPainel().add(novoCampoTAM);
        novoCampoTAM.setVisible(true);
        novoCampoTAM.setFont(new Font("Tahoma", Font.PLAIN, 13));
        novoCampoTAM.setColumns(10);

        JTextField novoCampoValorUNIT = new JTextField();
        if (EFETUAR_VENDA.getPainel().getBackground().equals(new Color(2,69,122))) {
        	novoCampoValorUNIT.setBackground(Color.lightGray);
        	novoCampoValorUNIT.setForeground(Color.black);
        }
        novoCampoValorUNIT.setSize(90, 30);
        novoCampoValorUNIT.setLocation(722, posicao);
        novoCampoValorUNIT.setText("");
        EFETUAR_VENDA.getPainel().add(novoCampoValorUNIT);
        novoCampoValorUNIT.setVisible(true);
        novoCampoValorUNIT.setFont(new Font("Tahoma", Font.PLAIN, 13));
        novoCampoValorUNIT.setColumns(10);


        JTextField novoCampoCS = new JTextField();
        if (EFETUAR_VENDA.getPainel().getBackground().equals(new Color(2,69,122))) {
        	novoCampoCS.setBackground(Color.lightGray);
        	novoCampoCS.setForeground(Color.black);
        }
        novoCampoCS.setSize(120, 30);
        novoCampoCS.setLocation(12, posicao);
        novoCampoCS.setText("");
        novoCampoCS.setFont(new Font("Tahoma", Font.PLAIN, 13));
        novoCampoCS.setColumns(10);

        novoCampoCS.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                Sapato sapato = BuscarSap(novoCampoCS, novoCampoM, novoCampoC, novoCampoMD, novoCampoT, novoCampoTAM, novoCampoValorUNIT);
                if (sapato != null) {
                    adicionaItemVenda(sapato);
                }

            }
        });
        EFETUAR_VENDA.getPainel().add(novoCampoCS);
        novoCampoCS.setVisible(true);

        JButton novoRemover = new JButton("X");
        if (EFETUAR_VENDA.getPainel().getBackground().equals(new Color(2,69,122))) {
        	novoRemover.setBackground(new Color(231,231,231));
        }
        novoRemover.setLocation(820, posicao);
        novoRemover.setForeground(new Color(51,153,255));
        novoRemover.setSize(40, 30);
        novoRemover.setHorizontalAlignment(SwingConstants.LEFT);
        novoRemover.setFont(new Font("Tahoma", Font.PLAIN, 10));


        novoRemover.addActionListener(e -> {
            if (novoCampoCS.getText() == null || novoCampoCS.getText().equals(" ") || novoCampoCS.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "C\u00F3digo de barras n\u00e3o preenchido.");
            } else {
                ItemVenda itemErrado = compararPraRemover(Double.parseDouble(novoCampoCS.getText()));
                PRODUTOS.remove(itemErrado);
                JOptionPane.showMessageDialog(null, "Removido");
                total = total - Double.parseDouble(novoCampoValorUNIT.getText());
                EFETUAR_VENDA.getCampoTotal().setText(String.format("%.2f", total));
                JOptionPane.showMessageDialog(null, "Total atualizado: " + String.format("%.2f", total));
                novoCampoC.setText("");
                novoCampoM.setText("");
                novoCampoT.setText("");
                novoCampoValorUNIT.setText("");
                novoCampoMD.setText("");
                novoCampoTAM.setText("");
                novoCampoCS.setText("");
            }

        });
        EFETUAR_VENDA.getPainel().add(novoRemover);
        EFETUAR_VENDA.getAdicionarItem().setFont(new Font("Tahoma", Font.PLAIN, 15));
        //aparecer todos a cada adição.
        EFETUAR_VENDA.getPainel().repaint();
    }

    private void confirma() {
        int conf = JOptionPane.showConfirmDialog(null, "Deseja confirmar a venda", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (conf == JOptionPane.YES_OPTION)
            finalizarVenda();

    }

    private void limpaPainel() {
        EFETUAR_VENDA.getPainel().removeAll();
        EFETUAR_VENDA.getPainel().repaint();
        posicao = -40;
        adicionaField();


    }

    private void finalizarVenda() {
        if (vendedor != null && cliente != null && !PRODUTOS.isEmpty() && !Objects.requireNonNull(EFETUAR_VENDA.getEscolhePagamento().getSelectedItem()).toString().equals("Selecionar")) {
            venda.setProdutos(PRODUTOS);
            //insere a venda
            persistVenda.inserir(venda);
            //insere os item adicionados
            inserirItensAtuais(venda.getProdutos());
            //atualiza o total e sua exibição com o desconto
            total = total - total * (venda.getDesconto() / 100);
            //imprime um comprovante 'grosseiro' na tela.
            JOptionPane.showMessageDialog(null, " Venda efetuada com sucesso!!!" + "\n" + " Imprimindo o comprovante!!!"
                    + "\n" + persistVenda.buscarPorCodigo(venda.getCodigo()).toString() +
                    ", cpfCliente='" + venda.getCliente().getCPF() + '\'' +
                    ", cpfvendedor='" + venda.getVendedor().getCPF() + '\'' + "\n " + "Cliente " + venda.getCliente().getNome() + "\n " + "Vendedor "
                    + venda.getVendedor().getNome() + "\n" + "Total da venda:" + String.format("%.2f", total) + "\n" + imprimirItensAtuais(persistItem.listaTodos()));


            EFETUAR_VENDA.getCampoTotal().setText(String.format("%.2f", total));
            if (venda.getFormaPagamento().equals("Dinheiro")) {
                calculaTroco();
            }


            int codigo1 = ((VendaDao) persistVenda).buscarCodigo() + 1;
            EFETUAR_VENDA.getCodigoVenda().setText("" + codigo1);
            limpaCampo();
            PRODUTOS.removeAll(PRODUTOS);
            total = 0;
            EFETUAR_VENDA.getCampoTotal().setText(String.format("%2f", total));
            limpaPainel();

        } else {

            JOptionPane.showMessageDialog(null, "Algo est\u00e1 incorreto com o vendedor, cliente, pagamento ou n\u00e3o foi cadastrado nenhum item de venda.");
        }
    }

    private void cancelarVenda() {
        limpaCampo();
        JOptionPane.showMessageDialog(null, "Fechando o Sistema!");
        ConexaoBD.closeconexao();
        System.exit(0);


    }

    private void removerItem() {
        if (EFETUAR_VENDA.getCodigoSapato().getText() == null || EFETUAR_VENDA.getCodigoSapato().getText().equals(" ") || EFETUAR_VENDA.getCodigoSapato().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "C\u00F3digo de barras n\u00e3o preenchido.");
        } else {
            // busca qual é o item a se remover.
            ItemVenda itemErrado = compararPraRemover(Double.parseDouble(EFETUAR_VENDA.getCodigoSapato().getText()));
            if (itemErrado == null)
                JOptionPane.showMessageDialog(null, "N\u00e3o h\u00e1 esse item na venda ainda");
            else {
                PRODUTOS.remove(itemErrado);
                JOptionPane.showMessageDialog(null, "Removido");
                //atualiza o total e sua exibição
                total = total - Double.parseDouble(EFETUAR_VENDA.getCampoValorUni().getText());
                EFETUAR_VENDA.getCampoTotal().setText(String.format("%.2f", total));
                JOptionPane.showMessageDialog(null, "Total atualizado: " + String.format("%.2f", total));
                //apaga os campos do item removido.
                EFETUAR_VENDA.getCampoColecao().setText("");
                EFETUAR_VENDA.getCampoMarca().setText("");
                EFETUAR_VENDA.getCampoTam().setText("");
                EFETUAR_VENDA.getCampoValorUni().setText("");
                EFETUAR_VENDA.getCodigoSapato().setText("");
                EFETUAR_VENDA.getCampoTipo().setText("");
                EFETUAR_VENDA.getCampoModelo().setText("");
            }


        }

    }

    @Override
    public void actionPerformed(ActionEvent EventoBotao) {
        if (EventoBotao.getSource().equals(EFETUAR_VENDA.getCancelar())) {
            cancelarVenda();
        } else if (EventoBotao.getSource().equals(EFETUAR_VENDA.getConfirmar())) {
            confirma();


        } else if (EventoBotao.getSource().equals(EFETUAR_VENDA.getRemover())) {
            removerItem();


        } else if (EventoBotao.getSource().equals(EFETUAR_VENDA.getAdicionarItem())) {
            adicionaField();
            
        } else if (EventoBotao.getSource().equals(EFETUAR_VENDA.getMudarTema())){
            mudarTema();
        }

    }

    private void mudarTema() {
		// TODO Auto-generated method stub
    	if (!EFETUAR_VENDA.getFrame().getContentPane().getBackground().equals(new Color(27,27,27))) {
            EFETUAR_VENDA.getFrame().getContentPane().setBackground(new Color(27,27,27));
            for (int i = 0; i< EFETUAR_VENDA.getFrame().getContentPane().getComponentCount(); i++){
            	// botão
                if (EFETUAR_VENDA.getFrame().getContentPane().getComponent(i) instanceof JButton){
                    EFETUAR_VENDA.getFrame().getContentPane().getComponent(i).setBackground(new Color(55,0,179));
                    EFETUAR_VENDA.getFrame().getContentPane().getComponent(i).setForeground(Color.white);
                // insere valores
                }else if (EFETUAR_VENDA.getFrame().getContentPane().getComponent(i) instanceof JTextField){
                	EFETUAR_VENDA.getFrame().getContentPane().getComponent(i).setForeground(Color.black);
                    EFETUAR_VENDA.getFrame().getContentPane().getComponent(i).setBackground(Color.lightGray);
                //cor oficial
                }else if (EFETUAR_VENDA.getFrame().getContentPane().getComponent(i) instanceof JLabel && i==0){
                    EFETUAR_VENDA.getFrame().getContentPane().getComponent(i).setForeground(new Color(51,153,255));
                //letras
                }else if (EFETUAR_VENDA.getFrame().getContentPane().getComponent(i) instanceof JLabel && i!=0){
                    EFETUAR_VENDA.getFrame().getContentPane().getComponent(i).setForeground(Color.lightGray);
                }
                //forma de pagamento
                else if (EFETUAR_VENDA.getFrame().getContentPane().getComponent(i) instanceof JComboBox){
                    EFETUAR_VENDA.getFrame().getContentPane().getComponent(i).setBackground(Color.lightGray);
                    EFETUAR_VENDA.getFrame().getContentPane().getComponent(i).setForeground(Color.black);
                }

            }
            // adicionar itens
            EFETUAR_VENDA.getPainel().setBackground(new Color(2,69,122));
            for (int j=0;j< EFETUAR_VENDA.getPainel().getComponentCount();j++){
            	// botão de inserir produto
                if (EFETUAR_VENDA.getPainel().getComponent(j) instanceof JButton){
                    EFETUAR_VENDA.getPainel().getComponent(j).setBackground(new Color(231,231,231));
                // onde insere valores do produto
                }else if (EFETUAR_VENDA.getPainel().getComponent(j) instanceof JTextField){
                    EFETUAR_VENDA.getPainel().getComponent(j).setBackground(Color.lightGray);
                }


            }
            EFETUAR_VENDA.getPainel().repaint();

        }else {
        	EFETUAR_VENDA.getFrame().getContentPane().setBackground( new JFrame().getContentPane().getBackground() );
            for (int i = 0; i< EFETUAR_VENDA.getFrame().getContentPane().getComponentCount(); i++){
                if (EFETUAR_VENDA.getFrame().getContentPane().getComponent(i) instanceof JButton){
                    EFETUAR_VENDA.getFrame().getContentPane().getComponent(i).setBackground(new JButton().getBackground());
                    EFETUAR_VENDA.getFrame().getContentPane().getComponent(i).setForeground(new JButton().getForeground());
                }else if (EFETUAR_VENDA.getFrame().getContentPane().getComponent(i) instanceof JTextField){
                    EFETUAR_VENDA.getFrame().getContentPane().getComponent(i).setBackground(new JTextField().getBackground());
                }else if (EFETUAR_VENDA.getFrame().getContentPane().getComponent(i) instanceof JLabel && i !=0){
                    EFETUAR_VENDA.getFrame().getContentPane().getComponent(i).setForeground(
                            new JLabel().getForeground());
                }else if (EFETUAR_VENDA.getFrame().getContentPane().getComponent(i) instanceof JComboBox){
                    EFETUAR_VENDA.getFrame().getContentPane().getComponent(i).setBackground(new JComboBox().getBackground());
                    EFETUAR_VENDA.getFrame().getContentPane().getComponent(i).setForeground(new JComboBox().getForeground());
                }

            }
            EFETUAR_VENDA.getPainel().setBackground(SystemColor.activeCaption);
            for (int j=0;j< EFETUAR_VENDA.getPainel().getComponentCount();j++){
                if (EFETUAR_VENDA.getPainel().getComponent(j) instanceof JButton){
                    EFETUAR_VENDA.getPainel().getComponent(j).setBackground(new JButton().getBackground());
                }else if (EFETUAR_VENDA.getPainel().getComponent(j) instanceof JTextField){
                    EFETUAR_VENDA.getPainel().getComponent(j).setBackground(new JTextField().getBackground());
                }


            }
            EFETUAR_VENDA.getPainel().repaint();
        }     
	}
    
    private void validaCpfVendedor() {
        if (EFETUAR_VENDA.getCampoCpfVendedor().getText() == null || EFETUAR_VENDA.getCampoCpfVendedor().getText().equals("") || EFETUAR_VENDA.getCampoCpfVendedor().getText().equals(" ")) {
            JOptionPane.showMessageDialog(new JFrame(), " Vendedor n\u00e3o preenchido!");

        } else {
            //busca o vendedor no banco.
            vendedor = persistVendedor.buscarPorCodigo(EFETUAR_VENDA.getCampoCpfVendedor().getText());
            // checa se o vendedor existe antes de armazenar na variável venda.
            if (vendedor != null) {
                venda.setVendedor(vendedor);
                EFETUAR_VENDA.getCampoNomeVendedor().setText(vendedor.getNome());
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Vendedor inv\u00e1lido!");
            }
        }
    }

    private void validaNomeVendedor() {
        if (EFETUAR_VENDA.getCampoNomeVendedor().getText() == null || EFETUAR_VENDA.getCampoNomeVendedor().getText().equals("") || EFETUAR_VENDA.getCampoNomeVendedor().getText().equals(" ")) {
            JOptionPane.showMessageDialog(new JFrame(), " Vendedor n\u00e3o preenchido!");

        } else {
            //busca o vendedor no banco.
            vendedor = ((VendedorDao) persistVendedor).buscarPorNome(EFETUAR_VENDA.getCampoNomeVendedor().getText());
            // checa se o vendedor existe antes de armazenar na variável venda.
            if (vendedor != null) {
                venda.setVendedor(vendedor);
                EFETUAR_VENDA.getCampoCpfVendedor().setText(vendedor.getCPF());
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Vendedor inv\u00e1lido!");
            }
        }
    }

    private void validaCpfCliente() {
        if (EFETUAR_VENDA.getCampoCpfCliente().getText() == null || EFETUAR_VENDA.getCampoCpfCliente().getText().equals("") || EFETUAR_VENDA.getCampoCpfCliente().getText().equals(" ")) {
            JOptionPane.showMessageDialog(new JFrame(), "Cliente n\u00e3o preenchido!");

        } else {
            //busca o cliente no banco
            cliente = persistCliente.buscarPorCodigo(EFETUAR_VENDA.getCampoCpfCliente().getText());
            // checa se o cliente existe antes de armazenar na variável venda.
            if (cliente != null) {
                venda.setCliente(cliente);
                EFETUAR_VENDA.getCampoNomeCliente().setText(cliente.getNome());
            } else
                JOptionPane.showMessageDialog(new JFrame(), "Cliente n\u00e3o cadastrado!");
        }
    }

    private void validaNomeCliente() {
        if (EFETUAR_VENDA.getCampoNomeCliente().getText() == null || EFETUAR_VENDA.getCampoNomeCliente().getText().equals("") || EFETUAR_VENDA.getCampoNomeCliente().getText().equals(" ")) {
            JOptionPane.showMessageDialog(new JFrame(), "Cliente n\u00e3o preenchido!");

        } else {
            //busca o cliente no banco
            cliente = ((ClienteDao) persistCliente).buscarPorNome(EFETUAR_VENDA.getCampoNomeCliente().getText());
            // checa se o cliente existe antes de armazenar na variável venda.
            if (cliente != null) {
                venda.setCliente(cliente);
                EFETUAR_VENDA.getCampoCpfCliente().setText(cliente.getCPF());
            } else
                JOptionPane.showMessageDialog(new JFrame(), "Cliente n\u00e3o cadastrado!");
        }
    }

    private void validaDesconto() {
        // impede que o vendedor coloque primeiro o desconto e depois a forma de pagamento e dê mais desconto onde não pode.
        if (Objects.requireNonNull(EFETUAR_VENDA.getEscolhePagamento().getSelectedItem()).toString().equals("Selecionar")) {
            venda.setDesconto(0);
            EFETUAR_VENDA.getCampoDesconto().setText("0");
            JOptionPane.showMessageDialog(null, " Selecione o pagamento primeiro!");
        } else {
            if (Objects.requireNonNull(EFETUAR_VENDA.getEscolhePagamento().getSelectedItem()).toString().equals("Cr\u00E9dito")) {
                venda.setDesconto(0);
                EFETUAR_VENDA.getCampoDesconto().setText("0");
                JOptionPane.showMessageDialog(new JFrame(), "Desconto n\u00e3o dado em cr\u00E9dito");
            } else {
                // impede o não preenchimento do desconto.
                if (EFETUAR_VENDA.getCampoDesconto().getText() == null || EFETUAR_VENDA.getCampoDesconto().getText().equals(" ") || EFETUAR_VENDA.getCampoDesconto().getText().equals(""))
                    JOptionPane.showMessageDialog(new JFrame(), "Desconto n\u00e3o preenchido.");
                    //confere se é inteiro.
                else if (isInteger(EFETUAR_VENDA.getCampoDesconto().getText())) {
                    //impede o desconto em valor parcelado
                    if (Integer.parseInt(EFETUAR_VENDA.getCampoParcelas().getText()) == 1) {
                        // impede que o desconto seja negativo ou maior que 10 por cento.
                        if (Integer.parseInt(EFETUAR_VENDA.getCampoDesconto().getText()) < 0 || Integer.parseInt(EFETUAR_VENDA.getCampoDesconto().getText()) > 10) {
                            venda.setDesconto(0);
                            EFETUAR_VENDA.getCampoDesconto().setText("0");
                            JOptionPane.showMessageDialog(new JFrame(), "Desconto inv\u00e1lido!");
                        } else {
                            venda.setDesconto(Integer.parseInt(EFETUAR_VENDA.getCampoDesconto().getText()));
                            JOptionPane.showMessageDialog(new JFrame(), "Desconto registrado.");
                        }
                    } else {
                        venda.setDesconto(0);
                        EFETUAR_VENDA.getCampoDesconto().setText("0");
                        JOptionPane.showMessageDialog(new JFrame(), "N\u00e3o h\u00e1 desconto em valor parcelado.");
                    }
                }
                //impede que uma String ou outro tipo seja atribuído ao desconto que não seja inteiro.
                else {
                    venda.setDesconto(0);
                    JOptionPane.showMessageDialog(new JFrame(), "Desconto n\u00e3o \u00E9 valor inteiro.");

                }

            }

        }

    }

    private void validaFormaPag() {
        //impede que seja armazenado o valor "Selecionar" como forma de pagamento.
        if (Objects.requireNonNull(EFETUAR_VENDA.getEscolhePagamento().getSelectedItem()).toString().equals("Selecionar"))
            JOptionPane.showMessageDialog(null, "Forma de Pagamento n\u00e3o preenchida!");
        else
            venda.setFormaPagamento(EFETUAR_VENDA.getEscolhePagamento().getSelectedItem().toString());

    }

    private void validaParcelas() {
        //obriga selecionar o pagamento antes, evitar que parcele onde não pode.
        if (Objects.requireNonNull(EFETUAR_VENDA.getEscolhePagamento().getSelectedItem()).toString().equals("Selecionar")) {
            JOptionPane.showMessageDialog(new JFrame(), "Selecione o pagamento primeiro!");
            EFETUAR_VENDA.getCampoParcelas().setText("1");
        } else {
            //checa se é inteiro.
            if (isInteger(EFETUAR_VENDA.getCampoParcelas().getText())) {
                //impede o parcelamento em dinheiro ou débito.
                if (EFETUAR_VENDA.getEscolhePagamento().getSelectedItem().toString().equals("D\u00E9bito") || EFETUAR_VENDA.getEscolhePagamento().getSelectedItem().toString().equals("Dinheiro")) {
                    if (Integer.parseInt(EFETUAR_VENDA.getCampoParcelas().getText()) != 1) {
                        JOptionPane.showMessageDialog(null, "N\u00e3o se parcela em d\u00E9bito nem em dinheiro.");
                        EFETUAR_VENDA.getCampoParcelas().setText("1");
                    }
                }
                //opção do crédito
                else {
                    // define o à vista.
                    if (Integer.parseInt(EFETUAR_VENDA.getCampoParcelas().getText()) == 1) {
                        JOptionPane.showMessageDialog(null, "Venda  vai ser \u00e0 vista");
                        EFETUAR_VENDA.getCampoParcelas().setText("1");
                    }
                    //impede parcelas negativas, nenhuma parcela ou maiores que 6.
                    else if (Integer.parseInt(EFETUAR_VENDA.getCampoParcelas().getText()) < 1 || Integer.parseInt(EFETUAR_VENDA.getCampoParcelas().getText()) > 6) {
                        JOptionPane.showMessageDialog(null, "N\u00famero de parcelas inv\u00e1lido");
                        EFETUAR_VENDA.getCampoParcelas().setText("1");
                    }
                    //notifica inválido;
                    else {
                        EFETUAR_VENDA.getCampoDesconto().setText("0");
                        EFETUAR_VENDA.getCampoDesconto().setText("0");
                        venda.setDesconto(0);
                        JOptionPane.showMessageDialog(null, "N\u00famero de parcelas registrado.");
                    }
                }

            } else {
                // avisa que não esta preenchida.
                if (EFETUAR_VENDA.getCampoParcelas().getText() == null || EFETUAR_VENDA.getCampoParcelas().getText().equals(" ") || EFETUAR_VENDA.getCampoParcelas().getText().equals("")) {
                    JOptionPane.showMessageDialog(new JFrame(), "Parcelas n\u00e3o preenchidas.");
                }
                //não é valor inteiro;
                JOptionPane.showMessageDialog(new JFrame(), "N\u00famero de parcelas n\u00e3o \u00E9 inteiro.");
            }
        }
    }

    private Sapato BuscarSap(JTextField codigo, JTextField marca, JTextField colecao, JTextField modelo, JTextField tipo, JTextField tamanho, JTextField valor) {
        //checa se é vazio
        if (codigo.getText() == null || codigo.getText().equals(" ") || codigo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "C\u00F3digo de barras n\u00e3o preenchido.");
            return null;
        } else {
            //checa se é double (tipo do codigo de barras)
            if (isDouble(codigo.getText())) {
                //busca o sapato no banco e confere se existe.
                Sapato sapato = persistSapato.buscarPorCodigo(Double.parseDouble(codigo.getText()));
                if (sapato != null) {

                    //preenche os campos que descrevem o sapato
                    marca.setText(sapato.getMarca());
                    colecao.setText(sapato.getColecao());
                    modelo.setText(sapato.getModelo());
                    tipo.setText(sapato.getTipo());
                    tamanho.setText(String.valueOf(sapato.getNumero()));
                    valor.setText(String.valueOf(sapato.getPreco()));
                    return sapato;
                }
                // retorna que o código não é válido, ou seja, não há sapato cadastrado
                else {
                    JOptionPane.showMessageDialog(null, "c\u00F3digo de Barras Inv\u00e1lido ");
                    return null;
                }
            }
            //não é double;
            else {
                JOptionPane.showMessageDialog(null, "C\u00F3digo de barras n\u00e3o Double.");
                return null;
            }
        }
    }

    private void adicionaItemVenda(Sapato sapato) {
        // inicializa um item de venda pra guardá-lo
        ItemVenda item = new ItemVenda();
        //refere o sapato no item venda
        item.setSapato(sapato);
        //refere a venda no item venda
        item.setVenda(venda);
        //atualiza o total
        total = total + item.getValorUnitario();
        //atualiza a exibição do total
        EFETUAR_VENDA.getCampoTotal().setText(String.format("%.2f", total));
        //guarda item venda no vetor de produtos.
        PRODUTOS.add(item);
        JOptionPane.showMessageDialog(null, "" + total + " da compra at\u00E9 agora");

    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource().equals(EFETUAR_VENDA.getCampoCpfCliente())) {
            JPopupMenu menu = new JPopupMenu();
            ArrayList<Cliente> clientes = persistCliente.listaTodos();
            for (Cliente cliente : clientes) {
                JMenuItem item = new JMenuItem();
                item.setText(cliente.getCPF());
                item.addActionListener(e1 -> {
                    EFETUAR_VENDA.getCampoCpfCliente().setText(item.getText());
                    menu.setVisible(false);
                });
                menu.add(item);

            }
            EFETUAR_VENDA.getCampoCpfCliente().setComponentPopupMenu(menu);
            menu.setLocation(EFETUAR_VENDA.getCampoCpfCliente().getX() + 90, EFETUAR_VENDA.getCampoCpfCliente().getY() + 5 * EFETUAR_VENDA.getCampoCpfCliente().getHeight());
            menu.setVisible(true);


        } else if (e.getSource().equals(EFETUAR_VENDA.getCampoNomeVendedor())) {
            JPopupMenu menu = new JPopupMenu();
            ArrayList<Vendedor> vendedores = persistVendedor.listaTodos();
            for (Vendedor vendedor : vendedores) {
                JMenuItem jMenuItem = new JMenuItem();
                jMenuItem.setText(vendedor.getNome());
                jMenuItem.addActionListener(e12 -> {
                    EFETUAR_VENDA.getCampoNomeVendedor().setText(jMenuItem.getText());
                    menu.setVisible(false);
                });
                menu.add(jMenuItem);

            }
            EFETUAR_VENDA.getCampoNomeVendedor().setComponentPopupMenu(menu);
            menu.setLocation(EFETUAR_VENDA.getCampoNomeVendedor().getX() + 85, EFETUAR_VENDA.getCampoNomeVendedor().getY() + 5 * EFETUAR_VENDA.getCampoNomeVendedor().getHeight());
            menu.setVisible(true);


        } else if (e.getSource().equals(EFETUAR_VENDA.getCampoCpfVendedor())) {
            JPopupMenu menu = new JPopupMenu();
            ArrayList<Vendedor> vendedores = persistVendedor.listaTodos();
            for (Vendedor vendedor : vendedores) {
                JMenuItem item = new JMenuItem();
                item.setText(vendedor.getCPF());
                item.addActionListener(e13 -> {
                    EFETUAR_VENDA.getCampoCpfVendedor().setText(item.getText());
                    menu.setVisible(false);
                });
                menu.add(item);

            }
            EFETUAR_VENDA.getCampoCpfVendedor().setComponentPopupMenu(menu);
            menu.setLocation(EFETUAR_VENDA.getCampoCpfVendedor().getX() + 90, EFETUAR_VENDA.getCampoCpfVendedor().getY() + 5 * EFETUAR_VENDA.getCampoCpfVendedor().getHeight());
            menu.setVisible(true);


        } else if (e.getSource().equals(EFETUAR_VENDA.getCampoNomeCliente())) {
            JPopupMenu menu = new JPopupMenu();
            ArrayList<Cliente> clientes = persistCliente.listaTodos();
            for (Cliente cliente : clientes) {
                JMenuItem item = new JMenuItem();
                item.setText(cliente.getNome());
                item.addActionListener(e14 -> {
                    EFETUAR_VENDA.getCampoNomeCliente().setText(item.getText());
                    menu.setVisible(false);
                });
                menu.add(item);

            }
            EFETUAR_VENDA.getCampoNomeCliente().setComponentPopupMenu(menu);
            menu.setLocation(EFETUAR_VENDA.getCampoNomeCliente().getX() + 85, EFETUAR_VENDA.getCampoNomeCliente().getY() + 5 * EFETUAR_VENDA.getCampoNomeCliente().getHeight());
            menu.setVisible(true);


        }

    }

    @Override
    public void focusLost(FocusEvent e) {
        //ValidaFormaPagamento
        if (e.getSource().equals(EFETUAR_VENDA.getEscolhePagamento())) {
            validaFormaPag();

        }

        //BuscaSapato e AdicionaItemVenda
        else if (e.getSource().equals(EFETUAR_VENDA.getCodigoSapato())) {
            Sapato sapato = BuscarSap(EFETUAR_VENDA.getCodigoSapato(), EFETUAR_VENDA.getCampoMarca(), EFETUAR_VENDA.getCampoColecao(), EFETUAR_VENDA.getCampoModelo(), EFETUAR_VENDA.getCampoTipo(), EFETUAR_VENDA.getCampoTam(), EFETUAR_VENDA.getCampoValorUni());
            if (sapato != null) {
                adicionaItemVenda(sapato);
            }


        }

        //ValidaDesconto()

        else if (e.getSource().equals(EFETUAR_VENDA.getCampoDesconto())) {
            validaDesconto();
        }


        //Valida cpfVendedor
        else if (e.getSource().equals(EFETUAR_VENDA.getCampoCpfVendedor())) {
            validaCpfVendedor();
            EFETUAR_VENDA.getCampoCpfVendedor().getComponentPopupMenu().setVisible(false);

        }

        //ValidaCpfCliente()
        else if (e.getSource().equals(EFETUAR_VENDA.getCampoCpfCliente())) {
            validaCpfCliente();
            EFETUAR_VENDA.getCampoCpfCliente().getComponentPopupMenu().setVisible(false);
        } else if (e.getSource().equals(EFETUAR_VENDA.getCampoNomeCliente())) {
            validaNomeCliente();
            EFETUAR_VENDA.getCampoNomeCliente().getComponentPopupMenu().setVisible(false);
        } else if (e.getSource().equals(EFETUAR_VENDA.getCampoNomeVendedor())) {
            validaNomeVendedor();
            EFETUAR_VENDA.getCampoNomeVendedor().getComponentPopupMenu().setVisible(false);
        } else if (e.getSource().equals(EFETUAR_VENDA.getCampoParcelas())) {
            validaParcelas();
        }
    }

    //imprimir na tela os itens de venda atuais
    private static String imprimirItensAtuais(ArrayList<ItemVenda> lista) {
        String string = "";
        for (ItemVenda est : lista) {
            string += "C\u00f3digo do Item " + est.getCodigoItemVenda() + " C\u00f3digo de barras  " + String.format("%2f", est.getSapato().getCodigoDeBarras()) + "\n";

        }
        return string;
    }

    //inserir no banco todos os itens armazenados na programa.
    private static void inserirItensAtuais(ArrayList<ItemVenda> lista) {
        for (ItemVenda est : lista) {
            persistItem.inserir(est);
        }
    }

    //comparar os itens de venda já adicionados para remover o que foi erroneamente add.
    private static ItemVenda compararPraRemover(Double codigo) {
        ItemVenda errado = null;
        for (ItemVenda est : ControlaEV.PRODUTOS) {
            if (est.getSapato().getCodigoDeBarras() == codigo) {
                errado = est;

            }

        }
        return errado;
    }


    //checar se é valor inteiro.

    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }

        return true;
    }

    //checar se é valor double.
    private boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }

        return true;
    }

    private void limpaCampo() {
        EFETUAR_VENDA.getCampoCpfCliente().setText("");
        EFETUAR_VENDA.getCampoCpfVendedor().setText("");
        EFETUAR_VENDA.getCampoDesconto().setText("0");
        EFETUAR_VENDA.getCampoParcelas().setText("1");
        EFETUAR_VENDA.getCampoNomeVendedor().setText("");
        EFETUAR_VENDA.getCampoNomeCliente().setText("");
        for (int i = 0; i < EFETUAR_VENDA.getPainel().getComponentCount(); i++) {
            //varre todos os componentes do painel
            Component c = EFETUAR_VENDA.getPainel().getComponent(i);

            if (c instanceof JTextField) {
                //apaga os valores das TextField
                JTextField field = (JTextField) c;
                field.setText("");
            }
        }
    }

    private void calculaTroco() {

        double valorPago = Double.parseDouble(JOptionPane.showInputDialog(null, "Insira a quantia recebida"));
        double troco = valorPago - total;
        if (troco != 0) {
            JOptionPane.showMessageDialog(null, "O troco é " + String.format("%.2f", troco));
        }
    }


}
