package com.lucaschianca.easyimoveis.controller;

import com.lucaschianca.easyimoveis.domain.entities.Imovel;
import com.lucaschianca.easyimoveis.dto.DadosDetalhadosImovel;
import com.lucaschianca.easyimoveis.dto.DadosImovel;
import com.lucaschianca.easyimoveis.dto.DadosListagemImovel;
import com.lucaschianca.easyimoveis.repository.ImovelRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "/imovel")
public class ImovelController {
    @Autowired
    private ImovelRepository imovelRepository;

    @PostMapping(value = "/cadastro")
    @Transactional
    public ResponseEntity cadastraImovel(@RequestBody @Valid DadosImovel dadosImovel, UriComponentsBuilder uriBuilder) {
        var resultImovel = new Imovel(dadosImovel);
        imovelRepository.save(resultImovel);

        var uri =uriBuilder.path("imovel/{id}").buildAndExpand(resultImovel.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhadosImovel(resultImovel));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<Page<DadosListagemImovel>> listaImoveis(@PageableDefault(size = 10, page = 0, sort = "nome") Pageable paginacao) {
        var resultImoveis = imovelRepository.findAll(paginacao).map(DadosListagemImovel::new);
        return ResponseEntity.ok(resultImoveis);
    }

    @GetMapping(value = "/all/permutaon")
    public ResponseEntity<Page<DadosListagemImovel>> listaImoveisPermuta(@PageableDefault(size = 10, page = 0, sort = "nome") Pageable paginacao) {
        var resultImoveis = imovelRepository.findAllByPermutaTrue(paginacao).map(DadosListagemImovel::new);
        return ResponseEntity.ok(resultImoveis);
    }

    @GetMapping(value = "/all/permutaof")
    public ResponseEntity<Page<DadosListagemImovel>> listaImoveisSemPermuta(@PageableDefault(size = 10, page = 0, sort = "nome") Pageable paginacao) {
        var resultImoveis = imovelRepository.findAllByPermutaFalse(paginacao).map(DadosListagemImovel::new);
        return ResponseEntity.ok(resultImoveis);
    }
}
