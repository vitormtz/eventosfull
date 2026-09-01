/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.apicode.model;

/**
 *
 * @author vitor
 */
public class InscricaoRequest {

    private int id;
    private String nome;
    private String evento;
    private String local;
    private String data_hora;

    public InscricaoRequest() {
    }

    public InscricaoRequest(int id, String nome, String evento, String local, String data_hora) {
        this.id = id;
        this.nome = nome;
        this.evento = evento;
        this.local = local;
        this.data_hora = data_hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData_hora() {
        return data_hora;
    }

    public void setData_hora(String data_hora) {
        this.data_hora = data_hora;
    }
}
