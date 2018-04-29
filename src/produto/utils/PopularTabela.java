/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produto.utils;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;
import produto.model.Produto;

/**
 *
 * @author Thiago
 */
public class PopularTabela extends AbstractTableModel {
    
    private List<Produto> items = new ArrayList<>();

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return javax.swing.ImageIcon.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            default:
                return String.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        // coluna zero(imagem) nao é editável
        return columnIndex == 0 ? false : true;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Imagem";
            case 1:
                return "Nome";
            case 2:
                return "Preço";
            default:
                return "";
        }
    }

    public List<Produto> getItems() {
        return this.items;
    }

    public Produto getItem(int row) {
        return items.get(row);
    }

    public void setItems(List<Produto> items) {
        this.items = items;
        this.fireTableDataChanged();
    }

    public void addItem(Produto produto) {
        this.items.add(produto);
        this.fireTableDataChanged();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {
        return items.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return new ImageIcon(items.get(rowIndex).getImagem());
            case 1:
                return items.get(rowIndex).getNomeProduto();
            case 2:
                return items.get(rowIndex).getPreco();
            default:
                return "";
        }
    }
}
