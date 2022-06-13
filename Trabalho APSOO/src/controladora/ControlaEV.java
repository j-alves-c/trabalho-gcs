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


public class ControlaEV  implements ActionListener, FocusListener {
    private final Connection conexao;
    private final EfetuarVenda efetuarVenda;
    private static Vendedor vendedor;
    private static Cliente cliente;
    private static InterfaceDAO<Sapato, Double> persistSapato = null;
    private static InterfaceDAO<ItemVenda, Integer> persistItem = null;
    private static InterfaceDAO<Venda, Integer> persistVenda = null;
    private static InterfaceDAO<Vendedor, String> persistVendedor = null;
    private static InterfaceDAO<Cliente, String> persistCliente = null;
    private static Venda venda;
    private static final ArrayList<ItemVenda> produtos = new ArrayList<>();

    private int posicao = 10;
    private double total = 0;


    public ControlaEV(EfetuarVenda efetuarVenda){
       this.conexao = ConexaoBD.conectar();

         this.efetuarVenda = efetuarVenda;
        // inicialização das classes Dao necessárias

        try {
            persistSapato = new SapatoDao(conexao);
        } catch (Exception e) {

            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }


        try {
            persistVenda = new VendaDao(conexao);
        } catch (Exception e) {

            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }



        try {
            persistVendedor = new VendedorDao(conexao);
        } catch (Exception e) {

            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }



        try {
            persistCliente = new ClienteDao(conexao);
        } catch (Exception e) {

            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        try {
            persistItem = new ItemVendadao(conexao);

        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        // fim da inicialização das classes Dao necessárias

    }

    public void iniciaVenda(){
        // busca o código da última venda armazenada no banco e acresce de um para exibir o da venda nova que será armazenada

        assert persistVenda != null;
        int codigo = ((VendaDao) persistVenda).buscarCodigo() + 1;
        efetuarVenda.getCodigoVenda().setText(  "" + codigo);
        venda = new Venda();
        venda.setCodigo(Integer.parseInt(efetuarVenda.getCodigoVenda().getText()));

        //seta a data da venda para a data do dia atual.
        venda.setDatavenda(efetuarVenda.getDataAtual().getText());
    }

    public void atualizaData(){
        // criar uma variável Date para captar a data.
        Date data = new Date(System.currentTimeMillis());
        //formatar pra String
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy");
        // settar a data do dia no campo da data.
        efetuarVenda.getDataAtual().setText(formatarDate.format(data));

    }

    private void adicionaField(){
        // adiciona os textfield extras + botões de remoção.
        posicao += 50;

        JTextField novoCampoM = new JTextField();
        novoCampoM.setSize(120, 30);
        novoCampoM.setLocation(142, posicao);
        novoCampoM.setText("");
        efetuarVenda.getPanel().add(novoCampoM);
        novoCampoM.setVisible(true);
     	novoCampoM.setHorizontalAlignment(SwingConstants.LEFT);
		novoCampoM.setFont(new Font("Tahoma", Font.PLAIN, 13));
		novoCampoM.setColumns(10);

        JTextField novoCampoC = new JTextField();

        novoCampoC.setSize(120, 30);
        novoCampoC.setLocation(272, posicao);
        novoCampoC.setText("");
        novoCampoC.setVisible(true);
	    novoCampoC.setHorizontalAlignment(SwingConstants.LEFT);
		novoCampoC.setFont(new Font("Tahoma", Font.PLAIN, 13));
		novoCampoC.setColumns(10);
		novoCampoC.setText("");
        novoCampoC.setVisible(true);
        efetuarVenda.getPanel().add(novoCampoC);


        JTextField novoCampoMD = new JTextField();

        novoCampoMD.setSize(120, 30);
        novoCampoMD.setLocation(402, posicao);
        novoCampoMD.setText("");
        efetuarVenda.getPanel().add(novoCampoMD);
        novoCampoMD.setVisible(true);
        novoCampoMD.setHorizontalAlignment(SwingConstants.LEFT);
		novoCampoMD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		novoCampoMD.setColumns(10);

        JTextField novoCampoT = new JTextField();

        novoCampoT.setSize(120, 30);
        novoCampoT.setLocation(532, posicao);
        novoCampoT.setText("");
        efetuarVenda.getPanel().add(novoCampoT);
        novoCampoT.setVisible(true);
        novoCampoT.setHorizontalAlignment(SwingConstants.LEFT);
		novoCampoT.setFont(new Font("Tahoma", Font.PLAIN, 13));
		novoCampoT.setColumns(10);


        JTextField novoCampoTAM = new JTextField();

        novoCampoTAM.setSize(50, 30);
        novoCampoTAM.setLocation(662, posicao);
        novoCampoTAM.setText("");
        efetuarVenda.getPanel().add(novoCampoTAM);
        novoCampoTAM.setVisible(true);
        novoCampoTAM.setFont(new Font("Tahoma", Font.PLAIN, 13));
		novoCampoTAM.setColumns(10);

        JTextField novoCampoValorUNIT = new JTextField();

        novoCampoValorUNIT.setSize(90, 30);
        novoCampoValorUNIT.setLocation(722, posicao);
        novoCampoValorUNIT.setText("");
        efetuarVenda.getPanel().add(novoCampoValorUNIT);
        novoCampoValorUNIT.setVisible(true);
        novoCampoValorUNIT.setFont(new Font("Tahoma", Font.PLAIN, 13));
		novoCampoValorUNIT.setColumns(10);


        JTextField novoCampoCS = new JTextField();

        novoCampoCS.setSize(120, 30);
        novoCampoCS.setLocation(12, posicao);
        novoCampoCS.setText("");
        novoCampoCS.setFont(new Font("Tahoma", Font.PLAIN, 13));
		novoCampoCS.setColumns(10);

        novoCampoCS.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                Sapato sapato = BuscarSap(novoCampoCS, novoCampoM, novoCampoC, novoCampoMD, novoCampoT, novoCampoTAM,novoCampoValorUNIT);
                if (sapato != null){
                    adicionaItemVenda(sapato);}

        }
        });
        efetuarVenda.getPanel().add(novoCampoCS);
        novoCampoCS.setVisible(true);




        JButton novoRemover = new JButton("X");
        novoRemover.setLocation(820, posicao);
        novoRemover.setForeground(Color.MAGENTA);
        novoRemover.setSize(40, 30);
        novoRemover.setHorizontalAlignment(SwingConstants.LEFT);
        novoRemover.setFont(new Font("Tahoma", Font.PLAIN, 10));


        novoRemover.addActionListener(e -> {
            if (novoCampoCS.getText() == null || novoCampoCS.getText().equals(" ") || novoCampoCS.getText().equals("") ){
                JOptionPane.showMessageDialog(null, "C\u00F3digo de barras n\u00e3o preenchido.");
            }
            else{
                ItemVenda itemErrado = compararPraRemover(Double.parseDouble(novoCampoCS.getText()));
                produtos.remove(itemErrado);
                JOptionPane.showMessageDialog(null,"Removido");
                total = total - Double.parseDouble(novoCampoValorUNIT.getText());
                efetuarVenda.getCampototal().setText(String.format("%.2f",total));
                JOptionPane.showMessageDialog(null,"Total atualizado: "+ String.format("%.2f",total));
                novoCampoC.setText("");
                novoCampoM.setText("");
                novoCampoT.setText("");
                novoCampoValorUNIT.setText("");
                novoCampoMD.setText("");
                novoCampoTAM.setText("");
                novoCampoCS.setText("");
            }
            
        });
        efetuarVenda.getPanel().add(novoRemover);
        efetuarVenda.getAdicionar_item().setFont(new Font("Tahoma", Font.PLAIN, 15));
        //aparecer todos a cada adição.
        efetuarVenda.getPanel().repaint();

        

    }

    private void confirma(){
        int conf = JOptionPane.showConfirmDialog(null, "Deseja confirmar a venda", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (conf == JOptionPane.YES_OPTION)
            finalizarVenda();

    }
    private void limpaPainel(){
        efetuarVenda.getPanel().removeAll();
        efetuarVenda.getPanel().repaint();
        posicao = -40;
        adicionaField();


    }
    private void finalizarVenda(){
        if (vendedor != null && cliente != null && !produtos.isEmpty() && !Objects.requireNonNull(efetuarVenda.getEscolhePagamento().getSelectedItem()).toString().equals("Selecionar")){
            venda.setProdutos(produtos);
            //insere a venda
            persistVenda.inserir(venda);
            //insere os item adicionados
            inserirItensAtuais(venda.getProdutos());
            //atualiza o total e sua exibição com o desconto
            total = total - total*(venda.getDesconto()/100);
            //imprime um comprovante 'grosseiro' na tela.
            JOptionPane.showMessageDialog(null," Venda efetuada com sucesso!!!"+"\n"+ " Imprimindo o comprovante!!!"
                    +"\n"+ persistVenda.buscarPorCodigo(venda.getCodigo()).toString()  +
                    ", cpfCliente='" + venda.getCliente().getCPF() + '\'' +
                    ", cpfvendedor='" + venda.getVendedor().getCPF() + '\''+ "\n "+ "Cliente " + venda.getCliente().getNome()+ "\n "+ "Vendedor "
                    + venda.getVendedor().getNome()+ "\n"+"Total da venda:" + String.format("%.2f", total) + "\n"+ imprimirItensAtuais(persistItem.listaTodos()));



            efetuarVenda.getCampototal().setText(String.format("%.2f", total));
            if (venda.getFormaPagamento().equals("Dinheiro")){
                calculaTroco();
            }




            int codigo1 = ((VendaDao) persistVenda).buscarCodigo() + 1;
            efetuarVenda.getCodigoVenda().setText( "" + codigo1);
            limpaCampo();
            produtos.removeAll(produtos);
            total = 0;
            efetuarVenda.getCampototal().setText(String.format("%2f",total));
            limpaPainel();

        }
        else {

            JOptionPane.showMessageDialog(null,"Algo est\u00e1 incorreto com o vendedor, cliente, pagamento ou n\u00e3o foi cadastrado nenhum item de venda." );
        }
    }
    private void cancelarVenda(){
        limpaCampo();
        JOptionPane.showMessageDialog(null,"Fechando o Sistema!");
        ConexaoBD.closeconexao();
        System.exit(0);


    }
    private void removerItem(){
        if (efetuarVenda.getCodigo_sapato().getText() == null || efetuarVenda.getCodigo_sapato().getText().equals(" ") || efetuarVenda.getCodigo_sapato().getText().equals("") ){
            JOptionPane.showMessageDialog(null, "C\u00F3digo de barras n\u00e3o preenchido.");
        }else{
            // busca qual é o item a se remover.
            ItemVenda itemErrado = compararPraRemover(Double.parseDouble(efetuarVenda.getCodigo_sapato().getText()));
            if (itemErrado == null)
                JOptionPane.showMessageDialog(null,"N\u00e3o h\u00e1 esse item na venda ainda");
            else{
                produtos.remove(itemErrado);
                JOptionPane.showMessageDialog(null,"Removido");
                //atualiza o total e sua exibição
                total = total - Double.parseDouble(efetuarVenda.getCampovaloruni().getText());
                efetuarVenda.getCampototal().setText(String.format("%.2f",total));
                JOptionPane.showMessageDialog(null,"Total atualizado: "+ String.format("%.2f",total));
                //apaga os campos do item removido.
                efetuarVenda.getCampocolecao().setText("");
                efetuarVenda.getCampoMarca().setText("");
                efetuarVenda.getCampotam().setText("");
                efetuarVenda.getCampovaloruni().setText("");
                efetuarVenda.getCodigo_sapato().setText("");
                efetuarVenda.getCampotipo().setText("");
                efetuarVenda.getCampomodelo().setText("");
            }


        }

    }


    @Override
    public void actionPerformed(ActionEvent EventoBotao) {
        if (EventoBotao.getSource().equals(efetuarVenda.getCancelar())){
           cancelarVenda();
        }
        else if (EventoBotao.getSource().equals(efetuarVenda.getConfirmar())){
            confirma();


        } else if (EventoBotao.getSource().equals(efetuarVenda.getRemover())){
           removerItem();


        } else if (EventoBotao.getSource().equals(efetuarVenda.getAdicionar_item())){
            adicionaField();
        }

    }

    private void validaVendedor(){
        if (efetuarVenda.getCampoVendedor().getText() == null || efetuarVenda.getCampoVendedor().getText().equals("") || efetuarVenda.getCampoVendedor().getText().equals(" ")  ){
            JOptionPane.showMessageDialog(new JFrame(), " Vendedor n\u00e3o preenchido!" );

        } else {
            //busca o vendedor no banco.
            vendedor = persistVendedor.buscarPorCodigo(efetuarVenda.getCampoVendedor().getText());
            // checa se o vendedor existe antes de armazenar na variável venda.
            if (vendedor != null) {
                venda.setVendedor(vendedor);
                efetuarVenda.getCampoNomeVendedor().setText(vendedor.getNome());
            } else{
                JOptionPane.showMessageDialog(new JFrame(), "Vendedor inv\u00e1lido!");}
        }
    }
    private void validaCliente(){
        if (efetuarVenda.getCampoCliente().getText() == null || efetuarVenda.getCampoCliente().getText().equals("") || efetuarVenda.getCampoCliente().getText().equals(" ")  ){
            JOptionPane.showMessageDialog(new JFrame(), "Cliente n\u00e3o preenchido!" );

        } else{
            //busca o cliente no banco
            cliente = persistCliente.buscarPorCodigo(efetuarVenda.getCampoCliente().getText());
            // checa se o cliente existe antes de armazenar na variável venda.
            if (cliente != null) {
                venda.setCliente(cliente);
                efetuarVenda.getCampoNomeCliente().setText(cliente.getNome());
            }else
                JOptionPane.showMessageDialog(new JFrame(), "Cliente n\u00e3o cadastrado!" );
        }
    }
    private void validaDesconto(){
        // impede que o vendedor coloque primeiro o desconto e depois a forma de pagamento e dê mais desconto onde não pode.
        if (Objects.requireNonNull(efetuarVenda.getEscolhePagamento().getSelectedItem()).toString().equals("Selecionar")){
            venda.setDesconto(0);
            efetuarVenda.getCampoDesconto().setText("0");
            JOptionPane.showMessageDialog(null," Selecione o pagamento primeiro!");}
        else {
            if (Objects.requireNonNull(efetuarVenda.getEscolhePagamento().getSelectedItem()).toString().equals("Cr\u00E9dito")){
                venda.setDesconto(0);
                efetuarVenda.getCampoDesconto().setText("0");
                JOptionPane.showMessageDialog(new JFrame(), "Desconto n\u00e3o dado em cr\u00E9dito");
            } else{
                // impede o não preenchimento do desconto.
                if (efetuarVenda.getCampoDesconto().getText() == null || efetuarVenda.getCampoDesconto().getText().equals(" ") || efetuarVenda.getCampoDesconto().getText().equals(""))
                    JOptionPane.showMessageDialog(new JFrame(), "Desconto n\u00e3o preenchido.");
                    //confere se é inteiro.
                else if (isInteger(efetuarVenda.getCampoDesconto().getText()) ) {
                    //impede o desconto em valor parcelado
                    if (Integer.parseInt(efetuarVenda.getCampoParcelas().getText()) == 1){
                        // impede que o desconto seja negativo ou maior que 10 por cento.
                        if (Integer.parseInt(efetuarVenda.getCampoDesconto().getText()) < 0 || Integer.parseInt(efetuarVenda.getCampoDesconto().getText()) > 10 ){
                            venda.setDesconto(0);
                            efetuarVenda.getCampoDesconto().setText("0");
                            JOptionPane.showMessageDialog(new JFrame(), "Desconto inv\u00e1lido!");}
                        else{
                            venda.setDesconto(Integer.parseInt(efetuarVenda.getCampoDesconto().getText()));
                            JOptionPane.showMessageDialog(new JFrame(), "Desconto registrado.");}
                    }	else {
                        venda.setDesconto(0);
                        efetuarVenda.getCampoDesconto().setText("0");
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
    private void validaFormaPag(){
        //impede que seja armazenado o valor "Selecionar" como forma de pagamento.
        if (Objects.requireNonNull(efetuarVenda.getEscolhePagamento().getSelectedItem()).toString().equals("Selecionar"))
            JOptionPane.showMessageDialog(null,"Forma de Pagamento n\u00e3o preenchida!");
        else
            venda.setFormaPagamento(efetuarVenda.getEscolhePagamento().getSelectedItem().toString());

    }
    private void validaParcelas(){
        //obriga selecionar o pagamento antes, evitar que parcele onde não pode.
        if (Objects.requireNonNull(efetuarVenda.getEscolhePagamento().getSelectedItem()).toString().equals("Selecionar")) {
            JOptionPane.showMessageDialog(new JFrame(), "Selecione o pagamento primeiro!");
            efetuarVenda.getCampoParcelas().setText("1");
        } else {
            //checa se é inteiro.
            if (isInteger(efetuarVenda.getCampoParcelas().getText())) {
                //impede o parcelamento em dinheiro ou débito.
                if (efetuarVenda.getEscolhePagamento().getSelectedItem().toString().equals("D\u00E9bito") || efetuarVenda.getEscolhePagamento().getSelectedItem().toString().equals("Dinheiro") )
                {if (Integer.parseInt(efetuarVenda.getCampoParcelas().getText()) != 1){
                    JOptionPane.showMessageDialog(null,"N\u00e3o se parcela em d\u00E9bito nem em dinheiro.");
                    efetuarVenda.getCampoParcelas().setText("1");}}
                //opção do crédito
                else {
                    // define o à vista.
                    if (Integer.parseInt(efetuarVenda.getCampoParcelas().getText()) == 1 ){
                        JOptionPane.showMessageDialog(null, "Venda  vai ser \u00e0 vista");
                        efetuarVenda.getCampoParcelas().setText("1"); }
                    //impede parcelas negativas, nenhuma parcela ou maiores que 6.
                    else if (Integer.parseInt(efetuarVenda.getCampoParcelas().getText()) < 1 || Integer.parseInt(efetuarVenda.getCampoParcelas().getText()) > 6){
                        JOptionPane.showMessageDialog(null, "N\u00famero de parcelas inv\u00e1lido");
                        efetuarVenda.getCampoParcelas().setText("1"); }
                    //notifica inválido;
                    else{
                        efetuarVenda.getCampoDesconto().setText("0");
                        efetuarVenda.getCampoDesconto().setText("0");
                        venda.setDesconto(0);
                        JOptionPane.showMessageDialog(null, "N\u00famero de parcelas registrado.");}
                }

            }

            else{
                // avisa que não esta preenchida.
                if (efetuarVenda.getCampoParcelas().getText() == null || efetuarVenda.getCampoParcelas().getText().equals(" ") || efetuarVenda.getCampoParcelas().getText().equals("")){
                    JOptionPane.showMessageDialog(new JFrame(), "Parcelas n\u00e3o preenchidas.");}
                //não é valor inteiro;
                JOptionPane.showMessageDialog(new JFrame(), "N\u00famero de parcelas n\u00e3o \u00E9 inteiro.");}
        }
    }
    private Sapato BuscarSap(JTextField codigo,JTextField marca,JTextField colecao,JTextField modelo,JTextField tipo,JTextField tamanho,JTextField valor){
        //checa se é vazio
        if (codigo.getText() == null || codigo.getText().equals(" ") || codigo.getText().equals("") ){
            JOptionPane.showMessageDialog(null, "C\u00F3digo de barras n\u00e3o preenchido.");
                return null;
        } else{
            //checa se é double (tipo do codigo de barras)
            if (isDouble(codigo.getText())){
                //busca o sapato no banco e confere se existe.
                Sapato sapato =persistSapato.buscarPorCodigo(Double.parseDouble(codigo.getText()));
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
                else{
                    JOptionPane.showMessageDialog(null, "c\u00F3digo de Barras Inv\u00e1lido " );
                    return null;}
            }
            //não é double;
            else {
                JOptionPane.showMessageDialog(null, "C\u00F3digo de barras n\u00e3o Double.");
                return null;
            }
        }
    }
    private void adicionaItemVenda(Sapato sapato){
        // inicializa um item de venda pra guardá-lo
        ItemVenda item = new ItemVenda();
        //refere o sapato no item venda
        item.setSapato(sapato);
        //refere a venda no item venda
        item.setVenda(venda);
        //atualiza o total
        total = total + item.getValorUnitario();
        //atualiza a exibição do total
        efetuarVenda.getCampototal().setText(String.format("%.2f", total));
        //guarda item venda no vetor de produtos.
        produtos.add(item);
        JOptionPane.showMessageDialog(null, ""+ total + " da compra at\u00E9 agora");

    }
    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {
        //ValidaFormaPagamento
        if (e.getSource().equals(efetuarVenda.getEscolhePagamento())){
            validaFormaPag();

        }

        //BuscaSapato e AdicionaItemVenda
        else if(e.getSource().equals(efetuarVenda.getCodigo_sapato())){
            Sapato sapato = BuscarSap(efetuarVenda.getCodigo_sapato(), efetuarVenda.getCampoMarca(), efetuarVenda.getCampocolecao(), efetuarVenda.getCampomodelo(), efetuarVenda.getCampotipo(), efetuarVenda.getCampotam(), efetuarVenda.getCampovaloruni());
            if (sapato != null){
                adicionaItemVenda(sapato);
                 }


        }

        //ValidaDesconto()

        else if (e.getSource().equals(efetuarVenda.getCampoDesconto())){
            validaDesconto();
        }


        //Valida cpfVendedor
        else if (e.getSource().equals(efetuarVenda.getCampoVendedor())){
            validaVendedor();

        }

        //ValidaCpfCliente()
        else if (e.getSource().equals(efetuarVenda.getCampoCliente())){
            validaCliente();

        }

        else if(e.getSource().equals(efetuarVenda.getCampoParcelas())){
            validaParcelas();
        }
    }
    //imprimir na tela os itens de venda atuais
    private static String imprimirItensAtuais(ArrayList<ItemVenda> lista){
        String string = "";
        for(ItemVenda est:lista){
            string += "C\u00f3digo do Item "+ est.getCodigoItemVenda() + " C\u00f3digo de barras  " + String.format("%2f",est.getSapato().getCodigoDeBarras()) +"\n";
            
        }
        return string;
    }
    //inserir no banco todos os itens armazenados na programa.
    private static void inserirItensAtuais(ArrayList<ItemVenda> lista){
        for(ItemVenda est:lista){
            persistItem.inserir(est);
        }
    }
    //comparar os itens de venda já adicionados para remover o que foi erroneamente add.
    private static ItemVenda compararPraRemover(Double codigo){
        ItemVenda errado = null;
        for(ItemVenda est: ControlaEV.produtos){
            if (est.getSapato().getCodigoDeBarras() == codigo){
                errado = est;

            }

        }
        return errado;
    }


    //checar se é valor inteiro.

    private  boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException | NullPointerException e) {
            return false;
        }

        return true;
    }
    //checar se é valor double.
    private  boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
        } catch(NumberFormatException | NullPointerException e) {
            return false;
        }

        return true;
    }


private void limpaCampo(){
    efetuarVenda.getCampoCliente().setText("");
    efetuarVenda.getCampoVendedor().setText("");
    efetuarVenda.getCampoDesconto().setText("0");
    efetuarVenda.getCampoParcelas().setText("1");
    efetuarVenda.getCampoNomeVendedor().setText("");
    efetuarVenda.getCampoNomeCliente().setText("");
    for (int i=0; i < efetuarVenda.getPanel().getComponentCount(); i++) {
        //varre todos os componentes do painel
        Component c = efetuarVenda.getPanel().getComponent(i);

        if (c instanceof JTextField) {
            //apaga os valores das TextField
            JTextField field = (JTextField) c;
            field.setText("");
        }}
}

private void calculaTroco(){

        double valorPago = Double.parseDouble(JOptionPane.showInputDialog(null,"Insira a quantia recebida"));
        double troco = valorPago - total;
        if (troco != 0){
            JOptionPane.showMessageDialog(null, "O troco é "+ String.format("%.2f",troco));}
}













}
