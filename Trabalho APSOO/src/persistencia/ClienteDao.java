package persistencia;

import dominio.Cliente;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ClienteDao implements  InterfaceDAO<Cliente,String>{
    private final Connection conexao;
    //conectar no banco
    public ClienteDao(Connection connection) throws Exception{
        this.conexao=connection;
    }
    //inserir no banco (junta tabelas)
    public void inserir(Cliente entidade)  {
        try {
            PreparedStatement preStm=conexao.prepareStatement("" +
                    "insert into pessoa(cpf,nome,endereco,estado,cidade,email,telefone) values(?,?,?,?,?,?,?)");
            preStm.setString(1, entidade.getCPF());
            preStm.setString(2, entidade.getNome());
            preStm.setString(3, entidade.getEndereco());
            preStm.setString(4, entidade.getEstado());
            preStm.setString(5, entidade.getCidade());
            preStm.setString(6, entidade.getEmail());
            preStm.setString(7, entidade.getTelefone());


            int qtd=preStm.executeUpdate();
            PreparedStatement preStm1=conexao.prepareStatement("" +
                    "insert into cliente(datadecadastro,cpf) values(?,?)");
            preStm1.setString(2, entidade.getCPF());
            DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            preStm1.setDate(1, new Date(simpleDateFormat.parse(entidade.getData()).getTime()));
            int qtd1 = preStm1.executeUpdate();

            if(qtd>0 && qtd1>0){
                System.out.println("Salvo no banco");
            }else{
                System.out.println("não foi possível salvar no banco");
            }
        } catch (SQLException | ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //atualizar no banco
    @Override
    public void atualizar(Cliente entidade) {
        try {
            PreparedStatement preStm=conexao.prepareStatement("" +
                    "update pessoa set nome = ?,telefone = ? where cpf = ?");
            preStm.setString(1, entidade.getNome());
            preStm.setString(2, entidade.getTelefone());
            preStm.setString(3, entidade.getCPF());
            int qtd=preStm.executeUpdate();
            if(qtd>0){
                System.out.println("Atualizado no banco");
            }else{
                System.out.println("Não foi possível atualizar no banco");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
//deletar no banco (junta tabelas)
    @Override
    public void deletar(Cliente entidade) {
        try {
            PreparedStatement preStm=conexao.prepareStatement("" +
                    "delete from cliente where cpf=?");
            preStm.setString(1, entidade.getCPF());
            int qtd=preStm.executeUpdate();

            PreparedStatement preStm1=conexao.prepareStatement("" +
                    "delete from pessoa where cpf=?");
            preStm.setString(1, entidade.getCPF());
            int qtd1 = preStm1.executeUpdate();



            if(qtd>0 && qtd1>0){
                System.out.println("Deletado do banco");
            }else{
                System.out.println("Não foi possível deletar no banco");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
//buscar no banco
    @Override
    public Cliente buscarPorCodigo(String chave) {
        PreparedStatement preStm;
        try {
            preStm = conexao.prepareStatement("select pessoa.*, cliente.datadecadastro from pessoa,cliente WHERE pessoa.cpf = cliente.cpf AND cliente.cpf = ?  ; ");
            preStm.setString(1, chave);
            ResultSet resultado=preStm.executeQuery();
            while(resultado.next()){
                //System.out.println(resultado.getString("nome"));
                Cliente pessoa = new Cliente();
                pessoa.setCPF(resultado.getString("cpf"));
                pessoa.setNome(resultado.getString("nome"));
                pessoa.setEndereco(resultado.getString("endereco"));
                pessoa.setEstado(resultado.getString("estado"));
                pessoa.setCidade(resultado.getString("cidade"));
                pessoa.setEmail(resultado.getString("email"));
                pessoa.setTelefone(resultado.getString("telefone"));
                pessoa.setData(resultado.getString("datadecadastro"));
                return pessoa;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return null;
    }
//listar todos os clientes cadastrados.
    @Override
    public ArrayList<Cliente> listaTodos() {
        PreparedStatement preStm;
        ArrayList<Cliente> lista=new ArrayList<>();
        try {
            preStm = conexao.prepareStatement("select pessoa.*,cliente.datadecadastro from pessoa,cliente where pessoa.cpf = cliente.cpf order by pessoa.cpf asc ");
            ResultSet resultado=preStm.executeQuery();
            while(resultado.next()){
                Cliente pessoa = new Cliente();
                pessoa.setCPF(resultado.getString("cpf"));
                pessoa.setNome(resultado.getString("nome"));
                pessoa.setEndereco(resultado.getString("endereco"));
                pessoa.setEstado(resultado.getString("estado"));
                pessoa.setCidade(resultado.getString("cidade"));
                pessoa.setEmail(resultado.getString("email"));
                pessoa.setTelefone(resultado.getString("telefone"));
                pessoa.setData(resultado.getString("datadecadastro"));
                lista.add(pessoa);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return lista;

    }


}
