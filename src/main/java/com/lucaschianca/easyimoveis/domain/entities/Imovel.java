package com.lucaschianca.easyimoveis.domain.entities;

import com.lucaschianca.easyimoveis.domain.endereco.Endereco;
import com.lucaschianca.easyimoveis.dto.DadosAtualizaImovel;
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
    private boolean ativo;

    public Imovel(DadosImovel dadosImovel) {
        this.ativo = true;
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

    public void atualizaImovel(DadosAtualizaImovel dadosAtualizaImovel) {
        if (dadosAtualizaImovel.id() == null) {
        } else {
            this.permuta = dadosAtualizaImovel.permuta();
            if (dadosAtualizaImovel.nome() != null)
                this.nome = dadosAtualizaImovel.nome();
            if (dadosAtualizaImovel.descricao() != null)
                this.descricao = dadosAtualizaImovel.descricao();
            if (dadosAtualizaImovel.preco() != null)
                this.preco = dadosAtualizaImovel.preco();
            if (dadosAtualizaImovel.tamanho() != null)
                this.tamanho = dadosAtualizaImovel.tamanho();
            if (dadosAtualizaImovel.endereco() != null)
                this.endereco = dadosAtualizaImovel.endereco();
            if (dadosAtualizaImovel.corretorParceiro() != null)
                this.corretorParceiro = dadosAtualizaImovel.corretorParceiro();
            if (dadosAtualizaImovel.numeroDeQuartos() != null)
                this.numeroDeQuartos = dadosAtualizaImovel.numeroDeQuartos();
            if (dadosAtualizaImovel.numeroDeGaragem() != null)
                this.numeroDeGaragem = dadosAtualizaImovel.numeroDeGaragem();
        }
    }
    public void inativo() {
        this.ativo = false;
    }

    public void ativo() {
        this.ativo = true;
    }
}
