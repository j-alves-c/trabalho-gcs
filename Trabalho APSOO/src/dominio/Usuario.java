package dominio;

public abstract class Usuario extends Pessoa {
	protected String login;
	protected String senha;
	protected String dataContratacao;



	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(String data) {
		this.dataContratacao = data;
	}
  public String toString(){
    return super.toString() + '\n'+ getLogin();
  }

}