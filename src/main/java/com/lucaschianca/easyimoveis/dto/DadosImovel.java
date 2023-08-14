package com.lucaschianca.easyimoveis.dto;

import com.lucaschianca.easyimoveis.domain.endereco.Endereco;
import jakarta.validation.Valid;

public record DadosImovel(
        String nome,
        String descricao,
        float preco,
        String tamanho,
        @Valid
        DadosEndereco endereco,
        boolean permuta,
        String corretorParceiro,
        String numeroDeQuartos,
        String numeroDeGaragem) {
}
