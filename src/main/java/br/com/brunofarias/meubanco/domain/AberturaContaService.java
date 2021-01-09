package br.com.brunofarias.meubanco.domain;

import br.com.brunofarias.meubanco.domain.core.Cliente;
import br.com.brunofarias.meubanco.domain.core.ClienteRepository;
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
    public Cliente cadastraCliente(String nome, String email, String cpf, LocalDate dataNascimento) throws IllegalArgumentException {
        certificaQueClientePodeSerCadastrado(email, cpf);

        Cliente cliente = new Cliente(nome, email, cpf, dataNascimento);
        return clienteRepository.save(cliente);
    }

    private void certificaQueClientePodeSerCadastrado(String email, String cpf) {
        if (clienteRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("EMAIL_JA_CADASTRADO");
        }

        if (clienteRepository.existsByCpf(cpf)) {
            throw new IllegalArgumentException("CPF_JA_CADASTRADO");
        }
    }
}