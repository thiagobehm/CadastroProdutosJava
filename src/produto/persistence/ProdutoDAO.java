/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produto.persistence;

import produto.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Thiago
 */
public class ProdutoDAO extends BaseConnection implements Persistence<Produto>{
    /*
    * Implementa o método de gravar dados no banco
    * @produto - Objeto com os dados da view para gravação no banco de dados
    */
    @Override
    public void gravarDados(Produto produto) {
        Connection connection;
        PreparedStatement statement;
        String sql = "INSERT INTO cadastro_produtos.produto (nome, preco, imagem) values(?,?,?) ";

        try {
            connection = super.getConnection();
            
            statement = connection.prepareStatement(sql);

            //seta os parametros para a query
            statement.setString(1, produto.getNomeProduto());
            statement.setBigDecimal(2, produto.getPreco());
            statement.setBytes(3, produto.getImagem());

            statement.executeUpdate();
        } catch (Exception ex) {
           System.out.print(ex.getMessage());
        } 
        
    }
    @Override
    public List<Produto> getDados() {
        Connection connection;
        PreparedStatement statement;
        Produto produto = null;
        List<Produto> produtos = new ArrayList<>();
        ResultSet rs;
        String sql = "SELECT id, imagem, nome, preco FROM cadastro_produtos.produto";

        
        try {  
            connection = super.getConnection();
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();    
             
        while(rs.next()) {
            produto = new Produto();
            produto.setId(rs.getInt("id"));
            produto.setNomeProduto(rs.getString("nome"));
            produto.setPreco(rs.getBigDecimal("preco"));
            produto.setImagem(rs.getBytes("imagem"));
            
            produtos.add(produto);
        }
       
        } catch (Exception ex) {
           System.out.print(ex.getMessage());
        } 
    
        return produtos;
    }

    @Override
    public void updateDados(Produto produto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
