package dominio;


import java.util.ArrayList;

public  class Venda {

  private String datavenda;
  private int codigo;
  private int desconto;
  private String formaPagamento;

  private Cliente Cliente;

  private Vendedor Vendedor;
  private ArrayList<ItemVenda> produtos;
  public Venda(){
    

  }

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getDesconto() {
		return desconto;
	}

	public void setDesconto(int desconto) {
		this.desconto = desconto;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}










	public String getDatavenda() {
		return datavenda;
	}

	public void setDatavenda(String datavenda) {
		this.datavenda = datavenda;
	}

	public Cliente getCliente() {
		return Cliente;
	}

	public void setCliente(Cliente cliente) {
		Cliente = cliente;

	}

	public Vendedor getVendedor() {
		return Vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		Vendedor = vendedor;

			}

	public void setProdutos(ArrayList<ItemVenda> produtos) {
		this.produtos = produtos;
	}
	public ArrayList<ItemVenda> getProdutos(){
  		return produtos;
	}

	@Override
	public String toString() {
		return "Venda " +
				"datavenda='" + datavenda + '\'' +
				", codigo=" + codigo +
				", desconto=" + desconto +
				", formaPagamento='" + formaPagamento + '\'';
	}
}