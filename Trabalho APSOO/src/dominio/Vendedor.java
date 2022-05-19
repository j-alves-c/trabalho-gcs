package dominio;

public class Vendedor extends Usuario {
	private boolean permissaoVendedor;
	private double comissao;



  public void setPermissaoVendedor(boolean permissao) {
    this.permissaoVendedor = permissao;
  }
  
  public Boolean getPermissaoVendedor() {
   return permissaoVendedor;
  }

  public void setComissao(double comissao) {
	  this.comissao = comissao;
  }
  
  public double getComissao() {
   return comissao;
  }

public String toString(){
    return super.toString() + '\n'+ getPermissaoVendedor() + '\n'+ getComissao() + '\n' ;
  }

}