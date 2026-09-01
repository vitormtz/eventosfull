/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.apicode.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.apicode.dao.EmailDAO;
import org.apicode.model.Email;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vitor
 */
@RestController
@RequestMapping("/emails")
public class EmailController {

    private EmailDAO emailService = new EmailDAO();

    @PostMapping
    public Email enviarEmail(@RequestBody Email emailRequest, HttpServletRequest request) {
        String url = request.getRequestURL().toString(); // Obtém a URL da requisição
        String metodo = request.getMethod();

        if (emailRequest.getToken().equals("SenhaUltraSecreta")) {
            if (emailService.salvar(emailRequest, url, metodo) != null) {
                return emailRequest;
            }
        }
        return null;
    }
}
