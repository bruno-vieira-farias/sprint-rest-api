package br.com.brunofarias.apirest.endpoint;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public class ClienteDto {

    @NotBlank(message = "NOME_NAO_INFORMADO")
    private String nome;
    @Email(message = "EMAIL_INVALIDO")
    private String email;
    @NotBlank(message = "CPF_NAO_INFORMADO.")
    private String cpf;
    @Past(message = "DATA_NASCIMENTO_INVALIDA.")
    private LocalDate dataNascimento;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}