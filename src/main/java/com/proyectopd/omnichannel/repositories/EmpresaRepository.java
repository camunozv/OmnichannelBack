package com.proyectopd.omnichannel.repositories;

import com.proyectopd.omnichannel.models.Empresa;
import com.proyectopd.omnichannel.models.TipoServicio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    // Add methods if needed
    Empresa findEmpresaByNombreEmpresa(String nombreEmpresa);

    void deleteEmpresaByNombreEmpresa(String nombreEmpresa);

    List<Empresa> getEmpresasByTipoServicioEquals(TipoServicio tipoServicio);
}
