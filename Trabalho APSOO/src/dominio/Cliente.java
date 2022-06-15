package dominio;

public class Cliente extends Pessoa {
    private String dataDeCadastro;


    public String getData() {
        return dataDeCadastro;
    }

    public void setData(String data) {
        this.dataDeCadastro = data;
    }
}