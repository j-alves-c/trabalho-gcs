package dominio;

public class ItemTroca  {
	  private int codigoItemTroca;

	  private Troca troca;

	  private Sapato sapato;
	  private double valorUnitario;

	public ItemTroca() {
	}

	public int getCodigoItemTroca() {
			return codigoItemTroca; 
		}
	public void setCodigocodigoItemTroca(int codigoItemTroca){

		this.codigoItemTroca = codigoItemTroca;
	  }












	public void setTroca(Troca troca) {
		this.troca = troca;

	}







	public void setSapato(Sapato sapato) {
		this.sapato = sapato;

		this.setValorUnitario(sapato.getPreco());
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
}