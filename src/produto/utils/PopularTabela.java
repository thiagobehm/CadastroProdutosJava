/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produto.utils;


import java.io.IOException;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import produto.model.Produto;

/**
 *
 * @author Thiago
 */
public class PopularTabela {
    
    public static DefaultTableModel atualizarTabela(ResultSet rs, List<Produto> produtos) throws SQLException, IOException {

        ResultSetMetaData dados = rs.getMetaData();
        Blob imgDB;
        byte[] imgData;
        
        criarObjeto(produtos, rs);
        rs.beforeFirst();
        // Seta o nome das colunas
        Vector<String> nomeColunas = new Vector<>();
        int countColunas = dados.getColumnCount();
           
        nomeColunas.add("Imagem");
        nomeColunas.add("Nome");
        nomeColunas.add("Preço");

        // Busca os dados(valores) da tabela
        Vector<Vector<Object>> data = new Vector<>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<>();
            for (int columnIndex = 1; columnIndex <= countColunas; columnIndex++) {
                //Não mostra na tabela o ID
                if(columnIndex != 1) {
                   vector.add(rs.getObject(columnIndex));
                }  else {
                    if(columnIndex == 1) {
                       ImageIcon icon = new ImageIcon(rs.getBytes("imagem"));
                       vector.add(icon);
                    }
                }
            }
            data.add(vector);
        }
        
        /*
        * Retorna um novo Model onde bloqueia a edição da primeira coluna(imagem)
        * e atualiza os valores na view que estão no banco
        */
        return new DefaultTableModel(data, nomeColunas) {
            //seta que a primeira coluna não será editável
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                if (columnIndex != 0) {
                    return true;
                }
                return false;
            }
        };

    }

    private static void criarObjeto(List<Produto> produtos, ResultSet rs) throws SQLException {
        Produto produto = new Produto();
        while(rs.next()) {
            produto.setId(rs.getInt("id"));
            produto.setNomeProduto(rs.getString("nome"));
            produto.setPreco(rs.getBigDecimal("preco"));
            produto.setImagem(rs.getBytes("imagem"));
            
            produtos.add(produto);
        }
        
    }
}
