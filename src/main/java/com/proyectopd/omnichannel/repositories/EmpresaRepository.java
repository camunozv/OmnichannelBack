package com.proyectopd.omnichannel.repositories;

import com.proyectopd.omnichannel.models.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    // Add methods if needed
    Empresa findEmpresaByNombreEmpresa(String nombreEmpresa);
}
