/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produto.utils;


import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


/**
 *
 * @author Thiago
 */
public class PopularTabela {
    
    public static DefaultTableModel atualizarTabela(ResultSet rs) throws SQLException {

        ResultSetMetaData dados = rs.getMetaData();
        
        // Busca o nome das colunas
        Vector<String> nomeColunas = new Vector<>();
        int countColunas = dados.getColumnCount();
           
        nomeColunas.add("Imagem");
        nomeColunas.add("Nome");
        nomeColunas.add("Preço");

        // Busca os dados da tabela
        Vector<Vector<Object>> data = new Vector<>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<>();
            for (int columnIndex = 1; columnIndex <= countColunas; columnIndex++) {
                //Não mostra na tabela o ID
                if(columnIndex != 1)
                   vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, nomeColunas){
                //seta que a primeira coluna não será editável
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    if(columnIndex != 0) return true;
                return false;
            }
        };

    }
}
