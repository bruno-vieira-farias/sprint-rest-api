package br.com.brunofarias.meubanco.endpoint;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.Objects;

public class ClienteDto {

    @NotBlank(message = "NOME_NAO_INFORMADO")
    private String nome;
    @Email(message = "EMAIL_INVALIDO")
    private String email;
    @NotBlank(message = "CPF_NAO_INFORMADO.")
    private String cpf;
    @Past(message = "DATA_NASCIMENTO_INVALIDA.")
    private LocalDate dataNascimento;

    public ClienteDto(@NotBlank(message = "NOME_NAO_INFORMADO") String nome, @Email(message = "EMAIL_INVALIDO") String email, @NotBlank(message = "CPF_NAO_INFORMADO.") String cpf, @Past(message = "DATA_NASCIMENTO_INVALIDA.") LocalDate dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteDto that = (ClienteDto) o;
        return Objects.equals(nome, that.nome) && Objects.equals(email, that.email) && Objects.equals(cpf, that.cpf) && Objects.equals(dataNascimento, that.dataNascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, email, cpf, dataNascimento);
    }
}