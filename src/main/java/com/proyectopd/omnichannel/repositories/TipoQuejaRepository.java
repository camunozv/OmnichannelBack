package com.proyectopd.omnichannel.repositories;

import com.proyectopd.omnichannel.models.TipoQueja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoQuejaRepository extends JpaRepository<TipoQueja, Integer> {

    TipoQueja getTipoQuejaByTipoQueja(String nombreTipoQueja);

    void deleteTipoQuejaByTipoQuejaEquals(String nombreTipoQueja);
}
