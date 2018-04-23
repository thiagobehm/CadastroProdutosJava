/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produto.controller;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import produto.model.Produto;
import produto.model.validator.ValidarProduto;
import produto.persistence.ProdutoDAO;
import produto.utils.PopularTabela;

/**
 *
 * @author Thiago
 */
public class ProdutoController{
    public Produto produto;
    
    public ProdutoController() {}
    
    //cria um novo produto quando instanciada
    public ProdutoController(String nome, BigDecimal preco, byte[] imagem) {
        this.produto = new Produto(nome, preco, imagem);
    }
    
    /*
    * Valida os campos fornecidos e caso valide grava no banco
    */
    public Boolean validarDados() throws Exception {
        
        if(ValidarProduto.validar(this.produto)){
            return true;
        } else {
            throw new Exception("Dados informados estão incorretos!");
        }
    }
    
    /*
    * Grava no banco os dados do produto caso a validação tenha sido realizada com sucesso
    */
    public void cadastrarProduto() throws Exception{
        ProdutoDAO dao = new ProdutoDAO();
        
        try {
            dao.gravarDados(this.produto);
        } catch(Exception e) {
            throw new Exception("Falha de comunicação com o banco de dados!");
        }
    }
    
    public void listarProdutos(JTable table) throws Exception {
        List<Produto> produtos = new ArrayList();
        ProdutoDAO dao = new ProdutoDAO();
        ResultSet rs;
        DefaultTableModel model;
        
        try{
            rs = dao.getDados();
            model = PopularTabela.atualizarTabela(rs, produtos);
            table.setModel(model);
            System.out.print(produtos.size());
        }catch(Exception e) {
            throw new Exception("Falha de comunicação com o banco de dados!");
        }
    }
    
    
}
