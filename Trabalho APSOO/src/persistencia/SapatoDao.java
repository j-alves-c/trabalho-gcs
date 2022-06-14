package persistencia;

import dominio.Sapato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//conecta
public class SapatoDao implements InterfaceDAO<Sapato, Double> {
    private final Connection CONEXAO;

    public SapatoDao(Connection connection) throws Exception {
        CONEXAO = connection;
    }

    //insere no banco
    @Override
    public void inserir(Sapato entidade) {
        try {
            PreparedStatement preStm = CONEXAO.prepareStatement("" +
                    "insert into sapato(codigobarras,numero,modelo, tipo,colecao,marca,preco,quantidade) values(?,?,?,?,?,?,?,?)");
            preStm.setDouble(1, entidade.getCodigoDeBarras());
            preStm.setInt(2, entidade.getNumero());
            preStm.setString(3, entidade.getModelo());
            preStm.setString(4, entidade.getTipo());
            preStm.setString(5, entidade.getColecao());
            preStm.setString(6, entidade.getMarca());
            preStm.setDouble(7, entidade.getPreco());
            preStm.setInt(8, entidade.getQuantidade());


            int qtd = preStm.executeUpdate();
            if (qtd > 0) {
                System.out.println("Salvo no banco");
            } else {
                System.out.println("n�o foi possivel salvar no banco");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //atualiza no caso de venda (diminui um)
    @Override
    public void atualizar(Sapato entidade) {
        try {
            PreparedStatement preStm = CONEXAO.prepareStatement("" +
                    "update sapato set quantidade = sapato.quantidade - 1  WHERE sapato.codigobarras = ?");
            preStm.setDouble(1, entidade.getCodigoDeBarras());

            int qtd = preStm.executeUpdate();
            if (qtd > 0) {
                System.out.println("Sapato atualizado");
            } else {
                System.out.println("N�o foi possivel atualizar no banco");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    public void atualizarMais(Sapato entidade) {
        try {
            PreparedStatement preStm = CONEXAO.prepareStatement("" +
                    "update sapato set quantidade = sapato.quantidade + 1  WHERE sapato.codigobarras = ?");
            preStm.setDouble(1, entidade.getCodigoDeBarras());

            int qtd = preStm.executeUpdate();
            if (qtd > 0) {
                System.out.println("Sapato atualizado");
            } else {
                System.out.println("N�o foi possivel atualizar no banco");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    //deleta
    @Override
    public void deletar(Sapato entidade) {
        try {
            PreparedStatement preStm = CONEXAO.prepareStatement("" +
                    "delete from sapato where codigobarras=?");

            preStm.setDouble(1, entidade.getCodigoDeBarras());
            int qtd = preStm.executeUpdate();
            if (qtd > 0) {
                System.out.println("Deletado do banco");
            } else {
                System.out.println("N�o foi possivel deletar no banco");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //busca
    @Override
    public Sapato buscarPorCodigo(Double chave) {
        PreparedStatement preStm;
        try {
            preStm = CONEXAO.prepareStatement("select * from sapato where codigobarras=? ");
            preStm.setDouble(1, chave);
            ResultSet resultado = preStm.executeQuery();
            while (resultado.next()) {

                Sapato sap = new Sapato();
                sap.setCodigoDeBarras(resultado.getDouble("codigobarras"));
                sap.setNumero(resultado.getInt("numero"));
                sap.setModelo(resultado.getString("modelo"));
                sap.setTipo(resultado.getString("tipo"));
                System.out.println("Encontrado");
                sap.setColecao(resultado.getString("colecao"));
                sap.setMarca(resultado.getString("marca"));
                sap.setPreco(resultado.getDouble("preco"));
                sap.setQuantidade(resultado.getInt("quantidade"));
                return sap;

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    //lista
    @Override
    public ArrayList<Sapato> listaTodos() {
        PreparedStatement preStm;
        ArrayList<Sapato> lista = new ArrayList<>();
        try {
            preStm = CONEXAO.prepareStatement("select * from sapato order by codigobarras asc ");
            ResultSet resultado = preStm.executeQuery();
            while (resultado.next()) {
                Sapato sap = new Sapato();
                sap.setCodigoDeBarras(resultado.getDouble("codigobarras"));
                sap.setNumero(resultado.getInt("numero"));
                sap.setModelo(resultado.getString("modelo"));
                sap.setTipo(resultado.getString("tipo"));

                sap.setColecao(resultado.getString("colecao"));
                sap.setMarca(resultado.getString("marca"));
                sap.setPreco(resultado.getDouble("preco"));
                sap.setQuantidade(resultado.getInt("quantidade"));
                lista.add(sap);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return lista;

    }


}
