package dominio;

public class ItemVenda {
	  private int codigoItemVenda;

	  private Venda Venda;
	  private double valorUnitario;
	  private Sapato Sapato;





	  public void setCodigoItemVenda(int codigoItemVenda) {
	    this.codigoItemVenda = codigoItemVenda;
	  }
	  public int getCodigoItemVenda() {
			return codigoItemVenda; 
		}









	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}




	public void setVenda(Venda venda) {
		Venda = venda;

	}


	public void setSapato(dominio.Sapato sapato) {
		Sapato = sapato;
		setValorUnitario(this.Sapato.getPreco());
	}

	public dominio.Venda getVenda() {
		return Venda;
	}


	public dominio.Sapato getSapato() {
		return Sapato;
	}
//-----------------------------------------------------

	}