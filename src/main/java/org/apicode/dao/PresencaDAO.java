/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.apicode.dao;

import java.sql.Statement;
import java.util.ArrayList;
import org.apicode.model.Presenca;
import org.apicode.util.ConexaoBD;
import org.apicode.util.IDAOT;

/**
 *
 * @author vitor
 */
public class PresencaDAO implements IDAOT<Presenca> {

    @Override
    public Presenca salvar(Presenca o, String url, String metodo) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "";

            sql = "INSERT INTO presenca VALUES ("
                    + "" + o.getId() + ", "
                    + "" + o.getIdEvento() + ", "
                    + "" + o.getIdParticipante() + ", "
                    + "'" + o.getDataHoraCheckin() + "')";

            st.executeUpdate(sql);

            salvaLog(url, metodo);
            
            return o;
        } catch (Exception e) {
            return null;
        }
    }

    public void salvaLog(String url, String metodo) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "";

            sql = "INSERT INTO log_eventos VALUES ("
                    + "(SELECT COALESCE(MAX(id), 0) + 1 FROM log_eventos), "
                    + "CURRENT_TIMESTAMP, "
                    + "'" + url + "', "
                    + "'" + metodo + "')";

            st.executeUpdate(sql);
        } catch (Exception e) {
        }
    }

    @Override
    public boolean atualizar(Presenca o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean excluir(int id, String url, String metodo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Presenca> consultarTodos(String url, String metodo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Presenca consultar(String criterio, String url, String metodo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Presenca consultar(int id, String url, String metodo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer consultarUltimoId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Presenca consultar(Presenca o, String url, String metodo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
