/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Essa classe conecta o Java no banco de Dados BikeShop do Mysql
 *
 * @author herrmann
 */
public class Conector {

    private static Connection con;

    public static Connection getConnection() {
        try {
            //string que armazena a url de conexao com o banco
            String url = "jdbc:mysql://localhost:3306/"; //caminho do banco e porta
            String banco = "bikeshop2";                      //nome da base
            String usuario = "root";                       //usuário para acesso
            String senha = "aluno@LP3";                  //senha para acesso

            con = DriverManager.getConnection(url + banco, usuario, senha);
            return con;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
