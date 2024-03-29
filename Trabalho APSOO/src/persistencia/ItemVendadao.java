package persistencia;

import dominio.ItemVenda;
import dominio.Sapato;
import dominio.Venda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//conecta no banco
public class ItemVendadao implements InterfaceDAO<ItemVenda,Integer> {
    private final Connection CONEXAO;
    private final SapatoDao SAPATO_DAO;
    public ItemVendadao(Connection connection) throws Exception{
        CONEXAO =connection;
        SAPATO_DAO = new SapatoDao(CONEXAO);
    }
//inser��o do item venda no banco
    @Override
    public void inserir(ItemVenda entidade) {
        try {
            PreparedStatement preStm= CONEXAO.prepareStatement("" +
                    "insert into itemvenda(codigovenda,codigobarras,valorunitario) values(?,?,?)");
            preStm.setInt(1, entidade.getVenda().getCodigo());
            preStm.setDouble(2, entidade.getSapato().getCodigoDeBarras());
            preStm.setDouble(3, entidade.getValorUnitario());


            int qtd=preStm.executeUpdate();
            if(qtd>0){


                SAPATO_DAO.atualizar(SAPATO_DAO.buscarPorCodigo(entidade.getSapato().getCodigoDeBarras()));
            }else{
                System.out.println("n\u00e3o foi possivel salvar no banco");
            }

        } catch (SQLException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
//atualizar
    @Override
    public void atualizar(ItemVenda entidade) {
        try {
            PreparedStatement preStm= CONEXAO.prepareStatement("" +
                    "update itemvenda set codigobarras = ? where codigoitemvenda = ?");
            preStm.setInt(2, entidade.getCodigoItemVenda());
            preStm.setDouble(1, entidade.getSapato().getCodigoDeBarras());
            int qtd=preStm.executeUpdate();
            if(qtd>0){

            }else{
                System.out.println("N\u00e3o foi possivel atualizar no banco");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
//deletar no banco
    @Override
    public void deletar(ItemVenda entidade) {
        try {
            SAPATO_DAO.atualizarMais(SAPATO_DAO.buscarPorCodigo(entidade.getSapato().getCodigoDeBarras()));
             PreparedStatement preStmt= CONEXAO.prepareStatement("" +
                    "delete from itemvenda where codigoitemvenda=?");

            preStmt.setInt(1, entidade.getCodigoItemVenda());
            int qtd=preStmt.executeUpdate();
            if(qtd>0 ){

            }else{
                System.out.println("N\u00e3o foi possivel deletar no banco");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
//buscar no banco pela chave primaria
    @Override
    public ItemVenda buscarPorCodigo(Integer chave) {
        PreparedStatement preStm;
        try {
            preStm = CONEXAO.prepareStatement("select * from itemvenda where codigoitemvenda=? ");
            preStm.setInt(1, chave);
            ResultSet resultado = preStm.executeQuery();
            while(resultado.next()){

                ItemVenda item = new ItemVenda();
                item.setCodigoItemVenda(resultado.getInt("codigoitemvenda"));
                Sapato sapato = new Sapato();
                item.setSapato(sapato);
                item.getSapato().setCodigoDeBarras(resultado.getDouble("codigobarras"));
                item.setValorUnitario(resultado.getDouble("valorunitario"));

                Venda venda = new Venda();
                item.setVenda(venda);
                item.getVenda().setCodigo(resultado.getInt("codigovenda"));
                return item;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
//listar os relacionados � venda dada
    @Override
    public ArrayList<ItemVenda> listaTodos() {
        PreparedStatement preStm;
        ArrayList<ItemVenda> lista= new ArrayList<>();
        try {
            preStm = CONEXAO.prepareStatement("select distinct itemvenda.codigoitemvenda,itemvenda.codigovenda,itemvenda.codigobarras, itemvenda.valorunitario from itemvenda  INNER JOIN venda on itemvenda.codigovenda =(SELECT MAX(codigodavenda) FROM venda)");

            ResultSet resultado=preStm.executeQuery();
            while(resultado.next()){
                ItemVenda item = new ItemVenda();
                item.setCodigoItemVenda(resultado.getInt("codigoitemvenda"));
                Sapato sapato = new Sapato();
                item.setSapato(sapato);
                item.getSapato().setCodigoDeBarras(resultado.getDouble("codigobarras"));
                item.setValorUnitario(resultado.getDouble("valorunitario"));

                Venda venda = new Venda();
                item.setVenda(venda);
                item.getVenda().setCodigo(resultado.getInt("codigovenda"));
                lista.add(item);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return lista;

    }
    public ArrayList<ItemVenda> listaTodosDeVenda(int codigo) {
        PreparedStatement preStm;
        ArrayList<ItemVenda> lista= new ArrayList<>();
        try {
            preStm = CONEXAO.prepareStatement("select distinct itemvenda.codigoitemvenda,itemvenda.codigovenda,itemvenda.codigobarras, itemvenda.valorunitario from itemvenda  INNER JOIN venda on itemvenda.codigovenda =venda.codigodavenda WHERE venda.codigodavenda =? ");

            preStm.setInt(1, codigo);
            ResultSet resultado=preStm.executeQuery();
            while(resultado.next()){
                ItemVenda item = new ItemVenda();
                item.setCodigoItemVenda(resultado.getInt("codigoitemvenda"));
                Sapato sapato = new Sapato();
                item.setSapato(sapato);
                item.getSapato().setCodigoDeBarras(resultado.getDouble("codigobarras"));
                item.setValorUnitario(resultado.getDouble("valorunitario"));

                Venda venda = new Venda();
                item.setVenda(venda);
                item.getVenda().setCodigo(resultado.getInt("codigovenda"));
                lista.add(item);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return lista;

    }


}
