/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modelDominio.Bike;

/**
 *
 * @author herrmann
 */
public class BikeTableModel extends AbstractTableModel {

    private ArrayList<Bike> listaBikes;

    // método construtor que recebe como parâmetro a lista de Bikes
    public BikeTableModel(ArrayList<Bike> listaBikes) {
        this.listaBikes = listaBikes;
    }

    // sobrescrita do método que diz quantas LINHAS a tabela tem
    @Override
    public int getRowCount() {
        return listaBikes.size();
    }

    // sobrescrita do método que diz quantas COLUNAS a tabela tem
    @Override
    public int getColumnCount() {
        return 4;
    }

    // sobrescrita do método que retorna o valor de cada coluna
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Bike bk = listaBikes.get(rowIndex);

        switch (columnIndex) {
            case 0:  return bk.getCodBike();
            case 1:  return bk.getModelo();
            case 2:  return bk.getMarca().getNomemarca();
            case 3:  return bk.getPrecoString();
            default: return "";
        }
    }

    // sobrescrita do método que retorna o nome de cada coluna
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:  return "Código";
            case 1:  return "Modelo";
            case 2:  return "Marca";
            case 3:  return "Preço";
            default: return "NoName";
        }
    }

    // método que retorna um objeto de Raça a partir da linha que o 
    // usuário selecionou.
    public Bike getBike(int row) {
        return listaBikes.get(row);
    }
}
