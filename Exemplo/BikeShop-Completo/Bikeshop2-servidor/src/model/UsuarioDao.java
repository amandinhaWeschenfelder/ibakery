/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import factory.Conector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelDominio.Administrador;
import modelDominio.Bike;
import modelDominio.Comum;
import modelDominio.Usuario;

/**
 *
 * @author herrmann
 */
public class UsuarioDao {
    
    private Connection con;

    public UsuarioDao() {
        con = Conector.getConnection();
    }
    
    
    // -1 é por que tudo está OK
    // != -1 é por que deu ERRO
    public int inserir(Usuario usr) {
        //vai receber o script SQL de INSERT 
        PreparedStatement stmt = null;
        try {
            try {
                // desliga o autocommit
                con.setAutoCommit(false);
                // o ? será substituído pelo valor
                String sql = "insert into usuario (nomeusuario,login,senha,email,tipo) " +
                             " values (?,?,?,?,?) ";
                stmt = con.prepareStatement(sql);
                //substituir os ? do script SQL
                stmt.setString(1, usr.getNomeUsuario());
                stmt.setString(2, usr.getLogin());
                stmt.setString(3, usr.getSenha());
                stmt.setString(4, usr.getEmail());
                // se for tipo Administrador guarda 1 senão guarda 0
                int tipo;
                if (usr instanceof Administrador){
                    tipo = 1;
                }else{
                    tipo = 0;
                }
                //stmt.setInt(5, ((usr instanceof Administrador) ? 1 : 0));
                stmt.setInt(5, tipo);

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

    // -1 é por que tudo está OK
    // != -1 é por que deu ERRO
    public int alterar(Usuario usr) {
        //vai receber o script SQL de INSERT 
        PreparedStatement stmt = null;
        try {
            try {
                // desliga o autocommit
                con.setAutoCommit(false);
                // o ? será substituído pelo valor
                String sql = " update usuario set nomeusuario = ?,"
                            + " login = ?,"
                            + " senha = ?,"
                            + " email = ?,"
                            + "tipo = ? where codusuario = ?";
                stmt = con.prepareStatement(sql);
                //substituir os ? do script SQL
                stmt.setString(1, usr.getNomeUsuario());
                stmt.setString(2, usr.getLogin());
                stmt.setString(3, usr.getSenha());
                stmt.setString(4, usr.getEmail());
                // se for admin guarda 1 senão guarda 0
                int admin;
                if (usr instanceof Administrador){
                    admin = 1;
                }else{
                    admin = 0;
                }
                //stmt.setInt(5, ((usr instanceof Administrador) ? 1 : 0));
                stmt.setInt(5, admin);
                stmt.setInt(6, usr.getCodUsuario());

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
    
    public int excluir(Usuario usr) {
        //vai receber o script SQL de INSERT 
        PreparedStatement stmt = null;
        try {
            try {
                // desliga o autocommit
                con.setAutoCommit(false);
                // o ? será substituído pelo valor
                String sql = "delete from usuario where codusuario = ? ";
                stmt = con.prepareStatement(sql);
                //substituir os ? do script SQL
                stmt.setInt(1, usr.getCodUsuario());
                
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
    
    public Usuario efetuarLogin(Usuario usr) {
        PreparedStatement stmt = null; // usado para rodar SQL
        Usuario usrselecionado = null;
        
        try {
            // passando a string SQL que faz o SELECT
            String sql = " select * from usuario where login = ? and senha = ? ";
            stmt = con.prepareStatement(sql);
            //substituir os ? do script SQL
            stmt.setString(1, usr.getLogin());
            stmt.setString(2, usr.getSenha());
            
            // Executando o select
            ResultSet res = stmt.executeQuery();

            // Pebkorrendo o resultado - res
            while (res.next()) {
                //int codUsuario, String nomeUsuario, String login, String senha, String email, boolean admin
                if (res.getBoolean("tipo")){ // é administrador
                    usrselecionado = new Administrador(res.getInt("codusuario"),
                                             res.getString("nomeusuario"),
                                             res.getString("login"),
                                             res.getString("senha"),
                                             res.getString("email"));
                }else{
                    usrselecionado = new Comum(res.getInt("codusuario"),
                                             res.getString("nomeusuario"),
                                             res.getString("login"),
                                             res.getString("senha"),
                                             res.getString("email"));
                }
                
            }
            res.close();// fechando o resultado
            stmt.close();// fechando statment
            con.close(); // fechando conexão com o banco
            return usrselecionado; // retornando a lista de gastomensals
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + "-" + e.getMessage());
            return null;
        }

    }
    
    public ArrayList<Usuario> getListaUsuarios() {
        Statement stmt = null; // usado para rodar SQL
        ArrayList<Usuario> listausr = new ArrayList<Usuario>();

        try {
            // cria o objeto para rodar o SQL
            stmt = con.createStatement();
            // passando a string SQL que faz o SELECT
            ResultSet res = stmt.executeQuery("select * from usuario");

            // Pebkorrendo o resultado - res
            while (res.next()) {
                Usuario usr;
                if (res.getBoolean("tipo")){ // é administrador
                    usr = new Administrador(res.getInt("codusuario"),
                                             res.getString("nomeusuario"),
                                             res.getString("login"),
                                             res.getString("senha"),
                                             res.getString("email"));
                }else{
                    usr = new Comum(res.getInt("codusuario"),
                                             res.getString("nomeusuario"),
                                             res.getString("login"),
                                             res.getString("senha"),
                                             res.getString("email"));
                }

                // adicionando na lista auxiliar
                listausr.add(usr);
            }
            res.close();// fechando o resultado
            stmt.close();// fechando statment
            con.close(); // fechando conexão com o banco
            return listausr; // retornando a lista de gastomensals
        } catch (SQLException e) {
            System.out.println(e.getErrorCode() + "-" + e.getMessage());
            return null;
        }

    }
    
}
