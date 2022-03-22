/**
NOME: Luana Kuntz e Amanda Weschenfelder
TURMA: INF4AT
DATA: 16/02/2022
*/
package model;

import factory.Conector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelDominio.Operacao;

public class OperacaoDAO {
    
    private final Connection con;

    public OperacaoDAO() {
        this.con = Conector.getConnection();
    }

    public int inserirCaixa(Operacao operacao) { //INSERIR VENDA (CAIXA)
        PreparedStatement stmt = null;
        try {
            try {
                con.setAutoCommit(false);
                String sql = "INSERT INTO operacao (valorTotal, idUsuario, tipoOperacao) VALUES (?, ?, ?)";
                stmt = con.prepareStatement(sql);
                stmt.setFloat(1, operacao.getValorTotal());
                stmt.setInt(2, operacao.getIdUsuario().getIdUsuario());
                stmt.setInt(3, operacao.getTipoOperacao());

                stmt.execute();
                con.commit();
                return -1;
            } catch (SQLException e) {
                try {
                    con.rollback();
                    return e.getErrorCode();
                } catch (SQLException ex) {
                    return ex.getErrorCode();
                }
            }
        } finally {
            try {
                stmt.close();
                con.setAutoCommit(true);
                con.close();
            } catch (SQLException e) {
                return e.getErrorCode();
            }
        }
    }
    
    public int inserirEncomenda(Operacao operacao) { //INSERIR ENCOMENDA (CLIENTE)
        PreparedStatement stmt = null;
        try {
            try {
                con.setAutoCommit(false);
                String sql = "INSERT INTO operacao (dataRetirada, horaRetirada, valorTotal, idUsuario, tipoOperacao) VALUES (?, ?, ?, ?, ?)";
                stmt = con.prepareStatement(sql);
                stmt.setDate(1, new java.sql.Date(operacao.getDataRetirada().getTime()));
                //stmt.setTime(2, new java.sql.Time(operacao.getHoraRetirada()));             
                //stmt.setTime(2, new java.sql.Time(operacao.getHoraRetirada()));             
                stmt.setFloat(3, operacao.getValorTotal());
                stmt.setInt(4, operacao.getIdUsuario().getIdUsuario());
                stmt.setInt(5, operacao.getTipoOperacao());

                stmt.execute();
                con.commit();
                return -1;
            } catch (SQLException e) {
                try {
                    con.rollback();
                    return e.getErrorCode();
                } catch (SQLException ex) {
                    return ex.getErrorCode();
                }
            }
        } finally {
            try {
                stmt.close();
                con.setAutoCommit(true);
                con.close();
            } catch (SQLException e) {
                return e.getErrorCode();
            }
        }
    }

//    public ArrayList<Operacao> getListaOperacao() { // CONSULTAR LISTA 
//        Statement stmt;
//        ArrayList<Operacao> listaOperacao = new ArrayList<>();
//        try {
//            stmt = con.createStatement();
//            try ( ResultSet res = stmt.executeQuery("SELECT * FROM operacao")) {
//                while (res.next()) {
//                    Operacao operacao = new Operacao(res.getInt("id"), res.getInt("idUsuario"), res.getFloat("valorTotal"), res.getDate("data"));
//                    listaOperacao.add(operacao);
//                }
//            }
//            stmt.close();
//            con.close();
//            return listaOperacao;
//        } catch (SQLException e) {
//            System.out.println(e.getErrorCode() + "" + e.getMessage());
//            return null;
//        }
//    }
//
//    public ArrayList<Produto> getListaProdutosNome(String nome) {
//        Statement stmt;
//        ArrayList<Produto> listaProdutos = new ArrayList<>();
//        try {
//            stmt = con.createStatement();
//            try ( ResultSet res = stmt.executeQuery("SELECT * FROM produto WHERE produto.nome LIKE '%" + nome + "%'")) {
//                while (res.next()) {
//                    Produto produto = new Produto(res.getInt("id"), res.getString("nome"));
//                    listaProdutos.add(produto);
//                }
//            }
//            stmt.close();
//            con.close();
//            return listaProdutos;
//        } catch (SQLException e) {
//            System.out.println(e.getErrorCode() + "" + e.getMessage());
//            return null;
//        }
//    }
}