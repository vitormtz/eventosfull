/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.apicode.controller;

import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.stream.Collectors;
import org.apicode.dao.EventoDAO;
import org.apicode.dao.PresencaDAO;
import org.apicode.dao.UsuarioDAO;
import org.apicode.model.Evento;
import org.apicode.model.Presenca;
import org.apicode.model.Usuario;
import org.apicode.model.UsuarioRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vitor
 */
@RestController
@RequestMapping("/eventos")
public class EventoController {

    private EventoDAO eventoService = new EventoDAO();
    private UsuarioDAO usuarioService = new UsuarioDAO();
    private PresencaDAO presencaService = new PresencaDAO();

    @GetMapping
    public ResponseEntity<ArrayList<Evento>> listarEventos(HttpServletRequest request) {
        String url = request.getRequestURL().toString(); // Obtém a URL da requisição
        String metodo = request.getMethod();

        ArrayList<Evento> eventos = eventoService.consultarTodos(url, metodo);
        return ResponseEntity.ok(eventos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArrayList<UsuarioRequest>> obterEventoPorId(@PathVariable int id, HttpServletRequest request) {
        String url = request.getRequestURL().toString(); // Obtém a URL da requisição
        String metodo = request.getMethod();

        ArrayList<Usuario> usuarios = usuarioService.consultarUsuarioEventos(id, url, metodo);

        ArrayList<UsuarioRequest> usuarioDTO = (ArrayList<UsuarioRequest>) usuarios.stream()
                .map(usuario -> new UsuarioRequest(usuario.getId(), usuario.getNome(), usuario.getEmail()))
                .collect(Collectors.toList());

        if (usuarioDTO.isEmpty()) {
            return null;
        } else {
            return ResponseEntity.ok(usuarioDTO);
        }
    }

    @PostMapping("/presencas")
    public Presenca registrarPresenca(@RequestBody Presenca presencaRequest, HttpServletRequest request) {
        String url = request.getRequestURL().toString(); // Obtém a URL da requisição
        String metodo = request.getMethod();

        if (presencaRequest.getToken().equals("SenhaUltraSecreta")) {
            if (presencaService.salvar(presencaRequest, url, metodo) != null) {
                return presencaRequest;
            }
        }
        return null;
    }
}
