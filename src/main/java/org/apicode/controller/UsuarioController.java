/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.apicode.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.apicode.dao.AutenticacaoDAO;
import org.apicode.dao.UsuarioDAO;
import org.apicode.model.Autenticacao;
import org.apicode.model.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vitor
 */
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioDAO usuarioService = new UsuarioDAO();
    private AutenticacaoDAO autenticacaoService = new AutenticacaoDAO();

    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuarioRequest, HttpServletRequest request) {
        String url = request.getRequestURL().toString(); // Obtém a URL da requisição
        String metodo = request.getMethod();

        if (usuarioRequest.getToken().equals("SenhaUltraSecreta")) {
            if (usuarioService.salvar(usuarioRequest, url, metodo) != null) {
                return usuarioRequest;
            }
        }
        return null;
    }

    @PostMapping("/autenticacao")
    public ResponseEntity<Autenticacao> autenticarUsuario(@RequestBody Autenticacao autenticacaoRequest, HttpServletRequest request) {
        String url = request.getRequestURL().toString(); // Obtém a URL da requisição
        String metodo = request.getMethod();

        if (autenticacaoRequest.getToken().equals("SenhaUltraSecreta")) {
            if (autenticacaoService.consultar(autenticacaoRequest, url, metodo) != null) {
                return ResponseEntity.ok(autenticacaoRequest);
            }
        }
        return null;
    }
}
