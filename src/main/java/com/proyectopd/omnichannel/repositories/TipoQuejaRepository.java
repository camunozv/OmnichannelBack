package com.proyectopd.omnichannel.repositories;

import com.proyectopd.omnichannel.models.TipoQueja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface TipoQuejaRepository extends JpaRepository<TipoQueja, Integer> {

    TipoQueja getTipoQuejaByTipoQueja(String nombreTipoQueja);

    @Transactional
    void deleteTipoQuejaByTipoQuejaEquals(String nombreTipoQueja);
}
