/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produto.persistence;

import java.sql.ResultSet;

/**
 *
 * @author Thiago
 */
public interface Persistence<T> {
    public void gravarDados(T Object);
    public ResultSet getDados();
    public void updateDados(T Object);
}
