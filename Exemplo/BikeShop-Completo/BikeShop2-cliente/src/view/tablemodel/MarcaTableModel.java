/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelDominio.Marca;

/**
 *
 * @author herrmann
 */
public class MarcaTableModel extends AbstractTableModel {

    private ArrayList<Marca> listaMarcas;

    // método construtor que recebe como parâmetro a lista de Marcas
    public MarcaTableModel(ArrayList<Marca> listaMarcas) {
        this.listaMarcas = listaMarcas;
    }

    // sobrescrita do método que diz quantas LINHAS a tabela tem
    @Override
    public int getRowCount() {
        return listaMarcas.size();
    }

    // sobrescrita do método que diz quantas COLUNAS a tabela tem
    @Override
    public int getColumnCount() {
        return 2;
    }

    // sobrescrita do método que retorna o valor de cada coluna
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Marca marca = listaMarcas.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return marca.getCodmarca();
            case 1:
                return marca.getNomemarca();
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
                return "Nome";
            default:
                return "NoName";
        }
    }

    // método que retorna um objeto de Raça a partir da linha que o usuário selecionou.
    public Marca getMarca(int row) {
        return listaMarcas.get(row);
    }
}
