package br.com.brunofarias.meubanco.endpoint;

import java.util.List;

public class RespostaErroDto {
    private List<String> codigosErro;

    public RespostaErroDto(List<String> codigosErro) {
        this.codigosErro = codigosErro;
    }

    public List<String> getCodigosErro() {
        return codigosErro;
    }
}
