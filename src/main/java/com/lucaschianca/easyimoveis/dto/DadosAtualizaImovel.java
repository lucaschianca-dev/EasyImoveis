package com.lucaschianca.easyimoveis.dto;

import com.lucaschianca.easyimoveis.domain.endereco.Endereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizaImovel(
        @NotNull
        Long id,
        String nome,
        String descricao,
        Float preco,
        String tamanho,
        Endereco endereco,
        boolean permuta,
        String corretorParceiro,
        String numeroDeQuartos,
        String numeroDeGaragem
) {
}
