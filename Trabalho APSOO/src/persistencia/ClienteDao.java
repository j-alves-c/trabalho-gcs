package persistencia;

import dominio.Cliente;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ClienteDao implements InterfaceDAO<Cliente, String> {
    private final Connection CONEXAO;

    //conectar no banco
    public ClienteDao(Connection connection) throws Exception {
        this.CONEXAO = connection;
    }

    //inserir no banco (junta tabelas)
    public void inserir(Cliente entidade) {
        try {
            PreparedStatement preStm = CONEXAO.prepareStatement("" +
                    "insert into pessoa(cpf,nome,endereco,estado,cidade,email,telefone) values(?,?,?,?,?,?,?)");
            preStm.setString(1, entidade.getCPF());
            preStm.setString(2, entidade.getNome());
            preStm.setString(3, entidade.getEndereco());
            preStm.setString(4, entidade.getEstado());
            preStm.setString(5, entidade.getCidade());
            preStm.setString(6, entidade.getEmail());
            preStm.setString(7, entidade.getTelefone());


            int qtd = preStm.executeUpdate();
            PreparedStatement preStm1 = CONEXAO.prepareStatement("" +
                    "insert into cliente(datadecadastro,cpf) values(?,?)");
            preStm1.setString(2, entidade.getCPF());
            DateFormat datanormal = new SimpleDateFormat("dd/MM/yyyy");
            Date dataFormatoHumano = new Date(datanormal.parse(entidade.getData()).getTime());

            DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dataBanco = simpleDateFormat.format(dataFormatoHumano);
            preStm1.setDate(1, new Date(simpleDateFormat.parse(dataBanco).getTime()));
            int qtd1 = preStm1.executeUpdate();

            if (qtd > 0 && qtd1 > 0) {

            } else {
                System.out.println("n\u00e3o foi poss�vel salvar no banco");
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
            PreparedStatement preStm = CONEXAO.prepareStatement("" +
                    "update pessoa set nome = ?,telefone = ? where cpf = ?");
            preStm.setString(1, entidade.getNome());
            preStm.setString(2, entidade.getTelefone());
            preStm.setString(3, entidade.getCPF());
            int qtd = preStm.executeUpdate();
            if (qtd > 0) {
            } else {
                System.out.println("N\u00e3o foi poss�vel atualizar no banco");
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
            PreparedStatement preStm = CONEXAO.prepareStatement("" +
                    "delete from cliente where cpf=?");
            preStm.setString(1, entidade.getCPF());
            int qtd = preStm.executeUpdate();

            PreparedStatement preStm1 = CONEXAO.prepareStatement("" +
                    "delete from pessoa where cpf=?");
            preStm.setString(1, entidade.getCPF());
            int qtd1 = preStm1.executeUpdate();


            if (qtd > 0 && qtd1 > 0) {
            } else {
                System.out.println("N\u00e3o foi poss�vel deletar no banco");
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
            preStm = CONEXAO.prepareStatement("select pessoa.*, cliente.datadecadastro from pessoa,cliente WHERE pessoa.cpf = cliente.cpf AND cliente.cpf = ?  ; ");
            preStm.setString(1, chave);
            ResultSet resultado = preStm.executeQuery();
            while (resultado.next()) {
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

    public Cliente buscarPorNome(String chave) {
        PreparedStatement preStm;
        try {
            preStm = CONEXAO.prepareStatement("select pessoa.*, cliente.datadecadastro from pessoa,cliente WHERE pessoa.cpf = cliente.cpf AND pessoa.nome = ?  ; ");
            preStm.setString(1, chave);
            ResultSet resultado = preStm.executeQuery();
            while (resultado.next()) {

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
        ArrayList<Cliente> lista = new ArrayList<>();
        try {
            preStm = CONEXAO.prepareStatement("select pessoa.*,cliente.datadecadastro from pessoa,cliente where pessoa.cpf = cliente.cpf order by pessoa.cpf asc ");
            ResultSet resultado = preStm.executeQuery();
            while (resultado.next()) {
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
