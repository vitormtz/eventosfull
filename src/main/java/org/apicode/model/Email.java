/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.apicode.model;

/**
 *
 * @author vitor
 */
public class Email {

    private int id;
    private int idUsuario;
    private int idEvento;
    private String dataHoraEnvio;
    private String nomeParticipante;
    private String nomeEvento;
    private String dataHoraInscricao;
    protected String token;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getDataHoraEnvio() {
        return dataHoraEnvio;
    }

    public void setDataHoraEnvio(String dataHoraEnvio) {
        this.dataHoraEnvio = dataHoraEnvio;
    }

    public String getNomeParticipante() {
        return nomeParticipante;
    }

    public void setNomeParticipante(String nomeParticipante) {
        this.nomeParticipante = nomeParticipante;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getDataHoraInscricao() {
        return dataHoraInscricao;
    }

    public void setDataHoraInscricao(String dataHoraInscricao) {
        this.dataHoraInscricao = dataHoraInscricao;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
}
