package br.com.brunofarias.apirest.endpoint;

import br.com.brunofarias.apirest.domain.ClienteService;
import br.com.brunofarias.apirest.domain.core.Cliente;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CadastroContaController {
    private final ClienteService clienteService;

    public CadastroContaController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/abertura-conta/cliente")
    public Cliente cadastraCliente(@Valid @RequestBody ClienteDto cliente) {
        return clienteService.cadastraCliente(cliente.getNome(), cliente.getEmail(), cliente.getCpf(), cliente.getDataNascimento());
    }
}