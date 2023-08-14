package com.lucaschianca.easyimoveis.repository;

import com.lucaschianca.easyimoveis.domain.entities.Imovel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImovelRepository extends JpaRepository<Imovel, Long> {
    Page<Imovel> findAllByPermutaTrue(Pageable paginacao);

    Page<Imovel> findAllByPermutaFalse(Pageable paginacao);

    Page<Imovel> findAllByAtivoTrue(Pageable paginacao);
}
