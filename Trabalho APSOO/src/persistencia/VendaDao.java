package persistencia;


import dominio.Cliente;
import dominio.Venda;
import dominio.Vendedor;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class VendaDao implements InterfaceDAO<Venda, Integer> {

    private final Connection CONEXAO;

    public VendaDao(Connection connection) {
        CONEXAO = connection;
    }

    @Override
    public void inserir(Venda entidade) {
        try {
            PreparedStatement preStm = CONEXAO.prepareStatement("" +
                    "insert into venda(desconto,cpfcliente,cpfvendedor, formapagamento,datadavenda) values(?,?,?,?,?)");
            preStm.setString(3, entidade.getVendedor().getCPF());
            preStm.setString(2, entidade.getCliente().getCPF());
            preStm.setInt(1, entidade.getDesconto());
            preStm.setString(4, entidade.getFormaPagamento());
            DateFormat datanormal = new SimpleDateFormat("dd/MM/yyyy");
            Date dataFormatoHumano = new Date(datanormal.parse(entidade.getDatavenda()).getTime());

            DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dataBanco = simpleDateFormat.format(dataFormatoHumano);
            preStm.setDate(5, new Date(simpleDateFormat.parse(dataBanco).getTime()));

            int qtd = preStm.executeUpdate();

            PreparedStatement preStmt = CONEXAO.prepareStatement(
                    " select codigodavenda from venda where codigodavenda = (SELECT MAX(codigodavenda) FROM venda)");
            ResultSet resultado = preStmt.executeQuery();
            while (resultado.next()) {

                entidade.setCodigo(resultado.getInt("codigodavenda"));
            }
            if (qtd > 0) {

            } else {
                System.out.println("n\u00e3o foi possivel salvar no banco");
            }
        } catch (SQLException | ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Venda entidade) {
        /*
        try {
            PreparedStatement preStm=conexao.prepareStatement("" +
                    "update venda set desconto = ? where codigodavenda = ?");
            preStm.setInt(2, entidade.getCodigo());
            preStm.setInt(1, entidade.getDesconto());
            int qtd=preStm.executeUpdate();
            if(qtd>0){
                System.out.println("Atualizado no banco");
            }else{
                System.out.println("Não foi possivel atualizar no banco");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/

    }

    @Override
    public void deletar(Venda entidade) {
/*
        try {
            PreparedStatement preStm1=conexao.prepareStatement("" +
                    "update sapato set quantidade = sapato.quantidade + 1 FROM itemvenda,venda  WHERE sapato.codigobarras = itemvenda.codigobarras AND itemvenda.codigovenda = venda.codigodavenda AND venda.codigodavenda = ? ");
            preStm1.setInt(1, entidade.getCodigo());
            int qtd1;
            int qtd2;
            int qtd3;
            PreparedStatement preStm2=conexao.prepareStatement("" +"delete from itemvenda where codigovenda = ?");

            preStm2.setInt(1, entidade.getCodigo());
            PreparedStatement preStm3=conexao.prepareStatement("" +
                    "delete from venda where codigodavenda=?");

            preStm3.setInt(1, entidade.getCodigo());
            qtd1 =preStm1.executeUpdate();
            qtd2 =preStm2.executeUpdate();
            qtd3 =preStm3.executeUpdate();
            if(qtd1>0 && qtd2> 0 && qtd3>0 ){
                System.out.println("Deletado do banco");
            }else if (qtd1 == 0 && qtd2 ==  0 && qtd3>0){
                System.out.println("Deletado do banco");
            } else {
                System.out.println("Falha no banco. Verificar tabelas");
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/

    }


    @Override
    public Venda buscarPorCodigo(Integer chave) {
        PreparedStatement preStm;
        try {
            preStm = CONEXAO.prepareStatement("select * from venda where codigodavenda=? ");
            preStm.setInt(1, chave);
            ResultSet resultado = preStm.executeQuery();
            while (resultado.next()) {
                //System.out.println(resultado.getString("nome"));
                Venda venda = new Venda();
                venda.setCodigo(resultado.getInt("codigodavenda"));
                Cliente cliente = new Cliente();
                venda.setCliente(cliente);
                venda.getCliente().setCPF(resultado.getString("cpfcliente"));
                Vendedor vendedor = new Vendedor();
                venda.setVendedor(vendedor);
                venda.getVendedor().setCPF(resultado.getString("cpfvendedor"));
                venda.setDesconto(resultado.getInt("desconto"));
                venda.setFormaPagamento(resultado.getString("formapagamento"));
                Date data = resultado.getDate("datadavenda");
                SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy");
                venda.setDatavenda(formatarDate.format(data));
                return venda;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Venda> listaTodos() {
        PreparedStatement preStm;
        ArrayList<Venda> lista = new ArrayList<>();
        try {
            preStm = CONEXAO.prepareStatement("select * from venda order by codigodavenda asc ");
            ResultSet resultado = preStm.executeQuery();
            while (resultado.next()) {
                //System.out.println(resultado.getString("nome"));
                Venda venda = new Venda();
                venda.setCodigo(resultado.getInt("codigodavenda"));
                Cliente cliente = new Cliente();
                venda.setCliente(cliente);
                venda.getCliente().setCPF(resultado.getString("cpfcliente"));
                Vendedor vendedor = new Vendedor();
                venda.setVendedor(vendedor);
                venda.getVendedor().setCPF(resultado.getString("cpfvendedor"));
                venda.setDesconto(resultado.getInt("desconto"));
                venda.setFormaPagamento(resultado.getString("formapagamento"));
                venda.setDatavenda(resultado.getString("datadavenda"));
                lista.add(venda);
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

            preStm = CONEXAO.prepareStatement("select codigodavenda from venda where codigodavenda = (SELECT MAX(codigodavenda) FROM venda);");
            ResultSet resultado = preStm.executeQuery();
            while (resultado.next()) {

                codigo = resultado.getInt("codigodavenda");
                return codigo;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return codigo;
    }

}
