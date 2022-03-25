/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import modelDominio.Bike;
import factory.Conector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelDominio.Marca;

/**
 * Classe responsável pelo Data Access Object. Tem os métodos que incluem,
 * alteram, excluem e selecionam do banco
 *
 * @author herrmann
 */
public class BikeDao {

    private Connection con;

    public BikeDao() {
        con = Conector.getConnection();
    }

    // -1 é por que tudo está OK
    // != -1 é por que deu ERRO
    public int inserir(Bike bk) {
        //vai receber o script SQL de INSERT 
        PreparedStatement stmt = null;
        try {
            try {
                // desliga o autocommit
                con.setAutoCommit(false);
                String sql = "insert into bike (modelo,codmarca,preco,imagem) values (?,?,?,?)";
                stmt = con.prepareStatement(sql);
                //substituir os ? do script SQL
                stmt.setString(1, bk.getModelo());
                stmt.setInt(2, bk.getMarca().getCodmarca());
                stmt.setDouble(3, bk.getPreco());
                stmt.setBytes(4, bk.getImagem());
                //executar o SCRIPT SQL
                stmt.execute();
                //efetivar a transação
                con.commit();
                return -1; // <- indica que tudo deu CERTO
            } catch (SQLException e) {
                try {
                    con.rollback(); // cancelando a transação 
                    e.printStackTrace();
                    return e.getErrorCode(); // devolvendo o erro
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    return ex.getErrorCode();
                }
            }
        } finally {// isto será executado dando ERRO ou NÃO
            try {
                stmt.close();
                con.setAutoCommit(true);
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return e.getErrorCode();
            }
        }
    }

    public int excluir(Bike bk) {
        //vai receber o script SQL de INSERT 
        PreparedStatement stmt = null;
        try {
            try {
                // desliga o autocommit
                con.setAutoCommit(false);
                // o ? será substituído pelo valor
                String sql = "delete from bike where codbike = ? ";
                stmt = con.prepareStatement(sql);
                //substituir os ? do script SQL
                stmt.setInt(1, bk.getCodBike());
                
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

    public int alterar(Bike bk) {
        //vai receber o script SQL de INSERT 
        PreparedStatement stmt = null;
        try {
            try {
                // desliga o autocommit
                con.setAutoCommit(false);
                // o ? será substituído pelo valor
                String sql = "update bike set preco = ?, modelo = ?, codmarca = ?, imagem = ? where codbike = ?";
                stmt = con.prepareStatement(sql);
                //substituir os ? do script SQL
                stmt.setDouble(1, bk.getPreco());
                stmt.setString(2, bk.getModelo());
                stmt.setInt(3, bk.getMarca().getCodmarca());
                stmt.setBytes(4, bk.getImagem());
                stmt.setInt(5, bk.getCodBike());
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

    public ArrayList<Bike> getListaBikes() {
        Statement stmt = null; // usado para rodar SQL
        ArrayList<Bike> listaBikes = new ArrayList<Bike>();

        try {
            // cria o objeto para rodar o SQL
            stmt = con.createStatement();
            // passando a string SQL que faz o SELECT
            ResultSet res = stmt.executeQuery(" select bike.*, marca.nomemarca from bike "+
                                              " inner join marca on (marca.codmarca = bike.codmarca) "+
                                              " order by bike.codbike ");

            // Pebkorrendo o resultado - res
            while (res.next()) {
                // criando o objeto de gastomensal pegando dados do res.
                Bike bk = new Bike(res.getInt("codbike"),
                        res.getString("modelo"),
                        new Marca(res.getInt("codmarca"),res.getString("nomemarca")),
                        res.getFloat("preco"),
                        res.getBytes("imagem"));
                // adicionando na lista auxiliar
                listaBikes.add(bk);
            }
            res.close();// fechando o resultado
            stmt.close();// fechando statment
            con.close(); // fechando conexão com o banco
            return listaBikes; // retornando a lista de gastomensals
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
