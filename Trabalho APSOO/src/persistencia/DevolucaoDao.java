package persistencia;

import dominio.Devolucao;
import dominio.Venda;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DevolucaoDao implements InterfaceDAO<Devolucao,Integer> {
    private final Connection conexao;
    public DevolucaoDao(Connection connection) {
        this.conexao=connection;
    }
    @Override
    public void inserir(Devolucao entidade) {
        try {
            PreparedStatement preStm=conexao.prepareStatement("" +
                    "insert into devolucao(datadevolucao,codigovenda) values(?,?)");
            preStm.setInt(2, entidade.getVenda().getCodigo());

            DateFormat datanormal = new SimpleDateFormat("dd/MM/yyyy");
            Date dataFormatoHumano = new Date(datanormal.parse(entidade.getDataDevolucao()).getTime());

            DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dataBanco = simpleDateFormat.format(dataFormatoHumano);


            preStm.setDate(1, new Date(simpleDateFormat.parse(dataBanco).getTime()) );

            int qtd=preStm.executeUpdate();

            PreparedStatement preStmt=conexao.prepareStatement(
                    " select codigodevolucao from devolucao where codigodevolucao = (SELECT MAX(codigodevolucao) FROM devolucao)");
            ResultSet resultado=preStmt.executeQuery();
            while(resultado.next()){

                entidade.setCodigoDaDevolucao(resultado.getInt("codigodevolucao"));}
            if(qtd>0){
                System.out.println("Salvo no banco");
            }else{
                System.out.println("não foi possivel salvar no banco");
            }
        } catch (SQLException | ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void atualizar(Devolucao entidade) {

    }

    @Override
    public void deletar(Devolucao entidade) {

    }

    @Override
    public Devolucao buscarPorCodigo(Integer chave) {
        PreparedStatement preStm;
        try {
            preStm = conexao.prepareStatement("select * from devolucao where codigodevolucao =? ");
            preStm.setInt(1, chave);
            ResultSet resultado=preStm.executeQuery();
            while(resultado.next()){

                Devolucao devolucao = new Devolucao();
                devolucao.setCodigoDaDevolucao(resultado.getInt("codigodevolucao"));
                Venda venda  = new Venda();
                devolucao.setVenda(venda);
                devolucao.getVenda().setCodigo(resultado.getInt("codigovenda"));
                Date data =resultado.getDate("datadevolucao");
                SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy");
                devolucao.setDataDevolucao(formatarDate.format(data));

                return devolucao;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Devolucao> listaTodos() {
        PreparedStatement preStm;
        ArrayList<Devolucao> lista= new ArrayList<>();
        try {
            preStm = conexao.prepareStatement("select * from devolucao order by codigodevolucao asc ");
            ResultSet resultado=preStm.executeQuery();
            while(resultado.next()){
                Devolucao devolucao = new Devolucao();
                devolucao.setCodigoDaDevolucao(resultado.getInt("codigodevolucao"));
                Venda venda  = new Venda();
                devolucao.setVenda(venda);
                devolucao.getVenda().setCodigo(resultado.getInt("codigovenda"));
                devolucao.setDataDevolucao(resultado.getString("datadevolucao"));
                lista.add(devolucao);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return lista;
    }
    public int buscarCodigo() {
        int codigo = 0;

        PreparedStatement preStm;
        try {

            preStm = conexao.prepareStatement("select codigodevolucao from devolucao where codigodevolucao = (SELECT MAX(codigodevolucao) FROM devolucao);");
            ResultSet resultado=preStm.executeQuery();
            while(resultado.next()){

                codigo = resultado.getInt("codigodevolucao");
                return codigo;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return codigo;
    }
}
