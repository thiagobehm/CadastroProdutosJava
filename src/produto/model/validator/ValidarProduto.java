/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produto.model.validator;

import produto.model.Produto;

/*
 * valida se dados informados estão corretos de acordo com a validação feita na classe Validator
 */
public class ValidarProduto extends Validator{
    
    public static Boolean validar(Produto p) {
            return validarNome(p.getNomeProduto()) && validarPreco(p.getPreco());
    }
}
