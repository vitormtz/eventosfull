/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.apicode.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apicode.model.Inscricao;
import org.apicode.model.InscricaoRequest;
import org.apicode.util.ConexaoBD;
import org.apicode.util.IDAOT;

/**
 *
 * @author vitor
 */
public class InscricaoDAO implements IDAOT<Inscricao> {

    ResultSet resultadoQ = null;

    @Override
    public Inscricao salvar(Inscricao o, String url, String metodo) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "";

            sql = "INSERT INTO inscricoes VALUES ("
                    + "" + o.getId() + ", "
                    + "" + o.getIdUsuario() + ", "
                    + "" + o.getIdEvento() + ", "
                    + "'" + o.getDataHoraInscricao() + "')";

            st.executeUpdate(sql);

            salvaLog(url, metodo);

            return o;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean atualizar(Inscricao o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean excluir(int id, String url, String metodo) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "DELETE FROM inscricoes "
                    + "WHERE id = " + id;

            if (st.executeUpdate(sql) == 0) {
                throw new RuntimeException();
            }

            salvaLog(url, metodo);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public ArrayList<Inscricao> consultarTodos(String url, String metodo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Inscricao consultar(String criterio, String url, String metodo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Inscricao consultar(int id, String url, String metodo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<InscricaoRequest> consultarInscricao(int id, String url, String metodo) {
        ArrayList<InscricaoRequest> inscricoes = new ArrayList<>();

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT i.id, u.nome, e.nome AS evento, e.local, e.data_hora "
                    + "FROM inscricoes i INNER JOIN usuarios u ON i.id_usuario = u.id "
                    + "INNER JOIN eventos e ON i.id_evento = e.id "
                    + "WHERE u.id = " + id;

            resultadoQ = st.executeQuery(sql);
            while (resultadoQ.next()) {
                InscricaoRequest inscricao = new InscricaoRequest();

                inscricao.setId(resultadoQ.getInt("id"));
                inscricao.setNome(resultadoQ.getString("nome"));
                inscricao.setEvento(resultadoQ.getString("evento"));
                inscricao.setLocal(resultadoQ.getString("local"));
                inscricao.setData_hora(resultadoQ.getString("data_hora"));

                inscricoes.add(inscricao);
            }

            salvaLog(url, metodo);

            return inscricoes;
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
    public Integer consultarUltimoId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Inscricao consultar(Inscricao o, String url, String metodo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
