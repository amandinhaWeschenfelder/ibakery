///**
//NOME: Luana Kuntz e Amanda Weschenfelder
//TURMA: INF4AT
//DATA: 16/02/2022
// */
//package model;
//
//import factory.Conector;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//
//public class ItensOperacaoDAO {
//
//    private final Connection con;
//
//    public ItensOperacaoDAO() {
//        this.con = Conector.getConnection();
//    }
//
//    public int inserir(Estados estado) { //INSERIR
//        PreparedStatement stmt = null;
//        try {
//            try {
//                con.setAutoCommit(false);
//                String sql = "INSERT INTO estados (nome) VALUES (?)";
//                stmt = con.prepareStatement(sql);
//                stmt.setString(1, estado.getNome());
//
//                stmt.execute();
//                con.commit();
//                return -1;
//            } catch (SQLException e) {
//                try {
//                    con.rollback();
//                    return e.getErrorCode();
//                } catch (SQLException ex) {
//                    return ex.getErrorCode();
//                }
//            }
//        } finally {
//            try {
//                stmt.close();
//                con.setAutoCommit(true);
//                con.close();
//            } catch (SQLException e) {
//                return e.getErrorCode();
//            }
//        }
//    }
//
//    public int excluir(Estados estado) { //EXCLUIR
//        PreparedStatement stmt = null;
//        try {
//            try {
//                con.setAutoCommit(false);
//                String sql = "DELETE FROM estados WHERE id = ?";
//                stmt = con.prepareStatement(sql);
//                stmt.setInt(1, estado.getId());
//
//                stmt.execute();
//                con.commit();
//                return -1;
//            } catch (SQLException e) {
//                try {
//                    con.rollback();
//                    return e.getErrorCode();
//                } catch (SQLException ex) {
//                    return ex.getErrorCode();
//                }
//            }
//        } finally {
//            try {
//                stmt.close();
//                con.setAutoCommit(true);
//                con.close();
//            } catch (SQLException e) {
//                return e.getErrorCode();
//            }
//        }
//    }
//
//    public int alterar(Estados estado) { //ALTERAR
//        PreparedStatement stmt = null;
//        try {
//            try {
//                con.setAutoCommit(false); // aceita poder voltar no commit
//                String sql = "UPDATE estados SET nome = ? WHERE id = ?";
//                stmt = con.prepareStatement(sql);
//                stmt.setString(1, estado.getNome());
//                stmt.setInt(2, estado.getId());
//
//                stmt.execute();
//                con.commit();
//                return -1;
//            } catch (SQLException e) {
//                try {
//                    con.rollback();
//                    return e.getErrorCode();
//                } catch (SQLException ex) {
//                    return ex.getErrorCode();
//                }
//            }
//        } finally {
//            try {
//                stmt.close();
//                con.setAutoCommit(true);
//                con.close();
//            } catch (SQLException e) {
//                return e.getErrorCode();
//            }
//        }
//    }
//
//    public ArrayList<Estados> getListaEstados() { // CONSULTAR
//        Statement stmt;
//        ArrayList<Estados> listaEstados = new ArrayList<>();
//        try {
//            stmt = con.createStatement();
//            try ( ResultSet res = stmt.executeQuery("SELECT * FROM estados")) {
//                while (res.next()) {
//                    Estados estado = new Estados(res.getInt("id"), res.getString("nome"));
//                    listaEstados.add(estado);
//                }
//            }
//            stmt.close();
//            con.close();
//            return listaEstados;
//        } catch (SQLException e) {
//            System.out.println(e.getErrorCode() + "" + e.getMessage());
//            return null;
//        }
//    }
//
//    public ArrayList<Estados> getListaEstadosNome(String nome) {
//        Statement stmt;
//        ArrayList<Estados> listaEstados = new ArrayList<>();
//        try {
//            stmt = con.createStatement();
//            try ( ResultSet res = stmt.executeQuery("SELECT * FROM estados WHERE estados.nome LIKE '%" + nome + "%'")) {
//                while (res.next()) {
//                    Estados estado = new Estados(res.getInt("id"), res.getString("nome"));
//                    listaEstados.add(estado);
//                }
//            }
//            stmt.close();
//            con.close();
//            return listaEstados;
//        } catch (SQLException e) {
//            System.out.println(e.getErrorCode() + "" + e.getMessage());
//            return null;
//        }
//    }
//}
//
//}
