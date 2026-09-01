/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apicode.util;

import java.util.ArrayList;

/**
 *
 * @author pretto
 */

// Utiliza Generics como tipo de dado

public interface IDAOT <T> {

    public T salvar(T o, String url, String metodo);

    public boolean atualizar(T o);

    public boolean excluir(int id, String url, String metodo);

    public ArrayList<T> consultarTodos(String url, String metodo);

    public T consultar(String criterio, String url, String metodo);

    public T consultar(int id, String url, String metodo);
    
    public T consultar(T o, String url, String metodo);
    
    public Integer consultarUltimoId();
}
