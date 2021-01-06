package br.com.brunofarias.apirest.domain;

import br.com.brunofarias.apirest.domain.core.Cliente;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface ClienteService {

    public Cliente cadastraCliente(String nome, String email, String cpf, LocalDate dataNascimento);

}
