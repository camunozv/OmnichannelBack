package com.proyectopd.omnichannel.repositories;

import com.proyectopd.omnichannel.models.Queja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

public interface QuejaRepository extends JpaRepository<Queja, Integer> {
    Queja getQuejaByIdQueja(Integer idQueja);

    List<Queja> findQuejasByEmpresa_NombreEmpresaEquals(String empresaNombreEmpresa);

    List<Queja> findQuejasByTiempoMinimoRespuestaIsLessThan(LocalDate today);

    List<Queja> findQuejasByTiempoMinimoRespuestaEquals(LocalDate dueDate);

    List<Queja> findQuejasByEstado(String estado);

    @Transactional
    void deleteQuejaByIdQueja(Integer idQueja);

    // List<Queja> findQuejasByEstado(String estado);
}
