package br.com.brunofarias.meubanco.domain.core;

import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

    public Boolean existsByCpf(String cpf);

    public Boolean existsByEmail(String email);

}
