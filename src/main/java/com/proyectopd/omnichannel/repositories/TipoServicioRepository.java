package com.proyectopd.omnichannel.repositories;

import com.proyectopd.omnichannel.models.Empresa;
import com.proyectopd.omnichannel.models.TipoServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TipoServicioRepository extends JpaRepository<TipoServicio, Integer> {

    List<Empresa> getTipoServicioByNombreServicio(String nombreServicio);

    TipoServicio findTipoServicioByNombreServicio(String nombreServicio);

    @Transactional
    void deleteTipoServicioByNombreServicio(String nombreServicio);

    TipoServicio getTipoServicioByNombreServicioEquals(String nombreServicio);
}
