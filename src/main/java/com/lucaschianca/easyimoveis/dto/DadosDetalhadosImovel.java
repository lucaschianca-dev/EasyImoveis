package com.lucaschianca.easyimoveis.dto;

import com.lucaschianca.easyimoveis.domain.endereco.Endereco;
import com.lucaschianca.easyimoveis.domain.entities.Imovel;

public record DadosDetalhadosImovel(
        Long id,
        String nome,
        String descricao,
        float preco,
        String tamanho,
        Endereco endereco,
        boolean permuta,
        String corretorParceiro,
        String numeroDeQuartos,
        String numeroDeGaragem) {

    public DadosDetalhadosImovel(Imovel imovel) {
        this(
                imovel.getId(),
                imovel.getNome(),
                imovel.getDescricao(),
                imovel.getPreco(),
                imovel.getTamanho(),
                imovel.getEndereco(),
                imovel.isPermuta(),
                imovel.getCorretorParceiro(),
                imovel.getNumeroDeQuartos(),
                imovel.getNumeroDeGaragem()
        );
    }
}
