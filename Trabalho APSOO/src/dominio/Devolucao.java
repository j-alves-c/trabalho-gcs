package dominio;

import java.util.ArrayList;

public class Devolucao {
    private int codigoDaDevolucao;
    private String dataDevolucao;

    private Venda venda;
    private ArrayList<ItemDevolucao> produtos;


    //--------------------------------------------------------
    public void setCodigoDaDevolucao(int codigoDaDevolucao) {
        this.codigoDaDevolucao = codigoDaDevolucao;
    }

    public int getCodigoDaDevolucao() {
        return codigoDaDevolucao;
    }

    //--------------------------------------------------------
    public void setDataDevolucao(String data) {
        this.dataDevolucao = data;
    } //setar a data do dia em que esta ocorrendo a devolucao

    public String getDataDevolucao() {
        return dataDevolucao;
    }
    //--------------------------------------------------------


    //--------------------------------------------------------

    //--------------------------------------------------------
    public void setVenda(Venda venda) {
        this.venda = venda;

    }

    public Venda getVenda() {
        return venda;
    }


    public void setProdutos(ArrayList<ItemDevolucao> produtos) {
        this.produtos = produtos;
    }

    public ArrayList<ItemDevolucao> getProdutos() {
        return produtos;
    }
    //--------------------------------------------------------


    @Override
    public String toString() {
        return "Devolu\u00e7\u00e3o{" +
                "c\u00F3digo da Devolu\u00e7\u00e3o=" + codigoDaDevolucao +
                ", data da Devolu\u00e7\u00e3o='" + dataDevolucao + '\'' +
                '}';
    }
}