package dominio;

public class Sapato {
    private double codigoDeBarras;
    private int numero;
    private String tipo;
    private String modelo;
    private String colecao;
    private String marca;
    private double preco;
    private int quantidade;


    //-----------------------------------------------------
    public void setCodigoDeBarras(double codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    public double getCodigoDeBarras() {
        return codigoDeBarras;
    }

    //-----------------------------------------------------
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    //-----------------------------------------------------
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    //-----------------------------------------------------
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    //-----------------------------------------------------
    public void setColecao(String colecao) {
        this.colecao = colecao;
    }

    public String getColecao() {
        return colecao;
    }

    //-----------------------------------------------------
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    //-----------------------------------------------------
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    //-----------------------------------------------------


}