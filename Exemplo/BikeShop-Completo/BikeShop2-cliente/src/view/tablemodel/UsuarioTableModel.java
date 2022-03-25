/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelDominio.Administrador;
import modelDominio.Usuario;

/**
 *
 * @author herrmann
 */
public class UsuarioTableModel extends AbstractTableModel {

    private ArrayList<Usuario> listaUsuarios;

    // método construtor que recebe como parâmetro a lista de Bikes
    public UsuarioTableModel(ArrayList<Usuario> listausr) {
        this.listaUsuarios = listausr;
    }

    // sobrescrita do método que diz quantas LINHAS a tabela tem
    @Override
    public int getRowCount() {
        return listaUsuarios.size();
    }

    // sobrescrita do método que diz quantas COLUNAS a tabela tem
    @Override
    public int getColumnCount() {
        return 6;
    }

    // sobrescrita do método que retorna o valor de cada coluna
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario usr = listaUsuarios.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return usr.getCodUsuario();
            case 1:
                return usr.getNomeUsuario();
            case 2:
                return usr.getLogin();
            case 3:
                return "***"; // senha
            case 4:
                return usr.getEmail();
            case 5:
                return (usr instanceof Administrador ? "Sim":"Não");
            default:
                return "";
        }
    }

    // sobrescrita do método que retorna o nome de cada coluna
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Código";
            case 1:
                return "Nome do usuário";
            case 2:
                return "Login";
            case 3:
                return "Senha"; // senha
            case 4:
                return "Email";
            case 5:
                return "Administrador?";
            default:
                return "NoName";
        }
    }

    // método que retorna um objeto de Raça a partir da linha que o usuário selecionou.
    public Usuario getUsuario(int row) {
        return listaUsuarios.get(row);
    }
}
