/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produto.model.validator;

import java.math.BigDecimal;
/**
 *
 * Classe abstrata que implementa os métodos de validação 
 */
public abstract class Validator {
    public static Boolean validarNome(String nome) {
        //Nome precisa ter mais que três caracteres
        if(nome.equals("") || nome.length() > 60){
            return false;
        }
        return true;
    }
    
    public static Boolean validarPreco(BigDecimal preco) {
        //preco nao pode ficar em branco, nem ser negativo
        if(preco.compareTo(new BigDecimal("0")) == 0 || preco.compareTo(new BigDecimal("0")) == -1){
            return false;
        }
        return true;
    }
}
