package persistencia;

import dominio.Vendedor;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class VendedorDao implements InterfaceDAO<Vendedor, String> {
    private final Connection CONEXAO;

    public VendedorDao(Connection connection) {
        CONEXAO = connection;
    }

    //insere em três tabelas as informações do vendedor
    @Override
    public void inserir(Vendedor entidade) {
        try {
            int qtd;
            PreparedStatement preStm = CONEXAO.prepareStatement("" +
                    "insert into pessoa(cpf,nome,endereco,estado,cidade,email,telefone) values(?,?,?,?,?,?,?)");
            preStm.setString(1, entidade.getCPF());
            preStm.setString(2, entidade.getNome());
            preStm.setString(3, entidade.getEndereco());
            preStm.setString(4, entidade.getEstado());
            preStm.setString(5, entidade.getCidade());
            preStm.setString(6, entidade.getEmail());
            preStm.setString(7, entidade.getTelefone());


            PreparedStatement preStm1 = CONEXAO.prepareStatement("" +
                    "insert into usuario(cpf,login,datacontratacao) values(?,?,?)");
            preStm1.setString(1, entidade.getCPF());
            preStm1.setString(2, entidade.getLogin());
            DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            preStm1.setDate(3, new Date(simpleDateFormat.parse(entidade.getDataContratacao()).getTime()));


            PreparedStatement preStm2 = CONEXAO.prepareStatement("" +
                    "insert into vendedor(cpf,comissao,permissaovendedor) values(?,?,?)");
            preStm2.setString(1, entidade.getCPF());
            preStm2.setDouble(2, entidade.getComissao());
            preStm2.setBoolean(3, entidade.getPermissaoVendedor());
            qtd = preStm.executeUpdate();
            int qtd1 = preStm1.executeUpdate();
            int qtd2 = preStm2.executeUpdate();

            if (qtd > 0 && qtd1 > 0 && qtd2 > 0) {
                System.out.println("Salvo no banco");
            } else {
                System.out.println("n\u00e3o foi possivel salvar no banco");
            }
        } catch (SQLException | ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Vendedor entidade) {
        try {
            PreparedStatement preStm = CONEXAO.prepareStatement("" +
                    "update pessoa set nome = ?,telefone = ? where cpf = ?");
            preStm.setString(1, entidade.getNome());
            preStm.setString(2, entidade.getTelefone());
            preStm.setString(3, entidade.getCPF());
            int qtd = preStm.executeUpdate();
            if (qtd > 0) {
                System.out.println("Atualizado no banco");
            } else {
                System.out.println("N\u00e3o foi possivel atualizar no banco");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    //apaga das três tabelas as informações do vendedor
    @Override
    public void deletar(Vendedor entidade) {
        try {
            PreparedStatement preStm = CONEXAO.prepareStatement("" +
                    "delete from vendedor where cpf=?");
            preStm.setString(1, entidade.getCPF());
            int qtd = preStm.executeUpdate();
            PreparedStatement preStm1 = CONEXAO.prepareStatement("" +
                    "delete from usuario where cpf=?");
            preStm.setString(1, entidade.getCPF());
            int qtd1 = preStm1.executeUpdate();

            PreparedStatement preStm2 = CONEXAO.prepareStatement("" +
                    "delete from pessoa where cpf=?");
            preStm.setString(1, entidade.getCPF());
            int qtd2 = preStm2.executeUpdate();


            if (qtd > 0 && qtd1 > 0 && qtd2 > 0) {
            } else {
                System.out.println("N\u00e3o foi possivel deletar no banco");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    //buscar no banco pelo código
    @Override
    public Vendedor buscarPorCodigo(String chave) {
        PreparedStatement preStm;
        try {
            preStm = CONEXAO.prepareStatement("select pessoa.*, usuario.login, usuario.datacontratacao, usuario.senha,vendedor.comissao,vendedor.permissaovendedor from pessoa,usuario,vendedor WHERE pessoa.cpf = usuario.cpf AND usuario.cpf = vendedor.cpf AND vendedor.cpf =?; ");
            preStm.setString(1, chave);
            ResultSet resultado = preStm.executeQuery();
            while (resultado.next()) {
                //System.out.println(resultado.getString("nome"));
                Vendedor pessoa = new Vendedor();
                pessoa.setCPF(resultado.getString("cpf"));
                pessoa.setNome(resultado.getString("nome"));
                pessoa.setEndereco(resultado.getString("endereco"));
                pessoa.setEstado(resultado.getString("estado"));
                pessoa.setCidade(resultado.getString("cidade"));
                pessoa.setEmail(resultado.getString("email"));
                pessoa.setTelefone(resultado.getString("telefone"));
                pessoa.setLogin(resultado.getString("login"));
                pessoa.setSenha(resultado.getString("senha"));
                pessoa.setComissao(resultado.getDouble("comissao"));
                pessoa.setDataContratacao(resultado.getString("datacontratacao"));
                pessoa.setPermissaoVendedor(resultado.getBoolean("permissaovendedor"));
                return pessoa;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return null;
    }


    public Vendedor buscarPorNome(String chave) {
        PreparedStatement preStm;
        try {
            preStm = CONEXAO.prepareStatement("select pessoa.*, usuario.login, usuario.datacontratacao, usuario.senha,vendedor.comissao,vendedor.permissaovendedor from pessoa,usuario,vendedor WHERE pessoa.cpf = usuario.cpf AND usuario.cpf = vendedor.cpf AND pessoa.nome =?; ");
            preStm.setString(1, chave);
            ResultSet resultado = preStm.executeQuery();
            while (resultado.next()) {
                //System.out.println(resultado.getString("nome"));
                Vendedor pessoa = new Vendedor();
                pessoa.setCPF(resultado.getString("cpf"));
                pessoa.setNome(resultado.getString("nome"));
                pessoa.setEndereco(resultado.getString("endereco"));
                pessoa.setEstado(resultado.getString("estado"));
                pessoa.setCidade(resultado.getString("cidade"));
                pessoa.setEmail(resultado.getString("email"));
                pessoa.setTelefone(resultado.getString("telefone"));
                pessoa.setLogin(resultado.getString("login"));
                pessoa.setSenha(resultado.getString("senha"));
                pessoa.setComissao(resultado.getDouble("comissao"));
                pessoa.setDataContratacao(resultado.getString("datacontratacao"));
                pessoa.setPermissaoVendedor(resultado.getBoolean("permissaovendedor"));
                return pessoa;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return null;
    }

    // lista todos os vendedores já cadastrados
    @Override
    public ArrayList<Vendedor> listaTodos() {
        PreparedStatement preStm;
        ArrayList<Vendedor> lista = new ArrayList<>();
        try {
            preStm = CONEXAO.prepareStatement("select pessoa.*,usuario.datacontratacao, usuario.login, vendedor.comissao from pessoa,usuario,vendedor WHERE pessoa.cpf = usuario.cpf AND usuario.cpf = vendedor.cpf; ");
            ResultSet resultado = preStm.executeQuery();
            while (resultado.next()) {
                Vendedor pessoa = new Vendedor();
                pessoa.setCPF(resultado.getString("cpf"));
                pessoa.setNome(resultado.getString("nome"));
                pessoa.setEndereco(resultado.getString("endereco"));
                pessoa.setEstado(resultado.getString("estado"));
                pessoa.setCidade(resultado.getString("cidade"));
                pessoa.setEmail(resultado.getString("email"));
                pessoa.setTelefone(resultado.getString("telefone"));
                pessoa.setLogin(resultado.getString("login"));
                pessoa.setDataContratacao(resultado.getString("datacontratacao"));
                pessoa.setComissao(resultado.getDouble("comissao"));
                lista.add(pessoa);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return lista;
    }


}



