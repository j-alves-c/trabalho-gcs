package controladora;

import dominio.*;
import persistencia.*;
import telas.EfetuarDevolucao;

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


public class ControlaED implements ActionListener, FocusListener {
    private static final ArrayList<ItemDevolucao> PRODUTOS = new ArrayList<>();
    private static Vendedor vendedor;
    private static Cliente cliente;
    private static InterfaceDAO<Sapato, Double> persistSapato = null;
    private static InterfaceDAO<ItemDevolucao, Integer> persistItem = null;
    private static InterfaceDAO<ItemVenda, Integer> persistVendidos = null;
    private static InterfaceDAO<Venda, Integer> persistVenda = null;
    private static InterfaceDAO<Devolucao, Integer> persistDevolucao = null;
    private static InterfaceDAO<Vendedor, String> persistVendedor = null;
    private static InterfaceDAO<Cliente, String> persistCliente = null;
    private static Venda venda;
    private static Devolucao devolucao;
    private final Connection CONEXAO;
    private final EfetuarDevolucao EFETUAR_DEVOLUCAO;
    private int posicao = -50;
    private double total = 0;

    public ControlaED(EfetuarDevolucao EFETUAR_DEVOLUCAO) {
        CONEXAO = ConexaoBD.conectar();
        this.EFETUAR_DEVOLUCAO = EFETUAR_DEVOLUCAO;
        try {
            persistSapato = new SapatoDao(CONEXAO);
        } catch (Exception e) {

            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        try {
            persistVendidos = new ItemVendadao(CONEXAO);
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
            persistDevolucao = new DevolucaoDao(CONEXAO);
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
            persistItem = new ItemDevolucaoDao(CONEXAO);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        // fim da inicialização das classes Dao necess\u00e1rias

    }

    private static void inserirItensAtuais(ArrayList<ItemDevolucao> lista) {
        for (ItemDevolucao est : lista) {
            persistItem.inserir(est);
        }
    }

    private static String imprimirItensAtuais(ArrayList<ItemDevolucao> lista) {
        String string = "";
        for (ItemDevolucao est : lista) {
            string += "C\u00f3digo do Item " + est.getCodigoItemDevolucao() + " C\u00f3digo de barras  " + String.format("%2f", est.getSapato().getCodigoDeBarras()) + "\n";
        }
        return string;
    }

    public void atualizaData() {
        // criar uma vari\u00e1vel Date para captar a data.
        Date data = new Date(System.currentTimeMillis());
        //formatar pra String
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy");
        // settar a data do dia no campo da data.
        EFETUAR_DEVOLUCAO.getCampoDataDevolucao().setText(formatarDate.format(data));
    }

    public void comecaDevolucao() {
        // busca o código da última devolucao armazenada no banco e acresce de um para exibir o da devolucao nova que ser\u00e1 armazenada

        assert persistDevolucao != null;
        int codigo = ((DevolucaoDao) persistDevolucao).buscarCodigo() + 1;
        EFETUAR_DEVOLUCAO.getCampoCodigoDevolucao().setText("" + codigo);
        devolucao = new Devolucao();
        devolucao.setCodigoDaDevolucao(Integer.parseInt(EFETUAR_DEVOLUCAO.getCampoCodigoDevolucao().getText()));
        //seta a data da venda para a data do dia atual.
        devolucao.setDataDevolucao(EFETUAR_DEVOLUCAO.getCampoDataDevolucao().getText());
    }

    @Override
    public void actionPerformed(ActionEvent EventoBotao) {
        if (EventoBotao.getSource().equals(EFETUAR_DEVOLUCAO.getCancelar())) {
            cancelarDevolucao();
        } else if (EventoBotao.getSource().equals(EFETUAR_DEVOLUCAO.getConfirmar())) {
            confirma();


        }

    }

    private void confirma() {
        int conf = JOptionPane.showConfirmDialog(null, "Deseja confirmar a devolu\u00e7\u00e3o", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (conf == JOptionPane.YES_OPTION)
            finalizarDevolucao();

    }

    private void finalizarDevolucao() {
        if (vendedor != null && cliente != null && !PRODUTOS.isEmpty() && venda != null) {
            devolucao.setProdutos(PRODUTOS);
            persistDevolucao.inserir(devolucao);
            inserirItensAtuais(devolucao.getProdutos());
            JOptionPane.showMessageDialog(null, " Devolu\u00e7\u00e3o efetuada com sucesso!!!" + "\n"
                    + "\n" + persistDevolucao.buscarPorCodigo(devolucao.getCodigoDaDevolucao()).toString() + ", C\u00F3digoVenda=" + venda.getCodigo() + "\n " + "Cliente " + cliente.getNome() + "\n " + "Vendedor " + vendedor.getNome() + "\n" + "Total devolvido:" + String.format("%.2f", total) + "\n" + imprimirItensAtuais(persistItem.listaTodos()));

            int codigo1 = ((DevolucaoDao) persistDevolucao).buscarCodigo() + 1;
            EFETUAR_DEVOLUCAO.getCampoCodigoDevolucao().setText("" + codigo1);
            limpaCampo();
            atualizaInfo();
        } else {

            JOptionPane.showMessageDialog(null, "Algo est\u00e1 incorreto com o vendedor, cliente, venda ou n\u00e3o foi cadastrado nenhum item para devolu\u00e7\u00e3o.");
        }


    }

    private void cancelarDevolucao() {
        limpaCampo();
        PRODUTOS.removeAll(PRODUTOS);
        JOptionPane.showMessageDialog(null, "Fechando o Sistema!");
        ConexaoBD.closeconexao();

        System.exit(0);

    }

    private void limpaCampo() {
        EFETUAR_DEVOLUCAO.getCampoCpfVendedor().setText("");
        EFETUAR_DEVOLUCAO.getCampoCodigoVenda().setText("");
        EFETUAR_DEVOLUCAO.getCampoCpfCliente().setText("");
        EFETUAR_DEVOLUCAO.getCampoDataVenda().setText("");
        EFETUAR_DEVOLUCAO.getCampoNomeCliente().setText("");
        EFETUAR_DEVOLUCAO.getCampoNomeVendedor().setText("");
        EFETUAR_DEVOLUCAO.getCampoValor().setText("0,00");
        for (int i = 0; i < EFETUAR_DEVOLUCAO.getPainel().getComponentCount(); i++) {
            //varre todos os componentes do painel
            Component c = EFETUAR_DEVOLUCAO.getPainel().getComponent(i);

            if (c instanceof JTextField) {
                //apaga os valores das TextField
                JTextField field = (JTextField) c;
                field.setText("");
            }
        }


    }

    private void validaCpf() {
        if (EFETUAR_DEVOLUCAO.getCampoCpfVendedor().getText() == null || EFETUAR_DEVOLUCAO.getCampoCpfVendedor().getText().equals("") || EFETUAR_DEVOLUCAO.getCampoCpfVendedor().getText().equals(" ")) {
            JOptionPane.showMessageDialog(new JFrame(), " Vendedor n\u00e3o preenchido!");

        } else {
            //busca o vendedor no banco.
            vendedor = persistVendedor.buscarPorCodigo(EFETUAR_DEVOLUCAO.getCampoCpfVendedor().getText());
            // checa se o vendedor existe antes de armazenar na vari\u00e1vel venda.
            if (vendedor != null) {
                EFETUAR_DEVOLUCAO.getCampoNomeVendedor().setText(vendedor.getNome());

            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Vendedor inv\u00e1lido!");
            }
        }
    }

    private void validaNome() {
        if (EFETUAR_DEVOLUCAO.getCampoNomeVendedor().getText() == null || EFETUAR_DEVOLUCAO.getCampoNomeVendedor().getText().equals("") || EFETUAR_DEVOLUCAO.getCampoNomeVendedor().getText().equals(" ")) {
            JOptionPane.showMessageDialog(new JFrame(), " Vendedor n\u00e3o preenchido!");

        } else {
            //busca o vendedor no banco.
            vendedor = ((VendedorDao) persistVendedor).buscarPorNome(EFETUAR_DEVOLUCAO.getCampoNomeVendedor().getText());
            // checa se o vendedor existe antes de armazenar na vari\u00e1vel venda.
            if (vendedor != null) {
                EFETUAR_DEVOLUCAO.getCampoCpfVendedor().setText(vendedor.getCPF());

            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Vendedor inv\u00e1lido!");
            }
        }
    }

    private void validaCodigo() {
        if (EFETUAR_DEVOLUCAO.getCampoCodigoVenda().getText() == null || EFETUAR_DEVOLUCAO.getCampoCodigoVenda().getText().equals("") || EFETUAR_DEVOLUCAO.getCampoCodigoVenda().getText().equals(" ")) {
            JOptionPane.showMessageDialog(new JFrame(), "C\u00f3digo da venda n\u00e3o preenchido!");

        } else if (isInteger(EFETUAR_DEVOLUCAO.getCampoCodigoVenda().getText())) {
            adicionaVenda(Integer.parseInt(EFETUAR_DEVOLUCAO.getCampoCodigoVenda().getText()));


        }
        //impede que uma String ou outro tipo seja atribuído ao desconto que não seja inteiro.
        else {

            JOptionPane.showMessageDialog(new JFrame(), "C\u00f3digo n\u00e3o \u00E9 valor inteiro.");

        }
    }

    private boolean comparaData() {
        int anoDev = Integer.parseInt(EFETUAR_DEVOLUCAO.getCampoDataDevolucao().getText().substring(6, 10));

        int anoVenda = Integer.parseInt(EFETUAR_DEVOLUCAO.getCampoDataVenda().getText().substring(6, 10));
        boolean data = true;
        boolean confirmaData = true;
        while (data && confirmaData) {
            if (anoDev != anoVenda) {
                data = false;

            } else {

                int mesDev;
                try {
                    mesDev = Integer.parseInt(EFETUAR_DEVOLUCAO.getCampoDataDevolucao().getText().substring(3, 5));
                } catch (StringIndexOutOfBoundsException e) {
                    mesDev = Integer.parseInt(EFETUAR_DEVOLUCAO.getCampoDataDevolucao().getText().substring(3, 5));
                }

                int mesVenda;
                try {
                    mesVenda = Integer.parseInt(EFETUAR_DEVOLUCAO.getCampoDataVenda().getText().substring(3, 5));
                } catch (StringIndexOutOfBoundsException e) {
                    mesVenda = Integer.parseInt(EFETUAR_DEVOLUCAO.getCampoDataVenda().getText().substring(3, 5));
                }

                if (mesDev != mesVenda) {
                    data = false;
                } else {
                    int diaDev = Integer.parseInt(EFETUAR_DEVOLUCAO.getCampoDataDevolucao().getText().substring(0, 2));

                    int diaVenda = Integer.parseInt(EFETUAR_DEVOLUCAO.getCampoDataVenda().getText().substring(0, 2));

                    if (diaDev - diaVenda > 3) {
                        data = false;
                    } else {
                        data = true;
                        confirmaData = false;
                    }
                }

            }
        }
        return data;
    }

    private void limpaPainel() {
        EFETUAR_DEVOLUCAO.getPainel().removeAll();
        EFETUAR_DEVOLUCAO.getPainel().repaint();
        posicao = -50;
    }

    private void limpaCampoVenda() {
        EFETUAR_DEVOLUCAO.getCampoCodigoVenda().setText("");
        EFETUAR_DEVOLUCAO.getCampoCpfCliente().setText("");
        EFETUAR_DEVOLUCAO.getCampoDataVenda().setText("");
        EFETUAR_DEVOLUCAO.getCampoNomeCliente().setText("");
        atualizaInfo();
    }

    private void atualizaInfo() {
        if (PRODUTOS != null) {
            PRODUTOS.removeAll(PRODUTOS);
            limpaPainel();
            total = 0;
            //atualiza a exibição do total
            EFETUAR_DEVOLUCAO.getCampoValor().setText(String.format("%.2f", total));
        } else {
            limpaPainel();
        }
    }

    private void adicionaVenda(int codigo) {
        if (venda != null)
            atualizaInfo();


        venda = persistVenda.buscarPorCodigo(codigo);
        if (venda != null) {
            cliente = persistCliente.buscarPorCodigo(venda.getCliente().getCPF());
            EFETUAR_DEVOLUCAO.getCampoCpfCliente().setText(venda.getCliente().getCPF());
            EFETUAR_DEVOLUCAO.getCampoNomeCliente().setText(cliente.getNome());

            EFETUAR_DEVOLUCAO.getCampoDataVenda().setText((venda.getDatavenda()));
            boolean validade = comparaData();

            if (validade) {
                devolucao.setVenda(venda);
                ArrayList<ItemVenda> vendidos = ((ItemVendadao) persistVendidos).listaTodosDeVenda(venda.getCodigo());
                for (ItemVenda est : vendidos) {
                    adicionaField(est.getSapato().getCodigoDeBarras());
                }
            } else {
                JOptionPane.showMessageDialog(null, " Tempo de devolu\u00e7\u00e3o excedido!");
                limpaCampoVenda();


            }


        } else {
            JOptionPane.showMessageDialog(new JFrame(), "C\u00f3digo inv\u00e1lido!");
            limpaCampoVenda();
        }


    }
    //checar se é valor inteiro.

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource().equals(EFETUAR_DEVOLUCAO.getCampoNomeVendedor())) {
            JPopupMenu menu = new JPopupMenu();
            ArrayList<Vendedor> vendedores = persistVendedor.listaTodos();
            for (Vendedor vendedor : vendedores) {
                JMenuItem item = new JMenuItem();
                item.setText(vendedor.getNome());
                item.addActionListener(e1 -> {
                    EFETUAR_DEVOLUCAO.getCampoNomeVendedor().setText(item.getText());
                    menu.setVisible(false);
                });
                menu.add(item);

            }
            EFETUAR_DEVOLUCAO.getCampoNomeVendedor().setComponentPopupMenu(menu);
            menu.setLocation(EFETUAR_DEVOLUCAO.getCampoNomeVendedor().getX() + 85,
                    EFETUAR_DEVOLUCAO.getCampoNomeVendedor().getY() + 5 * EFETUAR_DEVOLUCAO.getCampoNomeVendedor().getHeight());
            menu.setVisible(true);


        } else if (e.getSource().equals(EFETUAR_DEVOLUCAO.getCampoCpfVendedor())) {
            JPopupMenu menu = new JPopupMenu();
            ArrayList<Vendedor> vendedores = persistVendedor.listaTodos();
            for (Vendedor vendedor : vendedores) {
                JMenuItem jMenuItem = new JMenuItem();
                jMenuItem.setText(vendedor.getCPF());
                jMenuItem.addActionListener(e12 -> {
                    EFETUAR_DEVOLUCAO.getCampoCpfVendedor().setText(jMenuItem.getText());
                    menu.setVisible(false);
                });
                menu.add(jMenuItem);

            }
            EFETUAR_DEVOLUCAO.getCampoCpfVendedor().setComponentPopupMenu(menu);
            menu.setLocation(EFETUAR_DEVOLUCAO.getCampoCpfVendedor().getX() + 90,
                    EFETUAR_DEVOLUCAO.getCampoCpfVendedor().getY() + 5 * EFETUAR_DEVOLUCAO.getCampoCpfVendedor().getHeight());
            menu.setVisible(true);


        }
    }

    @Override
    public void focusLost(FocusEvent EventoCampo) {
        if (EventoCampo.getSource().equals(EFETUAR_DEVOLUCAO.getCampoCpfVendedor())) {
            validaCpf();
            EFETUAR_DEVOLUCAO.getCampoCpfVendedor().getComponentPopupMenu().setVisible(false);
        }
        //Valida cpfVendedor
        else if (EventoCampo.getSource().equals(EFETUAR_DEVOLUCAO.getCampoNomeVendedor())) {
            validaNome();
            EFETUAR_DEVOLUCAO.getCampoNomeVendedor().getComponentPopupMenu().setVisible(false);
        } else if (EventoCampo.getSource().equals(EFETUAR_DEVOLUCAO.getCampoCodigoVenda())) {
            validaCodigo();


        }
    }

    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }

        return true;
    }

    private Sapato BuscarSap(double codigo, JTextField marca, JTextField colecao, JTextField modelo, JTextField tipo, JTextField tamanho, JTextField valor) {

        Sapato sapato = persistSapato.buscarPorCodigo(codigo);
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
        // retorna que o código não é v\u00e1lido, ou seja, não h\u00e1 sapato cadastrado
        else {
            JOptionPane.showMessageDialog(null, "c\u00F3digo de Barras Inv\u00e1lido ");
            return null;
        }
    }

    private boolean checaItem(int codigo, double cod) {
        ItemDevolucao item = ((ItemDevolucaoDao) persistItem).checaChave(codigo, cod);
        return item != null;
    }

    private void adicionaItemDevolucao(Sapato sapato, boolean existente) {
        if (!existente) {
            // inicializa um item de venda pra guard\u00e1-lo
            ItemDevolucao item = new ItemDevolucao();
            //refere o sapato no item venda
            item.setSapato(sapato);
            //refere a venda no item venda
            item.setDevolucao(devolucao);
            //atualiza o total
            total = total + item.getValorUnitario();
            //atualiza a exibição do total
            EFETUAR_DEVOLUCAO.getCampoValor().setText(String.format("%.2f", total));
            //guarda item venda no vetor de produtos.
            PRODUTOS.add(item);
            JOptionPane.showMessageDialog(null, "" + total + " a ser devolvido at\u00E9 agora");

        } else if (existente) {
            JOptionPane.showMessageDialog(null, "Esse item j\u00e1 foi devolvido em outra devolu\u00e7\u00e3o");
        }


    }

    private void adicionaField(double codigo) {

        // adiciona os textfield extras + botões de seleção.
        posicao += 50;
        JTextField novoCampoM = new JTextField();

        novoCampoM.setSize(120, 30);
        novoCampoM.setLocation(142, posicao);
        novoCampoM.setText("");
        EFETUAR_DEVOLUCAO.getPainel().add(novoCampoM);
        novoCampoM.setVisible(true);


        JTextField novoCampoC = new JTextField();

        novoCampoC.setSize(120, 30);
        novoCampoC.setLocation(272, posicao);
        novoCampoC.setText("");
        EFETUAR_DEVOLUCAO.getPainel().add(novoCampoC);
        novoCampoC.setVisible(true);

        JTextField novoCampoMD = new JTextField();

        novoCampoMD.setSize(120, 30);
        novoCampoMD.setLocation(402, posicao);
        novoCampoMD.setText("");
        EFETUAR_DEVOLUCAO.getPainel().add(novoCampoMD);
        novoCampoMD.setVisible(true);

        JTextField novoCampoT = new JTextField();

        novoCampoT.setSize(120, 30);
        novoCampoT.setLocation(532, posicao);
        novoCampoT.setText("");
        EFETUAR_DEVOLUCAO.getPainel().add(novoCampoT);
        novoCampoT.setVisible(true);

        JTextField novoCampoTAM = new JTextField();

        novoCampoTAM.setSize(50, 30);
        novoCampoTAM.setLocation(662, posicao);
        novoCampoTAM.setText("");
        EFETUAR_DEVOLUCAO.getPainel().add(novoCampoTAM);
        novoCampoTAM.setVisible(true);

        JTextField novoCampoValorUNIT = new JTextField();

        novoCampoValorUNIT.setSize(90, 30);
        novoCampoValorUNIT.setLocation(722, posicao);
        novoCampoValorUNIT.setText("");
        EFETUAR_DEVOLUCAO.getPainel().add(novoCampoValorUNIT);
        novoCampoValorUNIT.setVisible(true);


        JTextField novoCampoCS = new JTextField();

        novoCampoCS.setSize(120, 30);
        novoCampoCS.setLocation(12, posicao);
        novoCampoCS.setText("");

        novoCampoCS.setText(String.format("%.2f", codigo));
        Sapato sapato = BuscarSap(codigo, novoCampoM, novoCampoC, novoCampoMD, novoCampoT, novoCampoTAM, novoCampoValorUNIT);
        EFETUAR_DEVOLUCAO.getPainel().add(novoCampoCS);
        novoCampoCS.setVisible(true);


        JButton selecionaPDevolver = new JButton("o");
        selecionaPDevolver.setHorizontalAlignment(SwingConstants.LEFT);
        selecionaPDevolver.setFont(new Font("Tahoma", Font.PLAIN, 12));
        selecionaPDevolver.setLocation(820, posicao);
        selecionaPDevolver.setForeground(Color.MAGENTA);
        selecionaPDevolver.setSize(40, 30);


        selecionaPDevolver.addActionListener(e -> {
            if (novoCampoM.getForeground().equals(Color.RED)) {
                JOptionPane.showMessageDialog(null, "Sapato j\u00e1 foi selecionado.");
            } else {
                assert sapato != null;
                boolean existente = checaItem(venda.getCodigo(), sapato.getCodigoDeBarras());

                adicionaItemDevolucao(selecionarPDevolver(sapato.getCodigoDeBarras()), existente);

                if (!existente) {
                    novoCampoM.setForeground(Color.RED);
                    novoCampoC.setForeground(Color.RED);
                    novoCampoT.setForeground(Color.RED);
                    novoCampoTAM.setForeground(Color.RED);
                    novoCampoValorUNIT.setForeground(Color.RED);
                    novoCampoMD.setForeground(Color.RED);
                    novoCampoCS.setForeground(Color.RED);

                }


            }

        });
        EFETUAR_DEVOLUCAO.getPainel().add(selecionaPDevolver);
        JButton novoRemover = new JButton("X");
        novoRemover.setFont(new Font("Tahoma", Font.PLAIN, 10));
        novoRemover.setLocation(870, posicao);
        novoRemover.setForeground(Color.MAGENTA);
        novoRemover.setSize(40, 30);


        novoRemover.addActionListener(e -> {
            assert sapato != null;
            ItemDevolucao itemErrado = compararPraRemover(sapato.getCodigoDeBarras());
            if (itemErrado != null) {
                PRODUTOS.remove(itemErrado);
                JOptionPane.showMessageDialog(null, "Removido");
                total = total - sapato.getPreco();
                EFETUAR_DEVOLUCAO.getCampoValor().setText(String.format("%.2f", total));
                JOptionPane.showMessageDialog(null, "Total atualizado: " + String.format("%.2f", total));
                novoCampoM.setForeground(Color.BLACK);
                novoCampoC.setForeground(Color.BLACK);
                novoCampoMD.setForeground(Color.BLACK);
                novoCampoT.setForeground(Color.BLACK);
                novoCampoTAM.setForeground(Color.BLACK);
                novoCampoValorUNIT.setForeground(Color.BLACK);
                novoCampoCS.setForeground(Color.BLACK);
            } else {
                JOptionPane.showMessageDialog(null, "Insira um item primeiro");
            }

        });
        EFETUAR_DEVOLUCAO.getPainel().add(novoRemover);
        //aparecer todos a cada adição.
        EFETUAR_DEVOLUCAO.getPainel().repaint();


    }

    private ItemDevolucao compararPraRemover(double codigoDeBarras) {
        ItemDevolucao errado = null;
        for (ItemDevolucao est : ControlaED.PRODUTOS) {
            if (est.getSapato().getCodigoDeBarras() == codigoDeBarras) {
                errado = est;

            }

        }
        return errado;
    }

    private Sapato selecionarPDevolver(double codigo) {
        return persistSapato.buscarPorCodigo(codigo);

    }


}
