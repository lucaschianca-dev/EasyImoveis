package com.lucaschianca.easyimoveis.domain.entities;

import com.lucaschianca.easyimoveis.domain.endereco.Endereco;
import com.lucaschianca.easyimoveis.dto.DadosImovel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Imovel")
@Table(name = "imoveis")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Imovel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private float preco;
    private String tamanho;
    @Embedded
    private Endereco endereco;
    private boolean permuta;
    private String corretorParceiro;
    private String numeroDeQuartos;
    private String numeroDeGaragem;

    public Imovel(DadosImovel dadosImovel) {
        this.nome = dadosImovel.nome();
        this.descricao = dadosImovel.descricao();
        this.preco = dadosImovel.preco();
        this.tamanho = dadosImovel.tamanho();
        this.endereco = new Endereco(dadosImovel.endereco());
        this.permuta = dadosImovel.permuta();
        this.corretorParceiro = dadosImovel.corretorParceiro();
        this.numeroDeQuartos = dadosImovel.numeroDeQuartos();
        this.numeroDeGaragem = dadosImovel.numeroDeGaragem();
    }
}
