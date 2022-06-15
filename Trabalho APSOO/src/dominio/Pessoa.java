package dominio;

public abstract class Pessoa {
    //mantive protected nessa pras classes filhas e netas terem acesso
    protected String nome;
    protected String cPF;
    protected String endereco;
    protected String estado;
    protected String cidade;
    protected String email;
    protected String telefone;
    // é o construtor padrão, vai ser invocado em todos os construtores das classes filhas e netas

    public Pessoa() {

    }

    //-----------------------------------------------------
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //-----------------------------------------------------
    public String getCPF() {
        return cPF;
    }

    public void setCPF(String cPF) {
        this.cPF = cPF;

    }

    //-----------------------------------------------------
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    //-----------------------------------------------------
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {

        if (estado.length() == 2)
            this.estado = estado;

    }

    //-----------------------------------------------------
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;

    }

    //-----------------------------------------------------
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //-----------------------------------------------------
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;

    }
    //-----------------------------------------------------

    public String toString() {
        return this.getNome() + "\n" + this.getCPF() + '\n' + this.getCidade() + '\n' + this.getEndereco() + '\n' + this.getEstado() + '\n' + this.getEmail() + '\n' + this.getTelefone() + "\n\n";
    }
}