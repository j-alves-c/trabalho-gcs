package controladora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dominio.Sapato;
import persistencia.ConexaoBD;
import persistencia.InterfaceDAO;
import persistencia.SapatoDao;
import telas.InserirSapato;

public class ControlaIS implements ActionListener, FocusListener {
	private final Connection CONEXAO;
	private static InterfaceDAO<Sapato, Double> persistSapato = null;
	private static Sapato sapato;
	private boolean codBarras = false, marca = false, colecao = false, modelo = false, tipo = false, tamanho = false, preco = false;
	private final InserirSapato INSERIR_SAPATO;
	
	public ControlaIS(InserirSapato INSERIR_SAPATO) {
		this.INSERIR_SAPATO = INSERIR_SAPATO;
		this.CONEXAO = ConexaoBD.conectar();
		try {
			persistSapato = new SapatoDao(CONEXAO);
		} catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
	}
	
    public void atualizaData() {
        // criar uma vari\u00e1vel Date para captar a data.
        Date data = new Date(System.currentTimeMillis());
        //formatar pra String
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy");
        // settar a data do dia no campo da data.
        INSERIR_SAPATO.getDataAtual().setText(formatarDate.format(data));
    }
	
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void focusLost(FocusEvent e) {
		//ValidaCpfsapato()
        if (e.getSource().equals(INSERIR_SAPATO.getCodigoSapato())) {
           validaCodigoSapato();

       }else if (e.getSource().equals(INSERIR_SAPATO.getCampoMarca())) {
            validaCampoMarca();

        }else if (e.getSource().equals(INSERIR_SAPATO.getCampoColecao())) {
            validaCampoColecao();

        }else if (e.getSource().equals(INSERIR_SAPATO.getCampoModelo())) {
            validaCampoModelo();

        }
        else if (e.getSource().equals(INSERIR_SAPATO.getCampoTipo())) {
            validaCampoTipo();

        }else if (e.getSource().equals(INSERIR_SAPATO.getCampoTam())) {
           validaCampoTam();

       }else if (e.getSource().equals(INSERIR_SAPATO.getCampoValorUni())){
            validaCampoValorUni();
        }
	}
        
    private void cancelaCadastro(){
        JOptionPane.showMessageDialog(null, "Fechando o Sistema!");
        ConexaoBD.closeconexao();
        INSERIR_SAPATO.getFrame().setVisible(false);
    }
    
    private void validaCodigoSapato() {

        if (INSERIR_SAPATO.getCodigoSapato().getText() == null || INSERIR_SAPATO.getCodigoSapato().getText().equals("") || INSERIR_SAPATO.getCodigoSapato().getText().equals(" ")) {
              JOptionPane.showMessageDialog(new JFrame(), "sapato n\u00e3o preenchido!");
              codBarras=false;
        } else {
            sapato =  persistSapato.buscarPorCodigo(Double.parseDouble(INSERIR_SAPATO.getCodigoSapato().getText()));
            if (sapato != null){
                JOptionPane.showMessageDialog(new JFrame(), "sapato j\u00e1 existente!");
                sapato = null;
                INSERIR_SAPATO.getCodigoSapato().setText("");
                codBarras=false;
            } else {
            	codBarras = true;
            }
        }
      }
    
    private void validaCampoMarca(){
        if (INSERIR_SAPATO.getCampoMarca().getText() == null || INSERIR_SAPATO.getCampoMarca().getText().equals("") || INSERIR_SAPATO.getCampoMarca().getText().equals(" ")) {
            JOptionPane.showMessageDialog(new JFrame(), "Marca não preenchida!");
            marca=false;
        } else {
            marca=true;

        }
    }
    
    private void validaCampoColecao(){
        if (INSERIR_SAPATO.getCampoColecao().getText() == null || INSERIR_SAPATO.getCampoColecao().getText().equals("") || INSERIR_SAPATO.getCampoColecao().getText().equals(" ")) {
            JOptionPane.showMessageDialog(new JFrame(), "Coleção não preenchida!");
            colecao=false;
        } else {
            colecao=true;

        }
    }
    
    private void validaCampoModelo(){
        if (INSERIR_SAPATO.getCampoModelo().getText() == null || INSERIR_SAPATO.getCampoModelo().getText().equals("") || INSERIR_SAPATO.getCampoModelo().getText().equals(" ")) {
            JOptionPane.showMessageDialog(new JFrame(), "Modelo não preenchido!");
            modelo=false;
        } else {
            modelo=true;

        }
    }
    
    private void validaCampoTipo(){
        if (INSERIR_SAPATO.getCampoTipo().getText() == null || INSERIR_SAPATO.getCampoTipo().getText().equals("") || INSERIR_SAPATO.getCampoTipo().getText().equals(" ")) {
            JOptionPane.showMessageDialog(new JFrame(), "Tipo não preenchida!");
            tipo=false;
        } else {
            tipo=true;

        }
    }
    
    private void validaCampoTam(){
        if (INSERIR_SAPATO.getCampoTam().getText() == null || INSERIR_SAPATO.getCampoTam().getText().equals("") || INSERIR_SAPATO.getCampoTam().getText().equals(" ")) {
            JOptionPane.showMessageDialog(new JFrame(), "Tamanho não preenchido!");
            tamanho=false;
        } else {
            if (isInteger(INSERIR_SAPATO.getCampoTam().getText())) {
            	tamanho=true;
            }
        }
    }
    
  //checar se é valor integer
    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }

        return true;
    }
    
    private void validaCampoValorUni(){
        if (INSERIR_SAPATO.getCampoValorUni().getText() == null || INSERIR_SAPATO.getCampoValorUni().getText().equals("") || INSERIR_SAPATO.getCampoValorUni().getText().equals(" ")) {
            JOptionPane.showMessageDialog(new JFrame(), "Valor unitário não preenchido!");
            preco=false;
        } else {
            if (isDouble(INSERIR_SAPATO.getCampoValorUni().getText())) {
            	preco=true;
            }
        }
    }

    //checar se é valor double
    private boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }

        return true;
    }
    
    private void confirma(){
        int conf = JOptionPane.showConfirmDialog(null, "Deseja confirmar o cadastro", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (conf == JOptionPane.YES_OPTION)
            cadastrarSapato();

    }
    
    private void cadastrarSapato(){
        if (codBarras && marca && colecao && modelo && tipo && tamanho && preco){
            sapato = new Sapato();
            sapato.setCodigoDeBarras(Double.parseDouble(INSERIR_SAPATO.getCodigoSapato().getText()));
            sapato.setMarca(INSERIR_SAPATO.getCampoMarca().getText());
            sapato.setColecao(INSERIR_SAPATO.getCampoColecao().getText());
            sapato.setModelo(INSERIR_SAPATO.getCampoModelo().getText());
            sapato.setTipo(INSERIR_SAPATO.getCampoTipo().getText().toUpperCase());
            sapato.setNumero(Integer.parseInt(INSERIR_SAPATO.getCampoTam().getText()));
            sapato.setPreco(Double.parseDouble(INSERIR_SAPATO.getCampoValorUni().getText()));

            persistSapato.inserir(sapato);
        }else{
            JOptionPane.showMessageDialog(new JFrame(), "Os campos  n\u00e3o foram preenchidos corretamente.");
        }
    }
        
	@Override
	public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(INSERIR_SAPATO.getButtonConfirmar())) {
            confirma();
        } else if (e.getSource().equals(INSERIR_SAPATO.getButtonCancelar())){
            cancelaCadastro();
        }
	} 
}
