package persistencia;

import dominio.Devolucao;
import dominio.ItemDevolucao;
import dominio.Sapato;
import dominio.Venda;

import java.sql.*;
import java.util.ArrayList;

public class ItemDevolucaoDao implements InterfaceDAO<ItemDevolucao, Integer> {
    private final Connection CONEXAO;
    private final SapatoDao SAPATO_DAO;

    public ItemDevolucaoDao(Connection connection) throws Exception {
        this.CONEXAO = connection;
        SAPATO_DAO = new SapatoDao(CONEXAO);
    }

    @Override
    public void inserir(ItemDevolucao entidade) {

        try {
            PreparedStatement preStm = CONEXAO.prepareStatement("" +
                    "insert into itemdevolucao(codigodevolucao,codigovenda,codigobarras,valorunitario) values(?,?,?,?)");
            preStm.setInt(1, entidade.getDevolucao().getCodigoDaDevolucao());
            preStm.setInt(2, entidade.getDevolucao().getVenda().getCodigo());
            preStm.setDouble(3, entidade.getSapato().getCodigoDeBarras());
            preStm.setDouble(4, entidade.getValorUnitario());


            int qtd = preStm.executeUpdate();
            if (qtd > 0) {

                SAPATO_DAO.atualizarMais(SAPATO_DAO.buscarPorCodigo(entidade.getSapato().getCodigoDeBarras()));
            } else {
                System.out.println("n�o foi possivel salvar no banco");
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void atualizar(ItemDevolucao entidade) {
        try {
            PreparedStatement preStm = CONEXAO.prepareStatement("" +
                    "update itemdevolucao set codigobarras = ? where codiigoitemdevolucao = ?");
            preStm.setInt(2, entidade.getCodigoItemDevolucao());
            preStm.setDouble(1, entidade.getSapato().getCodigoDeBarras());
            int qtd = preStm.executeUpdate();
            if (qtd > 0) {

            } else {
                System.out.println("N\u00e3o foi possivel atualizar no banco");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void deletar(ItemDevolucao entidade) {
        try {
            SAPATO_DAO.atualizar(SAPATO_DAO.buscarPorCodigo(entidade.getSapato().getCodigoDeBarras()));
            PreparedStatement preStmt = CONEXAO.prepareStatement("" +
                    "delete from itemdevolucao where codigoitemdevolucao=?");

            preStmt.setInt(1, entidade.getCodigoItemDevolucao());
            int qtd = preStmt.executeUpdate();
            if (qtd > 0) {

            } else {
                System.out.println("N\u00e3o foi possivel deletar no banco");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public ItemDevolucao checaChave(Integer venda, double codigo) {
        PreparedStatement preStm;
        try {
            preStm = CONEXAO.prepareStatement("select * from itemdevolucao where codigovenda=? AND codigobarras =? ");
            preStm.setInt(1, venda);
            preStm.setDouble(2, codigo);
            ResultSet resultado = preStm.executeQuery();
            while (resultado.next()) {

                ItemDevolucao item = new ItemDevolucao();
                item.setCodigoItemDevolucao(resultado.getInt("codigoitemdevolucao"));
                Sapato sapato = new Sapato();
                item.setSapato(sapato);
                item.getSapato().setCodigoDeBarras(resultado.getDouble("codigobarras"));
                item.setValorUnitario(resultado.getDouble("valorunitario"));
                Devolucao dev = new Devolucao();
                Venda venda2 = new Venda();
                dev.setVenda(venda2);
                item.setDevolucao(dev);
                item.getDevolucao().getVenda().setCodigo(resultado.getInt("codigovenda"));
                return item;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public ItemDevolucao buscarPorCodigo(Integer chave) {
        PreparedStatement preStm;
        try {
            preStm = CONEXAO.prepareStatement("select * from itemdevolucao where codigoitemdevolucao=? ");
            preStm.setInt(1, chave);
            ResultSet resultado = preStm.executeQuery();
            while (resultado.next()) {

                ItemDevolucao item = new ItemDevolucao();
                item.setCodigoItemDevolucao(resultado.getInt("codigoitemdevolucao"));
                Sapato sapato = new Sapato();
                item.setSapato(sapato);
                item.getSapato().setCodigoDeBarras(resultado.getDouble("codigobarras"));
                item.setValorUnitario(resultado.getDouble("valorunitario"));
                Devolucao dev = new Devolucao();
                Venda venda = new Venda();
                dev.setVenda(venda);
                item.setDevolucao(dev);
                item.getDevolucao().getVenda().setCodigo(resultado.getInt("codigovenda"));
                return item;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<ItemDevolucao> listaTodos() {
        PreparedStatement preStm;
        ArrayList<ItemDevolucao> lista = new ArrayList<>();
        try {
            preStm = CONEXAO.prepareStatement("select distinct itemdevolucao.codigoitemdevolucao,itemdevolucao.codigovenda,itemdevolucao.codigobarras, itemdevolucao.valorunitario from itemdevolucao  INNER JOIN devolucao on itemdevolucao.codigodevolucao =(SELECT MAX(codigodevolucao) FROM devolucao)");
            ResultSet resultado = preStm.executeQuery();
            while (resultado.next()) {
                ItemDevolucao item = new ItemDevolucao();
                item.setCodigoItemDevolucao(resultado.getInt("codigoitemdevolucao"));
                Sapato sapato = new Sapato();
                item.setSapato(sapato);
                item.getSapato().setCodigoDeBarras(resultado.getDouble("codigobarras"));
                item.setValorUnitario(resultado.getDouble("valorunitario"));
                Devolucao dev = new Devolucao();
                Venda venda = new Venda();
                dev.setVenda(venda);
                item.setDevolucao(dev);
                item.getDevolucao().getVenda().setCodigo(resultado.getInt("codigovenda"));
                lista.add(item);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return lista;

    }
}

