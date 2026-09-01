/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.apicode.controller;

import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import org.apicode.dao.InscricaoDAO;
import org.apicode.model.Inscricao;
import org.apicode.model.InscricaoRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 *
 * @author vitor
 */
@RestController
@RequestMapping("/inscricoes")
public class InscricaoController implements HandlerInterceptor {

    private InscricaoDAO inscricaoService = new InscricaoDAO();

    @GetMapping("/{id}")
    public ResponseEntity<ArrayList<InscricaoRequest>> obterInscricaoPorId(@PathVariable int id, HttpServletRequest request) {
        String url = request.getRequestURL().toString(); // Obtém a URL da requisição
        String metodo = request.getMethod();

        ArrayList<InscricaoRequest> inscricao = inscricaoService.consultarInscricao(id, url, metodo);

        if (inscricao.isEmpty()) {
            return null;
        } else {
            return ResponseEntity.ok(inscricao);
        }
    }

    @PostMapping
    public Inscricao criarInscricao(@RequestBody Inscricao inscricaoRequest, HttpServletRequest request) {
        String url = request.getRequestURL().toString(); // Obtém a URL da requisição
        String metodo = request.getMethod();

        if (inscricaoRequest.getToken().equals("SenhaUltraSecreta")) {
            if (inscricaoService.salvar(inscricaoRequest, url, metodo) != null) {
                return inscricaoRequest;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancelarInscricao(@PathVariable int id, HttpServletRequest request) {
        String url = request.getRequestURL().toString(); // Obtém a URL da requisição
        String metodo = request.getMethod();

        boolean cancelado = inscricaoService.excluir(id, url, metodo);

        if (cancelado) {
            return ResponseEntity.status(HttpStatus.OK).body("");
        } else {
            return ResponseEntity.status(HttpStatus.FOUND).body("");
        }
    }
}
