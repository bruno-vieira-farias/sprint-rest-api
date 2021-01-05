package br.com.brunofarias.apirest.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CadastroContaController {

    @PostMapping("/api/rest/cliente")
    public String cadastra(@RequestBody ClienteDto cliente) {
        return "Recebido";
    }

}
