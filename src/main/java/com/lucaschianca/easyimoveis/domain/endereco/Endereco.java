package com.lucaschianca.easyimoveis.domain.endereco;

import com.lucaschianca.easyimoveis.dto.DadosEndereco;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String cep;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;

    public Endereco(DadosEndereco dadosEndereco) {
        this.cep = dadosEndereco.cep();
        this.cidade = dadosEndereco.cidade();
        this.bairro = dadosEndereco.bairro();
        this.rua = dadosEndereco.rua();
        this.numero = dadosEndereco.numero();
    }
}
