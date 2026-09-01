/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.apicode.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.apicode.model.Evento;
import org.apicode.util.ConexaoBD;
import org.apicode.util.IDAOT;

/**
 *
 * @author vitor
 */
public class EventoDAO implements IDAOT<Evento> {

    ResultSet resultadoQ = null;

    @Override
    public Evento salvar(Evento o, String url, String metodo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean atualizar(Evento o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean excluir(int id, String url, String metodo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Evento> consultarTodos(String url, String metodo) {
        ArrayList<Evento> eventos = new ArrayList<>();

        try {
            Connection conexao = ConexaoBD.getInstance().getConnection();
            Statement st = conexao.createStatement();

            String sql = "SELECT * "
                    + "FROM eventos";
            ResultSet resultadoQ = st.executeQuery(sql);

            while (resultadoQ.next()) {
                // Criar um objeto Evento para cada linha do resultado
                Evento evento = new Evento();
                evento.setId(resultadoQ.getInt("id"));
                evento.setNome(resultadoQ.getString("nome"));
                evento.setDataHora(resultadoQ.getString("data_hora"));
                evento.setLocal(resultadoQ.getString("local"));
                // Adicionar o evento à lista
                eventos.add(evento);
            }
        } catch (Exception e) {
        }

        salvaLog(url, metodo);

        return eventos;
    }

    @Override
    public Evento consultar(String criterio, String url, String metodo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Evento consultar(int id, String url, String metodo) {
        Evento evento = null;

        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "SELECT  e.id AS id, e.nome AS evento, u.nome "
                    + "FROM inscricoes i INNER JOIN eventos e ON e.id = i.id_evento "
                    + "INNER JOIN usuarios u ON u.id = i.id_usuario "
                    + "WHERE e.id = " + id;

            resultadoQ = st.executeQuery(sql);

            if (resultadoQ.next()) {
                evento = new Evento();

                evento.setId(resultadoQ.getInt("id"));
                evento.setNome(resultadoQ.getString("nome"));
                evento.setDataHora(String.valueOf(resultadoQ.getString("data_hora")));
                evento.setLocal(resultadoQ.getString("local"));
            }
        } catch (Exception e) {
        }

        salvaLog(url, metodo);

        return evento;
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
    public Evento consultar(Evento o, String url, String metodo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
