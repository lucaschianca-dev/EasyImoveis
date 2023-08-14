package com.lucaschianca.easyimoveis.dto;

public record DadosEndereco(
        String cep,
        String cidade,
        String bairro,
        String rua,
        String numero
) {
}
