package br.com.brunofarias.meubanco.endpoint;

import br.com.brunofarias.meubanco.domain.AberturaContaService;
import br.com.brunofarias.meubanco.domain.core.Cliente;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
public class AberturaContaController {

    private final AberturaContaService aberturaContaService;

    public AberturaContaController(AberturaContaService aberturaContaService) {
        this.aberturaContaService = aberturaContaService;
    }

    @PostMapping("/api/abertura-conta/cliente")
    public ResponseEntity<Cliente> cadastraCliente(@Validated @RequestBody ClienteDto clienteDto) {
        Cliente cliente = aberturaContaService.cadastraCliente(
                clienteDto.getNome(),
                clienteDto.getEmail(),
                clienteDto.getCpf(),
                clienteDto.getDataNascimento()
        );
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RespostaErroDto> capturaValidacoesBeanValidation(MethodArgumentNotValidException ex) {
        List<String> codigosErro = ex.getBindingResult().getAllErrors().stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());

        return new ResponseEntity(new RespostaErroDto(codigosErro), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<RespostaErroDto> capturaValidacoesBeanValidation(IllegalArgumentException ex) {
        return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}