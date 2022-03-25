/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import modelDominio.Marca;
import factory.Conector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Classe responsável pelo Data Access Object. Tem os métodos que incluem,
 * alteram, excluem e selecionam do banco
 *
 * @author herrmann
 */
public class MarcaDao {

    private Connection con;

    public MarcaDao() {
        con = Conector.getConnection();
    }

    // -1 é por que tudo está OK
    // != -1 é por que deu ERRO
    public int inserir(Marca rc) {
        //vai receber o script SQL de INSERT 
        PreparedStatement stmt = null;
        try {
            try {
                // desliga o autocommit
                con.setAutoCommit(false);
                // o ? será substituído pelo valor
                String sql = "insert into marca (nomemarca) values (?)";
                stmt = con.prepareStatement(sql);
                //substituir os ? do script SQL
                stmt.setString(1, rc.getNomemarca());

                //executar o SCRIPT SQL
                stmt.execute();
                //efetivar a transação
                con.commit();
                return -1; // <- indica que tudo deu CERTO
            } catch (SQLException e) {
                try {
                    con.rollback(); // cancelando a transação 
                    return e.getErrorCode(); // devolvendo o erro
                } catch (SQLException ex) {
                    return ex.getErrorCode();
                }
            }
        } finally {// isto será executado dando ERRO ou NÃO
            try {
                stmt.close();
                con.setAutoCommit(true);
                con.close();
            } catch (SQLException e) {
                return e.getErrorCode();
            }
        }
    }

    public int excluir(Marca rc) {
        //vai receber o script SQL de INSERT 
        PreparedStatement stmt = null;
        try {
            try {
                // desliga o autocommit
                con.setAutoCommit(false);
                // o ? será substituído pelo valor
                String sql = "delete from marca where codmarca = ?";
                stmt = con.prepareStatement(sql);
                //substituir os ? do script SQL
                stmt.setInt(1, rc.getCodmarca());

                //executar o SCRIPT SQL
                stmt.execute();
                //efetivar a transação
                con.commit();
                return -1; // <- indica que tudo deu CERTO
            } catch (SQLException e) {
                try {
                    con.rollback(); // cancelando a transação 
                    return e.getErrorCode(); // devolvendo o erro
                } catch (SQLException ex) {
                    return ex.getErrorCode();
                }
            }
        } finally {// isto será executado dando ERRO ou NÃO
            try {
                stmt.close();
                con.setAutoCommit(true);
                con.close();
            } catch (SQLException e) {
                return e.getErrorCode();
            }
        }
    }

    public int alterar(Marca rc) {
        //vai receber o script SQL de INSERT 
        PreparedStatement stmt = null;
        try {
            try {
                // desliga o autocommit
                con.setAutoCommit(false);
                // o ? será substituído pelo valor
                String sql = "update marca  set nomemarca = ? where codmarca = ?";
                stmt = con.prepareStatement(sql);
                //substituir os ? do script SQL
                stmt.setString(1, rc.getNomemarca());
                stmt.setInt(2, rc.getCodmarca());

                //executar o SCRIPT SQL
                stmt.execute();
                //efetivar a transação
                con.commit();
                return -1; // <- indica que tudo deu CERTO
            } catch (SQLException e) {
                try {
                    con.rollback(); // cancelando a transação 
                    return e.getErrorCode(); // devolvendo o erro
                } catch (SQLException ex) {
                    return ex.getErrorCode();
                }
            }
        } finally {// isto será executado dando ERRO ou NÃO
            try {
                stmt.close();
                con.setAutoCommit(true);
                con.close();
            } catch (SQLException e) {
                return e.getErrorCode();
            }
        }
    }

    public ArrayList<Marca> getListaMarcas() {
        Statement stmt = null; // usado para rodar SQL
        ArrayList<Marca> listmarcas = new ArrayList<Marca>();

        try {
            // cria o objeto para rodar o SQL
            stmt = con.createStatement();
            // passando a string SQL que faz o SELECT
            ResultSet res = stmt.executeQuery("select * from marca");

            // Percorrendo o resultado - res
            while (res.next()) {
                // criando o objeto de marca pegando dados do res.
                Marca rc = new Marca(res.getInt("codmarca"),
                        res.getString("nomemarca"));
                // adicionando na lista auxiliar
                listmarcas.add(rc);
            }
            res.close();// fechando o resultado
            stmt.close();// fechando statment
            con.close(); // fechando conexão com o banco
            return listmarcas; // retornando a lista de marcas
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + "-" + e.getMessage());
            return null;
        }

    }

    public ArrayList<Marca> getListaMarcasNome(String nome) {
        Statement stmt = null; // usado para rodar SQL
        ArrayList<Marca> listmarcas = new ArrayList<Marca>();

        try {
            // cria o objeto para rodar o SQL
            stmt = con.createStatement();
            // passando a string SQL que faz o SELECT
            ResultSet res = stmt.executeQuery("select * from marca where nomemarca like '%" + nome + "%'");

            // Percorrendo o resultado - res
            while (res.next()) {
                // criando o objeto de marca pegando dados do res.
                Marca rc = new Marca(res.getInt("codmarca"),
                        res.getString("nomemarca"));
                // adicionando na lista auxiliar
                listmarcas.add(rc);
            }
            res.close();// fechando o resultado
            stmt.close();// fechando statment
            con.close(); // fechando conexão com o banco
            return listmarcas; // retornando a lista de marcas
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + "-" + e.getMessage());
            return null;
        }

    }
}
