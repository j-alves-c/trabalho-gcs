package dominio;

import java.util.ArrayList;

public  class Troca {
	  private int codigotroca;
	  private String dataTroca;

	  private Venda venda;
	  private ArrayList<ItemTroca> produtos;


	public String getDataTroca() {
		return dataTroca;
	}

	public void setDataTroca(String dataTroca) {
		this.dataTroca = dataTroca;
	}





	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;

	}
	public void setProdutos(ArrayList<ItemTroca> produtos){
		this.produtos = produtos;
	}

	public ArrayList<ItemTroca> getProdutos(){
		return produtos;
	}

	public int getCodigotroca() {
		return codigotroca;
	}

	public void setCodigotroca(int codigotroca) {
		this.codigotroca = codigotroca;
	}
}