/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produto.model;

import java.math.BigDecimal;
import javax.swing.ImageIcon;

/**
 *
 * @author Thiago
 * Mapeia a tabela do banco para os dados em memória (POJO Class)
 */

public class Produto {
    private String nomeProduto;
    private BigDecimal preco;
    private byte[] imagem;
    private Integer id;
    
    public Produto() {}
    
    public Produto(String nomeProduto, BigDecimal preco, byte[] imagem) {
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.imagem = imagem;
    }
    public ImageIcon renderImagem() {
        return new ImageIcon(this.imagem);
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public byte[] getImagem() {
        return imagem;
    }
 
    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }


    
    
}
