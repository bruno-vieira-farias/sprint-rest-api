package br.com.brunofarias.apirest.domain;

import br.com.brunofarias.apirest.domain.core.Cliente;
import br.com.brunofarias.apirest.domain.core.ClienteRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
public class AberturaContaService {
    private final ClienteRepository clienteRepository;

    public AberturaContaService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public Cliente cadastraCliente(String nome, String email, String cpf, LocalDate dataNascimento) {
        Cliente cliente = new Cliente(nome, email, cpf, dataNascimento);
        return clienteRepository.save(cliente);
    }

}