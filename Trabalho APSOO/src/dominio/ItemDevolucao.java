package dominio;

public class ItemDevolucao {

    private int codigoItemDevolucao;

    private Devolucao devolucao;

    private Sapato sapato;
    private double valorUnitario;

    public int getCodigoItemDevolucao() {
        return codigoItemDevolucao;
    }

    public void setCodigoItemDevolucao(int codigoItemDevolucao) {
        this.codigoItemDevolucao = codigoItemDevolucao;
    }


    public void setDevolucao(Devolucao devolucao) {
        this.devolucao = devolucao;


    }


    public Devolucao getDevolucao() {
        return devolucao;
    }

    public Sapato getSapato() {
        return sapato;
    }

    public void setSapato(Sapato sapato) {
        this.sapato = sapato;
        this.setValorUnitario(sapato.getPreco());

    }


    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
}